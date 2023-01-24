# Introducción

Los datos que se guardan en un archivo de texto plano van repartidos en filas. Cada fila es un registro.

Los datos en cada registro (los campos). Se separan uno del otro con una marca específica.

Las marcas de división más habituales suelen ser las "comas" (,) o los "punto y coma" (;).
Pero la mejor marca es la combinación "espacios dospuntos espacios" ( : ).

Por otro lado, es necesario tener en cuenta que las fechas y los números tienen distintas representaciones. Según el pais o la cultura en la que se esté trabajando.
- [Date and Time representation by country](https://en.wikipedia.org/wiki/Category:Date_and_time_representation_by_country) 
- [Date format by country](https://en.wikipedia.org/wiki/Date_format_by_country)
- [Decimal separator and digit grouping mark](https://en.wikipedia.org/wiki/Decimal_separator)

Y, para terminar, comentar la importancia de que todo número lleve de alguna forma asociada su unidad de medida. (Se han producido muchísimos errores debidos a malinterpretaciones. Por ejemplo: https://en.wikipedia.org/wiki/Unit_of_measurement#Real-world_implications)

# Tareas a realizar:

- Crear una clase "Persona" con los atributos y el constructor correspondientes.

- Poner a esa clase "Persona" metodos getter para sus atributos. Ponerle también un metodo setter para cambiar el peso y la fecha de medicion.

- Leer el archivo de texto que se suministra.
````
nombre   : apellidos     : nacimiento : peso_kg : altura_cm : fecha_medicion
Pedro    : Rodrigez Pike : 23/04/1973 :   56,3  :  168,5    : 22/11/2021
Marta    : Batiato Rueda : 21/09/1984 :   65,8  :  170,2    : 22/11/2021
Benzirpi : Mirvento      : 25/11/1967 :  100,2  :  172      : 22/11/2021
Luisa    : Perez Bila    : 23/07/1985 :   56,2  :  161,5    : 22/11/2021
````

- Separar las distintas lineas (registros) y trocear cada linea en sus respectivos datos (campos).

- Crear instancia de un objeto "persona" para cada registro y rellenar los campos correspondientes.

- Guardar todas esas instancias en una lista de personas.

- Recorrer la lista e imprimirla en pantalla: cada persona se representará en una especie de ficha de cuatro lineas, por ejemplo
````
Pedro Rodrigez Pike
Fecha de nacimiento: 1973-04-23
Altura: 168.5 cm
Peso: 56.3 kg   (medido el 2021-11-22)
=======================================
````

# Tareas extendidas (opcionales):

notas:
    - Si la lectura de fechas se complica, se puede relajar el ejercicio y simplificarlo usando propiedades tipo texto en lugar de un tipo fecha propiamente dicho.
    - Si la lectura de números se complica, se puede relajar el ejercicio y simplificarlo usando propiedades tipo texto en lugar un tipo numero propiamente dicho.

- Al trocear cada linea, seria interesante utilizar una expresión regular para indicar la marca de división. `(\s+:\s+)` Así se pueden indicar "cualquier número de espacios o de caracteres blancos (tabuladores o similares)", tanto por delante de los dospuntos como por detrás. 

- Respecto al peso de una persona, seria interesante poder disponer del historial de sus mediciones. Es decir, habria que disponer una lista y guardar en ella la medida anterior cada vez que se ejecute el metodo setter para poner una nueva medida.
