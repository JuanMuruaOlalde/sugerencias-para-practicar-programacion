# Introducción

Recorrer listas de elementos para hacer algo con cada uno de ellos. Es una operación muy habitual en muchos programas.

Los elementos pueden ser datos simples: números, textos, fechas, booleanos,... O pueden ser datos compuestos: tuplas, otras listas,objetos,...

Una lista se puede implementar de variadas formas:

- Las clásicas, lo que realmente hay implementado a nivel de máquina: arrays, listas enlazadas, árboles,...
- Las de uso habitual hoy en día, las colecciones: colas (queue), pilas (stack), listas (list), tuplas (tuple), conjuntos (set), mapas (map), diccionarios (dictionary), ...

# Tareas a realizar

Usando cualquiera de las colecciones que ponga a nuesta disposición el lenguaje de programación que estemos utilizando.

Agarrar esta lista de números:

```
{34, 76, 295, 17, 861, 5, 95, 127, 3, 99, 26, 49, 117, 532, 15, 88, 2, 31}
```

Y con ella:

- Obtener otra lista con todos los números multiplicados por un factor determinado. (por ejemplo por 2, es decir, el doble)

- Obtener la suma total de todos los números en la lista.

- Obtener otra lista con solo los números impares.

- Obtener otra lista con todos los números incrementados en un porcentaje determinado. (por ejemplo, un 30%)

Elaborar una lista de objetos de clase `MedicionMetereologica`:

```
fecha
temperatura_max_celsius
temperatura_min_celsius
humedad_max_porcentaje
humedad_min_porcentaje
lluvia_litrospormetrocuadrado
```

Y con ella:

- Obtener la temperatura máxima media y la temperatura mínima media.

# Tareas extras (opcionales)

En un principio se trata de resolver la funcionalidad. Pero en los programas reales es tanto o más importante la buena (y clara) presentación cara a las personas que los van a utilizar. En ese sentido, aquí mereceria prestar atención a:

- El formato de números (separador decimal, separador de grupos de cifras) y el formato de fechas, han de ser acordes a las costumbres del pais donde estemos.

- La suma total es más legible si lleva separador de miles.

- Las temperaturas quedan mejor mostrando dos decimales, las humedades mostrando número entero y la lluvia mostrando un decimal. Las unidades de medida son imprescindibles en toda cantidad que deba llevarlas.

# Una pista para el futuro...

En el paradigma de la `programación funcional`. Algunas de estas tareas tienen formas propias de hacerse:

- `map(lista, función)`, aplicar una función a todos y cada uno de los elementos de una lista, devolviendo otra lista con el mismo número de elementos (cada uno transformado por la función).

- `reduce(lista, función)`, similar a map, solo que la función se aplica sobre los elementos secuencialmente, devolviendo un resultado único (acumulado a partir de los resultados parciales de la función en los distintos elementos).

- `filter(lista, función)`, aplicar una función (con resultado booleano) a todos y cada uno de los elementos de una lista, devolviendo otra lista con aquellos elementos donde la función devuelve 'verdadero'.

