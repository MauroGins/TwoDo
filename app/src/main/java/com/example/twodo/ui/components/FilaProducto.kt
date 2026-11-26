package com.example.twodo.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.twodo.ui.theme.TwoDoTheme

data class FilaProductoData(
    val id: Int,
    val nombre: String,
    val cantidad: String,
    val comprado: Boolean
)

@Composable
fun FilaProducto(
    data: FilaProductoData,
    onMarcar:()-> Unit,
    onPulsar:()-> Unit,
    modifier: Modifier = Modifier
){
    Row(
        modifier= modifier.fillMaxWidth().clickable{onPulsar()},
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = data.comprado,
            onCheckedChange = {onMarcar()}
        )
        Text(data.nombre, modifier =Modifier.weight(1f))
        Text(data.cantidad, color = MaterialTheme.colorScheme.onSurfaceVariant)
    }
}

@Preview(showBackground = true)
@Composable
fun FilaProductoPreview() {
    TwoDoTheme {
        FilaProducto(
            data = FilaProductoData(
                id = 1,
                nombre = "Leche",
                cantidad = "x2",
                comprado = true
            ),
            onMarcar = { },
            onPulsar = { }
        )
    }
}