require recipes-bsp/u-boot/u-boot-qoriq_2017.09.bb


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