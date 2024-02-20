import com.github.jengelman.gradle.plugins.shadow.ShadowApplicationPlugin

plugins {
    kotlin("jvm")
    application
    id("com.github.johnrengelman.shadow")
}

kotlin {
    jvmToolchain(11)
}

dependencies {
    implementation(project(":game"))
}

val main_class_name: String by project

application {
    mainClass.set(main_class_name)
}

tasks {
    shadowJar {
        archiveBaseName.set("client")
        archiveClassifier.set("")
        archiveVersion.set("")

        isZip64 = true
    }
    named<Zip>("distZip").configure {
        enabled = false
    }
    named<Tar>("distTar").configure {
        enabled = false
    }
    named<CreateStartScripts>("startScripts").configure {
        enabled = false
    }
    named<CreateStartScripts>(ShadowApplicationPlugin.SHADOW_SCRIPTS_TASK_NAME).configure {
        enabled = false
    }
    named(ShadowApplicationPlugin.SHADOW_INSTALL_TASK_NAME).configure {
        enabled = false
    }
    named("shadowDistTar").configure {
        enabled = false
    }
    named("shadowDistZip").configure {
        enabled = false
    }
    withType<JavaCompile>().configureEach {
        options.isWarnings = false
        options.isDeprecation = false
        options.encoding = "UTF-8"
    }
}