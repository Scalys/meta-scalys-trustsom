DESCRIPTION = "U-boot script for booting linux kernel + root from SD card with single ext4 partition"

include u-boot-bootscript.inc

BOOT_SCRIPT = "boot-mmc.cmd"
BOOT_SCRIPT_DESC = "Boot linux from ext4 SD card"
