rootProject.name = "Vanguard-Client"

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
    resolutionStrategy {
        eachPlugin {
            if(requested.id.toString() == "com.mark.bootstrap.bootstrap")
                useModule("com.github.Mark7625:bootstrap-release:1676854127")
        }
    }
}

include("game","runelite")