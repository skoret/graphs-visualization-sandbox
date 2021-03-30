# graphs-visualization-sandbox
Sample project for graphs visualization with TornadoFX ([readme on russian](https://www.notion.so/skoret/kotlin-graphs-87f8d07433484cfa9024620080f8d45c))

## Setup
- Intellij IDEA `2020.3.2`
- Java `11.0.10 (x86_64) AdoptOpenJDK`
- Gradle `6.8.3`
- Kotlin `1.4.32`
- TornadoFX `1.7.20`
- JavaFX `11.0.2`
- OpenJFX JavaFX Gradle Plugin `0.0.9`

## Build & Run
Build: `./gradlew build` or `gradlew.bat build` on Windows   
Run: `./gradlew run` or `gradlew.bat run` on Windows   
Or open, build and run project from Intellij IDEA

## Troubleshooting
```log
👻 java.lang.UnsupportedClassVersionError: org/openjfx/gradle/JavaFXPlugin has been compiled
by a more recent version of the Java Runtime (class file version 55.0),
this version of the Java Runtime only recognizes class file versions up to 52.0
```

💡 Most likely, Java SDK version 8 (the same 52.0) is installed in the configuration of your project, but JavaFXPlugin was compiled and can only work with Java SDK version 11 (the same 55.0) | [source](https://www.baeldung.com/java-lang-unsupportedclassversion)

✅ Install Java SDK 11 (I have AdoptOpenJDK, for example). Probably will work with version 15 too. Next, we check that the settings in IDEA are set correctly:
- File | Project Structure... | Project Settings | Project | Project SDK = 11
- Preferences | Build, Execution, Deployment | Build Tools | Gradle | Gradle JVM = Project SDK
- **NB**: do not forget to click "OK" to save the settings

---
```log
👻 Error: JavaFX runtime components are missing, and are required to run this application
```

💡 There is some kind of magic inside JavaFX, but I don't want to go into details. There is a solution, but you can read more in the [source](https://edencoding.com/runtime-components-error/)

✅ Separate our main class `MainApp: App` from the actual launch of the application. I.e. we extract the `main` function from `MainApp` class and call TornadoFX `launch` from it, e.g.:
```kotlin
class MainApp: App(MainView::class, Styles::class)

fun main(args: Array<String>) { launch<MainApp>(args) }
```

---
