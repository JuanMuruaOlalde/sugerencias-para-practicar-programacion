public class Banco {
    
    private java.util.HashMap<String, CuentaBancaria> cuentas;

    // La cantidad mínima que se puede expresar en saldos o al hacer ingresos o...
    // Y por tanto la diferencia mínima para considerar dos double diferentes al compararlos.
    public static Double PRECISION_EN_CANTIDADES = 0.01;

    public Banco() {
        this.cuentas = new java.util.HashMap<>();
    }

    static public enum ResultadoDeLaOperacion {
        OK_OPERACION_REALIZADA,
        CUENTA_INEXISTENTE_EN_EL_BANCO, 
        SALDO_INSUFICIENTE,
        TITULAR_YA_TIENE_CUENTA
    }

    public ResultadoDeLaOperacion agregarUnaCuenta(String titular) {
        if (cuentas.containsKey(titular)) {
            return ResultadoDeLaOperacion.TITULAR_YA_TIENE_CUENTA;
        }
        cuentas.put(titular, new CuentaBancaria(titular));
        return ResultadoDeLaOperacion.OK_OPERACION_REALIZADA;
    }

    public Boolean tieneCuentaEnElBanco(String titular) {
        return (cuentas.get(titular) != null);
    }

    public double getSaldoDe(String titular) {
        CuentaBancaria cuenta = cuentas.get(titular);
        if (cuenta != null) {
            return cuenta.getSaldo();
        } else {
            return Double.NaN;
        }
    }

    public ResultadoDeLaOperacion transferirDinero(double cantidad, String titularDeLaCuentaOrigen, String titularDeLaCuentaDestino) {
        CuentaBancaria cuentaOrigen = cuentas.get(titularDeLaCuentaOrigen);
        CuentaBancaria cuentaDestino = cuentas.get(titularDeLaCuentaDestino);
        if (cuentaOrigen == null || cuentaDestino == null) {
            return ResultadoDeLaOperacion.CUENTA_INEXISTENTE_EN_EL_BANCO;
        }
        if (cantidad > cuentaOrigen.getSaldo()) {
            return ResultadoDeLaOperacion.SALDO_INSUFICIENTE;
        }
        cuentaOrigen.sacarDinero(cantidad);
        cuentaDestino.ingresarDinero(cantidad);
        return ResultadoDeLaOperacion.OK_OPERACION_REALIZADA;
    }

    public ResultadoDeLaOperacion ingresarDineroEnLaCuentaDe(String titular, double cantidad) {
        CuentaBancaria cuentaDestino = cuentas.get(titular);
        if (cuentaDestino == null) {
            return ResultadoDeLaOperacion.CUENTA_INEXISTENTE_EN_EL_BANCO;
        }
        return cuentaDestino.ingresarDinero(cantidad);
    }

    public Banco.ResultadoDeLaOperacion sacarDineroDeLaCuentaDe(String titular, double cantidad) {
        CuentaBancaria cuenta = cuentas.get(titular);
        if (cuenta == null) {
            return ResultadoDeLaOperacion.CUENTA_INEXISTENTE_EN_EL_BANCO;
        }
        return cuenta.sacarDinero(cantidad);
    }

}
