# Introducción

Las tablas de consulta, [LUT "lookup table"](https://en.wikipedia.org/wiki/Lookup_table), tienen muchos usos en programación. Desde facilitar conversiones entre grupos de símbolos, como es en esta práctica. Hasta el ahorro de cálculos costosos al almacenar resultados intermedios (o conocidos) ya (pre)calculados.

Una tabla de consulta consiste simplemente en unos cuantos elementos guardados en memoria. De forma que se pueda buscar en ellos el elemento necesario en cada momento.

## Algunos comentarios acerca de las búsquedas

Cuando hay pocos datos (a día de hoy, año 2020, pocos = hasta unas decenas de miles de elementos). Se puede buscar con el método simple y directo. En cada búsqueda:
- recorrer todos los elementos, 
- ir compararando en cada uno,
- hasta encontrar el que se busca.

Cuando hay muchos datos, se hace necesario recurrir a métodos de clasificación y búsqueda más sofisticados; como los que suelen estar detrás de cualquier base de datos. Por ejemplo los [árboles binarios](https://en.wikipedia.org/wiki/Binary_tree).

# Tareas a realizar

- Pedir al usuario un texto.

- Separar cada una de sus letras.

- Para cada una de las letras, buscar en la tabla de consulta letra|morse su símbolo morse correspondiente.
````
["A", ".-"]
["B", "-..."]
["C", "-.-.-"]
["D", "-.."]
["E", "."]
["F", "..-."]
["G", "--."]
["H", "...."]
["I", ".."]
["J", ".---"]
["K", "-.-"]
["L", ".-.."]
["M", "--"]
["N", "-."]
["O", "----"]
["P", ".--."]
["Q", "--.-"]
["R", ".-."]
["S", "..."]
["T", "-"]
["U", "..-"]
["V", "...-"]
["W", ".--"]
["X", "-..-"]
["Y", "-.--"]
["Z", "--."]
["1", ".----"]
["2", "..---"]
["3", "...--"]
["4", "....-"]
["5", "....."]
["6", "-...."]
["7", "--..."]
["8", "---.."]
["9", "----."]
["0", "-----"]
````
- Mostrar el resultado morse al usuario.

# Tareas extras (opcionales)

- Utilizar algún recurso de audio de la biblioteca del lenguaje de programación, para hacer audible el código morse. Tener en cuenta que es importante el "timming", la cadencia de reprodución de sonidos. El código morse se interpreta por la "musicalidad" de cada símbolo. 

    https://en.wikipedia.org/wiki/Morse_code#Representation,_timing,_and_speeds

    https://en.wikipedia.org/wiki/Morse_code#Learning_methods

- Implementar también la conversión inversa morse==>texto.
