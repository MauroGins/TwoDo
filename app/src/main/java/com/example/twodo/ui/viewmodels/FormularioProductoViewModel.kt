package com.example.twodo.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.twodo.data.ProductosRepositorio
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class FormularioProductoUiState(
    val nombre: String = "",
    val cantidad: String = "",
    val idProducto: Int? = null
)

class FormularioProductoViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(FormularioProductoUiState())
    val uiState: StateFlow<FormularioProductoUiState> = _uiState.asStateFlow()

    fun onNombreCambiado(texto: String) {
        _uiState.update { it.copy(nombre = texto) }
    }

    fun onCantidadCambiada(texto: String) {
        _uiState.update { it.copy(cantidad = texto) }
    }

    fun onGuardar() {
        val estado = _uiState.value
        if (estado.idProducto == null) {
            ProductosRepositorio.anadir(estado.nombre, estado.cantidad)
        } else {
            ProductosRepositorio.actualizar(estado.idProducto,estado.nombre,estado.cantidad)
            }
        _uiState.update { FormularioProductoUiState()
        }
    }

    fun cargarProducto(id: Int) {
        val producto = ProductosRepositorio.obtenerPorId(id)
        if (producto != null) {
            _uiState.update {
                it.copy(
                    idProducto = producto.id,
                    nombre = producto.nombre,
                    cantidad = producto.cantidad
                )
            }
        }
    }
}