require recipes-fsl/images/fsl-image-networking.bb 

export IMAGE_BASENAME = "trustsom-fsl-image-networking"

PACKAGE_ARCH = "${MACHINE_ARCH}"

IMAGE_FSTYPES = "tar.gz ext2.gz ext2.gz.u-boot jffs2 ubi cpio.gz.u-boot"

SUMMARY = "A Small image that can be used for evaluating the Scalys TrustSoM."

DESCRIPTION = "This is a small image which includes OP-TEE, some helpful tools and \
Freescale-specific packages."

LICENSE = "MIT"

#IMAGE_INSTALL_append = " \
#"

