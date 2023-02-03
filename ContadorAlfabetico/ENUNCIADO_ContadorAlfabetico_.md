# Introducción

Un contador se utiliza en las situaciones donde se ha de asignar un codigo identificador único a ciertos elementos. Por ejemplo: códigos de artículo, números de factura, etc.

- Se pueden usar cifras decimales, por su facilidad de incrementarlo: sumar +1 al número.

    nota: Es conveniente de que todos los códigos generados tengan un número fijo de cifras (por ejemplo 4, xxxx). 

    consejo: Para evitar confusiones o problemas informáticos. Poner alguna letra delante del número (letra que no afecta al contador) (Axxxx); o al menos asegurarse de no poner ceros a la izquierda (es decir, empezar por 1xxx).

- Pero usando letras, el código resulta mucho más robusto y compacto. (Un código de cuatro cifras puede tener 10^4 = 10.000 diferentes y uno de seis cifras 1.000.000. Sin embargo, un código de cuatro letras puede tener 21^6 = 194.481 diferentes y uno de seis letras 85.766.121)

    consejo: Para evitar confusiones, palabras malsonantes o problemas informáticos. Usar solo letras consonantes mayúsculas del código ASCII original:
    ````
    B C D F G H J K L M N P Q R S T V W X Y Z 
    ````

# Tareas a realizar

Implementar un objeto `ContadorAlfabetico` cuyo constructor reciba un código inicial de cuatro letras. Y que permita ir generando el siguiente código cada vez que se le pida hacerlo.

Por ejemplo:
````
El contador se ha inicializado con WHFX
El siguiente es WHFY
El siguiente es WHFZ
El siguiente es WHGB
El siguiente es WHGC
El siguiente es WHGD
El siguiente es WHGF
El siguiente es WHGG
El siguiente es WHGH
El siguiente es WHGJ
El siguiente es WHGK
````

# Tareas extras (opcionales)

Permitir trabajar con códigos de cualquier longitud. El constructor recibirá el número de caracteres a utilizar y un código de inicio acorde a la longitud escogida.

# Una pista para el futuro...

Si no es necesario que los códigos sean consecutivos. Es decir, solo importa la unicidad de los códigos. Y tampoco es necesario que los tecleen personas humanas. Es decir, por ejemplo, se van a representar en códigos QR (https://en.wikipedia.org/wiki/QR_code) o similares; y se van a manejar escaneando esos codigos.

En esos casos, lo más práctico son los UUID (https://en.wikipedia.org/wiki/Universally_unique_identifier). Con ellos, nos evitamos el uso de contadores.

Por eso, hoy en día, prácticamente todos los lenguajes modernos de programación tienen funciones para generar UUIDs ==> [Algunos ejemplos](https://en.wikipedia.org/wiki/Universally_unique_identifier#External_links). 