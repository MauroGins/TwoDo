package com.example.twodo.ui.viewmodels

import androidx.lifecycle.ViewModel
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
            productos = listOf(
                FilaProductoData(id=1, nombre= "Leche", cantidad="x2",comprado=false),
                FilaProductoData(id=2, nombre= "Arroz", cantidad="x1",comprado=false),
                FilaProductoData(id=3, nombre= "Naranjas", cantidad="x4",comprado=false),
                FilaProductoData(id=4, nombre= "Plátanos", cantidad="x4",comprado=false)
            )
        )
    )
    val uiState: StateFlow<ListaCompraUiState> = _uiState.asStateFlow()

    fun onProductoMarcado(id:Int){
        _uiState.update { estado ->
            estado.copy(
                productos = estado.productos.map{
                    if (it.id == id) it.copy(comprado = !it.comprado) else it
                }
            )
        }
    }
}
