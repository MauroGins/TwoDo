# Desglose de las pantallas de TwoDo

Método: elementos que se repiten (Lazy*), elementos fijos,
huecos del Scaffold, orientación de las listas y superposiciones (Box).

## Pantalla 0: Inicio

| Sección | Sería... |
|---|---|
| Saludo y fecha | Dos `Text` dentro de una `Column` |
| Tarjeta «Hoy» | `Card` con una `Column`: un `Text` de título y un `Text` por cada plan |
| Tarjetas de sección | `Card` con una `Row`, y dentro una `Column` con título y subtítulo. Se repite 3 veces con datos distintos |

## Pantalla 1 : Lista de la compra

| Sección | Sería... |
|---|---|
| Barra con el título | `Scaffold(topBar = { ... })` con `TopAppBar` |
| Botón «+» abajo a la derecha | `Scaffold(floatingActionButton = { FloatingActionButton(...) })` con un `Icon` |
| Lista de productos | `LazyColumn` con un item por producto (se repite con datos distintos) |
| Cada fila | `Row` con un `Checkbox`, un `Text` con el nombre (`weight(1f)`) y un `Text` con la cantidad |

## Pantalla 2: Detalle del producto

| Sección | Sería... |
|---|---|
| Barra con título y flecha de volver | `Scaffold(topBar = { ... })` con `TopAppBar` e `IconButton` con `Icon` en `navigationIcon` |
| Contenido | `Column` con un `Icon` grande y tres `Text`: nombre, cantidad y estado |

## Pantalla 3: Añadir producto

| Sección | Sería... |
|---|---|
| Barra con título y flecha de volver | `Scaffold(topBar = { ... })` con `TopAppBar` |
| Campos de formulario | `Column` con dos `OutlinedTextField` para nombre y cantidad |
| Botón de Guardar | `Button` con `Text` guardar|


Solo en la lista de la compra se usa la `LazyColumn` al ser la única pantalla con elementos que se reptien con datos distintos.