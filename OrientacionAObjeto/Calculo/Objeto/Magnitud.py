import math


class Magnitud:

    def __init__(self, valor=float("nan"), unidadDeMedida="sinasignar"):
        self._valor = float(valor)
        self._unidadDeMedida = unidadDeMedida

    def getValor(self):
        return self._valor

    def getUnidadDeMedida(self):
        return self._unidadDeMedida

    def __str__(self):
        return str(self._valor) + " " + self._unidadDeMedida

    def ConvertirmeALaUnidadDeMedida(self, nuevaUnidadDeMedida):
        if nuevaUnidadDeMedida != self._unidadDeMedida:
            if nuevaUnidadDeMedida == "m" and self._unidadDeMedida == "cm":
                self._valor = self._valor / 100
                self._unidadDeMedida = "cm"
            # como por ahora no vamos a convertir nada más, no nos hace falta nada más sofisticado...
            elif True:
                raise ValueError(
                    f"No está contemplada la conversión de {self._unidadDeMedida} a {nuevaUnidadDeMedida}")
