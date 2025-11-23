plugins {
    alias(libs.plugins.kotlinJvm)
}

group = "no.jeantuffier.functionalarchitecture.bankterminal.v400"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":bankterminal"))
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