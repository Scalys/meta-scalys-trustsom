# This SRC_URI is based on the LSDK-20.12-V5.4 tag of the qoriq linux repository
SRC_URI = "git://git@github-readonly-shared/Scalys/trustsom-linux.git;nobranch=1;protocol=ssh"
SRCREV = "2f1f7770e725fbbcabaf9218571cb8197ee766ea"

DELTA_KERNEL_DEFCONFIG_prepend_trustsom-tbdconnect = "trustsom_tbdconnect.config "
