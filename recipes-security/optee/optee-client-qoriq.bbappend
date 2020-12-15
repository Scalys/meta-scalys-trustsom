SUMMARY = "OPTEE Client"
HOMEPAGE = "https://github.com/qoriq-open-source/optee_client"

SRC_URI_remove = "git://source.codeaurora.org/external/qoriq/qoriq-components/optee_client;nobranch=1"
SRC_URI += "git://git@github-readonly-shared/Scalys/trustsom-optee_client.git;branch=trustsom-LSDK-20.04;protocol=ssh"
SRCREV = "08428734c67fb559e420d87fa52fd74a955ea1bd"
 
