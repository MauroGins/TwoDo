A1.3 · Análisis de limitaciones de un dispositivo

Objetivo: relacionar las limitaciones del hardware con decisiones concretas de diseño de software.

Sobre un dispositivo real (el tuyo o uno del departamento), documenta:

    Especificaciones: procesador, RAM, almacenamiento libre, pantalla (tamaño, resolución, densidad), versión de Android y nivel de API.
    Sensores disponibles. Puedes usar una app de diagnóstico para listarlos.
    Estado de la batería y consumo por aplicación (Ajustes → Batería).

Y después, la parte importante: tres conclusiones de diseño para tu futura aplicación derivadas de lo observado. No vale enunciar generalidades;
cada conclusión debe apoyarse en un dato concreto de los que has recogido.

[Mi dispositivo móvil]:
Me han aconsejado bajarme una app llamada "DevCheck" para obtener todos los datos.
El modelo de mi móvl es un Xiaomi 12T Pro, con una versión Android 15 Vanilla Ice Cream.
El procesador es un Qualcomm Snapdragon 8+ Gen1, con una pantalla de 120Hz y una resolución de 1220*2712 (Tamaño de 169mm o 6.67in). Las tasas de refersh 
que soporta son de 60,90 y 120 Hz.La densidad de Android(dpi es de 480dpi (xxhdpi)).Soporta HDR. Con una memoria Ram de 12GB y un almacenamiento de 256GB(libres 180GB).
En la lista de sensores encontramos el de temperaturas, acelerómetro, campo magnético, orientacion, giroscopio, luz ambienta, proximidad, gravedad,
aceleracion lineal, vector de rotacion, vector de rotación en juegos, detector de passo, contador de pasos, device_orient non-wakeup, touch sensor, entre
muchos otros.
El estado de la bateria (supongo que hablamos de salud de ella) es "Buena". Diseñada con una capacidad de 5000mAh.


La conclusión apra mi diseño de la futura aplicación.
Para explicarla debo decir que mi aplicación sera basicamente una app de compartir datos con mi esposa como listas de la compra, actividades de los niños con horario de recogida y entrega, actividades extraescolares,
o fechas importnates a recordar, que ambos podrán manejar o incluso poner alarmas
Pues según he estado investigando y basandome en el tipo de actividad que quiero realizar, me decantaré por:
1) El sistema de alarmas y avisos fiables en un Xiaomi (API35) con Android 15. Además se podrá quitar la restricción de uso de batería automático en los ajustes de Xiaomi.
2) La interfaz para una pantalla alta y estrecha. Perfecta para leer la información de la agenda con las recogidas cronológicas, etc. Perfecta para usar a una mano.
3) Al ser un movil de alta gama hay espacio de sobra para guardar los datos familiares en el propio movil y podría trabajar sin conexión, perfecta para hacer una copia a nivel local completa para consultar las listas.