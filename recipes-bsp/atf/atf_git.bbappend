# This SRC_URI is based on the LSDK-20.12 tag of the qoriq atf repository
SRC_URI_remove = "git://source.codeaurora.org/external/qoriq/qoriq-components/atf;nobranch=1"
SRC_URI += "git://git@github-readonly-shared/Scalys/trustsom-atf-qoriq.git;nobranch=1;protocol=ssh"
SRCREV = "217a00f8acffd2bc71e8be7857b96a53262a9e9f"

PLATFORM_trustsom-tbdconnect = "ls1028trustsom"
RCW_FOLDER_trustsom-tbdconnect = "trustsom_tbdconnect"

# set 'DISTRO_FEATURES_append = " secure"' in local.conf to enable secure boot
# set 'DISTRO_FEATURES_append = " srk_revocation_support"' in local.conf to enable the use of multiple SRK pairs so that key revocation is supported.
# Set the following in local.conf if 'srk_revocation_support' is enabled:
# SECURE_PRI_KEYS = "<path/to/keydir/*.pri>"
# SECURE_PUB_KEYS = "<path/to/keydir/*.pub>"
# BL33_INPUT_FILE = "<path/to/dir/bl33_input_file>"
# BL31_INPUT_FILE = "<path/to/dir/bl31_input_file>"
# BL32_INPUT_FILE = "<path/to/dir/bl32_input_file>"
# BL2_INPUT_FILE = "<path/to/dir/bl2_input_file>"
# PBI_INPUT_FILE = "<path/to/dir/pbi_input_file>"

BUILD_SRK_REVOK_SUPPORT = "${@bb.utils.contains('DISTRO_FEATURES', 'srk_revocation_support', 'true', 'false', d)}"

# For now we will abuse the 'ddrphyopt' variable used in the 'do_compile' function to support custom input files for the signing else we have to completely override / patch the 'do_compile' function.
ddrphyopt += "${@ 'BL33_INPUT_FILE=${ATF_BL33_INPUT_FILE}' if d.getVar('ATF_BL33_INPUT_FILE') else ''}"
ddrphyopt += " ${@ 'BL31_INPUT_FILE=${ATF_BL31_INPUT_FILE}' if d.getVar('ATF_BL31_INPUT_FILE') else ''}"
ddrphyopt += " ${@ 'BL32_INPUT_FILE=${ATF_BL32_INPUT_FILE}' if d.getVar('ATF_BL32_INPUT_FILE') else ''}"
ddrphyopt += " ${@ 'BL2_INPUT_FILE=${ATF_BL2_INPUT_FILE}' if d.getVar('ATF_BL2_INPUT_FILE') else ''}"
ddrphyopt += " ${@ 'PBI_INPUT_FILE=${ATF_PBI_INPUT_FILE}' if d.getVar('ATF_PBI_INPUT_FILE') else ''}"

# The following functions will add support for more than one SRK pair in order to support SRK revocation.
do_compile_prepend() {
    if [ "${BUILD_SECURE}" = "true" -a "${BUILD_SRK_REVOK_SUPPORT}" = "true" ]; then
        if [ -n "${SECURE_PRI_KEYS}" ]; then
            cp -f ${SECURE_PRI_KEYS} ${S}
        else
            bbfatal "SECURE_PRI_KEYS not defined"
        fi
        if [ -n "${SECURE_PUB_KEYS}" ]; then
            cp -f ${SECURE_PUB_KEYS} ${S}
        else
            bbfatal "SECURE_PUB_KEYS not defined"
        fi
    fi
}

do_install_prepend() {
    install -d ${D}/boot/atf
    cp -r ${S}/*.pri ${D}/boot/atf
    cp -r ${S}/*.pub ${D}/boot/atf
}

do_deploy_prepend() {
    install -d ${DEPLOYDIR}/atf
    cp -r ${D}/boot/atf/*.pri ${DEPLOYDIR}/atf
    cp -r  ${D}/boot/atf/*.pub ${DEPLOYDIR}/atf
}
