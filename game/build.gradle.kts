plugins {
    kotlin("jvm")
}

kotlin {
    jvmToolchain(11)
}

dependencies {
    implementation(project(":runelite"))

    implementation("org.slf4j:slf4j-api:1.7.25")
    implementation("com.google.guava:guava:30.0-android")
    implementation("ch.qos.logback:logback-classic:1.2.9")
    implementation("commons-io:commons-io:2.7")
    implementation("org.apache.commons:commons-lang3:3.9")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.12.7.1")
    implementation("com.dorkbox:Notify:3.7")
    implementation("com.google.code.gson:gson:2.8.9")

    // https://github.com/aschoerk/reflections8
    implementation("net.oneandone.reflections8:reflections8:0.11.7")

    // Jackson
    implementation("com.fasterxml.jackson.core:jackson-core:2.8.6")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.12.7.1")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.8.6")

    implementation(group = "com.google.inject", name = "guice", version = "5.0.1")

    // https://mvnrepository.com/artifact/me.tongfei/progressbar
    implementation("me.tongfei:progressbar:0.9.5")
    implementation("org.jetbrains:annotations:24.0.0")

    // https://mvnrepository.com/artifact/com.thoughtworks.xstream/xstream
    implementation("com.thoughtworks.xstream:xstream:1.4.20")

    val lombok = module("org.projectlombok", "lombok", "1.18.26")
    compileOnly(lombok)
    annotationProcessor(lombok)
    testCompileOnly(lombok)
    testAnnotationProcessor(lombok)
}

tasks {
    register<JavaExec>("Run-Normal") {
        group = "Runelite"
        description = "Run Runelite in Normal Mode"
        classpath = project.sourceSets.main.get().runtimeClasspath
        mainClass.set("Application")
    }

    register<JavaExec>("Run-Development") {
        group = "Runelite"
        description = "Run Runelite in Development Mode"
        enableAssertions = true
        args = listOf("--developer-mode")
        classpath = project.sourceSets.main.get().runtimeClasspath
        mainClass.set("Application")
    }
}