SRC_URI_remove = "git://source.codeaurora.org/external/qoriq/qoriq-components/linux;nobranch=1"
SRC_URI += "git://git@github-readonly-shared/Scalys/trustsom-linux.git;nobranch=1;protocol=ssh"
SRCREV = "bbfba762bd56a0b25f92fb7490b1e6192616354c"

DELTA_KERNEL_DEFCONFIG_prepend_trustsom-tbdconnect = "trustsom_tbdconnect.config "
