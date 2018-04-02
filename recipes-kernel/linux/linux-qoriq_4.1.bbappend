FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append_grapeboard += "\
    file://0001-arm64-dts-freescale-ls1012a-Add-DTS-support-for-Scal.patch \
    file://grapeboard.config \
"

DELTA_KERNEL_DEFCONFIG += " grapeboard.config"

SRCREV = "1ae843c08261402b2c35d83422e4fa1e313611f4"

do_uboot_mkimage() {
    # Compress Image
    gzip -9c < arch/${ARCH}/boot/Image > arch/${ARCH}/boot/Image.gz

    # Generate uImage
    uboot-mkimage -A ${UBOOT_ARCH} -O linux -T kernel -C gzip -a ${UBOOT_LOADADDRESS} -e ${UBOOT_ENTRYPOINT} -n "${DISTRO_NAME}/${PV}/${MACHINE}" -d arch/${ARCH}/boot/Image.gz arch/${ARCH}/boot/uImage
}

do_deploy_append() {
    KERNEL_UIMAGE=arch/${ARCH}/boot/uImage
    KERNEL_UIMAGE_BASE_NAME="uImage-${PKGE}-${PKGV}-${PKGR}-${MACHINE}-${DATETIME}"

	install -m 0644 ${KERNEL_UIMAGE} ${DEPLOYDIR}/${KERNEL_UIMAGE_BASE_NAME}.bin
}

addtask uboot_mkimage before do_install after do_compile