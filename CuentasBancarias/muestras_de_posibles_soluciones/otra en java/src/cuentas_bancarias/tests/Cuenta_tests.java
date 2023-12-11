package cuentas_bancarias.tests;

import org.junit.Test;
import static org.junit.Assert.*;

import cuentas_bancarias.Cuenta;


public class Cuenta_tests {

    @Test
    public void lasCuentasSeCreanConSaldoCero() {
        Cuenta nuevaCuenta = new Cuenta();
        assertTrue(nuevaCuenta.getSaldoActual().equals(0.0));
    }
  
    @Test
    public void sePuedeIngresarDineroEnUnaCuenta() {
        Cuenta unaCuenta = new Cuenta();
        unaCuenta.ingresarDinero(1000.0, "pruebas");
        assertTrue(unaCuenta.getSaldoActual().equals(1000.0));
        unaCuenta.ingresarDinero(1000.0, "pruebas");
        assertTrue(unaCuenta.getSaldoActual().equals(2000.0));
    }

    @Test
    public void noSePuedenIngresarCantidadesNegativas() {
        Cuenta unaCuenta = new Cuenta();
        assertThrows(java.lang.IllegalArgumentException.class, 
        () -> {
                unaCuenta.ingresarDinero(-1000.0, "pruebas");
        });    
    }

    @Test
    public void sePuedeIngresarCantidadCero() {
        Cuenta unaCuenta = new Cuenta();
        unaCuenta.ingresarDinero(0.0, "pruebas");
        assertTrue(unaCuenta.getSaldoActual().equals(0.0));
    }


    @Test
    public void sePuedeSacarDineroDeUnaCuenta() {
        Cuenta unaCuenta = new Cuenta();
        unaCuenta.ingresarDinero(5000.0, "pruebas");
        unaCuenta.sacarDinero(1000.0, "pruebas");
        assertTrue(unaCuenta.getSaldoActual().equals(4000.0));
        unaCuenta.sacarDinero(1000.0, "pruebas");
        assertTrue(unaCuenta.getSaldoActual().equals(3000.0));
    }

    @Test
    public void noSePuedenSacarMasDineroDelQueHay() {
        Cuenta unaCuenta = new Cuenta();
        unaCuenta.ingresarDinero(2000.0, "pruebas");
        assertThrows(java.lang.IllegalArgumentException.class, 
        () -> {
                unaCuenta.sacarDinero(3000.0, "pruebas");
        });    
    }

    @Test
    public void noSePuedenSacarCantidadesNegativas() {
        Cuenta unaCuenta = new Cuenta();
        assertThrows(java.lang.IllegalArgumentException.class, 
        () -> {
                unaCuenta.sacarDinero(-1000.0, "pruebas");
        });    
    }

    @Test
    public void sePuedeSacarCantidadCero() {
        Cuenta unaCuenta = new Cuenta();
        unaCuenta.sacarDinero(0.0, "pruebas");
        assertTrue(unaCuenta.getSaldoActual().equals(0.0));
    }

}
