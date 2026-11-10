package com.example.twodo.ui.components

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
import com.example.twodo.ui.theme.TwoDoTheme

data class TarjetaHoyData(
    val titulo: String,
    val planes: List<String>
)

@Composable
fun TarjetaHoy(data: TarjetaHoyData, modifier: Modifier = Modifier) {

    Card(modifier = modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                data.titulo,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )

            for (plan in data.planes) {
                Text(plan, style = MaterialTheme.typography.bodySmall)
            }

        }

    }
}


@Preview(showBackground = true)
@Composable
fun TarjetaHoyPreview() {
    TwoDoTheme {
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