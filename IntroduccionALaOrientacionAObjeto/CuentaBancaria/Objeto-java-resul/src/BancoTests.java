import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class BancoTests {

    @Test
    public void losIngresosFuncionanBien() {
        Banco bancoDePrueba = new Banco();
        bancoDePrueba.añadirCuenta(new CuentaBancaria("Alice"));

        Banco.resultadoDeLaOperacion resultado = bancoDePrueba.ingresarDineroEnLaCuenta("Alice", 5000.0);
        assertEquals(Banco.resultadoDeLaOperacion.OPERACION_COMPLETADA_CON_EXITO, resultado);
        assertTrue(bancoDePrueba.getSaldoDe("Alice") == 5000.0);
    }

    @Test
    public void losReintegrosFuncionanBien() {
        Banco bancoDePrueba = new Banco();
        bancoDePrueba.añadirCuenta(new CuentaBancaria("Alice"));
        bancoDePrueba.ingresarDineroEnLaCuenta("Alice", 5000.0);

        Banco.resultadoDeLaOperacion resultado01 = bancoDePrueba.sacarDineroDeLaCuenta("Alice", 3000.0);
        assertEquals(Banco.resultadoDeLaOperacion.OPERACION_COMPLETADA_CON_EXITO, resultado01);
        assertTrue(bancoDePrueba.getSaldoDe("Alice") == 2000.0);

        Banco.resultadoDeLaOperacion resultado02 = bancoDePrueba.sacarDineroDeLaCuenta("Alice", 2000.0);
        assertEquals(Banco.resultadoDeLaOperacion.OPERACION_COMPLETADA_CON_EXITO, resultado02);
        assertTrue(bancoDePrueba.getSaldoDe("Alice") == 0.0);
    }

    @Test
    void lasTransferenciasFuncionanBien() {
        Banco bancoDePrueba = new Banco();
        bancoDePrueba.añadirCuenta(new CuentaBancaria("Alice"));
        bancoDePrueba.añadirCuenta(new CuentaBancaria("Bob"));
        bancoDePrueba.ingresarDineroEnLaCuenta("Alice", 5000.0);

        Banco.resultadoDeLaOperacion resultado01 = bancoDePrueba.transferirDineroDeUnaCuentaAOtra("Alice", "Bob", 3000.0);
        assertEquals(Banco.resultadoDeLaOperacion.OPERACION_COMPLETADA_CON_EXITO, resultado01);
        assertTrue(bancoDePrueba.getSaldoDe("Alice") == 2000.0);
        assertTrue(bancoDePrueba.getSaldoDe("Bob") == 3000.0);
        
        Banco.resultadoDeLaOperacion resultado02 = bancoDePrueba.transferirDineroDeUnaCuentaAOtra("Alice", "Bob", 2000.0);
        assertEquals(Banco.resultadoDeLaOperacion.OPERACION_COMPLETADA_CON_EXITO, resultado02);
        assertTrue(bancoDePrueba.getSaldoDe("Alice") == 0.0);
        assertTrue(bancoDePrueba.getSaldoDe("Bob") == 5000.0);
    }

    @Test
    public void lasConsultasDeSiExisteONoUnaCuentaFuncionaBien() {
        Banco bancoDePrueba = new Banco();
        bancoDePrueba.añadirCuenta(new CuentaBancaria("Alice"));
        assertTrue(bancoDePrueba.tieneCuenta("Alice"));
        assertFalse(bancoDePrueba.tieneCuenta("Bob"));
    }
    
    @Test
    public void lasConsultasDeSaldoSuficienteFuncionaBien() {
        Banco bancoDePrueba = new Banco();
        bancoDePrueba.añadirCuenta(new CuentaBancaria("Alice"));
        bancoDePrueba.ingresarDineroEnLaCuenta("Alice", 5000.0);
        assertTrue(bancoDePrueba.tieneSaldoSuficiente("Alice", 4000.0));
        assertFalse(bancoDePrueba.tieneSaldoSuficiente("Alice", 8000.0));
    }
    
    @Test
    void consultarSaldoDeUnaCuentaInexistente_DaError() {
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
    void ingresarDineroEnUnaCuentaInexistente_DaError() {
        Banco bancoDePrueba = new Banco();
        bancoDePrueba.añadirCuenta(new CuentaBancaria("Alice"));
        Banco.resultadoDeLaOperacion resultado = bancoDePrueba.ingresarDineroEnLaCuenta("Bob", 1000.0);
        assertEquals(Banco.resultadoDeLaOperacion.ERROR_CUENTA_INEXISTENTE, resultado);
    }

    @Test
    void sacarDineroDeUnaCuentaInexistente_DaError() {
        Banco bancoDePrueba = new Banco();
        bancoDePrueba.añadirCuenta(new CuentaBancaria("Alice"));
        bancoDePrueba.añadirCuenta(new CuentaBancaria("Alice"));
        Banco.resultadoDeLaOperacion resultado = bancoDePrueba.sacarDineroDeLaCuenta("Bob", 1000.0);
        assertEquals(Banco.resultadoDeLaOperacion.ERROR_CUENTA_INEXISTENTE, resultado);
    }

    @Test
    void realizarTransferenciasDesdeUnaCuentaInexistente_DaError() {
        Banco bancoDePrueba = new Banco();
        bancoDePrueba.añadirCuenta(new CuentaBancaria("Bob"));
        Banco.resultadoDeLaOperacion resultado = bancoDePrueba.transferirDineroDeUnaCuentaAOtra("Alice","Bob", 1000.0);
        assertEquals(Banco.resultadoDeLaOperacion.ERROR_CUENTA_INEXISTENTE, resultado);
    }

    @Test
    void realizarTransferenciasHaciaUnaCuentaInexistente_DaError() {
        Banco bancoDePrueba = new Banco();
        bancoDePrueba.añadirCuenta(new CuentaBancaria("Alice"));
        Banco.resultadoDeLaOperacion resultado = bancoDePrueba.transferirDineroDeUnaCuentaAOtra("Alice","Bob", 1000.0);
        assertEquals(Banco.resultadoDeLaOperacion.ERROR_CUENTA_INEXISTENTE, resultado);
    }

    @Test
    void realizarUnaTransferenciaSinSaldoSuficiente_DaError() {
        Banco bancoDePrueba = new Banco();
        bancoDePrueba.añadirCuenta(new CuentaBancaria("Alice"));
        bancoDePrueba.añadirCuenta(new CuentaBancaria("Bob"));
        bancoDePrueba.ingresarDineroEnLaCuenta("Alice", 5000.0);
        Banco.resultadoDeLaOperacion resultado = bancoDePrueba.transferirDineroDeUnaCuentaAOtra("Alice", "Bob", 8000.0);
        assertEquals(Banco.resultadoDeLaOperacion.ERROR_SALDO_INSUFICIENTE, resultado);
    }

}
