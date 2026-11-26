package com.example.twodo.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.twodo.data.ProductosRepositorio
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class FormularioProductoUiState(
    val nombre: String = "",
    val cantidad: String = ""
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
        ProductosRepositorio.anadir(estado.nombre, estado.cantidad)
        _uiState.update { FormularioProductoUiState() }
    }
}