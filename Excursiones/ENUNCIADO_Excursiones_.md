# Tareas a realizar

Se trata de realizar un programa que permita a alguien (a una persona encargada dentro del club o asociación):

- Gestionar (altas/bajas/modificaciones) excursiones . Con estos datos: tipoDeExcursion, descripción, fecha, hora, poblacionOrigen, poblacionDestino, coste.

  nota: los tipos de excursión se clasificarán según la actividad principal que se vaya a hacer: VisitaHistorica, ConciertoMusical, ActuacionTeatral, RutaNatural,...

- Gestionar (altas/bajas/modificaciones) personas. Con estos datos: nombre, apellidos, poblacion, email, telefono, preferenciasDeTipoDeExcursion.

- Apuntar participantes a una excursión. Gestionar las personas participantes en una excursión . Gestionar quien ya ha pagado la excursión y quien todavia no ha pagado.

- Consultar qué excursiones están activas (fechas en el futuro). Pudiendo elegir una para ver sus detalles.

- Consultar en el histórico de excursiones realizadas (fechas en el pasado):
  - Excursiones a una determinada población.
  - Excursiones desde una determinada población.
  - Excursiones de un determinado tipo.
  - Excursiones en las que ha participado una determinada persona.

- Cuando se registra una nueva excursión, enviar avisos (por email) a todas las personas de la poblacionOrigen que pudieran estar interesadas en ese tipo de excursión.

  (nota: No es necesario implementar realmente la funcionalidad de enviar emails. Puede bastar con crear los mensajes para cada persona destinataria, y pasarselos a una función de enviar vacia; donde luego se implementaria el envio real).

# Tareas extendidas (opcionales)

Hacer el programa con interface web.

Y, ya que estamos en web, permitir a las propias personas participantes consultar las excursiones activas y registrarse/apuntarse ellas mismas a las excursiones que deseen.
