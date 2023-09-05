import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;


public class CuentaBancariaTests {

    @Test
    public void laCuentaSeCreaConSaldoCero() {
        CuentaBancaria cuentaDePrueba = new CuentaBancaria("pruebas");
        assertTrue(cuentaDePrueba.getSaldo() == 0.0);
    }

    @Test
    public void losIngresosFuncionanBien() {
        CuentaBancaria cuentaDePrueba = new CuentaBancaria("pruebas");
        cuentaDePrueba.ingresarDinero(5000.00);
        assertTrue(cuentaDePrueba.getSaldo() == 5000.0);
    }

    @Test
    public void losReintegrosFuncionanBien() {
        CuentaBancaria cuentaDePrueba = new CuentaBancaria("pruebas");
        cuentaDePrueba.ingresarDinero(5000.00);
        cuentaDePrueba.sacarDinero(3000.00);
        assertTrue(cuentaDePrueba.getSaldo() == 2000.0);
        cuentaDePrueba.sacarDinero(2000.00);
        assertTrue(cuentaDePrueba.getSaldo() == 0.0);
    }

    @Test
    public void laConsultaDeSaldoSuficienteFuncionaBien() {
        CuentaBancaria cuentaDePrueba = new CuentaBancaria("pruebas");
        cuentaDePrueba.ingresarDinero(5000.00);
        assertTrue(cuentaDePrueba.tieneSaldoSuficiente(4000.0));
        assertFalse(cuentaDePrueba.tieneSaldoSuficiente(8000.0));
    }

    @Test
    public void noSePuedenRealizarIngresosDeCantidadesNegativas() {
        CuentaBancaria cuentaDePrueba = new CuentaBancaria("pruebas");
        java.lang.IllegalArgumentException ex = 
            assertThrows(java.lang.IllegalArgumentException.class, 
                         () -> {
                                    cuentaDePrueba.ingresarDinero(-3000.00);
                                });
        assertTrue(ex.getMessage().contains("Se debe indicar una cantidad positiva"));
    }

    @Test
    public void noSePuedenRealizarReintegrosDeCantidadesNegativas() {
        CuentaBancaria cuentaDePrueba = new CuentaBancaria("pruebas");
        java.lang.IllegalArgumentException ex = 
            assertThrows(java.lang.IllegalArgumentException.class, 
                         () -> {
                                    cuentaDePrueba.sacarDinero(-3000.00);
                                });
        assertTrue(ex.getMessage().contains("Se debe indicar una cantidad positiva"));
    }

    @Test
    public void noSePuedeSacarMasDineroDelQueHayEnLaCuenta() {
        CuentaBancaria cuentaDePrueba = new CuentaBancaria("pruebas");
        cuentaDePrueba.ingresarDinero(5000.00);
        java.lang.IllegalArgumentException ex = 
            assertThrows(java.lang.IllegalArgumentException.class, 
                         () -> {
                                    cuentaDePrueba.sacarDinero(8000.00);
                                });
        assertTrue(ex.getMessage().contains("No hay suficiente saldo"));
    }
    
}
