# Tareas a realizar:

Se trata de pasar unos determinados datos a una función. Para que esta calcule y nos devuelva unos determinados resultados.

NOTA: El cálculo que se indica no tiene realmente sentido. No se corresponde con ningún cálculo real. Simplemente se ha cuidado que sea dimensionalmente coherente, sin más.

¡IMPORTANTE! ==> Primero se hará el ejercicio con una sola unidad de medida en cada parámetro. Así nos evitamos la tarea extra de hacer conversiones. Pero, también en este caso, aunque la unidad de medida sea fija, prever alguna forma para que cada parámetro guarde también su correspondiente unidad de medida además de su valor. (Es decir, preparar el terreno por si decidimos realizar la tarea adicional indicada al final.)

## Parámetros de entrada

**Velocidad del viento**: en metros por segundo (m/s)

**Lados de la vela** (rectangular): en centimetros (cm)

**Densidad del aire**: se considerará una constante, de valor 1.204 kg/m3

**¿Aplicar refuerzos?**: será un booleano (si/no)

**Densidad de partículas**: en partículas por metro cúbico (p/m3)

## Parámetros de salida: Resultados

**Área de la vela**: en metros cuadrados (m2)

La calcularemos multiplicando un lado por el otro lado de la vela rectangular.

**Factor Z**: lo calcularemos multiplicando la velocidad del viento por la densidad del aire y por el área de la vela.

En cuanto a sus unidades de medida quedaría así: (m/s)(kg/m3)(m2) = kg/s

**Cantidad de refuerzos**: En caso de aplicarse, se pondrá 1 refuerzo por cada 5 metros cuadrados de vela y 1 refuerzo más por cada 12 factoresZ. En caso de no aplicarse, se pondrá 0 refuerzos. Se redondeará al entero más cercano por arriba.

**Cantidad de contenedores de partículas**: se pondrá 1 contenedor por cada 350 particulas/m (dividir la densidad de partículas por el area de la vela). Se redondeará al entero más cercano por arriba.

# Algunos aspectos sobre los que reflexionar

## ¿Cómo agrupar valor y unidad de medida en cada parámetro?

Un número no significa realmente nada, (a no ser que sea un coeficiente o un ratio). La mayoria de números necesitan una unidad de medida para tener sentido.

De ahí que prácticamente cada parámetro necesite dos informaciones: valor y unidad.

## ¿Cómo diferenciar cláramente las entradas, por un lado, y los resultados, por otro?

Es algo importante, sobre todo si queremos delegar el calculo a una función.

A la hora de pasar todos los parámetros de entrada a la función, la cosa se complica si estos son muchos.

Igual problema se da a la hora de devolver muchos resultados.

# Tarea adiccional complementaria

Permitir escojer las unidades de medida en cada parámetro.

## Algunas recomendaciones para manejar unidades

Aunque admita entradas y salidas en distintas unidades de medida. El trabajo interno del programa es conveniente que sea en unas ciertas unidades fijas.

Decidir cual será la unidad interna para cada uno de los parámetros. De tal forma que:

-   Las entradas se convierten a unidades internas tan pronto como se introduzcan.
-   Los cálculos se realizan en las unidades internas.
-   La persistencia se guarda en las unidades internas.
-   Los resultados se convierten a las unidades que se soliciten, justo antes de mostrarlos al usuario.

Es conveniente que las unidades internas sean del Sistema Métrico Internacional (SI): metros, kilos, segundos,...

https://es.wikipedia.org/wiki/Sistema_Internacional_de_Unidades

https://es.wikipedia.org/wiki/Sistema_Internacional_de_Unidades#Unidades_derivadas

## Sugerencias de unidades de medida que podriamos usar

### Parámetros de entrada

**Velocidad del viento**: en metros por segundo (m/s) o en kilómetros por hora (km/h) o en nudos (kn)

-   1 km/h = 1/3.6 m/s = 0.2777 m/s
-   1 m/s = 1/0.277 km/h = 3.6 km/h
-   1 kn = 1/1.9455 m/s = 0.514 m/s
-   1 m/s = 1/0.514 kn = 1.9455 kn

**Lados de la vela** (rectangular): en metros (m), en centimetros (cm) o en pulgadas (in)

-   1 in = 1/0.3937 = 2.54 cm
-   1 cm = 1/2.54 in = 0.3937 in

**Densidad de partículas**: en partículas por metro cúbico (p/m3) o por pié cúbico (p/ft3) (nota: 1ft = 12in)

-   1 p/ft3 = 1/0.02832 p/m3 = 35.31 p/m3
-   1 p/m3 = 1/35.31 p/ft3 = 0.02832 p/ft3

### Parámetros de salida: Resultados

**Área de la vela**: en metros cuadrados (m2) o en pies cuadrados (ft2).

-   1 m2 = 10.7639 ft2
-   1 ft2 = 1/10.7639 m2 = 0.0929 m2

**Factor Z**: al calcularse multiplicando la velocidad del viento por la densidad del aire y por el área de la vela, sus unidades en SI serán: (m/s)(kg/m3)(m2) = kg/s
