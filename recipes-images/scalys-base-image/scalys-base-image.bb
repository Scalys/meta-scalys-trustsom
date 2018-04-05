SUMMARY = "Generic Scalys base image"
DESCRIPTION = "This image is meant to be used as a starting point for custom images"
LICENSE = "GPLV2"
LIC_FILES_CHKSUM = ""


require recipes-fsl/images/fsl-image-core.bb


IMAGE_FSTYPES = "tar.gz ext2.gz ext2.gz.u-boot ubi ubifs"

IMAGE_INSTALL += "\
    kernel-devicetree \
    kernel-modules \
    \
    dhcp-client \
    kernel-module-8723bu \
    linux-firmware-rtl8723bu_bt \
    linux-firmware-rtl8723bu_nic \
    iw \
    wpa-supplicant \
    crda \
    \
    mtd-utils \
    mtd-utils-ubifs \
    i2c-tools \
    \
    openssh \
    \
    packagegroup-core-full-cmdline \
    tmux \
    nano \
    vim \
"

EXTRA_IMAGE_FEATURES += "tools-sdk tools-debug"