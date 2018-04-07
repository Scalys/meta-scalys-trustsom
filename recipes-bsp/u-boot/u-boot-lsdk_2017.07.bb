require recipes-bsp/u-boot/u-boot-qoriq.inc

LICENSE = "GPLv2 & BSD-3-Clause & BSD-2-Clause & LGPL-2.0 & LGPL-2.1"
LIC_FILES_CHKSUM = " \
    file://Licenses/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
    file://Licenses/bsd-2-clause.txt;md5=6a31f076f5773aabd8ff86191ad6fdd5 \
    file://Licenses/bsd-3-clause.txt;md5=4a1190eac56a9db675d58ebe86eaf50c \
    file://Licenses/lgpl-2.0.txt;md5=5f30f0716dfdd0d91eb439ebec522ec2 \
    file://Licenses/lgpl-2.1.txt;md5=4fbd65380cdd255951079008b364516c \
"

SRC_URI = "git:///build/res/u-boot;nobranch=1 \
    \
    file://0001-Fix-python.h-not-found-build-issue.patch \
    file://0002-Remove-dependency-on-generated-autoconf.h.patch \
"
SRCREV = "1871e1c708dcb86c60dd99af4cc1835568b7a599"
