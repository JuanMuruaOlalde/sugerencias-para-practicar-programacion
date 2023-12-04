## Objetos como “agrupadores de datos”

Los objetos permiten pasar/transmitir/devolver/guardar un grupo de datos. Como si fueran un conjunto, un objeto, único.

Hay diversas maneras de manipular los valores de cada dato:

- Directamente, con *objeto.dato = xxxxxxxx*

- A través de su setter, con *objeto.setDato(xxxxxxxx)*

- A través de un *constructor*. Pudiendo haber varios constructores distintos para un mismo objeto. Para asignar valores iniciales a distintos datos dentro del grupo, según sea necesario, en distintos casos.

## Objetos como "definiciones de tipo"

Los objetos permiten guiar al compilador para evitar confusiones en los tipos de datos a manejar.

Cuando un lenguaje de programación es fuertemente tipado. El compilador puede detectar errores en la manipulación de datos. Evitando problemas en tiempo de ejecución debidos a que alguna función reciba un dato que no esperaba recibir.

Esto se ve reforzado utilizando objetos para definir tipos propios "ad-hoc".

Por ejemplo, si una función espera una temperatura y otra función espera un precio. En ambos casos se podria emplear un parámetro de tipo 'double'. Pero si se define un objeto 'temperatura' y otro objeto 'precio', no habrá lugar a dudas ni confusiones. (Además, esos objetos pueden incorporar datos adicionales importantes; tal como la unidad de medida en un caso y la moneda en el otro.)

## Objetos como “protectores de la información": propiedades

Los objetos permiten controlar la forma de utilizar y de modificar la información que contienen.

Una propiedad puede definirse como privada. Para impedir que pueda ser manipulada directamente (con *objeto.propiedad*). Obligando a que su manipulación esté controlada:

- Para valores inmutables o para inicializar valores => se puede obligar a introducirlos a través de un constructor.
- Para recuperar valores => se pueden habilitar getters.
- Para modificar variables => se pueden habilitar setters.

nota: No merece la pena hacer privada una propiedad si luego se le va a poner automaticamente un getter y un setter que se limitan simplemente a devolver y asignar valores directamente. Es más fácil de usar si es pública.

nota: Muchos lenguajes modernos contemplan mecanismos para aunar el control que dan los *getters/setters* con la facilidad de uso de *objeto.propiedad*.

## Objetos como “protectores del comportamiento”: métodos

Los objetos permiten controlar la forma de utilizar y de modificar la información que contienen.
Los objetos indican el comportamiento que se espera de ellos.

Lo ideal es que las propiedades solo se puedan manipular a través de métodos públicos. Así queda claro lo que se puede hacer con el objeto (y lo que no).

## Objetos como “garantes de contratos”: Interfaces

Los interfaces en un programa son como las costuras en un traje. Dejan bien claro dónde termina una parte y dónde comienza otra, además de expresar cómo una parte depende de la otra.

Utilizando objetos "abstractos", se puede definir y obligar a cumplir un determinado patrón (un cierto interface) en ciertos objetos derivados:

- Objetos hijo, en caso de utilizar *'Herencia'*.

- Objetos implementadores, en caso de utilizar *'Interface'*.

La Herencia casi no se suele utilizar en los programas habituales. Prácticamente solo suele aparecer dentro de algunas bibliotecas especializadas o de algunos marcos de trabajo (frameworks).

Los Interfaces son de amplia utilización en los programas habituales.

Definiendo interfaces, quedan claras las dependencias y se evitan problemas por cambios disrruptivos en un objeto (en una parte del programa) que se utiliza por otros (en otras partes del programa). Si una parte cuenta con que la otra parte cumpla un cierto interfaz, queda claro qué es lo que se ha de cuidar al realizar modificaciones.

nota: En los últimos tiempos, este papel de "garantizar contratos" lo desempeñan también las APIs (Application Programming Interface).

## Recapitulación

Un objeto suele contener dos tipos de elementos:

- PROPIEDADES: para almacenar valores, información.

- MÉTODOS: para implementar funcionalides, comportamiento.

Cada uno de los elementos puede ser público (otros objetos lo pueden utilizar) o privado (solo lo puede usar el propio objeto internamente).

Todo objeto ha de proteger sus propiedades (la información que maneja). Usando sus métodos públicos (su comportamiento) para mostrar al mundo exterior la forma correcta de manipularlas. Esta protección es lo que se suele denominar *'Encapsulación'*.

Un objeto que prácticamente solo contiene propiedades (información) se suele denominar "objeto anémico". Salvo que haya sido diseñado específicamente así, por estar destinado simplemente a:

- Almacenar información. (nota: en el mundo Java, se han venido denominando POJOs, -Plain Old Java Object-)

- Mover información entre partes de una aplicación. (nota: se suelen denominar objetos DTO, -Data Transfer Object-)

~

***

Es importante que los objetos en una aplicación reflejen correctamente los entes reales del dominio en que dicha aplicación trabaja. Modelando tanto su información como su comportamiento.

(nota: Para más detalles a este respecto, merece la pena estudiar los conceptos del DDD -Domain Driven Design-; concretamente el libro de su autor: Eric Evans.)

***
~

## Explicacion formal

La definición de un objeto (sus propiedades y métodos) se denomina **clase**.

Cada objeto concreto de una determinada clase que se crea en la memoria del ordenador se denomina **instancia**.

La programación orientada a objeto (POO), OOP (Object Oriented Programming) se fundamenta en cinco principios básicos:

- **Encapsulación**: el propio objeto controla cómo se puede acceder a su interior, solo se puede acceder a través de sus propiedades o métodos públicos.

- **Polimorfismo**: puede haber varios métodos distintos con el mismo nombre, distinguiendose entre sí por los parámetros que reciben o por el resultado que devuelven;(mismo nombre de método, diferentes signaturas).

- **Composición**: un objeto puede utilizar otros objetos en su interior.

- **Herencia**: un objeto puede derivarse de otro objecto padre, heredando todas las propiedades y métodos de este.

  nota: Los métodos heredados pueden sobreescribirse (modificar su código), para que se comporten de forma diferente en el objeto hijo. Pero respetando el nombre, parámetros y retorno (la signatura del método).

  nota: Una clase abstracta es aquella que no se puede instanciar. Está diseñada expresamente para que solo se puedan derivar clases hijas a partir de ella.

- **Interface**: Un objeto puede estar obligado a implementar ciertos métodos con unas ciertas signaturas concretas (implementar un interface). De esta forma, todos los objetos que implementan un cierto interface comparten cierta funcionalidad común. Así, otros objetos que los usan saben a qué atenerse (la dependencia es explícita). A la hora de programar, se puede cambiar libremente el código de las clases implementadoras, pero el interface ha de respetarse (se evita romper dependencias "sin querer").
