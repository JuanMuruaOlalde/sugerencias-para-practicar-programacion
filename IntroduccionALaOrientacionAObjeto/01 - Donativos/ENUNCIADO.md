# Tareas a realizar:

Tenemos una lista de personas que han dado donativos a nuestro proyecto:

```
Nombre,correo-e,recurrencia,cantidad
Alice,alice@example.com,mensual,15
Bob,bob@example.com,unica,75
Charlie,chlarlie@example.com,mensual,10
Eve,eve@example.com,mensual,7
Mallory,mallory@example.com,anual,100
Trudy,trudy@example.com,unica,30
```

Se desea obtener una lista de personas:

```
Me llamo Alice y mi correo es alice@example.com
Me llamo Bob y mi correo es bob@example.com
Me llamo Charlie y mi correo es charlie@example.com
Me llamo Eve y mi correo es eve@example.com
Me llamo Mallory y mi correo es mallory@example.com
Me llamo Trudy y mi correo es trudy@example.com
```

Se desea obtener los donativos totales según recurrencia:

```
Contribuciones unicas: 105.00
Contribuciones mensuales: 32.00
Contribuciones anuales: 100.00
```

O haciendo una lista detallada:

```
Contribuciones unicas: 105.00
  donadas por:  :  Bob (bob@example.com) :  Trudy (trudy@example.com)
Contribuciones mensuales: 32.00
  donadas por:  :  Alice (alice@example.com) :  Charlie (chlarlie@example.com) :  Eve (eve@example.com)
Contribuciones anuales: 100.00
  donadas por:  :  Mallory (mallory@example.com)
```

# Algunos aspectos sobre los que reflexionar

## ¿Cómo trabajar con los datos de varias personas?

Por ejemplo si queremos poner todos los datos de todas las personas donantes en una lista.
O si queremos pasar o retornar los datos de una persona a o desde una función.

Nos haria falta algún mecanismo para "agrupar" las variables relativas a cada persona.
