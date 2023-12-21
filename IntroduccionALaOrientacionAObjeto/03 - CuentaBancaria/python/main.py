from cuenta_bancaria import Cuenta


def main():
    cuentaDeAlice = Cuenta("Alice")
    print(f"Creada cuenta para Alice: {cuentaDeAlice.getCodigoDeCuenta()}")

    cuentaDeBob = Cuenta("Bob")
    print(f"Creada cuenta para Bob: {cuentaDeBob.getCodigoDeCuenta()}")

    cuentaDeAlice.hacerIngreso(12000.0)
    print(f"Alice ha ingresado 12.000 en su cuenta.")
    print(
        f"Saldo de Alice [{cuentaDeAlice.getSaldo()}] . Saldo de Bob [{cuentaDeBob.getSaldo()}]"
    )

    cuentaDeAlice.hacerReintegro(3000.0)
    cuentaDeBob.hacerIngreso(3000.0)
    print(f"Alice ha transferido 3.000 desde su cuenta a la de Bob.")
    print(
        f"Saldo de Alice [{cuentaDeAlice.getSaldo()}] . Saldo de Bob [{cuentaDeBob.getSaldo()}]"
    )

    cuentaDeAlice.hacerIngreso(5000.0)
    print(f"Alice ha ingresado 5.000 en su cuenta.")
    print(
        f"Saldo de Alice [{cuentaDeAlice.getSaldo()}] . Saldo de Bob [{cuentaDeBob.getSaldo()}]"
    )

    cuentaDeBob.hacerReintegro(1000.0)
    print(f"Bob ha sacado 1.000 de su cuenta.")
    print(
        f"Saldo de Alice [{cuentaDeAlice.getSaldo()}] . Saldo de Bob [{cuentaDeBob.getSaldo()}]"
    )


if __name__ == "__main__":
    main()
