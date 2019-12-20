require linux-qoriq.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/linux-qoriq_4.14:"

SRC_URI += "\
    file://0003-Disable-4-byte-addressing-mode-for-QSPI-flash.patch \
"
