# Default recipe has incorrect path for the misc firmware.
# Only include relevant firmware for the AX200.
FILES_${PN}-ibt-misc    = "${nonarch_base_libdir}/firmware/intel/ibt-2*"

# Only include relevant firmware for the AX200.
FILES_${PN}-iwlwifi-misc   = "${nonarch_base_libdir}/firmware/iwlwifi-cc-a0-*.ucode"
