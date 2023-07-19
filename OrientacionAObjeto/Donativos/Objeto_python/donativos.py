import os
import csv
from Donante import Donante

listaDeDonantes = []
with open(os.path.relpath('Donativos/subscripciones y donativos.csv')) as archivo:
    lector = csv.reader(archivo, delimiter=',')
    next(lector)
    for lineaLeida in lector:
        nombre, correo, recurrencia, cantidadTexto = lineaLeida
        unDonante = Donante(nombre=nombre, correo=correo, cantidad=float(cantidadTexto), recurrencia=recurrencia)
        listaDeDonantes.append(unDonante)

for donante in listaDeDonantes:
    print(donante)

totalUnicas = 0.0
totalMensuales = 0.0
totalAnuales = 0.0
for donante in listaDeDonantes:
    donativo = donante.getDonativo()
    if donativo['recurrencia'] == 'unica':
        totalUnicas = totalUnicas + donativo['cantidad']
    elif donativo['recurrencia'] == 'mensual':
        totalMensuales = totalMensuales + donativo['cantidad']
    elif donativo['recurrencia'] == 'anual':
        totalAnuales = totalAnuales + donativo['cantidad']
print(f"Contribuciones unicas: {totalUnicas:.2f}")
print(f"Contribuciones mensuales: {totalMensuales:.2f}")
print(f"Contribuciones anuales: {totalAnuales:.2f}")
