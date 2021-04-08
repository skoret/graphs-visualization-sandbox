pluginManagement {
    val `kotlin-version`: String by settings
    val `javafxplugin-version`: String by settings

    plugins {
        kotlin("jvm") version `kotlin-version`
        id("org.openjfx.javafxplugin") version `javafxplugin-version`
    }
}

rootProject.name = "graphs-visualization-sandbox"

include("logger")
// add 'logger' as sub-project to our 'sandbox' root project
//includeBuild("logger")
// add our or third-party 'logger' project to composite build for our 'sandbox' project
