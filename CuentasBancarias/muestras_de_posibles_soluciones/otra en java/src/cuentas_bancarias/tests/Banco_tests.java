package cuentas_bancarias.tests;

import org.junit.Test;

import cuentas_bancarias.Banco;
import cuentas_bancarias.Cliente;
import cuentas_bancarias.Cuenta;
import cuentas_bancarias.MovimientoEnCuentas;

import static org.junit.Assert.*;

public class Banco_tests {

  final Double DIFERENCIA_PARA_CONSIDERAR_DOS_NUMEROS_IGUALES = 0.000001;

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
		assertEquals(0.0, nuevaCuenta.getSaldoActual(), DIFERENCIA_PARA_CONSIDERAR_DOS_NUMEROS_IGUALES);
  }
  
  @Test
  public void sePuedeIngresarDineroEnUnaCuenta() {
		Banco unBanco = new Banco();
		Cuenta unaCuenta = unBanco.crearUnaNuevaCuenta();
        unBanco.ingresarDinero(unaCuenta.getNumeroDeCuenta(), 1000.0, "pruebas");
		assertEquals(1000.0, unBanco.getSaldoDeLaCuenta(unaCuenta.getNumeroDeCuenta()), DIFERENCIA_PARA_CONSIDERAR_DOS_NUMEROS_IGUALES);
        unBanco.ingresarDinero(unaCuenta.getNumeroDeCuenta(), 1000.0, "pruebas");
		assertEquals(2000.0, unBanco.getSaldoDeLaCuenta(unaCuenta.getNumeroDeCuenta()), DIFERENCIA_PARA_CONSIDERAR_DOS_NUMEROS_IGUALES);
  }

    @Test
    public void sePuedeSacarDineroDeUnaCuenta() {
      Banco unBanco = new Banco();
      Cuenta unaCuenta = unBanco.crearUnaNuevaCuenta();
      unBanco.ingresarDinero(unaCuenta.getNumeroDeCuenta(), 5000.0, "pruebas");
      assertEquals(5000.0, unBanco.getSaldoDeLaCuenta(unaCuenta.getNumeroDeCuenta()), DIFERENCIA_PARA_CONSIDERAR_DOS_NUMEROS_IGUALES);
      unBanco.sacarDinero(unaCuenta.getNumeroDeCuenta(), 2000.0, "pruebas");
      assertEquals(3000.0, unBanco.getSaldoDeLaCuenta(unaCuenta.getNumeroDeCuenta()), DIFERENCIA_PARA_CONSIDERAR_DOS_NUMEROS_IGUALES);
    }

    @Test
    public void sePuedeTransferirDineroDeUnaCuentaAOtra() {
      Banco unBanco = new Banco();
      Cuenta unaCuenta = unBanco.crearUnaNuevaCuenta();
      Cuenta otraCuenta = unBanco.crearUnaNuevaCuenta();
      unBanco.ingresarDinero(unaCuenta.getNumeroDeCuenta(), 5000.0, "pruebas");
      assertEquals(5000.0, unBanco.getSaldoDeLaCuenta(unaCuenta.getNumeroDeCuenta()), DIFERENCIA_PARA_CONSIDERAR_DOS_NUMEROS_IGUALES);
      unBanco.transferirDinero(unaCuenta.getNumeroDeCuenta(), otraCuenta.getNumeroDeCuenta(), 2000.0, "pruebas");
      assertEquals(3000.0, unBanco.getSaldoDeLaCuenta(unaCuenta.getNumeroDeCuenta()), DIFERENCIA_PARA_CONSIDERAR_DOS_NUMEROS_IGUALES);
      assertEquals(2000.0, unBanco.getSaldoDeLaCuenta(otraCuenta.getNumeroDeCuenta()), DIFERENCIA_PARA_CONSIDERAR_DOS_NUMEROS_IGUALES);
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
      assertEquals(1000.0, movimiento.getCantidad(), DIFERENCIA_PARA_CONSIDERAR_DOS_NUMEROS_IGUALES);
      assertEquals(1000.0, movimiento.getSaldoResultante(), DIFERENCIA_PARA_CONSIDERAR_DOS_NUMEROS_IGUALES);
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
      assertEquals(3000.0, movimiento.getCantidad(), DIFERENCIA_PARA_CONSIDERAR_DOS_NUMEROS_IGUALES);
      assertEquals(2000.0, movimiento.getSaldoResultante(), DIFERENCIA_PARA_CONSIDERAR_DOS_NUMEROS_IGUALES);
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
      assertEquals(3000.0, movimiento.getCantidad(), DIFERENCIA_PARA_CONSIDERAR_DOS_NUMEROS_IGUALES);
      assertEquals(3000.0, movimiento.getSaldoResultante(), DIFERENCIA_PARA_CONSIDERAR_DOS_NUMEROS_IGUALES);
    }

	@Test
	public void sePuedeDarDeAltaUnClienteEnElBanco() { 
		Cliente nuevoCliente = new Cliente("12345678R", "Benzirpi", "Mirvento", "Riverti");
		Banco unBanco = new Banco();
		unBanco.darDeAltaUnNuevoCliente(nuevoCliente);
		Cliente clienteEnElBanco = unBanco.getCliente(nuevoCliente.getDNI());
		assertEquals(nuevoCliente, clienteEnElBanco);
	}

  @Test
  public void sePuedeAsignarUnClienteAUnaCuenta() {
		Cliente unCliente = new Cliente("12345678R", "Benzirpi", "Mirvento", "Riverti");
		Banco unBanco = new Banco();
		unBanco.darDeAltaUnNuevoCliente(unCliente);
    Cuenta unaCuenta = unBanco.crearUnaNuevaCuenta();
    unBanco.asignarUnTitularAUnaCuenta(unCliente.getDNI(), unaCuenta.getNumeroDeCuenta());
    java.util.ArrayList<Cliente> titulares = unBanco.getClientesTitularesDeLaCuenta(unaCuenta.getNumeroDeCuenta());
    assertEquals(1, titulares.size());
  }


}
