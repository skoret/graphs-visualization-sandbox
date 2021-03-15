package com.example.demo.view

import com.example.demo.model.Graph
import com.example.demo.model.UndirectedGraph
import javafx.scene.layout.Pane
import tornadofx.add

class GraphView<V, E>(private val graph: Graph<V, E> = UndirectedGraph()): Pane() {
    private val vertices by lazy {
        graph.vertices().associateWith { VertexView(it, 0.0, 0.0, props.vertex.radius) }
    }
    private val edges by lazy {
        graph.edges().associateWith {
            val first = vertices[it.vertices.first] ?: throw IllegalStateException("VertexView for ${it.vertices.first} not found")
            val second = vertices[it.vertices.second] ?: throw IllegalStateException("VertexView for ${it.vertices.second} not found")
            EdgeView(it, first, second)
        }
    }

    fun vertices(): Collection<VertexView<V>> = vertices.values
    fun edges(): Collection<EdgeView<E, V>> = edges.values

    init {
        vertices().forEach {
            add(it)
            add(it.label)
        }
        edges().forEach {
            add(it)
            add(it.label)
        }
    }
}
