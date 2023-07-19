import os
import math
from Magnitud import Magnitud

class ParametrosDeSalida:

    def __init__(self):
        self.areaDeLaVela = Magnitud()
        self.factorZ = Magnitud()
        self.cantidadDeRefuerzos = float("nan")
        self.cantidadDeContenedores = float("nan")

    def __str__(self):
        texto = "Los resultados son:" + os.linesep
        texto = texto + f"  Area de la vela: {self.areaDeLaVela}" + os.linesep
        texto = texto + f"  Factor Z: {self.factorZ}" + os.linesep
        texto = texto + f"  Cantidad de refuerzos: {self.cantidadDeRefuerzos}" + os.linesep
        texto = texto + f"  Cantidad de contenedores: {self.cantidadDeContenedores}" + os.linesep
        return texto
