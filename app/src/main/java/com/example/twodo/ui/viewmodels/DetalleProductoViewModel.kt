package com.example.twodo.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.twodo.data.ProductosRepositorio
import com.example.twodo.ui.components.FilaProductoData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class DetalleProductoUiState(
    val producto: FilaProductoData? = null
)
class DetalleProductoViewModel : ViewModel(){
    private val _uiState = MutableStateFlow(DetalleProductoUiState())
    val uiState: StateFlow<DetalleProductoUiState> = _uiState.asStateFlow()

    fun cargarProducto (id: Int){
        _uiState.update { estado ->
            estado.copy(producto = ProductosRepositorio.obtenerPorId(id))
        }
    }
}