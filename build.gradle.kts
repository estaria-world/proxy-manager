import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    id("com.github.johnrengelman.shadow") version "8.1.1"
    kotlin("jvm") version "1.9.22"
}

allprojects {
    group = "world.estaria"
    version = "1.0.1"

    apply {
        plugin("org.jetbrains.kotlin.jvm")
        plugin("com.github.johnrengelman.shadow")
    }

    repositories {
        mavenCentral()

        // jitpack repositories
        maven("https://jitpack.io/")

        // minecraft repositories
        maven("https://repo.papermc.io/repository/maven-public/")
        maven("https://oss.sonatype.org/content/repositories/central")
        maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
        maven("https://repo.loohpjames.com/repository/")

        // estaria dependencies
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/estaria-world/kube-configmap-kit")
            credentials {
                username = project.findProperty("gpr.user") as String? ?: System.getenv("USERNAME")
                password = project.findProperty("gpr.key") as String? ?: System.getenv("TOKEN")
            }
        }
    }
}

subprojects {
    dependencies {
        compileOnly(kotlin("stdlib"))

        // estaria dependencies
        compileOnly("world.estaria:kube-configmap-kit:1.0.4")

        // avionik dependencies
        compileOnly("world.avionik:config-kit:1.0.2")

        // kubernetes dependencies
        compileOnly("io.fabric8:kubernetes-client:6.12.1")
    }

    tasks.named("shadowJar", ShadowJar::class) {
        mergeServiceFiles()
    }
}