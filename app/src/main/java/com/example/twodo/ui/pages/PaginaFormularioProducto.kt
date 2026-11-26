package com.example.twodo.ui.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.twodo.R
import com.example.twodo.ui.viewmodels.FormularioProductoViewModel


@Composable
fun PaginaFormularioProducto(
    onGuardado: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: FormularioProductoViewModel = viewModel()
){
    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        OutlinedTextField(
            value = uiState.nombre,
            onValueChange = viewModel::onNombreCambiado,
            label = { Text(stringResource(R.string.formulario_nombre)) },
            modifier = Modifier.fillMaxWidth()
        )
    }
}