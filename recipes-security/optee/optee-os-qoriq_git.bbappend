#SUMMARY = "OP-TEE Trusted OS"
#DESCRIPTION = "OPTEE OS"

SRC_URI_remove = "git://source.codeaurora.org/external/qoriq/qoriq-components/optee_os;nobranch=1"
SRC_URI += "git://git@github-readonly-shared/Scalys/trustsom-optee_os.git;branch=trustsom-LSDK-20.04;protocol=ssh"
SRCREV = "4b10dd24a1bc897c48b50ab56b40b82fcfeaf4f9"
 
OPTEEMACHINE_trustsom-tbdconnect = "trustsom_tbdconnect"

