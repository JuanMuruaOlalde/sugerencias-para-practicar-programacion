
## Caso de uso:

![caso de uso](.\imagenes\cuentas_bancarias-caso_de_uso.png)

Nota: Para simplificar el ejercicio, cada cuenta tendrá un solo cliente titular. Aunque un mismo cliente podrá ser titular de varias cuentas.

# Tarjetas de requisitos/funcionalidades:

Aquí van algunas fichas con casos de uso a implementar y tareas a realizar. Las podemos recortar y poner en el tablón de gestión del proyecto si es que llevamos alguno. (nota: No están en orden, cada cual tendrá que reorganizarlas según las prioridades que estime oportuno.)

nota: Es importante abordar una ficha cada vez; y no pasar a otra ficha hasta la ficha en curso esté totalmente terminada del todo, completamente. ("done, done")


----

`Como cliente, necesito ingresar dinero.`

La forma de validar sera:

- consulto saldo.                                

- ingreso dinero.

- vuelvo a consultar saldo y compruebo que el ingreso se ha realizado correctamente.

----

`Como cliente, necesito consultar saldo.`

La forma de validar sera:

- pido consulta de saldo.

- obtengo los últimos 8 movimientos de la cuenta y el saldo actual en ella.

----

`Como cliente, necesito sacar dinero.` 

La forma de validar sera:

- consulto saldo.

- saco dinero.

- vuelvo a consultar saldo y compruebo que el reintegro se ha registrado correctamente.

----                        
                
`Como cajero, necesito identificar al cliente y verificar el numero de cuenta.` 

La forma de validar sera:

- introduzco el número de cuenta y consulto los datos del cliente titular de la misma.

- compruebo esos datos con respecto al DNI del cliente.

Puede darse el caso de que el cliente no me de el número de cuenta. En ese caso:

- introduzco el DNI del cliente y consulto las cuentas de las que es titular (numero y saldo).

- el cliente me indica en cual de las cuentas desea operar.

----
                        
`Como cajero, necesito atender a las operaciones que el cliente solicite.`

La forma de validar sera:

- puedo realizar un ingreso de dinero en una cuenta.

- puedo realizar una retirada de dinero en una cuenta.

- puedo consultar los últimos movimientos y el saldo.

----                        
                
`Como dueño del banco, necesito tener un registro seguro de todas las transacciones realizadas.`

 La forma de validar sera:                

- realizar cada una de las operaciones posibles en el sistema: consultar, crear, modificar, etc.

- consultar el registro para ver que todas y cada una de las operaciones se han registrado correctamente: fecha, hora, tipo de operación, datos afectados por la operación (nota: en las modificaciones, incluir tanto los datos "antes" como los datos "después").

----


