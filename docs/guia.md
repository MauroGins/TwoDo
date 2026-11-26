# Guía rápida para el examen

## 0. Orden de trabajo recomendado

1. Desglosar las capturas (ver `docs/adr/0305_desglose_componentes.md`).
2. Incorporar el tema (sección 7).
3. Componentes → ViewModels → páginas → navegación → Scaffold.
4. Commit cada vez que algo funcione.

## 1. Crear un componente

Ejemplo: `ui/components/FilaProducto.kt`

1. `data class NombreData(...)` con los datos.
2. `@Composable fun Nombre(data: NombreData, onAlgo: () -> Unit, modifier: Modifier = Modifier)`.
3. `modifier` recibido **solo en la raíz**; dentro, `Modifier` nuevo.
4. Textos y colores: `MaterialTheme.typography...` y `MaterialTheme.colorScheme...`.
5. `@Preview` con `TwoDoTheme` y datos de ejemplo.

## 2. Crear un ViewModel

Ejemplos: `ui/viewmodels/ListaCompraViewModel.kt`, `FormularioProductoViewModel.kt`

1. `data class XUiState(...)` con valores por defecto.
2. `private val _uiState = MutableStateFlow(XUiState())`
3. `val uiState: StateFlow<XUiState> = _uiState.asStateFlow()`
4. Una función por evento: `fun onAlgo(...) { _uiState.update { it.copy(...) } }`
5. Los datos viven en el repositorio (`data/ProductosRepositorio.kt`): cambiar ahí y volver a leer.

## 3. Crear una página con ViewModel

Ejemplos: `ui/pages/PaginaListaCompra.kt`, `PaginaDetalleProducto.kt`, `PaginaFormularioProducto.kt`

- Parámetros: callbacks de navegación, `modifier` y `viewModel: XViewModel = viewModel()`.
- `val uiState by viewModel.uiState.collectAsState()`
- Lista que crece → `LazyColumn` + `items(lista) { ... }`.
- Cargar al entrar → `LaunchedEffect(clave) { viewModel.cargar(...) }`.
- Formulario: `OutlinedTextField(value = uiState.campo, onValueChange = viewModel::onCampoCambiado)`.

## 4. Navegación

Ejemplo: `ui/navigation/NavGraph.kt`

1. Añadir la ruta en `object Rutas` (con hueco `{id}` si recibe un dato).
2. Añadir `composable(Rutas.X) { PaginaX(...) }` en el `NavHost`.
3. Con argumento: `arguments = listOf(navArgument("id") { type = NavType.IntType })` y `entrada.arguments?.getInt("id") ?: 0`.
4. Navegar: `navController.navigate(ruta)`. Volver: `navController.navigateUp()`.

## 5. Scaffold único

Ejemplo: `MainActivity.kt`

- `rutaActual` con `currentBackStackEntryAsState()`.
- Título con `when (rutaActual)`.
- `topBar` → `BarraSuperior` (flecha solo en pantallas secundarias).
- `bottomBar` → `BarraInferior` (solo en pantallas principales), con `popUpTo` y `launchSingleTop`.
- `floatingActionButton` → solo donde toque, con `if`.

## 6. Piezas del mockup

Ejemplo: `ui/pages/PaginaMuestrario.kt`

| Pieza | Cómo |
|---|---|
| Elementos superpuestos | `Box` + `Modifier.align(Alignment.TopEnd)` |
| Imagen | `Image(painterResource(R.drawable.x), contentScale = ContentScale.Crop)` |
| Lista horizontal | `LazyRow` |
| Chips | `FilterChip(selected, onClick, label)` |
| Pantalla larga | `Column` + `Modifier.verticalScroll(rememberScrollState())` |
| Interruptor | `Switch(checked, onCheckedChange)` |
| Campo con error | `isError` + `supportingText` |

## 7. Incorporar un tema del Theme Builder

