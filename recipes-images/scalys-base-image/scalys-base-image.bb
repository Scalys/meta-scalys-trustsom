SUMMARY = "Scalys image for a SD cards. Can be used on USB/SATA with updated boot script"
DESCRIPTION = ""
LICENSE = "GPLV2"
LIC_FILES_CHKSUM = ""


require scalys-base-image.inc


IMAGE_FSTYPES = "tar.gz ext2.gz"

IMAGE_INSTALL += "\
    u-boot-mmc-boot \
"
