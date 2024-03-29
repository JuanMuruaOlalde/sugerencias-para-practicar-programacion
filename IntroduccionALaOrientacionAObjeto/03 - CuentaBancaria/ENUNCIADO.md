# Tareas a realizar:

Queremos manejar cuentas bancarias. Cada cuenta tendrá dos datos:

-   el nombre de su titular
-   y su saldo

Se utilizarán funciones para:

-   ingresar dinero en una cuenta
-   sacar dinero de una cuenta

Teniendo dos cuentas: una para Alice y otra para Bob. Se trata simplemente de reproducir los siguientes pasos:

1.  Alice ingresa 12.000 en su cuenta y luego transfiere 3.000 a la de Bob.

2.  Alice ingresa 5.000 en su cuenta.

3.  Bob saca 1.000 de su cuenta.

El programa ha de ir mostrando en pantalla las distintas operaciones, y el saldo de las dos cuentas tras cada operación. Por ejemplo:

```
Alice ha ingresado 12.000 en su cuenta.
Saldo de Alice [12000.0] . Saldo de Bob [0.0]
Alice ha transferido 3.000 desde su cuenta a la de Bob.
Saldo de Alice [9000.0] . Saldo de Bob [3000.0]
Alice ha ingresado 5.000 en su cuenta.
Saldo de Alice [14000.0] . Saldo de Bob [3000.0]
Bob ha sacado 1.000 de su cuenta.
Saldo de Alice [14000.0] . Saldo de Bob [2000.0]
```

# Comentarios

Para simplificar, un mismo titular solo puede tener una cuenta.

Para evitar fraudes, las funciones solo admitirán cantidades positivas (no negativas ni ceros).

Obviamente, no se puede sacar de una cuenta más dinero del que haya en ese momento.

# Algunos aspectos sobre los que reflexionar

## ¿Qué pasa si cambia el nombre de un titular?

Por ejemplo, Alice cambia su nombre y pasa a llamarse Dan.

## ¿Qué pasa si queremos incorporar otra cuenta para Charlie?

Por ejemplo, realizar también los siguientes pasos adicionales:

4.  Alice transfiere 2.000 a Charlie.

5.  Charlie ingresa 9.000 en su cuenta.

## ¿Qué pasa si queremos garantizar que no pueda haber saldos negativos?

Es decir, ¿cómo evitar que nadie programe operaciones "no previstas" tales como modificar directamente un saldo saltandose las comprobaciones en las funciones de ingresar(), sacar() y transferir()?
