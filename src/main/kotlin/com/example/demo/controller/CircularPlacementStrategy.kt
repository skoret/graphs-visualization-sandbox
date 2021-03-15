package com.example.demo.controller

import com.example.demo.view.VertexView
import javafx.geometry.Point2D
import tornadofx.Controller
import kotlin.math.cos
import kotlin.math.min
import kotlin.math.sin

class CircularPlacementStrategy: Controller(), PlacementStrategy {
    override fun <V, E> place(width: Double, height: Double, vertices: Collection<VertexView<V>>) {
        if (vertices.isEmpty()) {
            println("CircularPlacementStrategy.place: there is nothing to place 👐🏻")
            return
        }

        val center = Point2D(width / 2, height / 2)
        val angle = -360.0 / vertices.size

        val sorted = vertices.sortedBy { it.vertex.element.toString().toLowerCase() }
        val first = sorted.first()
        var point = Point2D(center.x, center.y - min(width, height) / 2 + first.radius * 2)
        first.position = point.x to point.y

        sorted.drop(1)
            .onEach {
                point = point.rotate(center, angle)
                it.position = point.x to point.y
            }
    }

    private fun Point2D.rotate(pivot: Point2D, degrees: Double): Point2D {
        val angle = rad(degrees)
        val sin = sin(angle)
        val cos = cos(angle)

        val diff = subtract(pivot)
        val rotated = Point2D(
            diff.x * cos - diff.y * sin,
            diff.x * sin + diff.y * cos,
        )
        return rotated.add(pivot)
    }

    private fun rad(deg: Double): Double = Math.toRadians(deg)
}
