SRC_URI += "\
    file://0001-arm64-dts-freescale-ls1012a-Add-DTS-support-for-Scal.patch \
    file://0002-fsl_ppfe-Fix-phy-autonegotiation.patch \
    \
    file://grapeboard.config \
"

DEPENDS += "u-boot-mkimage-native"

DELTA_KERNEL_DEFCONFIG += " grapeboard.config"


do_uboot_mkimage() {
    # Compress Image
    gzip -9c < arch/${ARCH}/boot/Image > arch/${ARCH}/boot/Image.gz

    # Generate uImage
    uboot-mkimage -A ${UBOOT_ARCH} -O linux -T kernel -C gzip -a ${UBOOT_LOADADDRESS} -e ${UBOOT_ENTRYPOINT} -n "${DISTRO_NAME}/${PV}/${MACHINE}" -d arch/${ARCH}/boot/Image.gz arch/${ARCH}/boot/uImage
}
addtask uboot_mkimage before do_install after do_compile

do_install_append() {
    mkdir -p ${D}/boot
    install -m 0644 arch/${ARCH}/boot/uImage ${D}/boot/uImage
    install -m 0644 arch/${ARCH}/boot/dts/freescale/${MACHINE}.dtb ${D}/boot/${MACHINE}.dtb

    # Clean up unnecessary images
    rm -f ${D}/boot/devicetree-Image*.dtb
    rm -f ${D}/boot/Image*
}

# Remove Image symlink installed into /boot by the kernel.bbclass
pkg_postinst_kernel-image() {
    true
}
pkg_postrm_kernel-image() {
    true
}

FILES_${KERNEL_PACKAGE_NAME}-image += "/boot/uImage"
FILES_${KERNEL_PACKAGE_NAME}-devicetree += "/boot/grapeboard.dtb"
