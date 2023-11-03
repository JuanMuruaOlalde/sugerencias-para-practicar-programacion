# Tareas a realizar

Se trata de realizar un programa que permita a alguien (a una persona encargada dentro del club o asociación):

- Registrar excursiones. Con estos datos: tipoDeExcursion, descripción, fecha, hora, poblacionOrigen, poblacionDestino, coste.

    nota: los tipos de excursión se clasificarán según la actividad principal que se vaya a hacer: VisitaHistorica, ConciertoMusical, ActuacionTeatral, RutaNatural,...

- Registrar personas interesadas en participar en alguna excursión. Con estos datos: nombre, apellidos, poblacion, email, telefono, preferenciasDeTipoDeExcursion.

- Saber qué excursiones están activas (aún sin realizar).

- Apuntar participantes a una excursión.

- De las personas apuntadas, llevar el control de quien ya ha pagado la excursión y quien todavia no ha pagado.

- Cuando se registra una nueva excursión, enviar avisos (por email) a todas las personas de la poblacionOrigen que pudieran estar interesadas en ese tipo de excursión. (nota: No es necesario implementar realmente la funcionalidad de enviar emails. Puede bastar con simplemente crear los mensajes para cada persona destinataria, y pasarselos a una función de enviar vacia; donde luego se implementaria el envio).

# Tareas extendidas (opcionales)

Hacer el programa con interface web.

Y, ya que estamos en web, permitir a las posibles personas participantes consultar las excursiones activas y registrarse/apuntarse ellas mismas a las excursiones que deseen.
