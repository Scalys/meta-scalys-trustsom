SUMMARY = "Scalys image for a small internal on-board MTD"
DESCRIPTION = ""
LICENSE = "GPLV2"
LIC_FILES_CHKSUM = ""


require scalys-base-image.inc


IMAGE_FSTYPES = "cpio.gz"

IMAGE_INSTALL_remove = "\
    kernel-image \
    kernel-devicetree \
"

IMAGE_FEATURES += "read-only-rootfs"
