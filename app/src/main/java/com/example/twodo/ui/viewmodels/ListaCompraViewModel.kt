package com.example.twodo.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.twodo.data.ProductosRepositorio
import com.example.twodo.ui.components.FilaProductoData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

//El estado de la pantalla
data class ListaCompraUiState(
    val productos: List<FilaProductoData> = emptyList()
)

//ViewModel
class ListaCompraViewModel : ViewModel(){
    private val _uiState = MutableStateFlow(
        ListaCompraUiState(
            productos = ProductosRepositorio.obtenerTodos()
        )
    )
    val uiState: StateFlow<ListaCompraUiState> = _uiState.asStateFlow()

    fun onProductoMarcado(id:Int){
        ProductosRepositorio.cambiarComprado(id)
        _uiState.update { estado ->
            estado.copy(productos = ProductosRepositorio.obtenerTodos())



        }
    }
}
