plugins {
    kotlin("jvm") version "1.9.22"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.9")
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    implementation("junit:junit:4.12")

}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}