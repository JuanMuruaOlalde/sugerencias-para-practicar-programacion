# Introduccion

Una cuenta bancaria ilustra muy bien la importancia de la principal caracteristica de la programación orientada a objeto: la encapsulación.

Si está bien diseñado, nada puede alterar el estado interno de un objeto si no es a través de los métodos públicos que este ofrece.

# Notas:

Un UUID es un número aleatorio de 128 bits prácticamente irrepetible [https://en.wikipedia.org/wiki/Universally_unique_identifier]. La biblioteca estandar de prácticamente todos los lenguajes modernos tienen funciones para generarlos de forma rápida y sencilla.

Un código de cuenta real tiene que seguir las normas internacionales [https://en.wikipedia.org/wiki/International_Bank_Account_Number]. Pero ello requiere llevar un contador interno de algún tipo para saber cual es el último número asignado y evitar así repetir números.

# Tareas a realizar

- Crear una clase CuentaBancaria, con:
    - Tres propiedades (codigoDeCuenta, titular, saldo) y sus correspondientes métodos getters para leerlas.
    - Un constructor, que: recibirá un titular como parámetro, generará el codigoDeCuenta (un UUID) y pondrá saldo cero.
    - Dos métodos, uno para realizar ingresos (poner dinero) y otro para realizar reintegros (sacar dinero). Notas: no se pueden hacer ingresos ni reintegros negativos y no se puede sacar más de lo que hay de saldo.

- Instanciar una cuenta para Alice y otra cuenta para Bob.

- Alice ingresa 12.000 en su cuenta y luego transfiere 3.000 a la de Bob.

- Alice ingresa 5.000 en su cuenta.

- Bob saca 1.000 de su cuenta.

- El programa ha de ir mostrando en pantalla las distintas operaciones, y el saldo de las dos cuentas tras cada operación que implique movimiento de dinero.
````
Creada cuenta para Alice: e020aec4-1bb4-424e-84d5-7aac0dd9b61a
Creada cuenta para Bob: 76165fb3-8b75-4048-80b4-420a9f2434c4
Alice ha ingresado 12.000 en su cuenta.
Saldo de Alice [12000.0] . Saldo de Bob [0.0]
Alice ha transferido 3.000 desde su cuenta a la de Bob.
Saldo de Alice [9000.0] . Saldo de Bob [3000.0]
Alice ha ingresado 5.000 en su cuenta.
Saldo de Alice [14000.0] . Saldo de Bob [3000.0]
Bob ha sacado 1.000 de su cuenta.
Saldo de Alice [14000.0] . Saldo de Bob [2000.0]
````

# Tareas extendidas (opcionales)

Incorporar una nueva propiedad a la clase CuentaBancaria: una lista de movimientos. 

En esa lista se irá registrando un simple texto cada vez que se realiza un ingreso o un reintegro. Ese texto ha de recoger la fechahora, la operación realizada y la cantidad. 
````
Registro de Alice:
2023-01-23T16:26:50:594 ==> Ingreso de 12.000,00
2023-01-23T16:26:50:595 ==> Reintegro de 3.000,00
2023-01-23T16:26:50:596 ==> Ingreso de 5.000,00

Registro de Bob:
2023-01-23T16:26:50:596 ==> Ingreso de 3.000,00
2023-01-23T16:26:50:596 ==> Reintegro de 1.000,00
````

Seria conveniente hacer un método privado para registrar movimientos, evitando así tener que repetir código en los métodos de ingreso y de reintegro.

