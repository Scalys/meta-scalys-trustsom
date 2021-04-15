# This SRC_URI is based on the LSDK-20.12-V5.4 tag of the qoriq linux repository
SRC_URI = "git://git@github-readonly-shared/Scalys/trustsom-linux.git;nobranch=1;protocol=ssh"
SRCREV = "66122fe32572f768dee2c0e304c1e610b0c23b04"

DELTA_KERNEL_DEFCONFIG_append_trustsom-tbdconnect = "trustsom_tbdconnect.config "
