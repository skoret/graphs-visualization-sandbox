package com.example.demo.model

internal class UndirectedGraph<V, E>: Graph<V, E> {
    private val vertices = hashMapOf<V, Vertex<V>>()
    private val edges = hashMapOf<E, Edge<E, V>>()

    override fun vertices(): Collection<Vertex<V>> = vertices.values

    override fun edges(): Collection<Edge<E, V>> = edges.values

    override fun addVertex(v: V): Vertex<V> = vertices.getOrPut(v) { UndirectedVertex(v) }

    override fun addEdge(u: V, v: V, e: E): Edge<E, V> {
        val first = addVertex(u)
        val second = addVertex(v)
        return edges.getOrPut(e) { UndirectedEdge(e, first, second) }
    }

    private data class UndirectedVertex<V>(override var element: V): Vertex<V>

    private data class UndirectedEdge<E, V>(
        override var element: E,
        var first: Vertex<V>,
        var second: Vertex<V>,
    ): Edge<E, V> {
        override val vertices
            get() = first to second
    }
}
