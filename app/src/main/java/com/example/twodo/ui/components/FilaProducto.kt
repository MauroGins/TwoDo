package com.example.twodo.ui.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.twodo.ui.theme.TwoDoTheme
import com.example.twodo.R

data class FilaProductoData(
    val id: Int,
    val nombre: String,
    val cantidad: String,
    val comprado: Boolean,
    val imagen: Int = R.drawable.ic_launcher_background
)

@Composable
fun FilaProducto(
    data: FilaProductoData,
    onMarcar: () -> Unit,
    onPulsar: () -> Unit,
    onBorrar: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onPulsar() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = data.comprado,
            onCheckedChange = { onMarcar() }
        )
        Image(painter = painterResource(data.imagen),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape))
        Text(data.nombre, modifier = Modifier.weight(1f))
        Text(data.cantidad, color = MaterialTheme.colorScheme.onSurfaceVariant)

        IconButton(onClick = onBorrar) {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = stringResource(R.string.borrar_producto)
            )
        }

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
            onPulsar = { },
            onBorrar = { }
        )
    }
}