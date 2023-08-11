# Tareas a realizar:

Se trata de pasar unos datos a una función. Y que esta calcule y nos devuelva unos resultados.

nota: El cálculo no tiene realmente sentido. No se corresponde con ningún cálculo real. Es simplemente para tener unas instrucciones a seguir.

¡IMPORTANTE! Hacer primero el ejercicio con solo una unidad de medida para cada parámetro. Así nos evitamos conversiones. Pero, aún en ese caso, preparar alguna forma para que cada parámetro tenga asociada su correspondiente unidad de medida además de su valor.

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

**Cantidad de refuerzos**: En caso de aplicarse, se pondrán 1 refuerzo por cada 5 metros cuadrados de vela y 1 refuerzo más por cada 12 factoresZ. En caso de no aplicarse, se pondrá 0 refuerzos. Se redondeará al entero más cercano por arriba.

**Cantidad de contenedores de partículas**: se pondrán 1 contenedor por cada 350 particulas/m (dividir la densidad de partículas por el area de la vela). Se redondeará al entero más cercano por arriba.

# Algunos aspectos sobre los que reflexionar

## ¿Cómo agrupar valor y unidad de medida en cada parámetro?

Un número no significa realmente nada, (a no ser que sea un coeficiente o un ratio).

La mayoria de números necesitan una unidad de medida para tener sentido.

## ¿Cómo diferenciar cláramente las entradas, por un lado, y los resultados, por otro?

Importante sobre todo si queremos delegar el calculo a una función. Tenemos que pasar todos los parámetros de entrada a dicha función. Además de que esta función ha de devolver todos los resultados.

Cuanto mejor se puedan manipular separadamente las entradas y las salidas. Más sencillo sera delegar el cálculo a una función o a un módulo dedicado que luego se pueda integrar en un sistema mayor. Más sencillo será hacer test automáticos a esa parte. Más sencillo será servir el cálculo a través de una API. ...

## ¿Cómo facilitar la definición de nuevas unidades de medida?

Las unidades y sus respectivos factores de conversión deberian estar en algún soporte facilmente editable por el usuario.

# Algunas recomendaciones para manejar unidades

Aunque admita entradas y salidas en distintas unidades de medida. El programa trabajará internamente todo en unidades internacionales (SI): metros, kilos, segundos,...

https://es.wikipedia.org/wiki/Sistema_Internacional_de_Unidades

https://es.wikipedia.org/wiki/Sistema_Internacional_de_Unidades#Unidades_derivadas

Es decir:

- Las entradas del usuario se convierten siempre a su equivalente (SI) y se trabaja internamente con esos valores en (SI).
- Los resultados se obtienen siempre en (SI) y se convierten a otras unidades solo en el momento de mostrarlos al usuario.

Si los parámetros se almacenan o transmiten de algún modo. En cada uno de ellos es conveniente contemplar los dos valores (con sus respectivas unidades de medida): la (SI) como principal y la del usuario como secundario.

Así queda claro que el programa trabaja internamente en (SI) y cuales han sido las conversiones realizadas. Evitandose malentendidos de unidades o problemas de interpretación por redondeos.

## Sugerencias de unidades de medida que podriamos usar

### Parámetros de entrada

**Velocidad del viento**: en metros por segundo (m/s) o en kilómetros por hora (km/h) o en nudos (kn)

- 1 km/h = 1/3.6 m/s = 0.2777 m/s
- 1 m/s = 1/0.277 km/h = 3.6 km/h
- 1 kn = 1/1.9455 m/s = 0.514 m/s
- 1 m/s = 1/0.514 kn = 1.9455 kn

**Lados de la vela** (rectangular): en centimetros (cm) o en pulgadas (in)

- 1 in = 1/0.3937 = 2.54 cm
- 1 cm = 1/2.54 in = 0.3937 in

**Densidad de partículas**: en partículas por metro cúbico (p/m3) o por pié cúbico (p/ft3) (nota: 1ft = 12in)

- 1 p/ft3 = 1/0.02832 p/m3 = 35.31 p/m3
- 1 p/m3 = 1/35.31 p/ft3 = 0.02832 p/ft3

### Parámetros de salida: Resultados

**Área de la vela**: en metros cuadrados (m2) o en pies cuadrados (ft2).

- 1 m2 = 10.7639 ft2
- 1 ft2 = 1/10.7639 m2 = 0.0929 m2

**Factor Z**: como se calcula multiplicando la velocidad del viento por la densidad del aire y por el área de la vela, sus unidades en SI serán: (m/s)(kg/m3)(m2) = kg/s
