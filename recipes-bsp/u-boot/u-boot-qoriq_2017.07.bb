require recipes-bsp/u-boot/u-boot-qoriq.inc

LICENSE = "GPLv2 & BSD-3-Clause & BSD-2-Clause & LGPL-2.0 & LGPL-2.1"
LIC_FILES_CHKSUM = " \
    file://Licenses/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
    file://Licenses/bsd-2-clause.txt;md5=6a31f076f5773aabd8ff86191ad6fdd5 \
    file://Licenses/bsd-3-clause.txt;md5=4a1190eac56a9db675d58ebe86eaf50c \
    file://Licenses/lgpl-2.0.txt;md5=5f30f0716dfdd0d91eb439ebec522ec2 \
    file://Licenses/lgpl-2.1.txt;md5=4fbd65380cdd255951079008b364516c \
"

SRC_URI = "git://git.scalys.com/lsdk/u-boot;protocol=http;branch=grapeboard-proto"
SRCBRANCH = "grapeboard-proto"
SRCREV = "eb59b5064aad50871ab856924913c83797711ca6"

do_compile_prepend () {
    # Fix 'python.h not found' build issue
    sed 's@\(^always += $(if $(shell which swig 2> /dev/null),_libfdt.so)$\)@# do not autodetect swig, there is no swig-native dependency \1@g' -i ${S}/tools/Makefile
}
