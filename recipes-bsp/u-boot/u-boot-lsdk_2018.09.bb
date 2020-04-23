require recipes-bsp/u-boot/u-boot-qoriq_2018.09.bb

FILESEXTRAPATHS_prepend := "${THISDIR}/patches:${THISDIR}/files:"
include recipes-bsp/u-boot/u-boot-mender.inc

SRCBRANCH = "trustbox-1903"
SRC_URI = "gitsm://github.com/Scalys/u-boot-qoriq.git;protocol=git;branch=${SRCBRANCH} \
"
SRCREV = "074705471b3630f2725794a69d2d1a0c471abdf2"
SRC_URI_append = "${@bb.utils.contains('MENDER_UBOOT_AUTO_CONFIGURE', \
    '1', \
    ' file://0001-Store-environment-on-mmc-for-mender-integration.patch', \
    '', \
    d)}"
SRC_URI_remove_mender-uboot = " file://0006-env-Kconfig-Add-descriptions-so-environment-options-.patch"

DEPENDS += "flex-native bison-native"
