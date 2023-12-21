from recetas import pan_ingredientes, pan_instrucciones
from recetas import lentejas_ingredientes, lentejas_instrucciones

def Comprar(listaDeIngredientes):
    print("Procurando los INGREDIENTES...")
    for ingrediente in listaDeIngredientes:
        material, cantidad, unidadDeMedida = ingrediente 
        print(f"Marchando {cantidad} {unidadDeMedida} de {material}.")
    print("Ya están todos los ingredientes.")

def Cocinar(instrucciones):
    print("COCINANDO...")
    i = 1
    for instruccion in instrucciones:
        print(f"[{i}] ==> {instruccion}")
        i = i + 1
    print("TERMINADO, ¡buen provecho!")

Comprar(pan_ingredientes)
Cocinar(pan_instrucciones)