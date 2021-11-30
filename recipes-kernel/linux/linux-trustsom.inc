require recipes-kernel/linux/linux-yocto.inc

KERNEL_FEATURES_remove = "cfg/virtio.scc"

# Make sure dependencies are available early in the build process
do_kernel_metadata[depends] += "flex-native:do_populate_sysroot bison-native:do_populate_sysroot gcc:do_install"

PV = "${LINUX_VERSION}+git${SRCPV}"

SRC_URI = "\
    file://base_config.cfg \
"
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

KCONFIG_MODE = "--allnoconfig"
#KBUILD_DEFCONFIG_trustsom ?= "tiny"
COMPATIBLE_MACHINE_trustsom = "trustsom"
KBUILD_DEFCONFIG = "trustsom_config"

do_kernel_metadata_prepend() {

    # Generate a defconfig based on the tinyconfig and build on top of that using the fragments
    # this way we don't need machine specific defconfigs
    oe_runmake_call -C ${S} CC="${KERNEL_CC}" LD="${KERNEL_LD}" O=${B} tinyconfig
    
    mv ${B}/.config ${S}/arch/${ARCH}/configs/${KBUILD_DEFCONFIG}
}

do_kernel_metadata_appenda() {
    echo "configuration complete"
}
