SUMMARY = "L2MACD Daemon"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

DEPENDS = "ops-ovsdb ops-cli"

BRANCH ?= "${OPS_REPO_BRANCH}"

SRC_URI = "${OPS_REPO_BASE_URL}/ops-l2macd;protocol=${OPS_REPO_PROTOCOL};branch=${BRANCH} \
           file://ops-l2macd.service \
           "

SRCREV = "ac97f292dd6bf41c21b731abe234a00cbed19dd2"

# When using AUTOREV, we need to force the package version to the revision of git
# in order to avoid stale shared states.
PV = "git${SRCPV}"

S = "${WORKDIR}/git"

FILES_${PN} += "/usr/lib/cli/plugins/"

inherit openswitch cmake
