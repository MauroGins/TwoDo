package com.example.twodo.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.twodo.R
import com.example.twodo.ui.theme.TwoDoTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BarraSuperior(
    titulo: String,
    puedeVolver: Boolean,
    onVolver: () -> Unit,
    modifier: Modifier = Modifier
){
    TopAppBar(
        title = {Text(titulo)},
        navigationIcon = {
            if (puedeVolver){
                IconButton(onClick = onVolver) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.volver)
                    )
                }
            }
        },
        modifier = modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun BarraSuperiorPreview() {
    TwoDoTheme {
        BarraSuperior(
            titulo = stringResource(R.string.titulo_detalle_producto),
            puedeVolver = true,
            onVolver = { }
        )
    }
}