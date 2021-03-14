package com.example.demo.app

import javafx.scene.text.FontWeight
import tornadofx.Stylesheet
import tornadofx.box
import tornadofx.cssclass
import tornadofx.loadFont
import tornadofx.px

class Styles : Stylesheet() {
    companion object {
        val heading by cssclass()

        val jbmono = loadFont("/fonts/jb-mono-regular.ttf", 48)
    }

    init {
        root {
            jbmono?.let { font = it }
        }
        label and heading {
            padding = box(10.px)
            fontSize = 20.px
            fontWeight = FontWeight.BOLD
        }
    }
}
