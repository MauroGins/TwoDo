package com.example.twodo.ui.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.twodo.R
import com.example.twodo.ui.theme.TwoDoTheme
import com.example.twodo.ui.viewmodels.DetalleProductoViewModel

@Composable
fun PaginaDetalleProducto(
    idProducto: Int,
    modifier: Modifier = Modifier,
    viewModel: DetalleProductoViewModel = viewModel()
) {
    LaunchedEffect(idProducto) {
        viewModel.cargarProducto(idProducto)
    }
    val uiState by viewModel.uiState.collectAsState()
    val producto = uiState.producto

    if (producto == null) {
        Text(
            text = stringResource(R.string.detalle_no_encontrado),
            modifier = modifier.padding(16.dp)
        )
    } else {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding((16.dp)),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Icon(
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = null,
                modifier = Modifier.size(96.dp),
                tint = MaterialTheme.colorScheme.primary
            )
            Text(producto.nombre, style = MaterialTheme.typography.headlineMedium)
            Text(stringResource(R.string.detalle_cantidad, producto.cantidad))
            Text(
                text = if (producto.comprado) stringResource(R.string.detalle_comprado)
                else stringResource(R.string.detalle_pendiente),
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PaginaDetalleProductoPreview() {
    TwoDoTheme {
        Surface {
            PaginaDetalleProducto(idProducto = 1)
        }
    }
}