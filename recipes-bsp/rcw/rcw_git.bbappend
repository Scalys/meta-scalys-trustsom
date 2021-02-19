# This SRC_URI is based on the LSDK-20.12 tag of the qoriq rcw repository
SRC_URI_remove = "git://source.codeaurora.org/external/qoriq/qoriq-components/rcw;nobranch=1"
SRC_URI += "git://git@github-readonly-shared/Scalys/trustsom-rcw.git;nobranch=1;protocol=ssh"
SRCREV = "85d63ce6a5f5bf144b5bc35413af0f028b39c96a"

BOARD_TARGETS_trustsom-tbdconnect="trustsom_tbdconnect"
