import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class CuentaBancariaTests {

    @Test
    public void lasCuentasSeCreanConSaldoCero() {
        CuentaBancaria cuenta = new CuentaBancaria("Alice");
        assertTrue(cuenta.getSaldo() == 0.0);
    }

    @Test
    public void podemosHacerUnIngresoEnLaCuenta() {
        CuentaBancaria cuenta = new CuentaBancaria("Alice");
        cuenta.ingresarDinero(1000.0);
        assertTrue(cuenta.getSaldo() == 1000.0);
    }

    @Test
    public void podemosHacerUnReintegroEnLaCuenta() {
        CuentaBancaria cuenta = new CuentaBancaria("Alice");
        cuenta.ingresarDinero(5000.0);
        cuenta.sacarDinero(1000.0);
        assertTrue(cuenta.getSaldo() == 4000.0);
    }

    @Test
    public void lasCantidadesEnIngresosOReintegrosHanDeSerPositivas() {
        CuentaBancaria cuenta = new CuentaBancaria("Alice");
        java.lang.IllegalArgumentException exAlIngresar = assertThrows(java.lang.IllegalArgumentException.class,
                                                () -> {
                                                    cuenta.ingresarDinero(-5000.0);
                                                });
        assertTrue(exAlIngresar.getMessage().contains("Las cantidades han de ser positivas"));
        java.lang.IllegalArgumentException exAlSacar = assertThrows(java.lang.IllegalArgumentException.class,
                                                () -> {
                                                    cuenta.sacarDinero(-5000.0);
                                                });
        assertTrue(exAlSacar.getMessage().contains("Las cantidades han de ser positivas"));
    }
    
    @Test
    public void noEsPosibleSacarMasDineroDelQueHayEnLaCuenta() {
        CuentaBancaria cuenta = new CuentaBancaria("Alice");
        Banco.ResultadoDeLaOperacion resultado = cuenta.sacarDinero(1000.0);
        assertEquals(Banco.ResultadoDeLaOperacion.SALDO_INSUFICIENTE, resultado);
    }

    @Test
    public void lasCuentasHanDeTenerUnaPersonaTitular() {
        CuentaBancaria cuenta = new CuentaBancaria("Alice");
        assertEquals("Alice", cuenta.getTitular());
    }

}
