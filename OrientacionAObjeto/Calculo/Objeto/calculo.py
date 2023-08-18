from Magnitud import Magnitud
from ParametrosDeEntrada import ParametrosDeEntrada
from ParametrosDeSalida import ParametrosDeSalida
from Calculador import Calculador


def PedirDatosAlUsuario():
    parametros = ParametrosDeEntrada()
    print()
    print("Por favor, introduce los datos con los que hacer el cálculo.")
    parametros.velocidadDelViento = Magnitud(
        float(input("Velocidad del viento (en m/s): ")), "m/s")
    parametros.unLadoDeLaVela = Magnitud(
        float(input("Longitud de un lado de la vela (rectangular) (en cm): ")), "cm")
    parametros.otroLadoDeLaVela = Magnitud(
        float(input("Longitud del otro lado de la vela (en cm): ")), "cm")
    aplicarRefuerzos_texto = input("¿Se van a aplicar refuerzos? (si o no): ")
    if aplicarRefuerzos_texto.upper() == "SI" or aplicarRefuerzos_texto.upper() == "S":
        parametros.aplicarRefuerzos = True
    elif aplicarRefuerzos_texto.upper() == "NO" or aplicarRefuerzos_texto.upper() == "N":
        parametros.aplicarRefuerzos = False
    else:
        print(
            f"Al responder [{aplicarRefuerzos_texto}], se considera que NO se aplicarán refuerzos.")
        parametros.aplicarRefuerzos = False
    parametros.densidadDeParticulas = Magnitud(
        float(input("Densidad de particulas (p/m3): ")), "p/m3")
    return parametros


entradas = PedirDatosAlUsuario()
resultados = Calculador().calcular(entradas)

print()
print(entradas)
print(resultados)
print()
