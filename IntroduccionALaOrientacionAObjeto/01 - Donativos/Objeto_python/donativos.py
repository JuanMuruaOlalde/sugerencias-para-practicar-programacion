import os
import csv
from Donante import Donante

def CargarDatosDeDonantesYDonativos(pathArchivo):
    listaDeDonantes = []
    with open(os.path.relpath(pathArchivo)) as archivo:
        lector = csv.reader(archivo, delimiter=',')
        next(lector)
        for lineaLeida in lector:
            nombre, correo, recurrencia, cantidadTexto = lineaLeida
            unDonante = Donante(nombre=nombre, correo=correo, cantidad=float(cantidadTexto), recurrencia=recurrencia)
            listaDeDonantes.append(unDonante)
    return listaDeDonantes

def ImprimirDonantes(listaDeDonantes):
    for donante in listaDeDonantes:
        print(donante)

def ImprimirDonaciones(listaDeDonantes):
    totalUnicas = 0.0
    totalMensuales = 0.0
    totalAnuales = 0.0
    for donante in listaDeDonantes:
        if donante.getRecurrencia() == 'unica':
            totalUnicas = totalUnicas + donante.getCantidad()
        elif donante.getRecurrencia() == 'mensual':
            totalMensuales = totalMensuales + donante.getCantidad()
        elif donante.getRecurrencia() == 'anual':
            totalAnuales = totalAnuales + donante.getCantidad()

    print()
    print(f"Contribuciones unicas: {totalUnicas:.2f}")
    print(f"  donadas por: ")
    donantesUnicos = filter((lambda donante: donante.getRecurrencia() == 'unica'), listaDeDonantes)
    for donante in donantesUnicos:
        print(f"    {donante.getNombre()} ({donante.getCorreo()}) : ")
    print()
    print(f"Contribuciones mensuales: {totalMensuales:.2f}")
    print(f"  donadas por: ")
    donantesMensuales = filter((lambda donante: donante.getRecurrencia() == 'mensual'), listaDeDonantes)
    for donante in donantesMensuales:
        print(f"    {donante.getNombre()} ({donante.getCorreo()}) : ")
    print()
    print(f"Contribuciones anuales: {totalAnuales:.2f}")
    print(f"  donadas por: ")
    donantesAnuales = filter((lambda donante: donante.getRecurrencia() == 'anual'), listaDeDonantes)
    for donante in donantesAnuales:
        print(f"    {donante.getNombre()} ({donante.getCorreo()}) : ")



datos = CargarDatosDeDonantesYDonativos('subscripciones y donativos.csv')
ImprimirDonantes(datos)
ImprimirDonaciones(datos)

