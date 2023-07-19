import copy

class Receta:

    def __init__(self, nombre, dificultad, tiempoAprox):
        self._listaDeIngredientes = []
        self._listaDeInstrucciones = []
        self._nombre = nombre
        self._dificultad = dificultad
        self._tiempoAprox = tiempoAprox

    def añadirIngrediente(self, materia, cantidad, unidadDeMedida):
        self._listaDeIngredientes.append([materia, cantidad, unidadDeMedida])

    def añadirInstruccion(self, texto):
        self._listaDeInstrucciones.append(texto)

    def getNombre(self):
        return self._nombre
    
    def getDificultad(self):
        return self._dificultad
    
    def getTiempoAproximado(self):
        return self._tiempoAprox

    def getIngredientes(self):
        return copy.deepcopy(self._listaDeIngredientes)
    
    def getInstrucciones(self):
        return copy.deepcopy(self._listaDeInstrucciones)