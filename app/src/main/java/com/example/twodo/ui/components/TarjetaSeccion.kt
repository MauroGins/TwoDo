package com.example.twodo.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.twodo.R
import com.example.twodo.ui.pages.PaginaInicio
import com.example.twodo.ui.theme.TwoDoTheme

data class TarjetaSeccionData  (
    val tituloSeccion: String,
    val subtituloSeccion: String
)

@Composable
fun TarjetaSeccion(data: TarjetaSeccionData, modifier: Modifier = Modifier) {
    Card(modifier= modifier.fillMaxWidth()) {
        Row(modifier=Modifier.padding(16.dp)){
            Column() {
                Text(
                    data.tituloSeccion,
                    style=MaterialTheme.typography.titleMedium)
                Text(
                    data.subtituloSeccion,
                    style= MaterialTheme.typography.bodySmall,
                    color= MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun TarjetaSeccionPreview() {
    TwoDoTheme {
        TarjetaSeccion(
            data = TarjetaSeccionData(
                tituloSeccion = stringResource(R.string.inicio_seccion_compra_titulo),
                subtituloSeccion = stringResource(R.string.inicio_seccion_compra_sub)
            )
        )
    }
}