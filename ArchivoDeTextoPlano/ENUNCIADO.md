# Introducción

Los datos que se guardan en un archivo de texto plano van repartidos en filas. Cada fila es un registro.

Los distintos datos de cada registro, los distintos campos. Se separan uno del otro con una marca específica.

Las marcas de división más habituales suelen ser las "comas" (,) o los "punto y coma" (;).
Pero la mejor marca es la combinación "espacios dospuntos espacios" ( : ).

# Tareas a realizar:

- Crear una clase "Persona" con los atributos y constructor correspondientes.

- Leer el archivo de texto que se suministra.
````
nombre   : apellidos     : nacimiento : peso_kg : altura_cm : fecha_medicion
Pedro    : Rodrigez Pike : 23/04/1973 :   56,3  :  168,5    : 22/11/2021
Marta    : Batiato Rueda : 21/09/1984 :   65,8  :  170,2    : 22/11/2021
Benzirpi : Mirvento      : 25/11/1967 :  100,2  :  172      : 22/11/2021
Luisa    : Perez Bila    : 23/07/1985 :   56,2  :  161,5    : 22/11/2021
````

- Separar las distintas lineas (registros) y trocear cada linea en sus respectivos datos (campos).

- Crear instancias de un objeto "persona" para cada registro e inicializarlas con los datos correspondientes.

- Guardar todos esos objetos en una lista de personas.

- Recorrer la lista e imprimirla en pantalla: cada persona volcada en una especie de ficha de cuatro lineas, por ejemplo
````
Pedro Rodriguez Pike
Fecha de nacimiento: 23/04/1973
Altura: 168,5 cm
Peso: 56,3 Kg (el 22/11/2021)
================================
````

# Tareas complementarias:
- Mejor si se utiliza una expresión regular para indicar la marca de división. `(\s+:\s+)` Así se pueden indicar "cualquier número de espacios o de caracteres blancos (tabuladores o similares)", tanto por delante de los dospuntos como por detrás. 

