package com.example.twodo.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.twodo.ui.pages.PaginaDetalleProducto
import com.example.twodo.ui.pages.PaginaFormularioProducto
import com.example.twodo.ui.pages.PaginaInicio
import com.example.twodo.ui.pages.PaginaListaCompra

//Nombres de rutas

object Rutas {
    const val LISTA_COMPRA = "lista_compra"
    const val DETALLE_PRODUCTO = "detalle_producto/{idProducto}"
    const val FORMULARIO_PRODUCTO = "formulario_producto"
    const val INICIO = "inicio"

    fun detalleProducto(id: Int) = "detalle_producto/$id"
}

//Mapeo de navegacion

@Composable
fun TwoDoNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Rutas.INICIO,
        modifier = modifier
    ) {
        //Destino 0
        composable(Rutas.INICIO){
            PaginaInicio()
        }
        //Destino 1 la lista
        composable(Rutas.LISTA_COMPRA) {
            PaginaListaCompra(
                onProductoPulsado = { id ->
                    navController.navigate(Rutas.detalleProducto(id))
                }
            )
        }
        //Destino 2 el detalle
        composable(
            route = Rutas.DETALLE_PRODUCTO,
            arguments = listOf(
                navArgument("idProducto") {
                    type = NavType.IntType
                })
        ) { entrada ->
            val id = entrada.arguments?.getInt("idProducto") ?: 0
            PaginaDetalleProducto(idProducto = id)
        }
        //Destino 3 el formulario
        composable(Rutas.FORMULARIO_PRODUCTO) {
            PaginaFormularioProducto(
                onGuardado = { navController.navigateUp() }
            )
        }
    }
}