SUMMARY = "Scalys image for a small internal on-board MTD"
DESCRIPTION = ""
LICENSE = "GPLV2"
LIC_FILES_CHKSUM = ""

inherit fitimage

FITIMAGE_SLOTS = "kernel fdt ramdisk"

FITIMAGE_SLOT_kernel = "linux-qoriq"
FITIMAGE_SLOT_kernel[type] = "kernel"
FITIMAGE_SLOT_kernel[file] = "Image.gz"
FITIMAGE_SLOT_kernel[comp] = "gzip"

FITIMAGE_SLOT_fdt = "linux-qoriq"
FITIMAGE_SLOT_fdt[type] = "fdt"
FITIMAGE_SLOT_fdt[file] = "trustbox.dtb"

FITIMAGE_SLOT_ramdisk = "scalys-base-image-ramdisk"
FITIMAGE_SLOT_ramdisk[type] = "ramdisk"
FITIMAGE_SLOT_ramdisk[fstype] = "cpio.gz"

FITIMAGE_LOADADDRESS = "${UBOOT_LOADADDRESS}"
FITIMAGE_ENTRYPOINT = "${UBOOT_ENTRYPOINT}"
FITIMAGE_DTB_LOADADDRESS = "${DTB_LOAD}"

#
#    FITIMAGE_its ?= "setup.its"  (FIT Image creation File, if set, then no creation if config file)
#
# Additionally you need to provide a certificate and a key file
#
#    FITIMAGE_KEY_FILE ?= "development-1.key.pem"
#    FITIMAGE_CERT_FILE ?= "development-1.cert.pem"
