package com.example.twodo.data

import com.example.twodo.ui.components.FilaProductoData

object ProductosRepositorio {
    private var productos = listOf(
        FilaProductoData(id = 1, nombre = "Leche", cantidad = "2", comprado = false),
        FilaProductoData(id = 2, nombre = "Arroz", cantidad = "1", comprado = false),
        FilaProductoData(id = 3, nombre = "Naranjas", cantidad = "4", comprado = false),
        FilaProductoData(id = 4, nombre = "Plátanos", cantidad = "4", comprado = false)
    )

    fun obtenerTodos(): List<FilaProductoData> = productos

    fun obtenerPorId(id: Int): FilaProductoData? = productos.find { it.id == id }

    fun cambiarComprado(id: Int) {
        productos = productos.map {
            if (it.id == id) it.copy(comprado = !it.comprado) else it
        }
    }

    fun anadir(
        nombre: String,
        cantidad: String
    ) {
        val nuevoId = (productos.maxOfOrNull { it.id } ?: 0) + 1
        productos = productos + FilaProductoData(
            id = nuevoId,
            nombre = nombre,
            cantidad = cantidad,
            comprado = false
        )
    }
    fun borrar(id: Int ){
        productos = productos.filter { it.id != id }

    }
    fun actualizar(id:Int, nombre: String, cantidad: String)
    {
        productos = productos.map{
            if (it.id == id) it.copy(nombre = nombre, cantidad = cantidad)
            else it
        }
    }
}
