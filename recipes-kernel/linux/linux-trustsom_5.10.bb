require linux-trustsom.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

LINUX_VERSION ?= "5.10.57"

SRC_URI_append = "\
    git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux.git;nobranch=1 \
    file://trustsom-tbdconnect.dts \
"
# Linux 5.10.57
# https://lore.kernel.org/r/20210806081113.126861800@linuxfoundation.org
SRCREV_trustsom  = "1cd6e30b83d741562b55bf5b7763b1238a91150c"

# Inject our device tree
do_configure_append() {
    cp ${WORKDIR}/trustsom-tbdconnect.dts ${S}/arch/arm64/boot/dts/freescale/
}
