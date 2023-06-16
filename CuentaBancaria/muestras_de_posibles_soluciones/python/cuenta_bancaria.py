from uuid import uuid4


class Cuenta:
    def __init__(self, titular):
        self._codigoDeCuenta = uuid4()
        self._titular = titular
        self._saldo = 0.0

    def getCodigoDeCuenta(self):
        return self._codigoDeCuenta

    def getTitular(self):
        return self._titular

    def getSaldo(self):
        return self._saldo

    def hacerIngreso(self, cantidad):
        if cantidad > 0:
            self._saldo = self._saldo + cantidad
        else:
            raise ValueError("Se ha de indicar siempre una cantidad positiva.")

    def hacerReintegro(self, cantidad):
        if cantidad > 0:
            if self._saldo >= cantidad:
                self._saldo = self._saldo - cantidad
            else:
                raise ValueError(
                    f"El saldo es insufiente para hacer este reintegro de {cantidad}."
                )
        else:
            raise ValueError("Se ha de indicar siempre una cantidad positiva.")
