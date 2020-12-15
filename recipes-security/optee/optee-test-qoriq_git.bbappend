#SUMMARY = "OP-TEE sanity testsuite"
#HOMEPAGE = "https://github.com/qoriq-open-source/optee_test"

SRC_URI_remove = "git://source.codeaurora.org/external/qoriq/qoriq-components/optee_test;nobranch=1"
SRC_URI += "git://git@github-readonly-shared/Scalys/trustsom-optee_test.git;branch=trustsom-LSDK-20.04;protocol=ssh"
SRCREV = "669058459e4a544be12f37dab103ee4c2b32e31d"
 
