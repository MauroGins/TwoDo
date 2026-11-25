package com.example.twodo.data

import com.example.twodo.ui.components.FilaProductoData

object ProductosRepositorio{
    private var productos = listOf(
        FilaProductoData(id=1, nombre= "Leche", cantidad="x2",comprado=false),
        FilaProductoData(id=2, nombre= "Arroz", cantidad="x1",comprado=false),
        FilaProductoData(id=3, nombre= "Naranjas", cantidad="x4",comprado=false),
        FilaProductoData(id=4, nombre= "Plátanos", cantidad="x4",comprado=false)
    )
    fun obtenerTodos(): List<FilaProductoData> = productos

    fun obtenerPorId(id: Int): FilaProductoData? = productos.find {it.id ==id}

    fun cambiarComprado(id: Int) {
        productos = productos.map {
            if (it.id == id) it.copy(comprado = !it.comprado) else it
        }
    }

}