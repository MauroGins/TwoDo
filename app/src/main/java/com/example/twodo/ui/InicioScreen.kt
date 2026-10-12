package com.example.twodo.ui


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun InicioScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(16.dp)
    ) {
        Text("Hola, familia", style = MaterialTheme.typography.headlineMedium)
        Text("12 octubre del 2026", style = MaterialTheme.typography.bodySmall,color = MaterialTheme.colorScheme.onSurfaceVariant)
        TarjetaHoy()
    }
}
@Composable
fun TarjetaHoy() {
    Card(modifier = Modifier.fillMaxWidth()) {
    Column(modifier = Modifier
        .padding(16.dp)) {
        Text("HOY", style = MaterialTheme.typography.titleMedium,color = MaterialTheme.colorScheme.primary)
        Text(
            "Tenemos que seguir avanzando en Jetpack Compose",
            style = MaterialTheme.typography.bodySmall
        )
        Text(
            "Tenemos que seguir avanzando en Jetpack Compose",
            style = MaterialTheme.typography.bodySmall
        )
        Text(
            "Tenemos que seguir avanzando en Jetpack Compose",
            style = MaterialTheme.typography.bodySmall
        )
    }
    }

}

@Preview(showBackground = true)
@Composable
fun InicioScreenPreview() {
    MaterialTheme {
        InicioScreen()
    }
}