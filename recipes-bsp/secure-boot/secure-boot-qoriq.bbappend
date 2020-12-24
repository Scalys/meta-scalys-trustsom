FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

unset do_patch[noexec]

SRC_URI_append_trustsom-tbdconnect = " file://create_secure_boot_image_trustsom_support.patch"

BOOT_TYPE_trustsom-tbdconnect ?= "sd"
