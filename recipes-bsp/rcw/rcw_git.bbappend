# This SRC_URI is based on the LSDK-20.12 tag of the qoriq rcw repository
SRC_URI_remove = "git://source.codeaurora.org/external/qoriq/qoriq-components/rcw;nobranch=1"
SRC_URI += "git://git@github-readonly-shared/Scalys/trustsom-rcw.git;nobranch=1;protocol=ssh"
SRCREV = "60f6395f1d5a877642cc02d6d9c6e36356721faa"

BOARD_TARGETS_trustsom-tbdconnect="trustsom_tbdconnect"
