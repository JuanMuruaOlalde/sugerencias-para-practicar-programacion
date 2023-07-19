from ParametrosDeEntrada import ParametrosDeEntrada
from ParametrosDeSalida import ParametrosDeSalida
from Calculador import Calculador

entradas = ParametrosDeEntrada()
print()
print("Por favor, introduce los datos con los que hacer el cálculo.")
entradas.velocidadDelViento.setValor(float(input("Velocidad del viento (en m/s): ")))
entradas.velocidadDelViento.setUnidadDeMedida("m/s")
entradas.unLadoDeLaVela.setValor(float(input("Longitud de un lado de la vela (rectangular) (en cm): ")))
entradas.unLadoDeLaVela.setUnidadDeMedida("cm")
entradas.otroLadoDeLaVela.setValor(float(input("Longitud del otro lado de la vela (en cm): ")))
entradas.otroLadoDeLaVela.setUnidadDeMedida("cm")
aplicarRefuerzos_texto = input("¿Se van a aplicar refuerzos? (si o no): ")
if aplicarRefuerzos_texto.upper() == "SI" or aplicarRefuerzos_texto.upper() == "S":
    entradas.aplicarRefuerzos = True
elif aplicarRefuerzos_texto.upper() == "NO" or aplicarRefuerzos_texto.upper() == "N":
    entradas.aplicarRefuerzos = False
else:
    print(f"Al responder [{aplicarRefuerzos_texto}], se considera que NO se aplicarán refuerzos.")
    entradas.aplicarRefuerzos = False
entradas.densidadDeParticulas.setValor(float(input("Densidad de particulas (p/m3): ")))
entradas.densidadDeParticulas.setUnidadDeMedida("p/m3")

calculador = Calculador()
resultados = calculador.calcular(entradas)

print()
print(entradas)
print(resultados)
print()