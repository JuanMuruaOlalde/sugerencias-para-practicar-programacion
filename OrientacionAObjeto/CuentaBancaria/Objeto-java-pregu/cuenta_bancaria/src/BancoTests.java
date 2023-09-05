import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class BancoTests {

    @Test
    public void losIngresosFuncionanBien() {
        Banco bancoDePrueba = new Banco();
        bancoDePrueba.añadirCuenta(new CuentaBancaria("Alice"));
        bancoDePrueba.ingresarDineroEnLaCuenta("Alice", 5000.0);
        assertTrue(bancoDePrueba.getSaldoDe("Alice") == 5000.0);
    }

    @Test
    public void losReintegrosFuncionanBien() {
        Banco bancoDePrueba = new Banco();
        bancoDePrueba.añadirCuenta(new CuentaBancaria("Alice"));
        bancoDePrueba.ingresarDineroEnLaCuenta("Alice", 5000.0);
        bancoDePrueba.sacarDineroDeLaCuenta("Alice", 3000.0);
        assertTrue(bancoDePrueba.getSaldoDe("Alice") == 2000.0);
        bancoDePrueba.sacarDineroDeLaCuenta("Alice", 2000.0);
        assertTrue(bancoDePrueba.getSaldoDe("Alice") == 0.0);
    }

    @Test
    void lasTransferenciasFuncionanBien() {
        Banco bancoDePrueba = new Banco();
        bancoDePrueba.añadirCuenta(new CuentaBancaria("Alice"));
        bancoDePrueba.añadirCuenta(new CuentaBancaria("Bob"));
        bancoDePrueba.ingresarDineroEnLaCuenta("Alice", 5000.0);
        bancoDePrueba.transferirDineroDeUnaCuentaAOtra("Alice", "Bob", 3000.0);
        assertTrue(bancoDePrueba.getSaldoDe("Alice") == 2000.0);
        assertTrue(bancoDePrueba.getSaldoDe("Bob") == 3000.0);
        bancoDePrueba.transferirDineroDeUnaCuentaAOtra("Alice", "Bob", 2000.0);
        assertTrue(bancoDePrueba.getSaldoDe("Alice") == 0.0);
        assertTrue(bancoDePrueba.getSaldoDe("Bob") == 5000.0);
    }

    @Test
    public void laConsultaDeCuentaExistenteFuncionaBien() {
        Banco bancoDePrueba = new Banco();
        bancoDePrueba.añadirCuenta(new CuentaBancaria("Alice"));
        assertTrue(bancoDePrueba.tieneCuenta("Alice"));
        assertFalse(bancoDePrueba.tieneCuenta("Bob"));
    }
    
    @Test
    public void laConsultaDeSaldoSuficienteFuncionaBien() {
        Banco bancoDePrueba = new Banco();
        bancoDePrueba.añadirCuenta(new CuentaBancaria("Alice"));
        bancoDePrueba.ingresarDineroEnLaCuenta("Alice", 5000.0);
        assertTrue(bancoDePrueba.tieneSaldoSuficiente("Alice", 4000.0));
        assertFalse(bancoDePrueba.tieneSaldoSuficiente("Alice", 8000.0));
    }
    
    @Test
    void noSePuedeConsultarSaldoDeUnaCuentaInexistente() {
        Banco bancoDePrueba = new Banco();
        bancoDePrueba.añadirCuenta(new CuentaBancaria("Alice"));
        java.lang.IllegalArgumentException ex = 
            assertThrows(java.lang.IllegalArgumentException.class, 
                         () -> {
                                    bancoDePrueba.getSaldoDe("Bob");
                                });
        assertTrue(ex.getMessage().contains("No hay ninguna cuenta a nombre de"));
    }

    @Test
    void noSePuedeIngresarDineroEnUnaCuentaInexistente() {
        Banco bancoDePrueba = new Banco();
        bancoDePrueba.añadirCuenta(new CuentaBancaria("Alice"));
        java.lang.IllegalArgumentException ex = 
            assertThrows(java.lang.IllegalArgumentException.class, 
                         () -> {
                                    bancoDePrueba.ingresarDineroEnLaCuenta("Bob", 1000.0);
                                });
        assertTrue(ex.getMessage().contains("No hay ninguna cuenta a nombre de"));
    }

    @Test
    void noSePuedeSacarDineroDeUnaCuentaInexistente() {
        Banco bancoDePrueba = new Banco();
        bancoDePrueba.añadirCuenta(new CuentaBancaria("Alice"));
        java.lang.IllegalArgumentException ex = 
            assertThrows(java.lang.IllegalArgumentException.class, 
                         () -> {
                                    bancoDePrueba.sacarDineroDeLaCuenta("Bob", 1000.0);
                                });
        assertTrue(ex.getMessage().contains("No hay ninguna cuenta a nombre de"));
    }

    @Test
    void noSePuedenRealizarTransferenciasDesdeUnaCuentaInexistente() {
        Banco bancoDePrueba = new Banco();
        bancoDePrueba.añadirCuenta(new CuentaBancaria("Bob"));
        java.lang.IllegalArgumentException ex = 
            assertThrows(java.lang.IllegalArgumentException.class, 
                         () -> {
                                    bancoDePrueba.transferirDineroDeUnaCuentaAOtra("Alice","Bob", 1000.0);
                                });
        assertTrue(ex.getMessage().contains("No hay ninguna cuenta a nombre de"));
    }

    @Test
    void noSePuedenRealizarTransferenciasHaciaUnaCuentaInexistente() {
        Banco bancoDePrueba = new Banco();
        bancoDePrueba.añadirCuenta(new CuentaBancaria("Alice"));
        java.lang.IllegalArgumentException ex = 
            assertThrows(java.lang.IllegalArgumentException.class, 
                         () -> {
                                    bancoDePrueba.transferirDineroDeUnaCuentaAOtra("Alice","Bob", 1000.0);
                                });
        assertTrue(ex.getMessage().contains("No hay ninguna cuenta a nombre de"));
    }

    @Test
    void noSePuedeRealizarUnaTransferenciaSinSaldoSuficiente() {
        Banco bancoDePrueba = new Banco();
        bancoDePrueba.añadirCuenta(new CuentaBancaria("Alice"));
        bancoDePrueba.añadirCuenta(new CuentaBancaria("Bob"));
        bancoDePrueba.ingresarDineroEnLaCuenta("Alice", 5000.0);
        java.lang.IllegalArgumentException ex = 
            assertThrows(java.lang.IllegalArgumentException.class, 
                         () -> {
                                    bancoDePrueba.transferirDineroDeUnaCuentaAOtra("Alice", "Bob", 8000.0);
                                });
        assertTrue(ex.getMessage().contains("No hay suficiente saldo en la cuenta de"));
    }

}
