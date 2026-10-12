package com.example.twodo.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val EsquemaTwoDo = darkColorScheme(
    primary = AzulPrincipal,
    onPrimary = FondoOscuro,
    background = FondoOscuro,
    onBackground = TextoClaro,
    surface = FondoOscuro,
    onSurface = TextoClaro,
    surfaceVariant = SuperficieClara,
    onSurfaceVariant = TextoApagado,
    surfaceContainerHighest = Superficie,
    outline = Borde
)

@Composable
fun TwoDoTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = EsquemaTwoDo, content = content
    )
}