package com.example.demo.app

import com.example.demo.view.MainView
import javafx.stage.Stage
import tornadofx.App

class MainApp: App(MainView::class, Styles::class) {
    override fun start(stage: Stage) {
        with(stage) {
            width = 1920.0
            height = 1080.0
        }
        super.start(stage)
    }
}
