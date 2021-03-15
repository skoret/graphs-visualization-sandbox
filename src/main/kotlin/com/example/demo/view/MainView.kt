package com.example.demo.view

import com.example.demo.controller.CircularPlacementStrategy
import com.example.demo.controller.PlacementStrategy
import com.example.demo.styles.Styles
import tornadofx.View
import tornadofx.action
import tornadofx.addClass
import tornadofx.borderpane
import tornadofx.center
import tornadofx.checkbox
import tornadofx.vbox

class MainView: View("Graph visualizer") {
    private val strategy: PlacementStrategy by inject<CircularPlacementStrategy>()
    private val graph = GraphView<String, Long>(props.SAMPLE_GRAPH)
    override val root = borderpane {
        center {
            add(graph)
        }
        left = vbox(10) {
            checkbox("Show vertices labels", props.vertex.label) {
                addClass(Styles.texts)
                action {
                    println("vertex labels are ${if (isSelected) "enabled" else "disabled"}")
                }
            }
            checkbox("Show edges labels", props.edge.label) {
                addClass(Styles.texts)
                action {
                    println("edges labels are ${if (isSelected) "enabled" else "disabled"}")
                }
            }
            checkbox("Run automatic layout", props.layout.auto) {
                addClass(Styles.texts)
                action {
                    println("automatic layout are ${if (isSelected) "enabled" else "disabled"}")
                }
            }
        }
    }

    init {
        currentStage?.apply {
            strategy.place<String, Long>(
                widthProperty().get() - props.vertex.radius.get() * 5,
                heightProperty().get() - props.vertex.radius.get() * 5,
                graph.vertices(),
            )
        }
    }
}
