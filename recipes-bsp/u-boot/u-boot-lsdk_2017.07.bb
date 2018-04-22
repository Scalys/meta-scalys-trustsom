require recipes-bsp/u-boot/u-boot-qoriq.inc

LICENSE = "GPLv2 & BSD-3-Clause & BSD-2-Clause & LGPL-2.0 & LGPL-2.1"
LIC_FILES_CHKSUM = " \
    file://Licenses/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
    file://Licenses/bsd-2-clause.txt;md5=6a31f076f5773aabd8ff86191ad6fdd5 \
    file://Licenses/bsd-3-clause.txt;md5=4a1190eac56a9db675d58ebe86eaf50c \
    file://Licenses/lgpl-2.0.txt;md5=5f30f0716dfdd0d91eb439ebec522ec2 \
    file://Licenses/lgpl-2.1.txt;md5=4fbd65380cdd255951079008b364516c \
"

SRCBRANCH = "scalys-lsdk-1803"
SRC_URI = "git://git.scalys.com/lsdk/u-boot;protocol=git;branch=${SRCBRANCH} \
    \
    file://0001-Fix-python.h-not-found-build-issue.patch \
    file://0002-Remove-dependency-on-generated-autoconf.h.patch \
    file://0003-UBIFS-and-distroboot-support-and-rescue-target-build.patch \
    file://0004-grapeboard-Increase-malloc-pool-size.patch \
    file://0005-ubifs-Silence-non-critical-assert-warnings.patch \
    file://0006-mtd-Change-default-mtd-id-to-the-one-used-in-kernel.patch \
"
SRCREV = "da6dafeb26b827d753e027920d14a287f678d659"
