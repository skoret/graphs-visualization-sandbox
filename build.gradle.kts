plugins {
    application
    kotlin("jvm") version "1.4.31"
    id("org.openjfx.javafxplugin") version "0.0.9"
}

repositories {
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))
    implementation("no.tornado:tornadofx:1.7.20")  {
        exclude("org.jetbrains.kotlin")
    }
}

application {
    mainClass.set("com.example.MyApp")
}

javafx {
    version = "11.0.2"
    modules("javafx.controls")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "11"
    }
}
