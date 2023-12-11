# Desarrollo iterativo en pequeños pasos.

Es importante dejar totalmente terminada cada funcionalidad antes de pasar a la siguiente.

Se entiende por terminada:

- Es operativa, los usuarios la pueden puede utilizar.

- Está cubierta por los test que correspondan.

- Encaja adecuadamente en la arquitectura general de la aplicación.

Un posible ejemplo de lo que podria entenderse por pequeño paso. Una posible división en funcionalidades. Podrian ser cada uno de los bolo-guión en las listas que se muestran a continuación.

## El banco tiene cuentas

- Se puede dar de alta una cuenta. Las cuentas se crean con saldo cero.

- Cada cuenta tiene un número de cuenta único. No puede haber números de cuenta duplicados.

- Se puede encontrar una cuenta existente, buscandola por número de cuenta.

## Se realizan movimientos monetarios con las cuentas

- Ingresar dinero en una cuenta.

- Sacar dinero de una cuenta.

- Realizar transferencias entre cuentas.

- Todos los movimientos quedan registrados para poderse auditar.

## Las cuentas tienen personas titulares

- Se puede dar de alta un cliente.

- Se puede encontrar un cliente existente, buscandolo por su DNI.

- Se puede asignar una cuenta a un cliente.

- Se pueden encontrar los clientes titulares de una cuenta.

- Se pueden encontrar las cuentas de las cuales un cliente es titular.

## Auditoria de cambios en los datos

- Se puede saber cuándo y qué se ha cambiado en un cliente, en una cuenta,...
