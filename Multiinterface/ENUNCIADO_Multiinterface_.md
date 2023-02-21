# Introduccion

Siempre es una buena idea estructurar el programa en diferentes capas especializadas. Cada una realizando su tarea concreta y con el mínimo de dependencias entre ellas. Limitando estas dependencias a los puntos de interacción (interfaces) entre capas.

Una muestra de algunas de las distintas posibilidades para estructurar un programa en varias capas:

![arquitecturas multicapa](.\imagenes\arquitecturas_multicapa.png)

El principal objetivo en cualquiera de estas arquitecturas multi-capa es desacoplar las capas entre sí.

Por ejemplo, separando:

- la forma de trabajar (medios de manipulación: ratón, teclado, gestos, voz,...) y de presentar información (gráfica, textual, auditiva,...),

- del trabajo a realizar (información manejada y operaciones ejecutadas) 

- de los datos a manipular (datos creados/leidos/modificados/borrados a través de esas operaciones) (nota: CRUD Create/Read/Update/Delete).

En una arquitectura multi-capa bien ejecutada, las capas tienen pocas dependencias (bajo acoplamiento) entre ellas. Y las dependencias están definidas de forma bien clara (`interfaces' concretos); con la intención de que las relaciones entre capas sean lo más estables posible.

Se facilita así la evolución del programa al permitir modificar capas concretas sabiendo de antemano cómo afectarán esos cambios a otras capas adyacentes.

De forma ideal, una arquitectura multi-capa bien ejecutada permite sustituir elementos en una de las capas sin afectar para nada a lo que hay en las otras capas, (o con mínimos cambios en alguna capa adyacente). 

Por ejemplo, debería ser posible sustituir sin demasiados problemas un interfaz gráfico basado en ventanas/ratón/teclado, por otro interfaz textual basado en comandos/parámetros, o por otro interfaz basado en servicios web. O por ejemplo, deberia ser posible sustituir una persistencia basada en archivos XML, por otra persistencia basada en archivos JSON, o por otra persistencia basada en una base de datos.

nota: No es que se vayan a realizar ninguna de esas sustituciones a lo largo de la vida útil del programa. El objetivo no es ese. Se trata de pensar en que se podrian realizar. Para así ayudar a detectar dependencias y evitarlas.  
  Cuanto menos dependencias existan, más fácil será  comprender, mantener y evolucionar las distintas partes del programa. 


# Tareas a realizar

Preparar un pequeño programilla sencillo. Por ejemplo:

- Uno que, dados un lado y otro lado de un paralelogramo, calcule y devuelva su perímetro y su área.

La idea es utilizar el programilla tal cual, sin modificar el modelo (la funcionalidad de cálculo del paralelogramo) desde diversos interfaces de usuario. Por ejemplo desde:

- Unos comandos tecleados desde la consola de línea de comandos.

![imagen de interface de comandos](.\imagenes\Consola_pantallazo.png)

- Un diálogo textual en el que se pide al usuario teclear datos y opciones en la consola de línea de comandos.

- Un interface gráfico, en una ventana donde poder interactuar con ratón y teclado.

![imagen de interface grafico](.\imagenes\WindowsForms_pantallazo.png)

- Un interfaz API llamado a través de URLs.

![imagen de interface API llamada por URL](.\imagenes\HttpGet_pantallazo.png)

- Una página web que hace uso de esa API.

![imagen de interface web](.\imagenes\HttpPut_web_pantallazo.png)

# Tareas extendidas (opcionales)

Hacer lo mismo que se ha hecho con el interfaz, pero con la persistencia de los datos. Esta se puede implementar en diversos formatos: texto plano, JSON, XML,.. 

Para ello se podria utilizar un pequeño programilla sencillo. Por ejemplo: 

- Uno que permita pedir una bebida de una lista (café, leche o chocolate) e introducir un código ID de usuario (3 letras). El usuario ha de poder consultar la lista de bebidas disponibles. El programilla ha de avisar en caso de pedir una bebida agotada (usar un contador de existencias en los depósitos; con la correspondiente función de cargar un depósito). Y ha de avisar también en caso de recibir un código incorrecto (usar una lista de usuarios; con la correspondiente función de dar alta/baja de códigos ID de usuario). Los contadores y la lista han de persistir en un archivo de texto. 

Aquí también la idea es usar una u otra persistencia sin modificar el modelo (la funcionalidad de la máquina de bebidas). Simplemente sustituyendo una persistencia por otra.
