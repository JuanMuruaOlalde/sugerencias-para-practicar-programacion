package CuentaBancaria.muestras_de_posibles_soluciones.java;

public class Main {
    public static void main(String args[]){
        CuentaBancaria cuentaDeAlice = new CuentaBancaria("Alice");
        System.out.println("Creada cuenta para Alice: " + cuentaDeAlice.getCodigoDeCuenta());

        CuentaBancaria cuentaDeBob = new CuentaBancaria("Bob");
        System.out.println("Creada cuenta para Bob: " + cuentaDeBob.getCodigoDeCuenta());
        
        cuentaDeAlice.hacerIngreso(12000.0);
        System.out.println("Alice ha ingresado 12.000 en su cuenta.");
        System.out.println("Saldo de Alice [" + cuentaDeAlice.getSaldo() + "] . Saldo de Bob [" + cuentaDeBob.getSaldo() + "]");

        cuentaDeAlice.hacerReintegro(3000.0);
        cuentaDeBob.hacerIngreso(3000.0);
        System.out.println("Alice ha transferido 3.000 desde su cuenta a la de Bob.");
        System.out.println("Saldo de Alice [" + cuentaDeAlice.getSaldo() + "] . Saldo de Bob [" + cuentaDeBob.getSaldo() + "]");

        cuentaDeAlice.hacerIngreso(5000.0);
        System.out.println("Alice ha ingresado 5.000 en su cuenta.");
        System.out.println("Saldo de Alice [" + cuentaDeAlice.getSaldo() + "] . Saldo de Bob [" + cuentaDeBob.getSaldo() + "]");

        cuentaDeBob.hacerReintegro(1000.0);
        System.out.println("Bob ha sacado 1.000 de su cuenta.");
        System.out.println("Saldo de Alice [" + cuentaDeAlice.getSaldo() + "] . Saldo de Bob [" + cuentaDeBob.getSaldo() + "]");

    }

}
