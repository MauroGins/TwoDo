package com.example.twodo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.twodo.ui.components.BarraInferior
import com.example.twodo.ui.components.BarraSuperior
import com.example.twodo.ui.navigation.Rutas
import com.example.twodo.ui.navigation.TwoDoNavGraph
import com.example.twodo.ui.theme.TwoDoTheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TwoDoTheme {
                val navController = rememberNavController()
                val entradaActual by navController.currentBackStackEntryAsState()
                val rutaActual = entradaActual?.destination?.route
                val puedeVolver = navController.previousBackStackEntry != null
                val titulo = when (rutaActual) {
                    Rutas.INICIO -> stringResource(R.string.app_name)
                    Rutas.DETALLE_PRODUCTO -> stringResource(R.string.titulo_detalle_producto)
                    Rutas.FORMULARIO_PRODUCTO -> stringResource(R.string.titulo_formulario_producto)
                    else -> stringResource(R.string.titulo_lista_compra)
                }
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        BarraSuperior(
                            titulo = titulo,
                            puedeVolver = puedeVolver,
                            onVolver = { navController.navigateUp() }
                        )
                    },
                    bottomBar = {
                        if (rutaActual == Rutas.INICIO || rutaActual == Rutas.LISTA_COMPRA) {
                            BarraInferior(
                                rutaActual = rutaActual,
                                onNavegar = { ruta ->
                                    navController.navigate(ruta) {
                                        popUpTo(Rutas.INICIO)
                                        launchSingleTop = true
                                    }
                                }
                            )
                        }
                    },
                    floatingActionButton = {
                        if (rutaActual == Rutas.LISTA_COMPRA) {
                            FloatingActionButton(
                                onClick = { navController.navigate(Rutas.FORMULARIO_PRODUCTO) }
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Add,
                                    contentDescription = stringResource(R.string.titulo_formulario_producto)
                                )
                            }
                        }
                    }) { innerPadding ->
                    TwoDoNavGraph(
                        navController = navController,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


