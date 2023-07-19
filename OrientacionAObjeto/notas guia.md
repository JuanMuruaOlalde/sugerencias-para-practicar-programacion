# Objetos como “agrupadores de datos”

Poner juntas las variables que pertenecen a un mismo concepto.
- (asignándolas con objeto.propiedad = xxxxxxxx )
- (asignándolas a través de un constructor; pudiendo haber varios constructores distintos para un mismo objeto)

Los objetos permiten pasar/transmitir/devolver/guardar un grupo de datos.

¡Los objetos han de representar elementos del dominio.!

nota: Los objetos en los que prácticamente casi su única misión es contener datos. Se suelen denominar DTOs (Data Transfer Object). Aunque en el entorno Java, también se suelen conocer como POJOs (Plain Old Java Object).

# Objetos como "definiciones de tipo"

Cuando un lenguaje de programación es fuertemente tipado. El compilador puede detectar errores en la manipulación de datos. Evitando problemas en tiempo de ejecución debidos a que alguna función reciba un dato que no esperaba recibir.

Esto se ve reforzado si utilizamos objetos para definir tipos propios de datos. Tipos especializados para el dominio de aplicación en el que estemos trabajando. 

Por ejemplo, si una función espera una temperatura y otra función espera un precio. En ambos casos se podria emplear un parámetro de tipo 'double'. Pero si definimos un objeto 'temperatura' y otro objeto 'precio', no habrá lugar a dudas ni confusiones. (Además, esos objetos pueden incorporar información adicional importante; tal como la unidad de medida en un caso y la moneda en el otro.)

# Objetos como “protectores de datos”: propiedades

Propiedades privadas
-	Para valores inmutables o para inicializar valores => introducirlos a través de un constructor.
-	Para valores variables => habilitar setters.
-	Para recuperar datos => habilitar getters.

Cada objeto deja bien clara la forma en que se pueden leer o modificar los valores que contiene.

# Objetos como “protectores del comportamiento”: métodos

Métodos públicos
(y métodos privados, si es menester…)

Cada objeto deja bien claras las operaciones que se pueden realizar sobre o con la información que contiene.

# Objetos como “garantes de contratos”:  Interface

Utilizando objetos "abstractos", se puede definir y obligar a cumplir un determinado patrón en ciertos objetos derivados. (Objetos hijo en caso de utilizar 'Herencia'.) (Objetos que lo implementan en caso de utilizar 'Interface'.)

De esta forma, quedan claras las dependencias (lo que se espera que el objeto haga o contenga). Y se evitan problemas por cambios disrruptivos en un objeto (en una parte del programa) que ha de ser utilizado en otras partes del programa.

La Herencia casi no se suele utilizar en los programas habituales. Prácticamente se utiliza solo en algunas bibliotecas especializadas o en algunos marcos de trabajo (frameworks).

Los Interfaces son (o deberian ser) de amplia utilización. Para hacer patente si una parte del programa espera interactuar de una cierta manera concreta con alguna otra parte del programa. Con el uso de Interfaces para explicitar esos puntos de interacción, el propio compilador avisará cuando se haga alguna modificación en alguna parte que rompa alguna de esas dependencias.

Los Interfaces en un programa son como las costuras en un traje. Dejan bien claro dónde termina una parte y dónde comienza otra, además de expresar cómo una parte depende de la otra.

nota: En los últimos tiempos, esta función la desempeñan también las APIs.


