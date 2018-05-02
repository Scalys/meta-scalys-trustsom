
#do_uboot_mkimage() {
#    # Compress Image
#    gzip -9c < arch/${ARCH}/boot/Image > arch/${ARCH}/boot/Image.gz
#
#    # Generate uImage
#    uboot-mkimage -A ${UBOOT_ARCH} -O linux -T kernel -C gzip -a ${UBOOT_LOADADDRESS} -e ${UBOOT_ENTRYPOINT} -n "${DISTRO_NAME}/${PV}/${MACHINE}" -d arch/${ARCH}/boot/Image.gz arch/${ARCH}/boot/uImage
#}
#addtask uboot_mkimage before do_install after do_compile
#
#do_install() {
#    mkdir -p ${D}/boot
#    install -m 0644 arch/${ARCH}/boot/uImage ${D}/boot/uImage
#    install -m 0644 arch/${ARCH}/boot/dts/freescale/${MACHINE}.dtb ${D}/boot/${MACHINE}.dtb
#}
#
## Remove dtb file created by linux-dtb.inc recipe
#do_install_append() {
#    rm ${D}/${KERNEL_IMAGEDEST}/devicetree-${DTB_SYMLINK_NAME}.dtb
#}
#
#do_deploy_append() {
#    KERNEL_UIMAGE=arch/${ARCH}/boot/uImage
#    KERNEL_UIMAGE_BASE_NAME="uImage-${PKGE}-${PKGV}-${PKGR}-${MACHINE}-${DATETIME}"
#
#    install -m 0644 ${KERNEL_UIMAGE} ${DEPLOYDIR}/${KERNEL_UIMAGE_BASE_NAME}.bin
#
#    # Create symlink to the latest build uImage
#    ln -sf ${KERNEL_UIMAGE_BASE_NAME}.bin ${DEPLOYDIR}/uImage
#
#    # Create symlink to the latest devicetree binary
#    DTB_NAME=`echo ${KERNEL_IMAGE_BASE_NAME} | sed "s/${MACHINE}/${DTB_BASE_NAME}/g"`
#    ln -sf ${DTB_NAME}.dtb ${DEPLOYDIR}/${MACHINE}.dtb
#}
#
## Remove Image symlink installed into /boot by the kernel.bbclass
#pkg_postinst_kernel-image() {
#    true
#}
#pkg_postrm_kernel-image() {
#    true
#}
#
#FILES_kernel-image = "/boot/uImage"
#FILES_kernel-devicetree = "/boot/grapeboard.dtb"
#FILES_kernel-modules = "/lib"