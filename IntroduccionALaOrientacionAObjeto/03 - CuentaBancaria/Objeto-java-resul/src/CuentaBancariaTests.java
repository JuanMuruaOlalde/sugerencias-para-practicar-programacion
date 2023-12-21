import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;


public class CuentaBancariaTests {

    @Test
    public void lasCuentasSeCreanConSaldoCero() {
        CuentaBancaria cuentaDePrueba = new CuentaBancaria("pruebas");
        assertTrue(cuentaDePrueba.getSaldo() == 0.0);
    }

    @Test
    public void losIngresosFuncionanBien() {
        CuentaBancaria cuentaDePrueba = new CuentaBancaria("pruebas");
        Banco.resultadoDeLaOperacion resultado = cuentaDePrueba.ingresarDinero(5000.00);
        assertEquals(Banco.resultadoDeLaOperacion.OPERACION_COMPLETADA_CON_EXITO, resultado);
        assertTrue(cuentaDePrueba.getSaldo() == 5000.0);
    }

    @Test
    public void losReintegrosFuncionanBien() {
        CuentaBancaria cuentaDePrueba = new CuentaBancaria("pruebas");
        cuentaDePrueba.ingresarDinero(5000.00);
        Banco.resultadoDeLaOperacion resultado01 = cuentaDePrueba.sacarDinero(3000.00);
        assertEquals(Banco.resultadoDeLaOperacion.OPERACION_COMPLETADA_CON_EXITO, resultado01);
        assertTrue(cuentaDePrueba.getSaldo() == 2000.0);
        Banco.resultadoDeLaOperacion resultado02 = cuentaDePrueba.sacarDinero(2000.00);
        assertEquals(Banco.resultadoDeLaOperacion.OPERACION_COMPLETADA_CON_EXITO, resultado02);
        assertTrue(cuentaDePrueba.getSaldo() == 0.0);
    }

    @Test
    public void laConsultaDeSaldoSuficienteFuncionaBien() {
        CuentaBancaria cuentaDePrueba = new CuentaBancaria("pruebas");
        Banco.resultadoDeLaOperacion resultado = cuentaDePrueba.ingresarDinero(5000.00);
        assertEquals(Banco.resultadoDeLaOperacion.OPERACION_COMPLETADA_CON_EXITO, resultado);
        assertTrue(cuentaDePrueba.tieneSaldoSuficiente(4000.0));
        assertFalse(cuentaDePrueba.tieneSaldoSuficiente(8000.0));
    }

    @Test
    public void realizarIngresosDeCantidadesNegativas_DaError() {
        CuentaBancaria cuentaDePrueba = new CuentaBancaria("pruebas");
        Banco.resultadoDeLaOperacion resultado = cuentaDePrueba.ingresarDinero(-3000.00);
        assertEquals(Banco.resultadoDeLaOperacion.ERROR_LAS_CANTIDADES_HAN_DE_SER_SIEMPRE_POSITIVAS, resultado);
    }

    @Test
    public void realizarReintegrosDeCantidadesNegativas_DaError() {
        CuentaBancaria cuentaDePrueba = new CuentaBancaria("pruebas");
        Banco.resultadoDeLaOperacion resultado = cuentaDePrueba.sacarDinero(-3000.00);
        assertEquals(Banco.resultadoDeLaOperacion.ERROR_LAS_CANTIDADES_HAN_DE_SER_SIEMPRE_POSITIVAS, resultado);
    }

    @Test
    public void sacarMasDineroDelQueHayEnLaCuenta_DaError() {
        CuentaBancaria cuentaDePrueba = new CuentaBancaria("pruebas");
        cuentaDePrueba.ingresarDinero(5000.00);
        Banco.resultadoDeLaOperacion resultado = cuentaDePrueba.sacarDinero(8000.00);
        assertEquals(Banco.resultadoDeLaOperacion.ERROR_SALDO_INSUFICIENTE, resultado);
    }
    
}
