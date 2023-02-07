from collections import namedtuple
from datetime import date

def main():
    lista_original = [34, 76, 295, 17, 861, 5, 95, 127, 3, 99, 26, 49, 117, 532, 15, 88, 2, 31]
    print()
    print('La lista original: ', lista_original)


    lista_duplicada = []
    for numero in lista_original:
        lista_duplicada.append(numero * 2) 
    print()
    print('Multiplicando sus elementos por 2: ', lista_duplicada)


    suma = 0;
    for numero in lista_original:
        suma += numero;
    print()
    print(f'Los elementos de la lista original suman {suma:,d}')


    solo_impares = []
    for numero in lista_original:
        if numero % 2 > 0 :
            solo_impares.append(numero)
    print()
    print('Los impares de la lista son: ', solo_impares)


    lista_incrementada = []
    for numero in lista_original:
        lista_incrementada.append(numero + (numero * 0.30))
    print()
    print('Incrementando sus elementos un 30%: ', lista_incrementada)


    MedicionMetereologica = namedtuple('MedicionMetereologica', 
        'fecha temperatura_max_celsius temperatura_min_celsius humedad_max_porcentaje humedad_min_porcentaje lluvia_litrospormetrocuadrado')
    mediciones = []
    mediciones.append(MedicionMetereologica(date(2023, 2, 14), 15.3, 4.6, 68, 45, 0.0))
    mediciones.append(MedicionMetereologica(date(2023, 2, 15), 18.2, 3.5, 78, 54, 2.5))
    mediciones.append(MedicionMetereologica(date(2023, 2, 16), 19.8, 2.6, 47, 41, 0.0))
    mediciones.append(MedicionMetereologica(date(2023, 2, 17), 17.3, 1.9, 52, 35, 7.5))
    mediciones.append(MedicionMetereologica(date(2023, 2, 18), 12.9, 3.7, 64, 43, 9.0))
    print()
    print('Con estos datos de partida:')
    suma_de_maximas = 0.0
    suma_de_minimas = 0.0
    for medicion in mediciones:
        print()
        print(medicion)
        suma_de_maximas += medicion.temperatura_max_celsius
        suma_de_minimas += medicion.temperatura_min_celsius
    temperatura_media_max = suma_de_maximas / len(mediciones)
    temperatura_media_min = suma_de_minimas / len(mediciones)
    print()
    print(f'Nos da una temperatura media máxima de {temperatura_media_max:.2f} °C y media mínima de {temperatura_media_min:.2f} °C')


if __name__ == '__main__':
    main()

