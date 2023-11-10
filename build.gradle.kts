plugins {
    kotlin("jvm") version "1.9.0"
    application
}

group = "com.waigoma"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("net.dv8tion:JDA:5.0.0-beta.17")
    implementation("commons-io:commons-io:2.15.0")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("MainKt")
}