package com.example.demo.view

import com.example.demo.model.Edge
import javafx.scene.paint.Color
import javafx.scene.shape.Line
import tornadofx.c
import tornadofx.label
import tornadofx.style
import tornadofx.text

class EdgeView<E, V>(
    private val edge: Edge<E, V>,
    private val first: VertexView<V>,
    private val second: VertexView<V>,
): Line() {
    init {
        startXProperty().bind(first.centerXProperty())
        startYProperty().bind(first.centerYProperty())
        endXProperty().bind(second.centerXProperty())
        endYProperty().bind(second.centerYProperty())
    }

    val label = text(edge.element.toString()) {
        visibleProperty().bind(props.edge.label)
        xProperty().bind(startXProperty().add(endXProperty()).divide(2).subtract(layoutBoundsProperty().get().width / 2))
        yProperty().bind(startYProperty().add(endYProperty()).divide(2).add(layoutBoundsProperty().get().height / 1.5))
    }
}
