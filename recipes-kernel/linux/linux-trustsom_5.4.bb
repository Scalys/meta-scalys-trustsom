require linux-trustsom.inc

LINUX_VERSION ?= "5.4.47-trustsom"

SRC_URI_append = "git://git@github-readonly-shared/Scalys/trustsom-linux.git;nobranch=1;protocol=ssh"

# This SRC_URI is based on the LSDK-20.12-V5.4 tag of the qoriq linux repository
SRCREV_trustsom  = "66122fe32572f768dee2c0e304c1e610b0c23b04"
KBRANCH = "trustsom-LSDK-20.12-V5.4"
