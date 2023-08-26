public class App {
    public static void main(String[] args) throws Exception {
        Banco banco = new Banco();
        banco.añadirCuenta(new CuentaBancaria("Alice"));
        banco.añadirCuenta(new CuentaBancaria("Bob"));

        banco.ingresarDineroEnLaCuenta("Alice", 12000.0);
        System.out.println("Alice ha ingresado 12.000 en su cuenta."); 
        mostrarSaldosDeAliceYBob(banco);

        banco.transferirDineroDeUnaCuentaAOtra("Alice", "Bob", 3000.0);
        System.out.println("Alice ha tranferido 3.000 desde su cuenta a la de Bob."); 
        mostrarSaldosDeAliceYBob(banco);

        banco.ingresarDineroEnLaCuenta("Alice", 5000.0);
        System.out.println("Alice ha ingresado 5.000 en su cuenta."); 
        mostrarSaldosDeAliceYBob(banco);

        banco.sacarDineroDeLaCuenta("Bob", 1000.0);
        System.out.println("Bob ha sacado 3.000 de su cuenta."); 
        mostrarSaldosDeAliceYBob(banco);
    }

    public static void mostrarSaldosDeAliceYBob(Banco banco) {
        System.out.println("Saldo de Alice [" + banco.consultarSaldoDeLaCuentaDe("Alice") + "]"
                           + " . Saldo de Bob [" + banco.consultarSaldoDeLaCuentaDe("Bob") + "]");
    }
}
