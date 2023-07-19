import os
from Magnitud import Magnitud

class ParametrosDeEntrada:

    def __init__(self):
        self.velocidadDelViento = Magnitud()
        self.unLadoDeLaVela = Magnitud()
        self.otroLadoDeLaVela = Magnitud()
        self.densidadDelAire = Magnitud(1.204, "kg/m3")
        self.aplicarRefuerzos = True
        self.densidadDeParticulas = Magnitud()

    def __str__(self):
        texto = "Los parametros de entrada son:" + os.linesep
        texto = texto + f"  Velocidad del viento: {self.velocidadDelViento}" + os.linesep
        texto = texto + f"  Vela de dimensiones: {self.unLadoDeLaVela} x {self.otroLadoDeLaVela}" + os.linesep
        texto = texto + f"  Densidad del aire: {self.densidadDelAire}" + os.linesep
        texto = texto + f"  Densidad de particulas: {self.densidadDeParticulas}" + os.linesep
        if self.aplicarRefuerzos:
            texto = texto + "  Se van a aplicar refuerzos." + os.linesep
        else:
            texto = texto + "  No se van a aplicar refuerzos." + os.linesep
        return texto
