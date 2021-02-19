require trustsom-base-image.bb

export IMAGE_BASENAME = "trustsom-test-image"

# Increase ext4 image size with 1GB of free space
IMAGE_ROOTFS_EXTRA_SPACE = "1048576"

SUMMARY = "An image that can be used for testing the Scalys TrustSoM."

DESCRIPTION = "This is an image which includes some helpful tools and \
Freescale-specific packages."

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
    ncurses \
    packagegroup-core-sdk \
    packagegroup-core-standalone-sdk-target \
    spidev-test \
    spitools \
    usbutils \
    i2c-tools \
    nano \
    tmux \
    openssh \
"

IMAGE_INSTALL_virtualization = "\
    qemu \
    qemu-dev \
    libvirt \
    libvirt-dev \
    libvirt-libvirtd \
    libvirt-virsh \
    iptables \
    bridge-utils \
    tunctl \
"

IMAGE_INSTALL += "\
    ${IMAGE_INSTALL_devtools} \
    ${IMAGE_INSTALL_benchmark_tests} \
    ${IMAGE_INSTALL_virtualization} \
"
