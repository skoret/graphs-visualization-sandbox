package com.example.demo.view

import com.example.demo.controller.CircularPlacementStrategy
import com.example.demo.controller.PlacementStrategy
import tornadofx.View
import tornadofx.action
import tornadofx.borderpane
import tornadofx.button
import tornadofx.center
import tornadofx.checkbox
import tornadofx.vbox

class MainView: View("Graph visualizer 📿") {
    private val graph = GraphView(props.SAMPLE_GRAPH)
    private val strategy: PlacementStrategy by inject<CircularPlacementStrategy>()

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
            checkbox("Run automatic layout", props.layout.auto) {
                isDisable = true
                action {
                    println("automatic layout are ${if (isSelected) "enabled" else "disabled"}")
                    // TODO: here some smart graph layout algorithm should be run
                }
            }
            button("Reset default layout") {
                action {
                    arrangeVertices()
                }
            }
        }
    }

    init {
        arrangeVertices()
    }

    private fun arrangeVertices() {
        currentStage?.apply {
            strategy.place<String, Long>(
                width - props.vertex.radius.get() * 5,
                height - props.vertex.radius.get() * 5,
                graph.vertices(),
            )
        }
    }
}
