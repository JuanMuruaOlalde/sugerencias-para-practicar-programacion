import math
import copy
from Magnitud import Magnitud
from ParametrosDeEntrada import ParametrosDeEntrada
from ParametrosDeSalida import ParametrosDeSalida


class Calculador:
    CUANTOS_M2_DE_VELA_PARA_UN_REFUERZO = 5
    CUANTOS_FACTORESZ_PARA_UN_REFUERZO = 12
    CUANTAS_PARTICULAS_PARA_UN_CONTENEDOR = 350

    def __init__(self):
        self._entradas = ParametrosDeEntrada()
        self._resultados = ParametrosDeSalida()

    def calcular(self, parametrosDeEntrada):
        self._entradas = copy.deepcopy(parametrosDeEntrada)
        self._entradas.velocidadDelViento.ConvertirmeALaUnidadDeMedida("m/s")
        self._entradas.unLadoDeLaVela.ConvertirmeALaUnidadDeMedida("m")
        self._entradas.otroLadoDeLaVela.ConvertirmeALaUnidadDeMedida("m")
        self._entradas.densidadDelAire.ConvertirmeALaUnidadDeMedida("kg/m3")
        self._entradas.densidadDeParticulas.ConvertirmeALaUnidadDeMedida(
            "p/m3")
        areaDeLaVela = self._entradas.unLadoDeLaVela.getValor(
        ) * self._entradas.otroLadoDeLaVela.getValor()
        self._resultados.areaDeLaVela = Magnitud(areaDeLaVela, "m2")
        factorZ = self._entradas.velocidadDelViento.getValor(
        ) * self._entradas.densidadDelAire.getValor() * self._resultados.areaDeLaVela.getValor()
        self._resultados.factorZ = Magnitud(factorZ, "kg/s")
        if self._entradas.aplicarRefuerzos:
            self._resultados.cantidadDeRefuerzos = (
                (self._resultados.areaDeLaVela.getValor() /
                 self.CUANTOS_M2_DE_VELA_PARA_UN_REFUERZO)
                + (self._resultados.factorZ.getValor() /
                   self.CUANTOS_FACTORESZ_PARA_UN_REFUERZO)
            )
        else:
            self._resultados.cantidadDeRefuerzos = 0
        self._resultados.cantidadDeRefuerzos = math.ceil(
            self._resultados.cantidadDeRefuerzos)
        self._resultados.cantidadDeContenedores = (
            (self._entradas.densidadDeParticulas.getValor(
            ) / self._resultados.areaDeLaVela.getValor()) / self.CUANTAS_PARTICULAS_PARA_UN_CONTENEDOR
        )
        self._resultados.cantidadDeContenedores = math.ceil(
            self._resultados.cantidadDeContenedores)
        return copy.deepcopy(self._resultados)
