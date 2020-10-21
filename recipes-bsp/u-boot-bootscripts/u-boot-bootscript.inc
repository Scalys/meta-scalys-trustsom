LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${WORKDIR}/COPYING;md5=12f884d2ae1ff87c09e5b7ccc2c4ca7e"


FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

DEPENDS += "u-boot-mkimage-native"

SRC_URI += "\
  file://${BOOT_SCRIPT} \
  file://COPYING \
"

inherit kernel-arch

BOOT_SCRIPT_DESTNAME = "trustbox_boot.scr"

do_compile() {
    uboot-mkimage -A ${UBOOT_ARCH} -O linux -T script -C none -a 0 -e 0 -n "${BOOT_SCRIPT_DESC}" -d "${WORKDIR}/${BOOT_SCRIPT}" ${BOOT_SCRIPT_DESTNAME}
}

do_install() {
    mkdir -p ${D}/boot
    install -m 0644 ${BOOT_SCRIPT_DESTNAME} ${D}/boot/${BOOT_SCRIPT_DESTNAME}
}


FILES_${PN} = "/boot/${BOOT_SCRIPT_DESTNAME}"
