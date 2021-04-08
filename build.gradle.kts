import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    application
    kotlin("jvm")
    id("org.openjfx.javafxplugin")
}

repositories {
    //mavenLocal()
    jcenter()
}

val `tornadofx-version`: String by project

dependencies {
    implementation(project("logger")) // import our sub-project
    //implementation("com.example.demo:logger:0.0.1")
    // import artifact from remote/local repository
    // or gradle will substitute this dependency with local 'logger' sources
    //  if we add 'includeBuild("logger")' to our 'settings.gradle.kts' file

    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))
    implementation("no.tornado:tornadofx:$`tornadofx-version`") {
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