1. Descomprimir el zip **fuera** del proyecto.
2. `font_certs.xml` → `res/values-v23/`.
3. `Color.kt`, `Theme.kt` y `Type.kt` → `ui/theme/`, sustituyendo.
4. En los tres: `package com.example.twodo.ui.theme`.
5. En `Theme.kt`: renombrar la función a `TwoDoTheme` y poner `dynamicColor = false`.
6. En `Type.kt`: `import com.example.twodo.R`.
7. Build → Make Project (Ctrl + F9).

## 8. Errores típicos

| Error | Solución |
|---|---|
| `has no method getValue... cannot serve as a delegate` | `import androidx.compose.runtime.getValue` |
| Error al asignar con `var ... by` | `import androidx.compose.runtime.setValue` |
| `items(count = lista)` en rojo | `import androidx.compose.foundation.lazy.items` |
| `R.string.x` en rojo aunque existe | Import de la `R` equivocada: `import com.example.twodo.R` |
| `Modifier` en rojo | Import equivocado: `import androidx.compose.ui.Modifier` |
| Import con varias opciones | Elegir siempre la de `androidx.compose` |
| `TopAppBar` en rojo | `@OptIn(ExperimentalMaterial3Api::class)` |
| Parámetro con nombre y otro sin nombre | Poner nombre a todos o el sin nombre primero |
| Rojo que no se va | Ejecutar ▶: a veces el análisis va con retraso |

## 9. Buenas prácticas que se valoran

- Todos los textos en `strings.xml` (con huecos `%1$s` si llevan datos).
- `contentDescription` en iconos que son botones; `null` solo si son decorativos.
- `val` por defecto, `var` solo si cambia.
- Cada componente con su `@Preview`.
- Imports limpios: Ctrl + Alt + O.

## 10. ¿Qué uso? (decisiones rápidas)

| Si en la captura veo… | Uso… |
|---|---|
| Cosas una al lado de otra | `Row` |
| Cosas una debajo de otra | `Column` |
| Algo encima de otra cosa (icono sobre imagen) | `Box` + `Modifier.align(...)` |
| Lo mismo repetido con datos distintos, en vertical | `LazyColumn` + `items(lista)` |
| Lo mismo repetido con datos distintos, en horizontal | `LazyRow` + `items(lista)` |
| Pocos elementos fijos que no crecen | `Column` normal |
| Pantalla larga con secciones distintas | `Column` + `verticalScroll(rememberScrollState())` |
| Un elemento que empuja a otro al borde | `Modifier.weight(1f)` en el del medio |
| Un hueco fijo entre elementos | `Spacer(Modifier.width(12.dp))` o `height(...)` |
| Separación igual entre todos | `Arrangement.spacedBy(8.dp)` |
| Tarjeta con fondo y esquinas redondeadas | `Card` |
| Estado que solo cambia el aspecto (chip marcado, desplegable abierto) | `remember { mutableStateOf(...) }` |
| Datos de la app o campos de un formulario | ViewModel + UiState |
| Barra de arriba / abajo / botón flotante | Huecos `topBar` / `bottomBar` / `floatingActionButton` del Scaffold |

| Tipo de dato | Kotlin |
|---|---|
| Texto | `String` |
| Número entero | `Int` |
| Número con decimales | `Double` |
| Sí / no | `Boolean` |
| Varios elementos | `List<Tipo>` |
| Puede no existir | `Tipo?` (con `?`) |

## 11. Algo no funciona (síntoma → causa)

