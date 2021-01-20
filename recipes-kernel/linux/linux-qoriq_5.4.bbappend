SRC_URI_remove = "git://source.codeaurora.org/external/qoriq/qoriq-components/linux;nobranch=1"
SRC_URI += "git://git@github-readonly-shared/Scalys/trustsom-linux.git;nobranch=1;protocol=ssh"
SRCREV = "e86bbeda9e6a9a79c335b8251d6cc6f6a7d85551"

DELTA_KERNEL_DEFCONFIG_prepend_trustsom-tbdconnect = "trustsom_tbdconnect.config "
