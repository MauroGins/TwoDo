package com.example.twodo.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun InicioScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier
        .padding(16.dp)
        ) {
        Text("Hola, familia", style = MaterialTheme.typography.headlineMedium)
        Text("12 octubre del 2026",style = MaterialTheme.typography.bodySmall)
    }

}

@Preview(showBackground = true)
@Composable
fun InicioScreenPreview() {
    MaterialTheme {
        InicioScreen()
    }
}