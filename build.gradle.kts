plugins {
    kotlin("jvm") version "1.6.20"
    id("io.papermc.paperweight.userdev") version "1.3.6"
}

val mcVersion = "1.18.2"
val isSnapshot = true

group = "net.spurkomet"
version = "$mcVersion${if(isSnapshot){"-SNAPSHOT"}else{""}}"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    paperDevBundle("1.18.2-R0.1-SNAPSHOT")
    implementation("net.axay:kspigot:1.18.2")
}

tasks {
    compileJava {
        options.encoding = "UTF-8"
        options.release.set(17)
    }
    compileKotlin {
        kotlinOptions.jvmTarget = "17"
    }
}