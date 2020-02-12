SRC_URI = "git://github.com/Scalys/linux-qoriq.git;protocol=git;branch=scalys-4.19"
SRCREV = "4acbb47387c60dfdeeb2d9d636a189809b7dca44"

DELTA_KERNEL_DEFCONFIG_append_qls1046a-4gb = " qls1046a-4gb.config"

# Insert fitImage into /boot/ folder of rootfs
RDEPENDS_${KERNEL_PACKAGE_NAME}-base += " kernel-image kernel-devicetree"
