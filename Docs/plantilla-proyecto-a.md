# Plantilla: propuesta del Proyecto A

---

## 0 · Datos

| |                    |
|---|--------------------|
| **Nombre de la app** | TwoDo              |
| **Autor/a** | Mauro Pereira Ríos |
| **Fecha** | 01/10/2026         |

---

## 1 · La idea en una frase

> Qué hace tu app y para quién, en una sola frase.
>
> Fórmula: «Compartir datos de interés con mi pareja como horarios de los niños, listas de la compra, etc para no olvidarse nada»


---

## 2 · El problema

> ¿Qué problema resuelve? ¿Cómo se resuelve hoy sin tu app?
> Resuelve el problema tipico de "has cogido la lista de la compra?" o el "has anotado lo que hacia falta?", además de los temas de los niños, como puede ser las meriendas estipuladas por día en el colegio, los horarios de recogida o entrega en las extra escolares, etc.
> Hoy en día lo resolvemos a base de mensajes o llamadas preguntando (en el caso del niño) o en situaciones incomodas de tener que volver a casa a por la lista de la compra.

---

## 3 · Personas usuarias

> ¿Quién la va a usar? Describe a una persona concreta: edad, soltura con la
> tecnología, cuándo y dónde abre la app, cuánto tiempo le dedica y qué pasa
> si le falla.
> 
> Creo que podría usarla cualquier persona en edad media con dificultades de memoria para recordar las lista de la compra o personas despistadas.
> Un rango de edad sería entre los 20 y los 50. La app se abriría en cualquier lugar. Si se necesita ir tachando cosas de la lista de la compra por 
> que ya están en el carro o poner que el niño ha llegado a tiempo a "natación".
> Si falla habría que ver donde se da el error para atajarlo, ya que en principio, debería poder autosincronizarse
> 

---

## 4 · Funcionalidades

### Imprescindibles (sin esto la app no tiene sentido)

| # | Funcionalidad        |
|---|----------------------|
| F1 | Alarmas y calendario |
| F2 | Lista de la compra   |
| F3 | Uso de esta offline  |

### Opcionales (si sobra tiempo)

| #  | Funcionalidad                                                                                                                     |
|----|-----------------------------------------------------------------------------------------------------------------------------------|
| O1 | Distintas plantillas por hijo                                                                                                     |
| O2 | Posibilidad de añadir autoalarmas de tiempo especifico (niño entra 16.00 a las 16.45 acaba, alarma a las 16.40 como recordatorio) |
| O3 | Compartir con la pareja                                                                                                           |
| O4 | Agenda de los niños                                                                                                               |

---

## 5 · Pantallas

| Pantalla                | Para qué sirve                           | Se llega desde  |
|-------------------------|------------------------------------------|-----------------|
| Inicio                  | Registro                                 | (arranque)      |
| Lista de la compra      | Anotaciones                              | Boton en inicio |
| Lista de tareas (hijos) | No olvidarse de los horarios y entregas  | Boton en inicio |
| Calendario              | Anotar las fechas importantes para ambos | Boton en inicio |

---

## 6 · Bocetos

> Dibuja las pantallas principales. A mano y fotografiado es válido.
> Pega aquí las imágenes o indica el nombre de los archivos adjuntos.
> 
>![Bocetos de las pantallas](res/apartado6.png)

---

## 7 · Qué datos guarda la app

| Tipo de dato | Campos                                                         | Ejemplo                                              |
|--------------|----------------------------------------------------------------|------------------------------------------------------|
| Usuarios     | nombres/emails                                                 | padre/madre - padre@email.com / madre@email.com      |
| Lista        | Familia nombre, miembros                                       | Casa XXXX, Superdelasemana, etc                      |    
| Producto     | lista, el nombre, cantidad, comprado(si/no), cantidad          | 2leche (S/N), supersemana                            |    
| Hijo         | Nombre, color                                                  | Pablo, Verde                                         |    
| Actividad    | Nombre hijo, dia, hora inicio y fin, quien lleva, quien recoge | Pablo natacion viernes 16.00 recoge papá, lleva mamá |    
| Alarma       | Actividad para avisar con antelación                           | Cumpleaños Abuela 10/10/2026                         |    
| Merienda     | dia semana, nombre hijo, selección                             | Pablo lunes lacteo,                                  |    


---


## 8 · Encaje con los requisitos del módulo

> Apartado obligatorio: ninguna casilla puede quedar vacía.

| Requisito | Dónde encaja en tu app                                                                                                | Tema |
|-----------|-----------------------------------------------------------------------------------------------------------------------|------|
| **Persistencia de datos** — la información sobrevive al cerrar la app | En las listas de productos o actividades, en fechas importantes, o en alarmas vinculadas                              | 4 |
| **Servicio web** — la app consulta datos por internet | Sincronizando los datos con algun servidor de alojamiento para que puedan ser compartidos a tiempo real con la pareja | 5 |
| **Sensor o localización** | Para avisar al llegar a un sitio o al supermercado "habitual": "Recordatorio, compra XXX"                             | 6 |
| **Contenido multimedia** — foto, audio, vídeo o animación | Posibilidad de agregar una foto para avisar de "recogido", o ·este yogurt"                                             | 7 |

---

## 9 · Riesgos

| Lo que me preocupa                                                      | Plan B                                                                                  |
|-------------------------------------------------------------------------|-----------------------------------------------------------------------------------------|
| La sincronización o que las alarmas no suenen en distintos dispositivos | Buscar la solución a través de internet o en foros. Afortunadamente hay muchos recursos |
| No tener tiempo real para terminar todo                                 | Priorizar la lista de la compra y luego lo del hijo                                     |

---

## Antes de entregar

- [ ] La idea cabe en una frase.
- [ ] El público es una persona concreta, no «todo el mundo».
- [ ] Hay **3 o 4** funcionalidades imprescindibles, no diez.
- [ ] Cada funcionalidad imprescindible tiene su pantalla.
- [ ] Hay bocetos de las pantallas principales.
- [ ] **Las cuatro casillas del apartado 8 están rellenas.**
- [ ] Está identificado al menos un riesgo con su plan B.
