package com.example.demo.view

import com.example.demo.controller.CircularPlacementStrategy
import com.example.demo.controller.RepresentationStrategy
import tornadofx.*


class MainView: View("Graph visualizer") {
    private val graph = GraphView(props.SAMPLE_GRAPH)
    private val strategy: RepresentationStrategy by inject<CircularPlacementStrategy>()

    override val root = borderpane {
        center {
            add(graph)
        }
        left = vbox(10) {
            checkbox("Show vertices labels", props.vertex.label) {
                action {
                    println("vertex labels are ${if (isSelected) "enabled" else "disabled"}")
                }
            }
            checkbox("Show edges labels", props.edge.label) {
                action {
                    println("edges labels are ${if (isSelected) "enabled" else "disabled"}")
                }
            }
            button("Reset default settings") {
                action {
                    arrangeVertices()
                }
            }
            button("Set colors") {
                action {
                    highlightVertices()
                }
            }
        }
    }

    init {
        arrangeVertices()
    }

    private fun arrangeVertices() {
        currentStage?.apply {
            strategy.place<String>(
                width - props.vertex.radius.get() * 5,
                height - props.vertex.radius.get() * 5,
                graph.vertices(),
            )
        }
    }

    private fun highlightVertices() {
        currentStage?.apply {
            strategy.highlight<String>(graph.vertices())
        }
    }
}
