pluginManagement {
    val `kotlin-version`: String by settings
    val `javafxplugin-version`: String by settings

    plugins {
        kotlin("jvm") version `kotlin-version`
        id("org.openjfx.javafxplugin") version `javafxplugin-version`
    }
}

rootProject.name = "graphs-visualization-sandbox"
