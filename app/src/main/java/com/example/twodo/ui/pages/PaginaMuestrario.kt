package com.example.twodo.ui.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.twodo.R
import com.example.twodo.ui.theme.TwoDoTheme

@Composable
fun PaginaMuestrario(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    )
    {
        //Prueba1 con imagen y elementos superpuestos
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .clip(RoundedCornerShape(16.dp))

        )
        {
            Image(
                painter = painterResource(R.drawable.ic_launcher_background),
                contentDescription = stringResource(R.string.muestrario_imagen),
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = stringResource(R.string.muestrario_favorito),
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(12.dp)
            )
            Text(
                text = stringResource(R.string.muestrario_destacado),
                color = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(12.dp)
                    .background(MaterialTheme.colorScheme.primary, RoundedCornerShape(8.dp))
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            )
        }
        // Prubea 2 LazyRow de chips con uno seleccionado

        val categorias = stringArrayResource(R.array.muestrario_categorias)
        var seleccionada by remember { mutableIntStateOf(0) }

        LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            items(categorias.size) { indice ->
                FilterChip(
                    selected = indice == seleccionada,
                    onClick = { seleccionada = indice },
                    label = { Text(categorias[indice]) }
                )
            }
        }
        // Prueba 3 Switch en una fila con texto
        var urgente by remember { mutableStateOf(false) }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.muestrario_urgente),
                modifier = Modifier.weight(1f)
            )
            Switch(
                checked = urgente,
                onCheckedChange = { urgente = it }
            )
        }

        //Prueba4 campo de texto con validacion o mensaje de erro
        var correo by remember { mutableStateOf("") }
        val correoValido = correo.isEmpty() || correo.contains("@")

        OutlinedTextField(
            value = correo,
            onValueChange = { correo = it },
            label = { Text(stringResource(R.string.muestrario_correo)) },
            isError = !correoValido,
            supportingText = {
                if (!correoValido) {
                    Text(stringResource(R.string.muestrario_correo_error))
                }
            },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PaginaMuestrarioPreview() {
    Surface() {
        TwoDoTheme {
            PaginaMuestrario()
        }
    }
}