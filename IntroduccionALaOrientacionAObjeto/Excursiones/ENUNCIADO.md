# Excursiones

## Tareas a realizar

Se trata de implementar dos objetos base, justo para almacenar datos:

- Excursion.

  Con estos datos: tipoDeExcursion, descripción, destino, fecha, hora, lugarDePartida, coste, listaDeParticipantes.

  nota: Los tipos de excursión se clasificarán según la actividad principal que se vaya a hacer: VisitaHistorica, ConciertoMusical, ActuacionTeatral, RutaNatural,...
  nota: La lista de participantes será un array de Personas.

- Persona.

  Con estos datos: nombre, apellidos, email, telefono, preferenciasDeTipoDeExcursion.

  nota: Una persona puede tener más de una preferencia de tipo de excursión.

E implementar un objeto para gestionar excursiones. Este objeto se encargará de llevar una lista de personas y una lista de excursiones. Permitiendo realizar las siguientes operaciones:

- Añadir una persona a la lista.
- Eliminar una persona de la lista.

- Añadir una excursión a la lista.
- Eliminar una excursión de la lista.

- Apuntar participantes a una excursión.
- Desapuntar participantes de una excursión.

nota: Para apuntar/desapuntar participantes, el gestor se apoyará en un método público de la propia excursión.

## Comentarios

Para simplificar, no contemplaremos la posibilidad de modificar los datos de un objeto una vez creado. Es decir, los objetos no tendrán setters.

Para evitar errores de tecleo, los tipos de excursión se implementaran con una enumeración.

## Algunos aspectos sobre los que reflexionar

- Un objeto puede contener otros. Por ejemplo,
  - Cada excursión tiene una lista de personas apuntadas a ella.
  - El gestor de excursiones tiene una lista de excursiones y otra de personas.

- Un objeto puede hacer uso de otro. Por ejemplo, el gestor tiene un método para apuntar una persona a una excursión; pero pide a la excursión que añada la persona a su listaDeParticipantes.
