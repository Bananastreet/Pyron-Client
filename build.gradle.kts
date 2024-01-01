import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.8.22"
    application
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("com.mark.bootstrap.bootstrap")
}


buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("com.guardsquare:proguard-gradle:7.3.0")
    }
}

configure<com.mark.bootstrap.BootstrapPluginExtension> {
    uploadType.set(com.mark.bootstrap.UploadType.FTP)
    buildType.set("normal")
    customRepo.set("https://nexusrsps.com/rlclient/client/normal/repo")
    passiveMode.set(false)
}


allprojects {
    apply(plugin = "kotlin")
    apply(plugin = "application")
    apply(plugin = "com.github.johnrengelman.shadow")

    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = JavaVersion.VERSION_11.toString()
    }

    java {
        setSourceCompatibility(JavaVersion.VERSION_11.toString())
        setTargetCompatibility(JavaVersion.VERSION_11.toString())
    }
}

dependencies {
    implementation(project("game"))
}

tasks.withType<JavaCompile>().configureEach {
    options.isWarnings = false
    options.isDeprecation = false
    options.isIncremental = true
}

tasks {
    jar {
        destinationDirectory.set(file("${rootProject.buildDir}\\"))
    }
}

