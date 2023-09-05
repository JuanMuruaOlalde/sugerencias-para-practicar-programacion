public class App {
    public static void main(String[] args) throws Exception {
        Banco banco = new Banco();
        banco.añadirCuenta(new CuentaBancaria("Alice"));
        banco.añadirCuenta(new CuentaBancaria("Bob"));

        banco.ingresarDineroEnLaCuenta("Alice", 12000.0);
        System.out.println("Alice ha ingresado 12.000 en su cuenta."); 
        mostrarSaldosDeAliceYBob(banco);

        //**Aviso**: Es mala idea usar el tratamiento de excepciones como mecanismo de control de la lógica de la aplicación. El tratamiento de excepciones es para lo que es: para lidiar con situaciones excepcionales que no suceden habitualmente en el funcionamiento normal del programa.

        try {
            banco.transferirDineroDeUnaCuentaAOtra("Alice", "Bob", 3000.0);
            System.out.println("Alice ha tranferido 3.000 desde su cuenta a la de Bob."); 
        } catch (java.lang.IllegalArgumentException ex) {
            System.out.println("Alice queria tranferir 3.000 desde su cuenta a la de Bob. Pero no tiene saldo suficiente."); 
        }
        mostrarSaldosDeAliceYBob(banco);

        banco.ingresarDineroEnLaCuenta("Alice", 5000.0);
        System.out.println("Alice ha ingresado 5.000 en su cuenta."); 
        mostrarSaldosDeAliceYBob(banco);

        try {
            banco.sacarDineroDeLaCuenta("Bob", 1000.0);
            System.out.println("Bob ha sacado 1.000 de su cuenta."); 
        } catch (java.lang.IllegalArgumentException ex) {
            System.out.println("Bob queria sacar 1.000 de su cuenta. Pero no tiene saldo suficiente."); 
        }
        mostrarSaldosDeAliceYBob(banco);
    }

    public static void mostrarSaldosDeAliceYBob(Banco banco) {
        System.out.println("Saldo de Alice [" + banco.consultarSaldoDeLaCuentaDe("Alice") + "]"
                           + " . Saldo de Bob [" + banco.consultarSaldoDeLaCuentaDe("Bob") + "]");
    }
}
