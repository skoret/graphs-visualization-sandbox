package com.example.demo.view

import com.example.demo.model.Edge
import javafx.scene.shape.Line
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
        xProperty().bind(startXProperty().add(endXProperty()).divide(2).subtract(layoutBounds.width / 2))
        yProperty().bind(startYProperty().add(endYProperty()).divide(2).add(layoutBounds.height / 1.5))
    }
}
