package com.example.demo.controller

import com.example.demo.view.VertexView

interface RepresentationStrategy {
    fun <V> place(width: Double, height: Double, vertices: Collection<VertexView<V>>)

    fun <V> highlight(vertices: Collection<VertexView<V>>)
}