| Síntoma | Causa probable | Solución |
|---|---|---|
| La lista no muestra un elemento nuevo al volver | El ViewModel no vuelve a leer | `LaunchedEffect(Unit) { viewModel.recargar() }` en la página |
| Una pantalla ve datos distintos que otra | Se cambió la copia del ViewModel | Cambiar en el repositorio y volver a leer |
| La vista previa dice «no encontrado» | La vista previa no ejecuta `LaunchedEffect` | Normal: probar en el emulador o en modo interactivo |
| Sale la flecha de volver donde no toca | `puedeVolver` mal calculado | Ponerlo solo para las rutas secundarias |
| Al pulsar la barra inferior se apilan pantallas | Falta `popUpTo` / `launchSingleTop` | Añadir las opciones en el `navigate` |
| Error al navegar con un argumento | La ruta no tiene el hueco o el tipo | Ruta con `{id}` + `navArgument("id") { type = NavType.IntType }` |
| Pulsar la fila no hace nada | Falta `.clickable { ... }` o el callback no está conectado | Revisar componente → página → NavGraph |
| El botón no se activa | `enabled` con una condición falsa | Revisar la validación (`isNotBlank()`…) |
| Al escribir en un campo no aparece nada | `value` no lee del estado o `onValueChange` no lo guarda | `value = uiState.campo` y `onValueChange = viewModel::onCampoCambiado` |
| El texto sale pegado al borde | Falta `padding` o el `innerPadding` del Scaffold | `Modifier.padding(innerPadding)` en el NavGraph |
| Colores raros (morado) en la app | `dynamicColor = true` o falta un color en el esquema | `dynamicColor = false` en `Theme.kt` |
| Emulador en negro | El emulador, no el código | Botón de encendido → cerrar y relanzar → *Cold Boot* |
| Muchos errores rojos de golpe | Suele ser uno solo (efecto dominó) | Arreglar el **primero** de la lista |

## 12. Recetas: «Si me piden…», paso a paso

Siempre en el mismo orden, de abajo arriba:
**datos (data class / repositorio) → ViewModel → componente → página → navegación → Scaffold**.

### 12.1. Borrar un elemento de la lista

1. **Repositorio** (`data/ProductosRepositorio.kt`):
   ```kotlin
   fun borrar(id: Int) {
       productos = productos.filter { it.id != id }
   }
   ```
   `filter` se queda con los que **cumplen** la condición: todos menos el de ese `id`.
2. **ViewModel** (`ListaCompraViewModel.kt`):
   ```kotlin
   fun onProductoBorrado(id: Int) {
       ProductosRepositorio.borrar(id)
       recargar()
   }
   ```
3. **Componente** (`FilaProducto.kt`): nuevo callback `onBorrar: () -> Unit` y, al final de la `Row`:
   ```kotlin
   IconButton(onClick = onBorrar) {
       Icon(Icons.Default.Delete, contentDescription = stringResource(R.string.borrar))
   }
   ```
   Añadir `<string name="borrar">Borrar</string>` y `onBorrar = { }` en la `@Preview`.
4. **Página** (`PaginaListaCompra.kt`): en la llamada a `FilaProducto`:
   ```kotlin
   onBorrar = { viewModel.onProductoBorrado(producto.id) }
   ```

### 12.2. Borrar todos los marcados («vaciar comprados»)

1. **Repositorio**: `fun borrarComprados() { productos = productos.filter { !it.comprado } }`
2. **ViewModel**: `fun onBorrarComprados() { ProductosRepositorio.borrarComprados(); recargar() }`
3. **Página**: meter la `LazyColumn` y un botón en una `Column`. La lista con `Modifier.weight(1f)` para que deje sitio al botón:
   ```kotlin
   Column(modifier = modifier.fillMaxSize()) {
       LazyColumn(modifier = Modifier.weight(1f)) { ... }
       Button(
           onClick = { viewModel.onBorrarComprados() },
           modifier = Modifier.fillMaxWidth().padding(16.dp)
       ) { Text(stringResource(R.string.borrar_comprados)) }
   }
   ```
   (El `modifier` recibido pasa a la `Column`, que ahora es la raíz).

### 12.3. Añadir un dato nuevo a cada elemento (por ejemplo, el precio)

1. **Data class** (`FilaProductoData`): `val precio: Double = 0.0` (con valor por defecto, así no se rompen las llamadas que ya existen).
2. **Repositorio**: dar el precio en los productos de ejemplo.
3. **Componente**: un `Text` más que lo muestre, por ejemplo `"${data.precio} €"`. Si es texto fijo con hueco, mejor en `strings.xml`: `<string name="precio">%1$s €</string>`.
4. **Detalle**: otro `Text` en `PaginaDetalleProducto`.
5. **Formulario** (si hay que poder escribirlo): seguir la receta 12.5.

