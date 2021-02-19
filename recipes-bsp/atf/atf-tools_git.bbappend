# This SRC_URI is based on the LSDK-20.12 tag of the qoriq atf repository
SRC_URI_remove = "git://source.codeaurora.org/external/qoriq/qoriq-components/atf;nobranch=1"
SRC_URI += "git://git@github-readonly-shared/Scalys/trustsom-atf-qoriq.git;nobranch=1;protocol=ssh"
SRCREV = "217a00f8acffd2bc71e8be7857b96a53262a9e9f"
