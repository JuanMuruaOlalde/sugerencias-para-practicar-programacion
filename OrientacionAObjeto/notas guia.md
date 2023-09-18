# Objetos como “agrupadores de datos”

Los objetos permiten pasar/transmitir/devolver/guardar un grupo de datos. Como si fueran un conjunto, un objeto, único.

Hay diversas maneras de manipular los valores de cada dato:

- Directamente, con *objeto.dato = xxxxxxxx*

- A través de su setter, con *objeto.setDato(xxxxxxxx)*

- A través de un *constructor*; pudiendo haber varios constructores distintos para un mismo objeto, para asignar valores iniciales a distintos datos dentro del grupo, según sea necesario en distintos casos.

# Objetos como "definiciones de tipo"

Los objetos permiten guiar al compilador para evitar confusiones en los tipos de datos a manejar.

Cuando un lenguaje de programación es fuertemente tipado. El compilador puede detectar errores en la manipulación de datos. Evitando problemas en tiempo de ejecución debidos a que alguna función reciba un dato que no esperaba recibir.

Esto se ve reforzado utilizando objetos para definir tipos propios "ad-hoc". 

Por ejemplo, si una función espera una temperatura y otra función espera un precio. En ambos casos se podria emplear un parámetro de tipo 'double'. Pero si se define un objeto 'temperatura' y otro objeto 'precio', no habrá lugar a dudas ni confusiones. (Además, esos objetos pueden incorporar datos adicionales importantes; tal como la unidad de medida en un caso y la moneda en el otro.)

# Objetos como “protectores de la información": propiedades

Los objetos permiten controlar la forma de utilizar y de modificar la información que contienen.

Una propiedad puede definirse como privada. Para impedir que pueda ser manipulada directamente (con objeto.propiedad). Obligando a que su  manipulación esté controlada:
-	Para valores inmutables o para inicializar valores => se puede obligar a introducirlos a través de un constructor.
-	Para recuperar valores => se pueden habilitar getters.
-	Para modificar variables => se pueden habilitar setters.

nota: No merece la pena hacer privada una propiedad si luego se le va a poner automaticamente un getter y un setter. Salvo que ese getter o ese setter hagan algo más que simplemente devolver o asignar valores directamente.

# Objetos como “protectores del comportamiento”: métodos

Los objetos permiten controlar la forma de utilizar y de modificar la información que contienen.
Los objetos indican el comportamiento que se espera de ellos.

Lo ideal es que las propiedades solo se puedan manipular a través de métodos públicos. Así queda claro lo que se puede hacer con el objeto (y lo que no).

# Objetos como “garantes de contratos”:  Interfaces

Los interfaces en un programa son como las costuras en un traje. Dejan bien claro dónde termina una parte y dónde comienza otra, además de expresar cómo una parte depende de la otra.

Utilizando objetos "abstractos", se puede definir y obligar a cumplir un determinado patrón (un cierto interface) en ciertos objetos derivados:

- Objetos hijo, en caso de utilizar *'Herencia'*.

- Objetos implementadores, en caso de utilizar *'Interface'*.

La Herencia casi no se suele utilizar en los programas habituales. Prácticamente solo se utiliza dentro de algunas bibliotecas especializadas o de algunos marcos de trabajo (frameworks).

Los Interfaces son de amplia utilización en los programas habituales. 

Definiendo interfaces, quedan claras las dependencias y se evitan problemas por cambios disrruptivos en un objeto (en una parte del programa) que se utiliza por otros (en otras partes del programa). Si una parte cuenta con que la otra parte cumpla un cierto interfaz, queda claro qué es lo que se ha de cuidar al realizar modificaciones.

nota: En los últimos tiempos, este papel lo desempeñan también las APIs, -Application Programming Interface-.

# Recapitulación

Un objeto suele contener dos tipos de elementos:

- PROPIEDADES: para almacenar valores, información.

- MÉTODOS: para implementar funcionalides, comportamiento.

Cada uno de los elementos puede ser público (otros objetos lo pueden utilizar) o privado (solo lo puede usar el propio objeto internamente). 

Todo objeto ha de proteger sus propiedades (la información que maneja). Usando sus métodos públicos (su comportamiento) para mostrar al mundo exterior la forma correcta de manipularlas. Esta protección es lo que se suele denominar *'Encapsulación'*.

Un objeto que prácticamente solo contiene propiedades (información) se suele denominar "objeto anémico". Salvo que haya sido diseñado específicamente así, por estar destinado simplemente a:

- Almacenar información. (nota: en el mundo Java, se han venido denominando POJOs, -Plain Old Java Object-)

- Mover información entre partes de una aplicación. (nota: se suelen denominar objetos DTO, -Data Transfer Object-)

~
---
Es importante que los objetos en una aplicación reflejen correctamente los entes reales del dominio en que dicha aplicación trabaja. Modelando tanto su información como su comportamiento. 
---
(nota: Para más detalles a este respecto, merece la pena estudiar los conceptos del DDD -Domain Driven Design-; concretamente el libro de su autor: Eric Evans.)


