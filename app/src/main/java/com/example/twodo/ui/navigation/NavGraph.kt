package com.example.twodo.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.twodo.ui.pages.PaginaDetalleProducto
import com.example.twodo.ui.pages.PaginaListaCompra

//Nombres de rutas

object Rutas {
    const val LISTA_COMPRA = "lista_compra"
    const val DETALLE_PRODUCTO = "detalle_producto/{idProducto}"

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
        startDestination = Rutas.LISTA_COMPRA,
        modifier = modifier
    ) {
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
        ){entrada ->
            val id= entrada.arguments?.getInt("idProducto") ?: 0
            PaginaDetalleProducto(idProducto = id)
        }
    }
}