package com.example.demo.controller

import com.example.demo.view.VertexView

interface PlacementStrategy {
    fun <V, E> place(width: Double, height: Double, vertices: Collection<VertexView<V>>)
}
