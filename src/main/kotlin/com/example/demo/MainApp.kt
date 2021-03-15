package com.example.demo

import com.example.demo.styles.Styles
import com.example.demo.view.MainView
import javafx.stage.Stage
import tornadofx.App
import tornadofx.launch

class MainApp: App(MainView::class, Styles::class) {
    override fun start(stage: Stage) {
        with(stage) {
            width = 1024.0
            height = 768.0
        }
        super.start(stage)
    }
}

fun main(args: Array<String>) {
    launch<MainApp>(args)
}
