import math

def ConvertirValorDeUnaUnidadAOtra(valor, unidadOrigen, unidadDestino):
    if unidadDestino == unidadOrigen:
        return valor
    if unidadDestino == "m" and unidadOrigen == "cm":
        return valor / 100
    # como por ahora no vamos a convertir nada más, no nos hace falta nada más sofisticado...


# Pedir datos al usuario
print()
print("Por favor, introduce los datos con los que hacer el cálculo.")
velocidadDelViento_valor = float(input("Velocidad del viento (en m/s): "))
velocidadDelViento_unidad = "m/s"
unLadoDeLaVela_valor = float(input("Longitud de un lado de la vela (rectangular) (en cm): "))
unLadoDeLaVela_unidad = "cm"
otroLadoDeLaVela_valor = float(input("Longitud del otro lado de la vela (en cm): "))
otroLadoDeLaVela_unidad = "cm"
aplicarRefuerzos_texto = input("¿Se van a aplicar refuerzos? (si o no): ")
if aplicarRefuerzos_texto.upper() == "SI" or aplicarRefuerzos_texto.upper() == "S":
    aplicarRefuerzos = True
elif aplicarRefuerzos_texto.upper() == "NO" or aplicarRefuerzos_texto.upper() == "N":
    aplicarRefuerzos = False
else:
    print(f"Al responder [{aplicarRefuerzos_texto}], se considera que NO se aplicarán refuerzos.")
    aplicarRefuerzos = False
densidadDeParticulas_valor = float(input("Densidad de particulas (p/m3): "))
densidadDeParticulas_unidad = "p/m3"


# Conversiones de las entradas a las unidades de trabajo internas.
velocidadDelViento_valor = ConvertirValorDeUnaUnidadAOtra(velocidadDelViento_valor, velocidadDelViento_unidad, "m/s")
unLadoDeLaVela_valor = ConvertirValorDeUnaUnidadAOtra(unLadoDeLaVela_valor, unLadoDeLaVela_unidad, "m")
otroLadoDeLaVela_valor = ConvertirValorDeUnaUnidadAOtra(otroLadoDeLaVela_valor, otroLadoDeLaVela_unidad, "m")
densidadDeParticulas_valor = ConvertirValorDeUnaUnidadAOtra(densidadDeParticulas_valor, densidadDeParticulas_unidad, "p/m3")

# Definir constantes
DENSIDAD_DEL_AIRE_valor = 1.204
DENSIDAD_DEL_AIRE_unidad = "kg/m3"
CUANTOS_M2_DE_VELA_PARA_UN_REFUERZO = 5
CUANTOS_FACTORESZ_PARA_UN_REFUERZO = 12
CUANTAS_PARTICULAS_PARA_UN_CONTENEDOR = 350


# Calculos
areaDeLaVela_valor = unLadoDeLaVela_valor * otroLadoDeLaVela_valor
areaDeLaVela_unidad = "m2"
factorZ_valor = velocidadDelViento_valor * DENSIDAD_DEL_AIRE_valor * areaDeLaVela_valor
factorZ_unidad = "kg/s"
if aplicarRefuerzos:
    cantidadDeRefuerzos = (areaDeLaVela_valor / CUANTOS_M2_DE_VELA_PARA_UN_REFUERZO) + (factorZ_valor / CUANTOS_FACTORESZ_PARA_UN_REFUERZO)
else:
    cantidadDeRefuerzos = 0
cantidadDeRefuerzos = math.ceil(cantidadDeRefuerzos)
cantidadDeContenedores = (densidadDeParticulas_valor / areaDeLaVela_valor) / CUANTAS_PARTICULAS_PARA_UN_CONTENEDOR
cantidadDeContenedores = math.ceil(cantidadDeContenedores)

# Conversiones de los resultados a las unidades de presentación externas.
areaDeLaVela_valor = ConvertirValorDeUnaUnidadAOtra(areaDeLaVela_valor, areaDeLaVela_unidad, "m2")
areaDeLaVela_unidad = "m2"
factorZ_valor = ConvertirValorDeUnaUnidadAOtra(factorZ_valor, factorZ_unidad, "kg/s")
factorZ_unidad = "kg/s"

# Presentar resultados al usuario
print()
print("Los resultados son:")
print(f"Area de la vela = {areaDeLaVela_valor} {areaDeLaVela_unidad}")
print(f"Factor Z = {factorZ_valor}  {factorZ_unidad}")
print(f"Se necesitan {cantidadDeRefuerzos} refuerzos")
print(f"y {cantidadDeContenedores} contenedores.")
print()
