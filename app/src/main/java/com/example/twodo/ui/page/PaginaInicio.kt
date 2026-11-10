package com.example.twodo.ui.page


import androidx.compose.foundation.layout.Column
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
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun PaginaInicio(modifier: Modifier = Modifier) {
    val fecha = SimpleDateFormat("EEEE d 'de' MMMM 'de' yyyy", Locale.forLanguageTag("es-ES")).format(Date()).replaceFirstChar{it.uppercase()}
    Column(
        modifier = modifier
            .padding(16.dp)
    ) {
        Text(text= stringResource(R.string.inicio_saludo), style = MaterialTheme.typography.headlineMedium)
        Text(fecha, style = MaterialTheme.typography.bodySmall,color = MaterialTheme.colorScheme.onSurfaceVariant)
        TarjetaHoy()
    }
}
@Composable
fun TarjetaHoy() {
    Card(modifier = Modifier.fillMaxWidth()) {
    Column(modifier = Modifier
        .padding(16.dp)) {
        Text(text= stringResource(R.string.inicio_hoy_titulo), style = MaterialTheme.typography.titleMedium,color = MaterialTheme.colorScheme.primary)
        Text(text= stringResource(R.string.inicio_plan_2),
            style = MaterialTheme.typography.bodySmall
        )
        Text(
            text= stringResource(R.string.inicio_plan_1),
            style = MaterialTheme.typography.bodySmall
        )
        Text(
            text= stringResource(R.string.inicio_plan_3),
            style = MaterialTheme.typography.bodySmall
        )
    }
    }

}

@Preview(showBackground = true)
@Composable
fun PaginaInicioPreview() {
    MaterialTheme {
        PaginaInicio()
    }
}