require ${BPN}.inc

SUMMARY = "a fast C/C++ compiler cache"
DESCRIPTION = "ccache is a compiler cache. It speeds up recompilation \
by caching the result of previous compilations and detecting when the \
same compilation is being done again. Supported languages are C, C\+\+, \
Objective-C and Objective-C++."
HOMEPAGE = "http://ccache.samba.org"
SECTION = "devel"

LICENSE = "GPLv3+"
LIC_FILES_CHKSUM = "file://LICENSE.adoc;md5=22d514dbc01fdf9a9784334b6b59417a"

DEPENDS = "zlib gperf"

SRC_URI = " \
    git://github.com/ccache/ccache.git;branch=3.7-maint \
    file://0001-mno-docs.patch \
"
S = "${WORKDIR}/git"

UPSTREAM_CHECK_URI = "https://github.com/ccache/ccache/releases/"

inherit autotools

# Remove ccache-native's dependencies, so that it can be used widely by
# other native recipes.
EXTRA_OECONF_class-native = "--with-bundled-zlib --disable-man"
PATCHTOOL = "patch"

BBCLASSEXTEND = "native"