### 12.4. Editar un elemento (cambiar un dato)

1. **Repositorio**: `fun actualizar(producto: FilaProductoData) { productos = productos.map { if (it.id == producto.id) producto else it } }`
2. **ViewModel**: función que copie el dato cambiado y llame a `actualizar`, después `recargar()` (o volver a cargar en el detalle).
3. Igual que `cambiarComprado`, que ya es una edición.

### 12.5. Añadir un campo al formulario

1. **UiState** (`FormularioProductoUiState`): `val nuevoCampo: String = ""`.
2. **ViewModel**: `fun onNuevoCampoCambiado(texto: String) { _uiState.update { it.copy(nuevoCampo = texto) } }`.
3. **Página**: copiar un `OutlinedTextField` y cambiar las tres cosas: `value`, `onValueChange` y `label`.
4. **Guardar**: pasar el dato en `onGuardar()` al repositorio (y añadir el parámetro a `anadir`).
5. Si es un **interruptor**: `val urgente: Boolean = false`, `fun onUrgenteCambiado(valor: Boolean)` y `Switch(checked = uiState.urgente, onCheckedChange = viewModel::onUrgenteCambiado)`.
6. Si tiene **validación**: `isError` + `supportingText` (ver `PaginaMuestrario`), y en el botón `enabled = ...`.

### 12.6. Añadir una página nueva con navegación

1. **Página**: `ui/pages/PaginaX.kt` con `modifier` y, si navega, sus callbacks.
2. **ViewModel** (si tiene datos): `ui/viewmodels/XViewModel.kt` (sección 2).
3. **Ruta**: `const val X = "x"` en `Rutas`.
4. **Destino**: `composable(Rutas.X) { PaginaX(...) }` en el `NavHost`.
5. **Título**: una línea en el `when` de `MainActivity` (+ texto en `strings.xml`).
6. **Cómo se llega**: desde la barra inferior (receta 12.7), un botón (`navController.navigate(Rutas.X)`) o un elemento de una lista (receta 12.8).
7. **Flecha de volver**: si es secundaria, añadirla a `puedeVolver`.

### 12.7. Añadir una sección a la barra inferior

1. Textos en `strings.xml`.
2. Un `NavigationBarItem` más en `BarraInferior.kt` (ruta, icono y texto).
3. En `MainActivity`, añadir la ruta a la condición del `bottomBar`.

### 12.8. Abrir el detalle de un elemento pulsado

1. **Componente**: callback `onPulsar: () -> Unit` y `.clickable { onPulsar() }` en la raíz.
2. **Página de lista**: parámetro `onElementoPulsado: (Int) -> Unit` y `onPulsar = { onElementoPulsado(elemento.id) }`.
3. **Rutas**: `const val DETALLE = "detalle/{id}"` y `fun detalle(id: Int) = "detalle/$id"`.
4. **NavGraph**: en la lista, `onElementoPulsado = { id -> navController.navigate(Rutas.detalle(id)) }`; y el destino del detalle con `navArgument("id")` y `getInt("id")`.
5. **Detalle**: `LaunchedEffect(id) { viewModel.cargar(id) }`.

### 12.9. Filtrar la lista con chips (afecta a los datos → ViewModel)

1. **UiState**: `val filtro: String = "Todo"` (o un `Int` con la posición).
2. **ViewModel**: `fun onFiltroCambiado(nuevo: String) { _uiState.update { it.copy(filtro = nuevo) } }`.
3. **Página**: `LazyRow` de `FilterChip` con `selected = categoria == uiState.filtro` y `onClick = { viewModel.onFiltroCambiado(categoria) }`.
4. **Lista filtrada**: `val visibles = if (uiState.filtro == "Todo") uiState.productos else uiState.productos.filter { it.categoria == uiState.filtro }` y `items(visibles)`.

### 12.10. Botones en la barra superior (iconos a la derecha)

