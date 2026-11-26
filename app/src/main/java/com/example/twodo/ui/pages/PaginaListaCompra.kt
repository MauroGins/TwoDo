package com.example.twodo.ui.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.twodo.ui.components.FilaProducto
import com.example.twodo.ui.theme.TwoDoTheme
import com.example.twodo.ui.viewmodels.ListaCompraViewModel

@Composable
fun PaginaListaCompra(
    onProductoPulsado: (Int) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: ListaCompraViewModel = viewModel()
) {
    LaunchedEffect(Unit) {
        viewModel.recargar()
    }
    val uiState by viewModel.uiState.collectAsState()
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(uiState.productos) { producto ->
            FilaProducto(
                data = producto,
                onMarcar = { viewModel.onProductoMarcado(producto.id) },
                onPulsar = { onProductoPulsado(producto.id) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PaginaListaCompraPreview() {
    Surface() {
        TwoDoTheme {
            PaginaListaCompra({})
        }
    }
}