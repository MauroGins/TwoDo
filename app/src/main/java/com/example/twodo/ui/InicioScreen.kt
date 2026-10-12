package com.example.twodo.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun InicioScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text("Hola, familia")
        Text("12 octubre del 2026")
    }

}

@Preview(showBackground = true)
@Composable
fun InicioScreenPreview() {
    MaterialTheme {
        InicioScreen()
    }
}