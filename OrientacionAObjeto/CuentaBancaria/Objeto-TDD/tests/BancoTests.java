import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BancoTests {
    
    @Test
    public void podemosHacerTransferenciasEntreCuentas() {
        String Alice = "Alice";
        String Bob = "Bob";
        Banco banco = new Banco();
        banco.agregarUnaCuenta(Alice);
        banco.agregarUnaCuenta(Bob);
        banco.ingresarDineroEnLaCuentaDe(Alice, 5000.0);
        Banco.ResultadoDeLaOperacion resultado = banco.transferirDinero(3000.0, Alice, Bob);
        assertEquals(Banco.ResultadoDeLaOperacion.OK_OPERACION_REALIZADA, resultado);
        assertEquals(3000.0, banco.getSaldoDe(Bob), Banco.PRECISION_EN_CANTIDADES);
        assertEquals(2000.0, banco.getSaldoDe(Alice), Banco.PRECISION_EN_CANTIDADES);
    }

    @Test
    public void paraHacerUnaTrasferenciaTieneQueHaberFondosSuficientesEnLaCuentaOrigen() {
        String Alice = "Alice";
        String Bob = "Bob";
        Banco banco = new Banco();
        banco.agregarUnaCuenta(Alice);
        banco.agregarUnaCuenta(Bob);
        banco.ingresarDineroEnLaCuentaDe(Alice, 1000.0);
        Banco.ResultadoDeLaOperacion resultado = banco.transferirDinero(3000.0, Alice, Bob);
        assertEquals(Banco.ResultadoDeLaOperacion.SALDO_INSUFICIENTE, resultado);
    }

    @Test
    public void paraHacerUnaTrasferenciaAmbasCuentasHanDeEstarDentroDelBanco() {
        String Alice = "Alice";
        Banco banco = new Banco();
        banco.agregarUnaCuenta(Alice);
        banco.ingresarDineroEnLaCuentaDe(Alice, 3000.0);
        Banco.ResultadoDeLaOperacion resultado01 = banco.transferirDinero(3000.0, Alice, "Desconocido");
        assertEquals(Banco.ResultadoDeLaOperacion.CUENTA_INEXISTENTE_EN_EL_BANCO, resultado01);
        Banco.ResultadoDeLaOperacion resultado02 = banco.transferirDinero(3000.0, "Desconocido", Alice);
        assertEquals(Banco.ResultadoDeLaOperacion.CUENTA_INEXISTENTE_EN_EL_BANCO, resultado02);
    }

    @Test
    public void podemosHacerIngresosEnUnaCuenta() {
        String Alice = "Alice";
        Banco banco = new Banco();
        banco.agregarUnaCuenta(Alice);
        Banco.ResultadoDeLaOperacion resultado = banco.ingresarDineroEnLaCuentaDe("Alice", 1000.0);
        assertEquals(Banco.ResultadoDeLaOperacion.OK_OPERACION_REALIZADA, resultado);
        assertEquals(1000.0, banco.getSaldoDe(Alice), Banco.PRECISION_EN_CANTIDADES);
    }

    @Test
    public void paraHacerUnIngresoLaCuentaHaDeExistirEnElBanco() {
        Banco banco = new Banco();
        Banco.ResultadoDeLaOperacion resultado = banco.ingresarDineroEnLaCuentaDe("Desconocido", 1000.0);
        assertEquals(Banco.ResultadoDeLaOperacion.CUENTA_INEXISTENTE_EN_EL_BANCO, resultado);
    }

    @Test
    public void podemosConsultarElSaldoDeUnaCuenta() {
        String Alice = "Alice";
        Banco banco = new Banco();
        banco.agregarUnaCuenta(Alice);
        assertEquals(0.0, banco.getSaldoDe(Alice), Banco.PRECISION_EN_CANTIDADES);
    }

    @Test
    public void paraConsultarSaldoLaCuentaHaDeExistirEnElBanco() {
        Banco banco = new Banco();
        assertTrue(Double.isNaN(banco.getSaldoDe("Desconocido")));
    }

    @Test
    public void podemosSacarDineroDeUnaCuenta() {
        String Alice = "Alice";
        Banco banco = new Banco();
        banco.agregarUnaCuenta(Alice);
        banco.ingresarDineroEnLaCuentaDe(Alice, 5000.0);
        Banco.ResultadoDeLaOperacion resultado = banco.sacarDineroDeLaCuentaDe("Alice", 3000.0);
        assertEquals(Banco.ResultadoDeLaOperacion.OK_OPERACION_REALIZADA, resultado);
        assertEquals(2000.0, banco.getSaldoDe(Alice), Banco.PRECISION_EN_CANTIDADES);
    }

    @Test
    public void paraSacarDineroDeUnaCuentaEsaCuentaHaDeTenerSaldoSuficiente() {
        String Alice = "Alice";
        Banco banco = new Banco();
        banco.agregarUnaCuenta(Alice);
        banco.ingresarDineroEnLaCuentaDe(Alice, 1000.0);
        Banco.ResultadoDeLaOperacion resultado = banco.sacarDineroDeLaCuentaDe("Alice", 2000.0);
        assertEquals(Banco.ResultadoDeLaOperacion.SALDO_INSUFICIENTE, resultado);
    }

    @Test
    public void paraSacarDineroDeUnaCuentaEsaCuentaHaDeExistirEnElBanco() {
        Banco banco = new Banco();
        Banco.ResultadoDeLaOperacion resultado = banco.sacarDineroDeLaCuentaDe("Desconocido", 1000.0);
        assertEquals(Banco.ResultadoDeLaOperacion.CUENTA_INEXISTENTE_EN_EL_BANCO, resultado);
    }


}
