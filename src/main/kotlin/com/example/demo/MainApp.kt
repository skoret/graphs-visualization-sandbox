package com.example.demo

import com.example.demo.logger.log
import com.example.demo.styles.Styles
import com.example.demo.view.MainView
import javafx.stage.Stage
import tornadofx.App
import tornadofx.launch

class MainApp: App(MainView::class, Styles::class) {
    override fun start(stage: Stage) {
        log("Starting the application...")

        with(stage) {
            width = 800.0
            height = 600.0
        }
        super.start(stage)

        log("The application has started")
    }
}

fun main(args: Array<String>) {
    launch<MainApp>(args)
}
