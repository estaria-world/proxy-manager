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
        repositories {
            maven {
                name = "estaria"
                url = uri("https://repo.estaria.world/releases")
                credentials(PasswordCredentials::class.java)
            }
        }
    }
}

subprojects {
    dependencies {
        compileOnly(kotlin("stdlib"))

        // estaria dependencies
        compileOnly("world.estaria:github-file-manager:1.2.0")

        // avionik dependencies
        compileOnly("world.avionik:config-kit:1.0.2")
    }

    tasks.named("shadowJar", ShadowJar::class) {
        mergeServiceFiles()
    }
}