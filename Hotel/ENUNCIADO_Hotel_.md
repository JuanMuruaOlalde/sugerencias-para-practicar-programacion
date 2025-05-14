nota: Este ejercicio intenta ser un proyecto de una cierta (gran) envergadura. Se puede complementar con todo aquello que se nos ocurra. Lo que se cita aquí son solo algunas ideas de por dónde comenzar a trabajar.

nota: un par de muestras de posibles soluciones están en [Hotel-Java](https://github.com/JuanMuruaOlalde/Hotel-Java) y en [Hotel-Rust](https://github.com/JuanMuruaOlalde/Hotel-Rust)


# Entidades a contemplar

Siguiendo la recomendación de DDD (Domain Driven Development) acerca del "ubiquitous language": todas las personas que participan en una determinada parte del sistema ("bounded context") han de hablar un lenguaje común.

Así vamos a llamar a las principales entidades que vamos a manejar:

- [Habitaciones:] Se identifican por un 'número de habitación' (un nombre de habitación que puede ser alfanumérico).  
  Su tipo de habitación puede ser, por ejemplo: SENCILLA, DOBLE, SUITE,...  
  Su baño puede ser, por ejemplo:  COMPARTIDO, DUCHA, BAÑERA,...  
  Pueden tener diferentes tamaños de cama, por ejemplo: 90, 135, 180,...  
  Pueden tener diferentes orientaciones de vista desde su ventana, por ejemplo: FRONTAL, POSTERIOR, DERECHA o IZQUIERDA (considerando el hotel como un "cuadrado rectangular", mirando desde dentro hacia la entrada principal, el frontal es la fachada donde está la entrada y el posterior queda a nuestra espalda)

- [Huespedes:] las personas que se alojan en el hotel.  
    Habrá que recoger al menos estos datos básicos:

    - id legal (por ejemplo, número de dni, de pasaporte, de cédula,...)

    - nombre y apellidos

    - forma de pago (por ejemplo, contado, tarjeta, facturación,...) y los datos necesarios para realizarla (por ejemplo, para la tarjeta seria su número, nombre titular, fecha caducidad y número clave).  (nota: Si un huésped no es el principal de una estancia de un grupo de personas, podemos saltarnos la forma de pago en su registro).

    Para simplificar, en un principio no se contemplarán los requisitos derivados de las leyes de protección de datos de información de carácter personal.  En una segunda etapa del ejercicio, se podría implementar este tema; para seguir profundizando en los aspectos de evolucionabilidad del software. (Obviamente, si esto fuera una aplicación real, el tema de la protección de datos seria una de las primeras cosas a tener en cuenta.)

    Otro posible aspecto para una segunda etapa, podría ser el de la "fidelización" de huéspedes: tarjeta de cliente, tarjeta VIP, puntos, promociones, etc.

- [Estancias:] Una estancia no es más que una asignación de un cierto huesped a una habitación (si es una persona individual) o de 
unos ciertos huespedes a una/s habitacion/es (si son un grupo de personas)

  Tiene una fecha de entrada y una fecha de salida. Ambas válidas desde/hasta el mediodía. (Es decir, la estancia está activa desde las 12:00 de la fecha de entrada hasta las 12:00 de la fecha de salida.)  
  Estancia activa ==> habitaciones ocupadas.

  A una estancia se le pueden ir cargando los servicios que vayan consumiendo sus huéspedes. Normalmente estos cargos se harán contra un número de habitación.

  Al terminar la estancia, hay que liquidar y crear una factura.


- [Servicios:] Todo aquello que se cobra al cliente.
 

- [Reservas:] Son como estancias, pero en el futuro. La diferencia es que no tienen un número de habitación exacto asignado aún (pero si un tipo de habitación concreto y unas posibles condiciones especiales).

  Se han de tener en cuenta al consultar disponibilidades en unas determinadas fechas. A efectos prácticos cuentan como habitaciones ocupadas, igual que las estancias que estén activas en esas fechas.

- [Empleados:] Las personas que trabajan en el hotel

- [Roles:] de los empleados. Por ejemplo:
    - Limpieza y servicio de habitacionesAssign/Schedule…
    -  RecepciónAssign/Schedule…
    -  Cafetería y restauraciónAssign/Schedule…
    -  Mantenimiento y reparacionesAssign/Schedule…
    -  Administración

- [Avisos:] Cualquier información que se deba hacer llegar a alguien
y que se le pueda hacer llegar de forma asíncrona.



# Fichas con casos de uso

Aquí van algunas fichas con casos de uso a implementar y tareas a realizar. Las podemos recortar y poner en el tablón de gestión del proyecto si es que llevamos alguno. (nota: No están en orden, cada cual tendrá que reorganizarlas según las prioridades que estime oportuno.)

nota: Es importante abordar una ficha cada vez; y no pasar a otra ficha hasta la ficha en curso esté totalmente terminada del todo, completamente. ("done, done")

----

`Altas/bajas/modificaciones de habitaciones.`

-  modelar la entidad Habitación
-  crear una nueva y guardarla
-  evitar duplicados 
-  buscar y recuperar una, o varias, o todas
-  editar datos de una existente
-  dar una de baja (inactivarla)

----

`Infraestructura de configuración.`

Toda aplicación tiene algunos parámetros que conviene poder modificar "desde fuera", para aplicarlos cuando la aplicación arranca.

nota: lo más típico es algún archivo INI, JSON o YAML,
o algunas variables de entorno,
o algunos parámetros en el ejecutable/comando que arranca la aplicación.

----

`Liquidar una estancia.`

Generando factura detallada de todo lo consumido.

----

`Cargar un servicio a una estancia.`

Normalmente, se identificará la estancia a través de un número de habitación.

----

`Infraestructura de persistencia.`

El mecanismo de persistencia principal que se va a utilizar para almacenar los datos manejados.

Pensar y preparar cómo se va a utilizar a lo largo y ancho de toda la aplicación.

nota: Una vez decidida como implementar la persistencia, normalmente esta no se suele cambiar.  

nota: Pero en este ejercicio conviene pensar en implementar más de un mecanismo de persistencia para unos mismos objetos. Por lo menos en alguna de las partes de la aplicación. Para así hacer experimentos acerca del grado de dependencia que tiene el código respecto de la persistencia utilizada.  

nota: Por ejemplo, se podria preparar una persistencia basada en base de datos (en MariaDB, o en PostgreSQL, o en SQLite, o en...), y otra persistencia basada en archivos (en JSON, o en XML, o en CSV, o en...). Para probar cuán sencilla (o complicada) es la tarea de cambiar de utilizar una a utilizar la otra según la arquitectura interna de nuestro programa.

----

`Infraestructura de interface.`

preparar la pantalla inicial y los "menús" de acceso a las distintas partes de la aplicación.

nota: En este ejercicio conviene pensar en implementar más de un interface. Por lo menos en alguna de las partes de la aplicación. Para así hacer experimentos acerca del grado de dependencia existente entre la lógica de aplicación y el interface.

nota: Por ejemplo, se podria preparar un clásico interface gráfico (GUI) y otro interface vía servicios (por ejemplo, una API HTTP/REST). En teoria, se deberian poder usar ambos indistintamente.

----

`Una persona consulta sus avisos.`

Tanto los dirigidos a ella personalmente, como los dirigidos a los roles que desempeña.

----

`Registrar un aviso para un empleado o para un rol.`

----

`Registrar la estancia de un/os huesped/es en un/as habitación/es.`

En caso de que varios huéspedes vengan como grupo y se les vaya a facturar como tal grupo,

-  Los datos generales (los de facturación) serán los de una de las personas integrantes, o del propio grupo (si este tiene entidad jurídica).

-  Pero se han de recoger también las identidades de cada una de las personas del grupo.

No se puede registrar una estancia sin las fechas de entrada y salida correctas. Entrada hoy o anterior. Salida posterior a la entrada.

No se puede registrar una nueva estancia para una habitación que ya esté ocupada por una estancia activa.

----

`Revisar/modificar los precios de las habitaciones.`

Obviamente, si el nuevo precio de alguna habitación se incrementa, no se puede aplicar a la estancia que estuviera ya registrada en esa habitación. Pero si que se debe aplicar si el nuevo precio se ha reducido.

----

`Altas/bajas/modificaciones de servicios.`

Es necesario tener una lista de los servicios disponibles, junto con el precio de cada.

Como va a haber muchos, será necesario prever un sistema de clasificación para ayudar a buscar un servicio concreto. Usando dos niveles: grupo y servicio; o tres niveles: grupo, subgrupo y servicio.

Los grupos podrian ser, por ejemplo: lavanderia, minibar, bar/restaurante, transporte,... 

----

`Revisar (modificar) los precios de los servicios.`

Lo ideal seria poder presentarlos en un interface tipo "hoja de cálculo" para facilitar la revisión.

Seria interesante también algún mecanismo para incrementar o decrementar un porcentaje concreto a todo un subgrupo o a todo un grupo de servicios.

----

`Infraestructura de log.`

Para registrar lo que va pasando dentro de la aplicación.

https://en.wikipedia.org/wiki/Logging_(software)

----

`Altas/bajas/modificaciones de huéspedes.`

Tener en cuenta que algunos huéspedes (aquellos registrados como 'huésped principal' de una estancia) han de tener datos de facturación y cobro. Dichos huéspedes  pueden ser personas físicas o jurídicas. 

En un principio, no se contemplarán temas sobre el tratamiento de datos de carácter personal. Pero si esto fuera una aplicación real, habria que tener en cuenta la normativa.

---- 

`Altas/bajas/modificaciones de reservas.`

A todos los efectos, una reserva es una habitación ocupada.  Es como una estancia, solo que no ocupa una habitación concreta, sino que ocupa una de un tipo determinado.

Se ha de tener en cuenta a la hora de consultar qué habitaciones hay libres cara a una nueva estancia o una nueva reserva.

----

`Gestión de tarjetas-llave.`

Se ha de llevar un registro de qué llaves están autorizadas para qué habitación.

Se ha de poder autorizar una llave para que abra una determinada habitación. Y también poder revocar esa autorización.

----

`Altas/bajas/modificaciones de roles.`

Ha de ir junto con un mecanismo de asignación de roles a empleados.

nota: Una misma persona puede tener más de un rol.

----

`Altas/bajas/modificaciones de empleados.`

---- 

`Asignar roles a empleados.`

Tener en cuenta que se podrán asignar, o bien roles a un empleado concreto, o bien empleados a un rol concreto.

----

`Infraestructura de autorizaciones y permisos.`

Una vez tengamos usuarios y tengamos roles. Podemos usarlos también para seguridad interna en la aplicación:

-  Hay que preparar un mecanismo de inicio de sesión (login) seguro.

-  Hay que asegurar que cada cual solo puede acceder a aquello que deba acceder.

Obviamente, esto pasa por tener también alguna manera de editar y mantener esa información de "qué" puede hacer "quién". Ese "quién" se definirá asignando a roles y no a usuarios individuales.

(Tener en cuenta que un mismo usuario puede tener asignados varios roles si es necesario.)

----

`Tarjetas-llave maestras . Auditoria de accesos.`

Los empleados necesitan tarjetas capaces de abrir cualquier habitación.

El uso de estas tarjetas maestras ha de quedar auditado. Y, ya que estamos, se puede también auditar el uso de cualquier tarjeta en cualquier habitación.

----


`Inicio de sesión de un empleado.`

Cada empleado puede gestionarse la contraseña que desee.

nota: Un hotel no es "Fort Knox", será suficiente con guardar y manejar hash-es de las contraseñas.

----

`Infraestructura de observabilidad.`

Una aplicación instrumentada y que reporta estadísticas (telemetría) sobre su funcionamiento interno, es una aplicación que puede monitorizarse continuamente para ver si está funcionando bien (como siempre) o si tiene problemas (hace "cosas raras").

Una vez instrumentada y reportando en algún formato estándar. La observación se puede hacer mediante una plataforma de agregación de estadísticas que incluya un cuadro de mando y un sistema de alertas. (algo tipo https://grafana.com/ o https://www.nagios.org/ o algo similar)

----

`Marcar una habitación como no utilizable.`

Se ha de recoger:

-  por qué está fuera de servicio

-  tiempo estimado (horas, días, meses,...) que va a permanecer así


----





