# Introducción

Como es sabido,

- Las personas trabajamos los números con un código decimal (diez símbolos).

- Los ordenadores trabajan internamente con un código binario (dos símbolos).

- Un número en binario se puede hacer muy largo, así es que suele resultar útil abreviarlo a un código hexadecimal (dieciseis símbolos). Agrupando el código binario de cuatro en cuatro.

El valor unitario de cada símbolo es fijo:

- El 0, 1, 2, 3, 4, 5, 6 ,7 ,8 y 9 del código decimal tienen el valor habitual.

- El 0 y el 1 del código binario tienen el valor habitual.

- El código hexadecimal amplia el decimal con A, B, C, D y E  (con los respectivos valores de 10, 11, 12, 13, 14 y 15)

En los tres códigos se suele usar [notación posicional](https://en.wikipedia.org/wiki/Positional_notation) para escribir los números: cada símbolo tiene un valor diferente dependiendo de en qué posición aparezca. Por ejemplo:

- En decimal `1511`. De derecha a izquierda, el primer 1 vale 10^0^=1, el segundo 1 vale 10^1^=10, el tercer 5 vale 10^2^=100 y el cuarto 1 vale 10^3^=1000. Es decir el número es 1 + 10 + 500 + 1000 = 1.511 en decimal.

- En binario `1011`. De derecha a izquierda, el primer 1 vale 2^0^=1, el segundo 1 vale 2^1^=2, el tercer 0 vale 2^2^=4 y el cuarto 1 vale 2^3^=8. Es decir el número es 1 + 2 + 0 + 8 = 11 en decimal.

- En hexadecimal `1A11`. De derecha a izquierda, el primer 1 vale 16^0^=1, el segundo 1 vale 16^1^=16, el tercer A vale 16^2^=256 y el cuarto 1 vale 16^3^=4.096. Es decir el número es 1 + 16 + 2.560 + 4.096 = 6.673 en decimal.


> Por ejemplo:  0011 1100 0101 1010 = 15.450 = 3C5A

> 0011 es 3 ,  1100 es 12 (C)  ,  0101 es 5  ,  1010 es 10 (A)

> 1C5A se interpreta como 10 * 16^0^ + 5 * 16^1^ + 12 * 16^2^ + 3 * 16^3^ = 10 * 1 + 5 * 16 + 12 * 256 + 3 * 4096 = 10 + 110 + 3072 + 12288


# Tareas a realizar

- Solicitar al usuario que introduzca un número entero (en código decimal)

- Convertirlo a hexadecimal usando aritmética modular módulo 16 (cocientes y restos dividiendo por 16).

- Convertirlo a binario usando aritmética modular módulo 2 (cocientes y restos dividiendo por 2).


# Tareas extras (opcionales)

- Solicitar al usuario un número en código hexadecimal y convertirlo a binario y a decimal.

- Solicitar al usuario un número en código binario y convertirlo a hexadecimal y a decimal.
