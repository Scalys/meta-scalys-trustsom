require recipes-core/images/core-image-minimal.bb

export IMAGE_BASENAME = "trustsom-base-image"

PACKAGE_ARCH = "${MACHINE_ARCH}"

CORE_IMAGE_EXTRA_INSTALL += "udev-extraconf lsb-release"
CORE_IMAGE_EXTRA_INSTALL_append_qoriq = " udev-rules-qoriq"

IMAGE_FSTYPES = "tar.gz ext4 ext2.gz"

SUMMARY = "A Small image that can be used for evaluating the Scalys TrustSoM."
DESCRIPTION = "This is a small image which includes some helpful tools and \
Freescale-specific packages."

LICENSE = "MIT"

IMAGE_INSTALL += " \
    packagegroup-core-ssh-openssh \
    packagegroup-fsl-mfgtools \
    packagegroup-fsl-tools-core \
    packagegroup-fsl-benchmark-core \
    packagegroup-fsl-networking-core \
"

IMAGE_INSTALL += "\
    kernel-image \
    kernel-devicetree \
    kernel-modules \
    packagegroup-core-full-cmdline \
    ccid \
    opensc \
    pcsc-lite \
    tpm2-tools \
    trousers \
    tpm2-tss \
    libtss2 \
    libtss2-mu \
    libtss2-tcti-device \
    libtss2-tcti-mssim \
    tpm2-abrmd \
    ibmswtpm2 \
    cryptsetup-tpm-incubator \
"


# Support for Wi-Fi module.
IMAGE_INSTALL += "   \
  ca-certificates \
  iproute2 \
  rng-tools \
  tzdata \
  alsa-utils \
  htop \
  ethtool \
  tcpdump \
  iw \
  wpa-supplicant \
  rfkill \
  dhcpcd \
  linux-firmware-iwlwifi-misc \
  linux-firmware-ibt-misc \
"
