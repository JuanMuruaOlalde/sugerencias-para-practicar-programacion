public class App {
    public static void main(String[] args) throws Exception {
        Banco banco = new Banco();
        banco.añadirCuenta(new CuentaBancaria("Alice"));
        banco.añadirCuenta(new CuentaBancaria("Bob"));

        banco.ingresarDineroEnLaCuenta("Alice", 12000.0);
        System.out.println("Alice ha ingresado 12.000 en su cuenta."); 
        mostrarSaldosDeAliceYBob(banco);

        if (banco.tieneSaldoSuficiente("Alice", 3000.0)) {
            banco.transferirDineroDeUnaCuentaAOtra("Alice", "Bob", 3000.0);
            System.out.println("Alice ha tranferido 3.000 desde su cuenta a la de Bob."); 
        } else {
            System.out.println("Alice queria tranferir 3.000 desde su cuenta a la de Bob. Pero no tiene saldo suficiente."); 
        }
        mostrarSaldosDeAliceYBob(banco);

        banco.ingresarDineroEnLaCuenta("Alice", 5000.0);
        System.out.println("Alice ha ingresado 5.000 en su cuenta."); 
        mostrarSaldosDeAliceYBob(banco);

        if (banco.tieneSaldoSuficiente("Bob", 1000.0)) {
            banco.sacarDineroDeLaCuenta("Bob", 1000.0);
            System.out.println("Bob ha sacado 1.000 de su cuenta."); 
        } else {
            System.out.println("Bob queria sacar 1.000 de su cuenta. Pero no tiene saldo suficiente."); 
        }
        mostrarSaldosDeAliceYBob(banco);
    }

    public static void mostrarSaldosDeAliceYBob(Banco banco) {
        System.out.println("Saldo de Alice [" + banco.getSaldoDe("Alice") + "]"
                           + " . Saldo de Bob [" + banco.getSaldoDe("Bob") + "]");
    }
}
