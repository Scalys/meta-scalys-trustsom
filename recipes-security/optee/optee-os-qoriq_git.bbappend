# This SRC_URI is based on the LSDK-20.12 tag of the qoriq optee_os repository
SRC_URI_remove = "git://source.codeaurora.org/external/qoriq/qoriq-components/optee_os;nobranch=1"
SRC_URI += "git://git@github-readonly-shared/Scalys/trustsom-optee_os.git;nobranch=1;protocol=ssh"
SRCREV = "4b10dd24a1bc897c48b50ab56b40b82fcfeaf4f9"

OPTEEMACHINE_trustsom-tbdconnect = "trustsom_tbdconnect"
