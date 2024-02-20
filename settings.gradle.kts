rootProject.name = "Pyron-Client"

dependencyResolutionManagement {
    @Suppress("UnstableApiUsage")
    repositories {
        mavenCentral()
        maven("https://repo.runelite.net")
        maven("https://jitpack.io")
        maven("https://nexus.motechproject.org/content/repositories/releases/")
    }
}

pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://jitpack.io")
    }
    plugins {
        kotlin("jvm") version "1.9.22"
        id("com.github.johnrengelman.shadow") version "8.1.1"
    }
    resolutionStrategy {
        eachPlugin {
            if(requested.id.toString() == "com.mark.bootstrap.bootstrap")
                useModule("com.github.Mark7625:bootstrap-release:9457850336")
        }
    }
}

include("game","runelite", "app")