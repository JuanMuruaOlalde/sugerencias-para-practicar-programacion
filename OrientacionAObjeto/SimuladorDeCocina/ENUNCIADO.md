# Tareas a realizar:

Preparar una forma de almacenar recetas (en memoria):
 - Lista de ingredientes: nombre, cantidad, unidad de medida.
 - Lista de instrucciones, con simples descripciones de lo que hacer en cada paso.

Alimentaremos la lista de ingredientes a una función "Comprar()". Que simplemente mostrará una frase resumiendo el ingrediente comprado.

Alimentaremos la lista de instrucciones a una función "Cocinar()". Que simplemente irá mostrando la descripción de cada paso con un número de orden por delante.

El resultado final prodria ser algo así como esto:
````
Procurando los INGREDIENTES...
Marchando 500 gr de harina.
Marchando 250 ml de agua.
Marchando 5 gr de levadura seca de panadero.
Marchando 8 gr de sal.
Ya están todos los ingredientes.
COCINANDO...
[1] ==> En un bol poner la levadura, un poquito del agua y un poquito de la harina.
[2] ==> Dejar reposar unos 15 minutos
[3] ==> Añadir el resto de la harina, del agua y la sal.
[4] ==> Mezclar bien. Al principio con una mano sujetando el bol y con la otra mezclando. Una vez la masa no pringa, se pueden usar las dos manos para amasar.
[5] ==> Trabajar la masa durante unos 10 minutos, amasandola con las manos.
[6] ==> Dar forma a la masa y dejarla dormir durante unas tres horas o más. Bien arropadita: en lugar cálido y sin corrientes de aire.
[7] ==> Precalentar el horno a unos 250 grados centígrados.
[8] ==> Poner la masa sobre una bandeja (o sobre rejilla con papel de horno). Hacerle unos cortes con una cuchilla de afeitar. Meterla al horno, durante unos 20 minutos.
[9] ==> Dejar enfriar, sobre una rejilla, durante una media hora como mínimo.
TERMINADO, ¡buen provecho!
````

# Algunos aspectos sobre los que reflexionar

## ¿Cómo almacenar también metadatos de cada receta?

Por ejemplo: nombre de la receta, tiempo aproximado para realizarla, nivel de dificultad, etc.
