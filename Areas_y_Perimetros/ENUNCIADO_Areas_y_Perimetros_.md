# Introduccion

Para poder utilizar de forma homogénea unos cuantos objetos de distintas clases como si fueran todos del mismo tipo. Se pueden utilizar dos mecanismos:

- La herencia: si los objetos comparten gran parte de su comportamiento y funcionalidad básicos (que se implementa en la clase madre).

- El interfaz: si los objetos tienen un comportamiento similar cara al exterior, pero dicho comportamiento se implementa de formas muy distintas en cada clase.

# Tareas a realizar

- Preparar clases para una serie de figuras geométricas: rectangulo, círculo, triángulo,...

- Llenar una lista de figuras con una mezcla de figuras de distinto tipo.

- Recorrer la lista y pedir a cada figura que se describa a sí misma y que indique su color, su perímetro y su área.

nota: El color de la figura solo puede ser: "rojo", "verde", "rosa" o "naranja"

## Utilizando herencia

El área y el perímetro se calculan en el constructor de cada clase. 

Los métodos: getArea() y getPerimetro(), son iguales para todas las clases y se limitan a devolver el valor precalculado.

La gestión del color se implementa en la clase madre.

## Utilizando interface

El cálculo de area y el de perímetro se implementan en los métodos: getArea() y getPerimetro() de cada clase.
Todas las clases han de tener esos dos métodos obligatoriamente.

La gestión del color se implementa en cada clase.

