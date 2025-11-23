plugins {
    alias(libs.plugins.kotlinJvm)
}

group = "no.jeantuffier.functionalarchitecture"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":bankterminal"))
    implementation(project(":bankterminal:v400"))

    implementation(libs.koin)

    testImplementation(platform(libs.junit.bom))
    testImplementation(libs.junit.jupiter)
    testRuntimeOnly(libs.junit.jupiter.launcher)
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(libs.versions.jvmToolchain.get().toInt())
}