public class App {
    public static void main(String[] args) throws Exception {
        Banco banco = new Banco();
        banco.añadirCuenta(new CuentaBancaria("Alice"));
        banco.añadirCuenta(new CuentaBancaria("Bob"));

        System.out.println();
        System.out.println("Alice va a ingresar 12.000 en su cuenta."); 
        Banco.resultadoDeLaOperacion resultado01 = banco.ingresarDineroEnLaCuenta("Alice", 12000.0);
        System.out.print(resultado01);
        mostrarSaldosDeAliceYBob(banco);

        System.out.println();
        System.out.println("Alice va a tranferir 3.000 desde su cuenta a la de Bob."); 
        Banco.resultadoDeLaOperacion resultado02 = banco.transferirDineroDeUnaCuentaAOtra("Alice", "Bob", 3000.0);
        System.out.print(resultado02);
        mostrarSaldosDeAliceYBob(banco);

        System.out.println();
        System.out.println("Alice va a ingresar 5.000 en su cuenta."); 
        Banco.resultadoDeLaOperacion resultado03 = banco.ingresarDineroEnLaCuenta("Alice", 5000.0);
        System.out.print(resultado03);
        mostrarSaldosDeAliceYBob(banco);

        System.out.println();
        System.out.println("Bob va a sacar 1.000 de su cuenta."); 
        Banco.resultadoDeLaOperacion resultado04 = banco.sacarDineroDeLaCuenta("Bob", 1000.0);
        System.out.print(resultado04);
        mostrarSaldosDeAliceYBob(banco);

        System.out.println();
    }

    public static void mostrarSaldosDeAliceYBob(Banco banco) {
        System.out.println(" . Saldo de Alice [" + banco.getSaldoDe("Alice") + "]"
                           + " . Saldo de Bob [" + banco.getSaldoDe("Bob") + "]");
    }
}
