require recipes-fsl/images/fsl-image-networking.bb

export IMAGE_BASENAME = "trustsom-test-image"

PACKAGE_ARCH = "${MACHINE_ARCH}"

IMAGE_FSTYPES = "tar.gz ext4"
# Increase ext4 image size with 1GB of free space
IMAGE_ROOTFS_EXTRA_SPACE = "1048576"

IMAGE_INSTALL_append = " kernel-image kernel-devicetree"

SUMMARY = "An image that can be used for evaluating the Scalys TrustSoM."

DESCRIPTION = "This is an image which includes OP-TEE, some helpful tools and \
Freescale-specific packages."

LICENSE = "MIT"

IMAGE_INSTALL_benchmark_tests = "\
    rt-tests \
    stress-ng \
    bonnie++ \
    dbench \
    iperf3 \
    libhugetlbfs \
    memtester \
    tiobench \
    fio \
    iozone3 \
    lmbench \
    nbench-byte \
    tinymembench \
"

IMAGE_INSTALL_devtools = "\
    gdb \
    gdbserver \
    tcf-agent \
    strace \
    lsof \
    tcpdump \
    \
    ncurses \
    packagegroup-core-sdk \
    packagegroup-core-standalone-sdk-target \
    \
    spidev-test \
    spitools \
    \
    usbutils \
"

IMAGE_INSTALL += "\
    \
    kernel-devicetree \
    kernel-modules \
    \
    packagegroup-core-full-cmdline \
    \
    openssh \
    \
    tmux \
    \
    i2c-tools \
    nano \
    vim \
    \
    mtd-utils \
    \
    ccid \
    opensc \
    pcsc-lite \
    \
    ${IMAGE_INSTALL_devtools} \
    ${IMAGE_INSTALL_benchmark_tests} \
"

IMAGE_INSTALL_remove += "\
"
