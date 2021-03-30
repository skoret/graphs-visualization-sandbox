import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    application
    kotlin("jvm")
    id("org.openjfx.javafxplugin")
}

repositories {
    jcenter()
}

val `tornadofx-version`: String by project

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))
    implementation("no.tornado:tornadofx:$`tornadofx-version`")  {
        exclude("org.jetbrains.kotlin")
    }
}

application {
    mainClass.set("com.example.demo.MainApp")
}

val `javafx-version`: String by project

javafx {
    version = `javafx-version`
    modules("javafx.controls")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}
