SRC_URI = "gitsm://github.com/ms-iot/optee_client.git;protocol=https;branch=ms-iot-openenclave-3.6.0"
SRCREV = "4e91c54a6384f7975779d61d88c8da1a5e0dd799"

do_install_prepend() {
    export SBINDIR="/bin"
    export BINDIR="/bin"
    export LIBDIR="/lib"
    export INCLUDEDIR="/include"
}