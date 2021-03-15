package com.example.demo.view

import com.example.demo.model.Vertex
import javafx.beans.property.DoubleProperty
import javafx.scene.paint.Color
import javafx.scene.shape.Circle
import tornadofx.label
import tornadofx.style
import tornadofx.text

class VertexView<V>(
    val vertex: Vertex<V>,
    x: Double,
    y: Double,
    r: DoubleProperty,
): Circle(x, y, r.get()) {
    init {
        radiusProperty().bind(r)
    }

    var position: Pair<Double, Double>
        get() = centerX to centerY
        set(value) {
            centerX = value.first
            centerY = value.second
        }

    val label = text(vertex.element.toString()) {
        visibleProperty().bind(props.vertex.label)
        xProperty().bind(centerXProperty().subtract(layoutBoundsProperty().get().width / 2))
        yProperty().bind(centerYProperty().add(radiusProperty().get() + layoutBoundsProperty().get().height))
    }
}
