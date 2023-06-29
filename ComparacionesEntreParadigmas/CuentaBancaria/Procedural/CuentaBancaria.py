cuenta01_titular = "Alice"
cuenta01_saldo = 0.0
cuenta02_titular = "Bob"
cuenta02_saldo = 0.0

def main():
    meterEnCuenta01(12000)
    mostrarSaldos()
    print("Transferencia de Alice a Bob:")
    sacarDeCuenta01(3000)
    meterEnCuenta02(3000)
    mostrarSaldos()
    meterEnCuenta01(5000)
    mostrarSaldos()
    sacarDeCuenta02(1000)
    mostrarSaldos()

def meterEnCuenta01(cantidad):
    global cuenta01_saldo
    cuenta01_saldo = cuenta01_saldo + cantidad
    print(f"{cuenta01_titular} ha ingresado {cantidad} en su cuenta")

def sacarDeCuenta01(cantidad):
    global cuenta01_saldo
    if(cuenta01_saldo < cantidad):
        print(f"Saldo insuficiente. No se puede sacar {cantidad} de la cuenta de {cuenta01_titular}")
    else:
        cuenta01_saldo = cuenta01_saldo - cantidad
        print(f"{cuenta01_titular} ha sacado {cantidad} en su cuenta")

def meterEnCuenta02(cantidad):
    global cuenta02_saldo
    cuenta02_saldo = cuenta02_saldo + cantidad
    print(f"{cuenta02_titular} ha ingresado {cantidad} en su cuenta")

def sacarDeCuenta02(cantidad):
    global cuenta02_saldo
    if(cuenta02_saldo < cantidad):
        print(f"Saldo insuficiente. No se puede sacar {cantidad} de la cuenta de {cuenta02_titular}")
    else:
        cuenta02_saldo = cuenta02_saldo - cantidad
        print(f"{cuenta02_titular} ha sacado {cantidad} en su cuenta")

def mostrarSaldos():
    print(f"Saldo de {cuenta01_titular} [{cuenta01_saldo}] . Saldo de {cuenta02_titular} [{cuenta02_saldo}]")

if __name__ == "__main__":
    main()
