
# Introduccion

Siempre es una buena idea estructurar el programa en diferentes capas especializadas. Cada una realizando su tarea concreta y con el mínimo de dependencias entre ellas. Limitando estas dependencias a los puntos de interacción (interfaces) entre capas.

Una organización muy típica consiste en organizar el código en tres capas:

- MODELO: la parte que representa el dominio de la aplicación y que engloba la gestión de datos y la lógica de trabajo.

- VISTA: la forma en que el modelo se muestra a los usuarios.

- CONTROLADOR: la forma en que los usuarios interactuan con el modelo  a través de la vista.

El orden de las letras en el acrónimo MVC es importante. Se obtienen mejores resultados si primero se construye el modelo, luego la vista y, por último, el controlador. 

Aunque sin olvidar que todo proceso de construcción de software es iterativo y, por tanto, se irán realizando ajustes en el modelo, en la vista o en el controlador según se avanza en el trabajo en cualquiera de esas partes.


# Tareas a realizar

Preparar un pequeño programilla aplicando una estructura multicapa MVC con:

- Un modelo: una lista de personas, con unos pocos datos (nombre, apellidos,\ldots) en cada entidad persona y un sistema de persistencia (  archivo de texto o base de datos) donde guardar la lista.

- Una vista: un interfaz gráfico (GUI) a través del cual interactuar con la lista de personas. Por ejemplo, consultarlas, dar de alta una nueva, borrar una,\ldots

- Un controlador: código que se encargará de recoger las instrucciones dadas a través del interfaz para trasladarselas al modelo; así como de leer datos del modelo, elaborarlos y mostrarlos en el interfaz según corresponda.

Hacerlo de dos formas distintas,  
  aplicando las dependencias entre sus distintas partes (objetos):

1. De forma directa:

    cada objeto se instancia él mismo los objetos que necesite.

2. De forma inversa: 

    cada objeto recibe desde fuera los objetos que necesite (o bien inyectados a través de su constructor o bien inyectados a través un metodo setter ad-hoc).

