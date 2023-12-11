package cuentas_bancarias.tests;

import org.junit.Test;

import cuentas_bancarias.Banco;
import cuentas_bancarias.Cliente;
import cuentas_bancarias.Cuenta;
import cuentas_bancarias.MovimientoEnCuentas;

import static org.junit.Assert.*;

public class Banco_tests {

  	@Test
	public void sePuedeCrearUnaCuentaEnElBanco() { 
		Banco unBanco = new Banco();
		Cuenta nuevaCuenta = unBanco.crearUnaNuevaCuenta();
		Cuenta cuentaEnElBanco = unBanco.getCuenta(nuevaCuenta.getNumeroDeCuenta());
		assertEquals(nuevaCuenta, cuentaEnElBanco);
	}

    @Test
    public void lasCuentasSeCreanConSaldoCero() {
		Banco unBanco = new Banco();
		Cuenta nuevaCuenta = unBanco.crearUnaNuevaCuenta();
		assertTrue(nuevaCuenta.getSaldoActual().equals(0.0));
    }
  
    @Test
    public void sePuedeIngresarDineroEnUnaCuenta() {
		Banco unBanco = new Banco();
		Cuenta unaCuenta = unBanco.crearUnaNuevaCuenta();
        unBanco.ingresarDinero(unaCuenta.getNumeroDeCuenta(), 1000.0, "pruebas");
		assertTrue(unBanco.getSaldoDeLaCuenta(unaCuenta.getNumeroDeCuenta()).equals(1000.0));
        unBanco.ingresarDinero(unaCuenta.getNumeroDeCuenta(), 1000.0, "pruebas");
		assertTrue(unBanco.getSaldoDeLaCuenta(unaCuenta.getNumeroDeCuenta()).equals(2000.0));
    }

    @Test
    public void sePuedeSacarDineroDeUnaCuenta() {
		Banco unBanco = new Banco();
		Cuenta unaCuenta = unBanco.crearUnaNuevaCuenta();
        unBanco.ingresarDinero(unaCuenta.getNumeroDeCuenta(), 5000.0, "pruebas");
		assertTrue(unBanco.getSaldoDeLaCuenta(unaCuenta.getNumeroDeCuenta()).equals(5000.0));
        unBanco.sacarDinero(unaCuenta.getNumeroDeCuenta(), 2000.0, "pruebas");
		assertTrue(unBanco.getSaldoDeLaCuenta(unaCuenta.getNumeroDeCuenta()).equals(3000.0));
    }

    @Test
    public void sePuedeTransferirDineroDeUnaCuentaAOtra() {
		Banco unBanco = new Banco();
		Cuenta unaCuenta = unBanco.crearUnaNuevaCuenta();
		Cuenta otraCuenta = unBanco.crearUnaNuevaCuenta();
        unBanco.ingresarDinero(unaCuenta.getNumeroDeCuenta(), 5000.0, "pruebas");
		assertTrue(unBanco.getSaldoDeLaCuenta(unaCuenta.getNumeroDeCuenta()).equals(5000.0));
        unBanco.transferirDinero(unaCuenta.getNumeroDeCuenta(), otraCuenta.getNumeroDeCuenta(), 2000.0, "pruebas");
		assertTrue(unBanco.getSaldoDeLaCuenta(unaCuenta.getNumeroDeCuenta()).equals(3000.0));
		assertTrue(unBanco.getSaldoDeLaCuenta(otraCuenta.getNumeroDeCuenta()).equals(2000.0));
    }

    @Test
    public void noSePuedeTransferirMasDineroDelQueHayEnLaCuentaOrigen() {
		Banco unBanco = new Banco();
		Cuenta unaCuenta = unBanco.crearUnaNuevaCuenta();
		Cuenta otraCuenta = unBanco.crearUnaNuevaCuenta();
        unBanco.ingresarDinero(unaCuenta.getNumeroDeCuenta(), 1000.0, "pruebas");
        assertThrows(java.lang.IllegalArgumentException.class, 
        () -> {
            unBanco.transferirDinero(unaCuenta.getNumeroDeCuenta(), otraCuenta.getNumeroDeCuenta(), 2000.0, "pruebas");
        });    
    }

    @Test
    public void losIngresosQuedanRegistrados() {
		Banco unBanco = new Banco();
		Cuenta unaCuenta = unBanco.crearUnaNuevaCuenta();
        unBanco.ingresarDinero(unaCuenta.getNumeroDeCuenta(), 1000.0, "pruebas");
        MovimientoEnCuentas movimiento = unBanco.getUltimoMovimiento();
        assertEquals( MovimientoEnCuentas.TIPO_DE_MOVIMIENTO.Ingreso, movimiento.getTipoDeMovimiento());
        assertEquals("pruebas", movimiento.getExplicacion());
        assertTrue(movimiento.getCantidad().equals(1000.0));
        assertTrue(movimiento.getSaldoResultante().equals(1000.0));
    }

    @Test
    public void losReintegrosQuedanRegistrados() {
		Banco unBanco = new Banco();
		Cuenta unaCuenta = unBanco.crearUnaNuevaCuenta();
        unBanco.ingresarDinero(unaCuenta.getNumeroDeCuenta(), 5000.0, "pruebas");
        unBanco.sacarDinero(unaCuenta.getNumeroDeCuenta(), 3000.0, "pruebas");
        MovimientoEnCuentas movimiento = unBanco.getUltimoMovimiento();
        assertEquals(MovimientoEnCuentas.TIPO_DE_MOVIMIENTO.Reintegro, movimiento.getTipoDeMovimiento());
        assertEquals("pruebas", movimiento.getExplicacion());
        assertTrue(movimiento.getCantidad().equals(3000.0));
        assertTrue(movimiento.getSaldoResultante().equals(2000.0));
    }

    @Test
    public void lasTransferenciasQuedanRegistradas() {
		Banco unBanco = new Banco();
		Cuenta unaCuenta = unBanco.crearUnaNuevaCuenta();
		Cuenta otraCuenta = unBanco.crearUnaNuevaCuenta();
        unBanco.ingresarDinero(unaCuenta.getNumeroDeCuenta(), 5000.0, "pruebas");
        unBanco.transferirDinero(unaCuenta.getNumeroDeCuenta(), otraCuenta.getNumeroDeCuenta(), 3000.0, "pruebas");
        MovimientoEnCuentas movimiento = unBanco.getUltimoMovimiento();
        assertEquals(MovimientoEnCuentas.TIPO_DE_MOVIMIENTO.RecibirTransferencia, movimiento.getTipoDeMovimiento());
        assertEquals(unaCuenta.getNumeroDeCuenta(), movimiento.getNumeroDeLaOtraCuenta());
        assertEquals("pruebas", movimiento.getExplicacion());
        assertTrue(movimiento.getCantidad().equals(3000.0));
        assertTrue(movimiento.getSaldoResultante().equals(3000.0));
    }

	@Test
	public void sePuedeDarDeAltaUnClienteEnElBanco() { 
		Cliente nuevoCliente = new Cliente("12345678R", "Benzirpi", "Mirvento", "Riverti");
		Banco unBanco = new Banco();
		unBanco.darDeAltaUnNuevoCliente(nuevoCliente);
		Cliente clienteEnElBanco = unBanco.getCliente(nuevoCliente.getDNI());
		assertEquals(nuevoCliente, clienteEnElBanco);
	}


}
