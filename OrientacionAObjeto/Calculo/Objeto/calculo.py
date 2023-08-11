from ParametrosDeEntrada import ParametrosDeEntrada
from ParametrosDeSalida import ParametrosDeSalida
from Calculador import Calculador

def PedirDatosAlUsuario():
    parametros = ParametrosDeEntrada()
    print()
    print("Por favor, introduce los datos con los que hacer el cálculo.")
    parametros.velocidadDelViento.setValor(float(input("Velocidad del viento (en m/s): ")))
    parametros.velocidadDelViento.setUnidadDeMedida("m/s")
    parametros.unLadoDeLaVela.setValor(float(input("Longitud de un lado de la vela (rectangular) (en cm): ")))
    parametros.unLadoDeLaVela.setUnidadDeMedida("cm")
    parametros.otroLadoDeLaVela.setValor(float(input("Longitud del otro lado de la vela (en cm): ")))
    parametros.otroLadoDeLaVela.setUnidadDeMedida("cm")
    aplicarRefuerzos_texto = input("¿Se van a aplicar refuerzos? (si o no): ")
    if aplicarRefuerzos_texto.upper() == "SI" or aplicarRefuerzos_texto.upper() == "S":
        parametros.aplicarRefuerzos = True
    elif aplicarRefuerzos_texto.upper() == "NO" or aplicarRefuerzos_texto.upper() == "N":
        parametros.aplicarRefuerzos = False
    else:
        print(f"Al responder [{aplicarRefuerzos_texto}], se considera que NO se aplicarán refuerzos.")
        parametros.aplicarRefuerzos = False
    parametros.densidadDeParticulas.setValor(float(input("Densidad de particulas (p/m3): ")))
    parametros.densidadDeParticulas.setUnidadDeMedida("p/m3")
    return parametros

calculador = Calculador()
entradas = PedirDatosAlUsuario()
resultados = calculador.calcular(entradas)

print()
print(entradas)
print(resultados)
print()