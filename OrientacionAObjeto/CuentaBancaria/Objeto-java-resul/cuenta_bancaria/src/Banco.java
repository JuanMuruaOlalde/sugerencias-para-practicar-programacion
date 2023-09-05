import java.util.HashMap;

public class Banco {

    java.util.HashMap<String, CuentaBancaria> cuentas;

    public static enum resultadoDeLaOperacion {
        OPERACION_COMPLETADA_CON_EXITO,
        ERROR_CUENTA_INEXISTENTE,
        ERROR_CADA_TITULAR_SOLO_PUEDE_TENER_UNA_CUENTA,
        ERROR_SALDO_INSUFICIENTE,
        ERROR_LAS_CANTIDADES_HAN_DE_SER_SIEMPRE_POSITIVAS,    
    }

    public Banco() {
        cuentas = new HashMap<>();
    }

    public resultadoDeLaOperacion añadirCuenta(CuentaBancaria unaCuenta) {
        if (tieneCuenta(unaCuenta.getTitular())) {
            return resultadoDeLaOperacion.ERROR_CADA_TITULAR_SOLO_PUEDE_TENER_UNA_CUENTA;
        } else {
            cuentas.put(unaCuenta.getTitular(), unaCuenta);
            return resultadoDeLaOperacion.OPERACION_COMPLETADA_CON_EXITO;
        }
    }

    public Boolean tieneCuenta(String titular) {
        return cuentas.containsKey(titular);
    }

    public Boolean tieneSaldoSuficiente(String titular, Double cantidad) {
        return getSaldoDe(titular) >= cantidad;
    }

    public Double getSaldoDe(String titular) {
        if (tieneCuenta(titular)) {
            CuentaBancaria cuenta = cuentas.get(titular);
            return cuenta.getSaldo();
        } else  {
            throw new IllegalArgumentException("No hay ninguna cuenta a nombre de [" + titular + "]");
        }
    }
    
    public resultadoDeLaOperacion ingresarDineroEnLaCuenta(String titular, Double cantidad) {
        if (!tieneCuenta(titular)) {
            return resultadoDeLaOperacion.ERROR_CUENTA_INEXISTENTE;
        }
        CuentaBancaria cuenta = cuentas.get(titular);
        return cuenta.ingresarDinero(cantidad);
    }

    public resultadoDeLaOperacion sacarDineroDeLaCuenta(String titular, Double cantidad) {
        if (!tieneCuenta(titular)) {
            return resultadoDeLaOperacion.ERROR_CUENTA_INEXISTENTE;
        }
        CuentaBancaria cuenta = cuentas.get(titular);
        return cuenta.sacarDinero(cantidad);
    }

    public resultadoDeLaOperacion transferirDineroDeUnaCuentaAOtra(String titularQueEnvia, String titularQueRecibe, Double cantidad) {
        if (!tieneCuenta(titularQueEnvia)) {
            return resultadoDeLaOperacion.ERROR_CUENTA_INEXISTENTE;
        }
        if (!tieneCuenta(titularQueRecibe)) {
            return resultadoDeLaOperacion.ERROR_CUENTA_INEXISTENTE;
        }
        if (!tieneSaldoSuficiente(titularQueEnvia, cantidad)){
            return resultadoDeLaOperacion.ERROR_SALDO_INSUFICIENTE;
        }
        CuentaBancaria cuentaDeDondeSacar = cuentas.get(titularQueEnvia);
        CuentaBancaria cuentaADondeIngresar = cuentas.get(titularQueRecibe);
        cuentaDeDondeSacar.sacarDinero(cantidad);
        cuentaADondeIngresar.ingresarDinero(cantidad);
        return resultadoDeLaOperacion.OPERACION_COMPLETADA_CON_EXITO;
    }

}
