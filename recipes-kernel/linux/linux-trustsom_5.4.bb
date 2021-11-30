require linux-trustsom.inc

LINUX_VERSION ?= "5.4.155-trustsom"
#commit 4f508aa9dd3bde7a1c5e4e6de72abb8a03fd504a
#Author: Greg Kroah-Hartman <gregkh@linuxfoundation.org>
#Date:   Wed Oct 20 11:40:18 2021 +0200
#
#    Linux 5.4.155
SRC_URI_append = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable-rc.git;nobranch=1;protocol=https"
     
SRCREV  = "4f508aa9dd3bde7a1c5e4e6de72abb8a03fd504a"
