plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "proxy-manager"
include("proxy-manager-api")
include("proxy-manager-plugin")
