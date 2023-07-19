import os
import csv

archivo = open(os.path.relpath('Donativos/subscripciones y donativos.csv'))
lector = csv.reader(archivo, delimiter=',')

next(lector)
totalUnicas = 0.0
totalMensuales = 0.0
totalAnuales = 0.0

for lineaLeida in lector:
    nombre, correo, recurrencia, cantidadTexto = lineaLeida
    print(f"Me llamo {nombre} y mi correo es {correo}")
    cantidad = float(cantidadTexto)
    if recurrencia == 'unica':
        totalUnicas = totalUnicas + cantidad
    elif recurrencia == 'mensual':
        totalMensuales = totalMensuales + cantidad
    elif recurrencia == 'anual':
        totalAnuales = totalAnuales + cantidad

print(f"Contribuciones unicas: {totalUnicas:.2f}")
print(f"Contribuciones mensuales: {totalMensuales:.2f}")
print(f"Contribuciones anuales: {totalAnuales:.2f}")

archivo.close()
