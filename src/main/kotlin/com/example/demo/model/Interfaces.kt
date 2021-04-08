package com.example.demo.model

interface Vertex<V> {
    var element: V
}

interface Edge<E, V> {
    var element: E
    val vertices: Pair<Vertex<V>, Vertex<V>>

    fun incident(v: Vertex<V>) = v == vertices.first || v == vertices.second
}

interface Graph<V, E> {
    fun vertices(): Collection<Vertex<V>>
    fun edges(): Collection<Edge<E, V>>

    fun addVertex(v: V): Vertex<V>
    fun addEdge(u: V, v: V, e: E): Edge<E, V>
}