En `BarraSuperior`, el `TopAppBar` tiene el hueco `actions`:
```kotlin
actions = {
    IconButton(onClick = onPerfil) {
        Icon(Icons.Default.Person, contentDescription = stringResource(R.string.perfil))
    }
}
```
Con su callback nuevo (`onPerfil: () -> Unit`) conectado en `MainActivity`.

### 12.11. Mostrar un mensaje temporal (Snackbar)

En `MainActivity`:
```kotlin
val snackbarHostState = remember { SnackbarHostState() }
val scope = rememberCoroutineScope()
// En el Scaffold:
snackbarHost = { SnackbarHost(snackbarHostState) },
// Para mostrarlo:
scope.launch { snackbarHostState.showSnackbar("Producto guardado") }
```
(El texto, mejor desde `strings.xml`).

## 13. Plantillas vacías para copiar

### Componente
```kotlin
data class XData(
    val id: Int,
    val titulo: String
)

@Composable
fun X(
    data: XData,
    onPulsar: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier.fillMaxWidth().clickable { onPulsar() }) {
        // TODO contenido
    }
}

@Preview(showBackground = true)
@Composable
fun XPreview() {
    TwoDoTheme {
        X(data = XData(id = 1, titulo = "Ejemplo"), onPulsar = { })
    }
}
```

### ViewModel
```kotlin
data class XUiState(
    val elementos: List<XData> = emptyList()
)

class XViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(XUiState())
    val uiState: StateFlow<XUiState> = _uiState.asStateFlow()

    fun recargar() {
        _uiState.update { it.copy(elementos = XRepositorio.obtenerTodos()) }
    }
}
```

### Página
```kotlin
@Composable
fun PaginaX(
    onElementoPulsado: (Int) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: XViewModel = viewModel()
) {
    LaunchedEffect(Unit) { viewModel.recargar() }
    val uiState by viewModel.uiState.collectAsState()

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(uiState.elementos) { elemento ->
            X(data = elemento, onPulsar = { onElementoPulsado(elemento.id) })
        }
    }
}
```

### Repositorio
```kotlin
object XRepositorio {
    private var elementos = listOf(
        XData(id = 1, titulo = "Uno")
    )
    fun obtenerTodos(): List<XData> = elementos
    fun obtenerPorId(id: Int): XData? = elementos.find { it.id == id }
}
```

## 14. Plan de examen (según la rúbrica)

| Orden | Apartado | Peso | Mínimo |
|---|---|---|---|
| 1 | Página de listado (componente + `LazyColumn`) | 15 % | Sí |
| 2 | Página de detalle | 15 % | Sí |
| 3 | ViewModel en listado y detalle | 10 % | Sí |
| 4 | Formulario | 15 % | No |
| 5 | ViewModel del formulario | 10 % | No |
| 6 | Scaffold único | 7 % | No |
| 7 | NavGraph y navegación | 7 % | No |
| 8 | Desglose de la imagen | 7 % | No |
| 9 | Incorporar el tema | 5 % | No |
| 10 | Buenas prácticas y accesibilidad | 9 % | No |

- Primero los **tres mínimos**: sin ellos no se aprueba.
- El tema y el desglose son rápidos: pueden ir al principio para «calentar».
- **Commit cada vez que algo funcione.**
- Antes de entregar: ejecutar, revisar vistas previas, textos en `strings.xml` y Ctrl + Alt + O.

## 15. Atajos de teclado

| Atajo | Qué hace |
|---|---|
| Alt + Enter | Arreglar / importar lo que está en rojo |
| Ctrl + Alt + L | Ordenar y alinear el código |
| Ctrl + Alt + O | Quitar imports que no se usan |
| Mayús + F6 | Renombrar en todos los sitios |
| Ctrl + Mayús + F | Buscar un texto en todo el proyecto |
| Ctrl + P (dentro de paréntesis) | Ver los parámetros que acepta una función |
| Ctrl + clic sobre un nombre | Ir a donde está definido |
| Ctrl + F9 | Compilar (Make Project) |
| Ctrl + Z / Ctrl + Mayús + Z | Deshacer / rehacer |
