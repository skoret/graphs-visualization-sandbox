package com.example.demo.controller

import com.example.demo.view.VertexView
import javafx.scene.Cursor
import javafx.scene.input.MouseEvent
import tornadofx.Controller

class VertexDragController: Controller() {
    fun entered(event: MouseEvent) {
        val v = check(event)
        if (!event.isPrimaryButtonDown)
            v.scene.cursor = Cursor.HAND
    }

    fun pressed(event: MouseEvent) {
        val v = check(event)
        if (!event.isPrimaryButtonDown)
            return
        v.scene.cursor =  Cursor.CLOSED_HAND
        event.consume()
    }

    fun dragged(event: MouseEvent) {
        val v = check(event)
        if (!event.isPrimaryButtonDown)
            return
        v.centerX = bound(event.x, 0.0, v.parent.layoutBounds.width, v.radius)
        v.centerY = bound(event.y, 0.0, v.parent.layoutBounds.height, v.radius)
        event.consume()
    }

    fun released(event: MouseEvent) {
        val v = check(event)
        v.scene.cursor = Cursor.HAND
        event.consume()
    }

    fun exited(event: MouseEvent) {
        val v = check(event)
        if (!event.isPrimaryButtonDown)
            v.scene.cursor = Cursor.DEFAULT
    }

    private fun check(event: MouseEvent): VertexView<*> {
        require(event.target is VertexView<*>) { "handler supposed to process events only for vertices: $event" }
        return event.target as VertexView<*>
    }

    private fun bound(value: Double, min: Double, max: Double, pad: Double) = when {
        value < min + pad -> min + pad
        value > max - pad -> max - pad
        else -> value
    }
}
