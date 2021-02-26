DESCRIPTION = "Secure boot signing recipe for binaries after ATF bootloader"
SECTION = "bootloaders"
LICENSE = "GPLv2"
# This recipe is derived from the meta-qoriq/recipes-bsp/secure-boot/secure-boot-qoriq.bb recipe

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "file://${MACHINE}.manifest"

inherit deploy

ITB_IMAGE = "scalys-image-kernelitb"
DEPENDS = "u-boot-mkimage-native cst-native atf"
do_deploy[depends] += "virtual/kernel:do_deploy ${ITB_IMAGE}:do_build"

# set 'DISTRO_FEATURES_append = " secure"' in local.conf to enable secure boot
# set 'DISTRO_FEATURES_append = " srk_revocation_support"' in local.conf to enable the use of multiple # Set the following in local.conf if 'srk_revocation_support' is enabled:
# SECURE_PRI_KEYS = "<path/to/keydir/*.pri>"
# SECURE_PUB_KEYS = "<path/to/keydir/*.pub>"

SECURE = "${@bb.utils.contains('DISTRO_FEATURES', 'secure', 'true', 'false', d)}"
BUILD_SRK_REVOK_SUPPORT = "${@bb.utils.contains('DISTRO_FEATURES', 'srk_revocation_support', 'true', 'false', d)}"

S = "${WORKDIR}"

do_deploy[nostamp] = "1"
do_patch[noexec] = "1"
do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_deploy () {
    cd ${RECIPE_SYSROOT_NATIVE}/usr/bin/cst
    cp ${S}/${MACHINE}.manifest ./
    if [ ${SECURE} = "true" ]; then
        if [ "${BUILD_SRK_REVOK_SUPPORT}" = "true" ]; then
            if [ -n "${SECURE_PRI_KEYS}" ]; then
                cp -f ${SECURE_PRI_KEYS} ./
            else
                bbfatal "SECURE_PRI_KEYS not defined"
            fi
            if [ -n "${SECURE_PUB_KEYS}" ]; then
                cp -f ${SECURE_PUB_KEYS} ./
            else
                bbfatal "SECURE_PUB_KEYS not defined"
            fi
        else
            if [ ! -f srk.pri ] && [ -f ${DEPLOY_DIR_IMAGE}/srk.pri ]; then
                cp ${DEPLOY_DIR_IMAGE}/srk.pri ./
                cp ${DEPLOY_DIR_IMAGE}/srk.pub ./
            elif [ ! -f srk.pri ] && [ ! -f ${DEPLOY_DIR_IMAGE}/srk.pri ]; then
                ./gen_keys 1024
            fi
        fi
    fi

    . ./${MACHINE}.manifest
    if [ -n "$distro_bootscript" ]; then
        echo $securevalidate > ${distro_bootscript}.tmp
        echo $distroboot >> ${distro_bootscript}.tmp
        mkimage -A arm64 -O linux -T script -C none -a 0 -e 0  -n "boot.scr" -d ${distro_bootscript}.tmp ${distro_bootscript}
        rm -f ${distro_bootscript}.tmp
        echo -e "${distro_bootscript}    [Done]\n"
    fi

    if [ ${SECURE} = "true" ]; then
        if [ ! -d  ${DEPLOY_DIR_IMAGE}/secboot_hdrs/ ]; then
        mkdir -p  ${DEPLOY_DIR_IMAGE}/secboot_hdrs/
        fi
        # Sign bootscript image
        cp ./$distro_bootscript ./bootscript && echo "Copying bootscript"
        ./uni_sign ${BOOTSCR_INPUT_FILE}

        # Generating SRK hash
        ./uni_sign --hash ${BOOTSCR_INPUT_FILE} > srk_hash.txt

        # Sign kernel image
        cp ${DEPLOY_DIR_IMAGE}/$kernel_itb ./kernel.itb && echo "Copying kernel_itb"
        ./uni_sign ${FITIMAGE_INPUT_FILE}

        # Concatenate secure boot headers
        if [ -f secboot_hdrs.bin ]; then
            rm secboot_hdrs.bin
        fi

        touch secboot_hdrs.bin
        dd if=hdr_kernel.out of=secboot_hdrs.bin bs=1K seek=0

        cp ./secboot_hdrs.bin ${DEPLOY_DIR_IMAGE}/secboot_hdrs/
        cp ./$distro_bootscript ${DEPLOY_DIR_IMAGE}/
        cp ./hdr_bs.out ${DEPLOY_DIR_IMAGE}/secboot_hdrs/hdr_${MACHINE}_bs.out
        cp ./srk_hash.txt ${DEPLOY_DIR_IMAGE}/
    fi
}

addtask deploy before do_build after do_compile

PACKAGE_ARCH = "${MACHINE_ARCH}"

COMPATIBLE_MACHINE = "(qoriq-arm|qoriq-arm64)"
