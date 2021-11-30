require linux-trustsom.inc

LINUX_VERSION ?= "5.10.76"

#commit 378e85d1aeb5c93db43f2089630ec40c7385bd54
#Author: Greg Kroah-Hartman <gregkh@linuxfoundation.org>
#Date:   Wed Oct 27 09:56:57 2021 +0200
#    Linux 5.10.76
SRCREV = "378e85d1aeb5c93db43f2089630ec40c7385bd54"

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"
SRC_URI_append = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux.git;nobranch=1"
