# Experimento de ciclo de vida

## Repositorio del experimento
[Repositorio del experimento](https://github.com/MauroGins/ciclovida)

## Trazas en los callbacks
```
private val TAG = "CicloVida"

```
```
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

```
He usado una etiqueta val TAG y un Log.d en cada callback para filtrar los mensajes tag:CicloVida

## Situación 1: arranque normal
![logcat_arranque_1.PNG](../res/logcat_arranque_1.PNG)
Al abrir la app se crea un proceso nuevo (PROCESS STARTED) y la Activity pasa por onCreate, onStart y onResume. Despues de onResume, la app está en primer plano podemos interactuar con ella.

## Situación 2: girar la pantalla
![logcat_giro_2.PNG](../res/logcat_giro_2.PNG)
En el giro se destruía la activity y se volvía a crear.

## Situación 3: pulsar Inicio y volver
![logcat_inicio_3.PNG](../res/logcat_inicio_3.PNG)
Aquí no pasa por onDestroy ni onCreate (activity paralizada).

## Situación 4: cerrar la app y reabrirla
![logcat_cierre_4.PNG](../res/logcat_cierre_4.PNG)
Aquí pasa por onDestroy y  al reabrir hay habia un proceso nuevo (onCreate).

## Guardar el estado con onSaveInstanceState
Al girar la pantalla, el contador sufría un problema, y el contador volvía a 0.

![pulsacion_giro_1.PNG](../res/pulsacion_giro_1.PNG)
![pulsacion_giro_2.PNG](../res/pulsacion_giro_2.PNG)

Se solucionó guardando con putInt y recuperando el onCreate

```
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")
        if (savedInstanceState != null) {
            contador = savedInstanceState.getInt("contador")
        }
```

Ahora el número se mantiene. 

![estado_horizontal_1.PNG](../res/estado_horizontal_1.PNG)
![estado_vertical_2.PNG](../res/estado_vertical_2.PNG)