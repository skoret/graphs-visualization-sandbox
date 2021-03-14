package com.example.demo.graphs

internal class UndirectedGraph<V, E>: Graph<V, E> {
    private val vertices = hashMapOf<V, Vertex<V>>()
    private val edges = hashMapOf<E, Edge<E, V>>()

    override val directed: Boolean = false

    override fun vertices(): Collection<Vertex<V>> = vertices.values

    override fun edges(): Collection<Edge<E, V>> = edges.values

    override fun addVertex(v: V): Vertex<V> = vertices.getOrPut(v) { UndirectedVertex(v) }

    override fun addEdge(u: V, v: V, e: E): Edge<E, V> {
        val first = addVertex(u)
        val second = addVertex(v)
        return edges.getOrPut(e) { UndirectedEdge(e, first, second) }
    }

    override fun incident(v: Vertex<V>): Collection<Edge<E, V>> {
        check(v)

        if (v.element !in vertices) return emptyList()

        return edges.values.filter { it.incident(v) }
    }

    override fun opposite(v: Vertex<V>, e: Edge<E, V>): Vertex<V>? {
        check(v)
        check(e)

        val (_, first, second) = e as UndirectedEdge
        return when (v) {
            first -> second
            second -> first
            else -> null
        }
    }

    private fun check(v: Vertex<V>): UndirectedVertex<V> {
        require(v is UndirectedVertex) { "Vertex $v has inappropriate type for this graph" }
        require(v.element in vertices) { "Vertex $v doesn't belong to this graph" }
        return v
    }

    private fun check(e: Edge<E, V>): UndirectedEdge<E, V> {
        require(e is UndirectedEdge) { "Edge $e has inappropriate type for this graph" }
        require(e.element in edges) { "Edge $e doesn't belong to this graph" }
        return e
    }

    internal data class UndirectedVertex<V>(override var element: V): Vertex<V>

    internal data class UndirectedEdge<E, V>(
        override var element: E,
        var first: Vertex<V>,
        var second: Vertex<V>,
    ): Edge<E, V> {
        override val vertices
            get() = first to second
    }
}
