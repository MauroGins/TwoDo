package com.example.twodo.ui.pages


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.twodo.R
import com.example.twodo.ui.components.TarjetaHoy
import com.example.twodo.ui.components.TarjetaHoyData
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun PaginaInicio(modifier: Modifier = Modifier) {
    val fecha = SimpleDateFormat(
        "EEEE d 'de' MMMM 'de' yyyy",
        Locale.forLanguageTag("es-ES")
    ).format(Date()).replaceFirstChar { it.uppercase() }
    Column(
        modifier = modifier
            .padding(16.dp)
    ) {
        Text(
            text = stringResource(R.string.inicio_saludo),
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            fecha,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        TarjetaHoy(
            data = TarjetaHoyData(
                titulo = stringResource(R.string.inicio_hoy_titulo),
                planes = listOf(
                    stringResource(R.string.inicio_plan_2),
                    stringResource(R.string.inicio_plan_1),
                    stringResource(R.string.inicio_plan_3)
                )
            )
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PaginaInicioPreview() {
    MaterialTheme {
        PaginaInicio()
    }
}