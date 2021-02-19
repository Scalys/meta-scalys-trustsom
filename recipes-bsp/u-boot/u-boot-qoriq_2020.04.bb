# For now we will require the old 2019.10 recipe
require recipes-bsp/u-boot/u-boot-qoriq_2019.10.bb

# This SRC_URI is based on the LSDK-20.12 tag of the qoriq u-boot repository
SRC_URI = "git://git@github-readonly-shared/Scalys/trustsom-uboot.git;nobranch=1;protocol=ssh"
SRCREV = "768550f771fd0cf0a0b0abac95b8e9e7588c36a0"
