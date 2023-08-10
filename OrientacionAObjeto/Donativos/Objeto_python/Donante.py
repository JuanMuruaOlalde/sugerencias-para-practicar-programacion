class Donante:

    def __init__(self, nombre, correo, cantidad, recurrencia):
        self._nombre = nombre
        self._correo = correo
        self._cantidad = cantidad
        self._recurrencia = recurrencia

    def __str__(self) -> str:
        return f"Me llamo {self._nombre} y mi correo es {self._correo}"
    
    def getCantidad(self):
        return self._cantidad
    
    def getRecurrencia(self):
        return self._recurrencia

    def getNombre(self):
        return self._nombre
    
    def getCorreo(self):
        return self._correo