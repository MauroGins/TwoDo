package com.example.twodo.ui.pages


import androidx.compose.foundation.layout.Arrangement
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
import com.example.twodo.ui.components.TarjetaSeccion
import com.example.twodo.ui.components.TarjetaSeccionData
import com.example.twodo.ui.theme.TwoDoTheme
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
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
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
                    stringResource(R.string.inicio_plan_1),
                    stringResource(R.string.inicio_plan_2),
                    stringResource(R.string.inicio_plan_3)
                )
            )
        )
        TarjetaSeccion(
            data = TarjetaSeccionData(
                tituloSeccion = stringResource(R.string.inicio_seccion_hijos_titulo),
                subtituloSeccion = stringResource(R.string.inicio_tareas_hijos)
            )
        )
        TarjetaSeccion(
            data = TarjetaSeccionData(
                tituloSeccion = stringResource(R.string.inicio_seccion_calendario_titulo),
                subtituloSeccion = stringResource(R.string.inicio_seccion_calendario_subtitulo)
            )
        )
        TarjetaSeccion(
            data = TarjetaSeccionData(
                tituloSeccion = stringResource(R.string.inicio_seccion_compra_titulo),
                subtituloSeccion = stringResource(R.string.inicio_seccion_compra_sub)
            )
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PaginaInicioPreview() {
    TwoDoTheme {
        PaginaInicio()
    }
}