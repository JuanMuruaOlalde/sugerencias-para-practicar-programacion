import os
import csv

archivo = open(os.path.relpath('subscripciones y donativos.csv'))
lector = csv.reader(archivo, delimiter=',')

next(lector)
totalUnicas = 0.0
donantesUnicos = ""
totalMensuales = 0.0
donantesMensuales = ""
totalAnuales = 0.0
donantesAnuales = ""

for lineaLeida in lector:
    nombre, correo, recurrencia, cantidadTexto = lineaLeida
    print(f"Me llamo {nombre} y mi correo es {correo}")
    cantidad = float(cantidadTexto)
    if recurrencia == 'unica':
        totalUnicas = totalUnicas + cantidad
        donantesUnicos = donantesUnicos + f" :  {nombre} ({correo})"
    elif recurrencia == 'mensual':
        totalMensuales = totalMensuales + cantidad
        donantesMensuales = donantesMensuales + f" :  {nombre} ({correo})"
    elif recurrencia == 'anual':
        totalAnuales = totalAnuales + cantidad
        donantesAnuales = donantesAnuales + f" :  {nombre} ({correo})"

print(f"Contribuciones unicas: {totalUnicas:.2f}")
print(f"  donadas por: {donantesUnicos}")
print(f"Contribuciones mensuales: {totalMensuales:.2f}")
print(f"  donadas por: {donantesMensuales}")
print(f"Contribuciones anuales: {totalAnuales:.2f}")
print(f"  donadas por: {donantesAnuales}")

archivo.close()
