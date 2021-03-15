package com.example.demo.styles

import tornadofx.Stylesheet
import tornadofx.cssclass
import tornadofx.loadFont
import tornadofx.px

class Styles : Stylesheet() {
    companion object {
        val texts by cssclass()
        private val jbmono = loadFont("/fonts/jb-mono-regular.ttf", 8)
    }

    init {
        root {
            jbmono?.let { font = it }
            fontSize = 10.px
        }
    }
}
