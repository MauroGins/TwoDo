package com.example.twodo.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.twodo.R
import com.example.twodo.ui.navigation.Rutas
import com.example.twodo.ui.theme.TwoDoTheme

@Composable
fun BarraInferior(
    rutaActual: String?,
    onNavegar: (String) -> Unit,
    modifier: Modifier = Modifier
){
    NavigationBar(modifier = modifier) {
        NavigationBarItem(
            selected = rutaActual == Rutas.INICIO,
            onClick = {onNavegar(Rutas.INICIO)},
            icon = { Icon(Icons.Default.Home, contentDescription = null) },
            label = { Text(stringResource(R.string.nav_inicio)) }
        )
        NavigationBarItem(
            selected = rutaActual == Rutas.LISTA_COMPRA,
            onClick = {onNavegar(Rutas.LISTA_COMPRA)},
            icon = { Icon(Icons.Default.ShoppingCart, contentDescription = null) },
            label = { Text(stringResource(R.string.nav_compra)) }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BarraInferiorPreview() {
    TwoDoTheme {
        BarraInferior(rutaActual = Rutas.INICIO, onNavegar = { })
    }
}