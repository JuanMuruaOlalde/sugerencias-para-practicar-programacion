# Introduccion

Se trata de realizar una serie de pequeños programas para practicar con los controles más habituales en los interfaces gráficos.

# Tareas a realizar


## Hello, Benzirpi.

Algo sencillo para empezar: un texbox donde teclear un nombre y un botón que rellena otro textbox (de solo lectura) con un saludo a ese nombre.

![pantallazo de como quedaria ejercicio Hello Benzirpi](./imagenes/HelloBenzirpi-pantallazo-Java.png)

## Bocatas

Algo sencillo para elegir opciones: unos cuantos radiobuttons y checkboxes.

![pantallazo de como quedaria ejercicio Bocatas](./imagenes/Bocatas-pantallazo-Java.png)

## Selección plana

Algo sencillo para elegir un elemento de una lista desplegable o de una lista abierta.

![pantallazo de como quedaria ejercicio Selección Plana](./imagenes/SeleccionPlana-pantallazo-Java.png)

## Diálogos estándares

Manejo de los diálogos del sistema operativo para: seleccionar carpetas, seleccionar archivos, seleccionar colores,...

![pantallazo de como quedaria ejercicio DialogosEstandares JFileChooser](./imagenes/DialogosEstandares-JFileChooser-Java.png)

![pantallazo de como quedaria ejercicio DialogosEstandares JColorChooser](./imagenes/DialogosEstandares-JColorChooser-Swatches-Java.png)

![pantallazo de como quedaria ejercicio DialogosEstandares JColorChooserRGB](./imagenes/DialogosEstandares-JColorChooser-RGB-Java.png)

## Scroll

Cuando se ha de mostrar un contenido que no cabe en el espacio disponible, se puede recurrir a unos deslizadores (scrollbars) horizontales o verticales para permitir desplazar dicho contenido dentro del espacio disponible.

![pantallazo de como quedaria ejercicio Scroll](./imagenes/Scroll-pantallazo-Java.png)

## Split

Cuando se desea permitir al usuario modificar sobre la marcha el espacio dedicado dentro de la ventana a los componentes dentro de ella, se puede recurrir a un separador ajustable entre zonas (spliter).

![pantallazo de como quedaria ejercicio Split](./imagenes/Split-pantallazo-Java.png)

## Calendario

Pedir una fecha mostrando un calendario.

## Selección arbórea

Presentar elementos con estructura jerárquica en árbol, navegar a través de ella mostrando u ocultando ramas, seleccionar algún elemento, y hacer algo con él (por ejemplo, mostrar información detallada de ese elemento concreto).


![pantallazo de como quedaria ejercicio SeleccionArborea](./imagenes/SeleccionArborea-pantallazo-Java.png)


## Barra de progreso

Cuando se desencadena una tarea larga, es conveniente mantener al usuario informado de cómo va progresando dicha tarea. Así se evita dar la impresión que el sistema se ha colgado.

nota: No suele ser sencillo. Se ha de recurrir a la multitarea para conseguir que el interfaz de usuario (main thread) se vaya refrescando periódicamente mientras se está ejecutando la tarea (worker thread). Pero es algo tan necesario que casi todos los entornos de programación cuentan con algún mecanismo específico para implementar esa comunicación periódica.

Una sugerencia de ejercicio para practicar:

![pantallazo de como quedaria ejercicio BarraDeProgreso](./imagenes/BarraDeProgreso-pantallazo-Java.png)

Una lectura interesante: [swingworker](https://www.oracle.com/technical-resources/articles/javase/swingworker.html)


# Tareas extendidas (opcionales)

## Internacionalización (i18n) y localización (L10n)

- Internacionalización (i18n) son los mecanismos para adaptar el software a distintos idiomas y países.

- Localización (L10n) son los mecanismos para adaptar el software a los distintos usos y costumbres de cada país: moneda, pesos y medidas, formatos numéricos, unidades de medida, formatos de fecha/hora, convenciones culturales, sentido de escritura,\ldots

Ambos dos son aspectos muy importantes para cualquier software que no sea algo pequeño ``de andar por casa''. Y, aún en estos, hay que tener en cuenta que muchas veces crecen y acaban desplegándose por multitud de sitios a donde no se había previsto que llegaran.

Tanto la internacionalización como la localización son prácticamente imposibles de implementar ``a posteriori''. Es decir, se han de ir incorporando desde el primer momento; desde la primera línea de código que se escriba.

Si conocemos y nos sentimos cómodos usando los mecanismos que tenga nuestra plataforma de desarrollo para facilitar esos aspectos. No nos costará mucho más utilizarlos en todos nuestros trabajos; aunque en ese momento estemos pensando en un solo idioma y un solo país. Así, si mas tarde se han de incorporar más idiomas o más países, el camino estará preparado.


## Ayudas y documentación

Es importante conocer los mecanismos que tenga nuestra plataforma de desarrollo para mostrar documentación de forma dinámica: indicaciones al poner el ratón un tiempo quieto sobre un determinado elemento(tooltips), acceso al manual de uso (ayuda, tecla F1), advertencias directas para algunos aspectos especialmente delicados (pop-ups), etc.

Son aspectos importantes si se van a desarrollar programas de una cierta envergadura. Programas que vayan a ser usados por muchas personas distintas, a lo largo de mucho tiempo.

### Algunas recomendaciones

Creo que es mejor no incordiar mucho a los usuarios en su día a día. Suele ser suficiente con disponer de:

- Unos tooltips cortos y precisos acerca de lo que hace cada parte del interface. Tooltips que solo aparezcan si el usuario deja manifiestamente el ratón quieto durante unos 2 segundos sobre algo. 

- Y un menú o botón de `Ayuda' bien visible, que abra el manual de usuario.

Por experiencia sé que casi nadie se lee el manual de usuario. Ni aún en el caso de que esté bien redactado, sea claro y sea ameno.

Pero aún así, creo que merece la pena dotar a nuestros programas de una buena documentación. Algo que realmente permita permita a una persona curiosa aprender la filosofia de funcionamiento del programa y los conceptos principales involucrados en su manejo.

Escribir una mera recopilación de cómo hacer qué, menú a menú y botón a botón, solo por cumplir el expediente, no merece la pena. Además de ser inútiles, han sido ese tipo de manuales los que han dado tan mala fama a los manuales de usuario.

De ponerse a producirlo, suele ser más rentable enfocar el manual de usuario como un curso de autoestudio.  
Si además se le dota de un buen índice de temas, podrá ser utilizado también, en cierta medida, como referencia puntual para resolver dudas.




