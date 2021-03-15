package com.example.demo.view

import com.example.demo.model.Graph
import com.example.demo.model.UndirectedGraph
import tornadofx.booleanProperty
import tornadofx.doubleProperty

@Suppress("ClassName")
object props {
    object layout {
        val auto = booleanProperty()
    }

    object vertex {
        val radius = doubleProperty(10.0)
        val label = booleanProperty()
    }

    object edge {
        val label = booleanProperty()
    }

    val SAMPLE_GRAPH: Graph<String, Long> = UndirectedGraph<String, Long>().apply {
        addVertex("A")
        addVertex("B")
        addVertex("C")
        addVertex("D")
        addVertex("E")
        addVertex("F")
        addVertex("G")

        addEdge("A", "B", 1)
        addEdge("A", "C", 2)
        addEdge("A", "D", 3)
        addEdge("A", "E", 4)
        addEdge("A", "F", 5)
        addEdge("A", "G", 6)

        addVertex("H")
        addVertex("I")
        addVertex("J")
        addVertex("K")
        addVertex("L")
        addVertex("M")
        addVertex("N")

        addEdge("H", "I", 7)
        addEdge("H", "J", 8)
        addEdge("H", "K", 9)
        addEdge("H", "L", 10)
        addEdge("H", "M", 11)
        addEdge("H", "N", 12)

        addEdge("A", "H", 0)
    }
}
