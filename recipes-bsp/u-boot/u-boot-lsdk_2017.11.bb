require recipes-bsp/u-boot/u-boot-qoriq_2018.03.bb


SRCBRANCH = "scalys-lsdk-1803"
SRC_URI = "git://git.scalys.com/lsdk/u-boot;protocol=git;branch=${SRCBRANCH} \
"
SRCREV = "4f6f24dd262af3de99af72125e576a290efe00ee"
