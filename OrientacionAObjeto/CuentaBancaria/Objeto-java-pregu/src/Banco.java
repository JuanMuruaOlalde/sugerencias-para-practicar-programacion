import java.util.HashMap;

public class Banco {
    java.util.HashMap<String, CuentaBancaria> cuentas;

    public Banco() {
        cuentas = new HashMap<>();
    }

    public void añadirCuenta(CuentaBancaria unaCuenta) {
        cuentas.put(unaCuenta.getTitular(), unaCuenta);
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
    
    public void ingresarDineroEnLaCuenta(String titular, Double cantidad) {
        if (tieneCuenta(titular)) {
            CuentaBancaria cuenta = cuentas.get(titular);
            cuenta.ingresarDinero(cantidad);
        } else  {
            throw new IllegalArgumentException("No hay ninguna cuenta a nombre de [" + titular + "]");
        }
    }

    public void sacarDineroDeLaCuenta(String titular, Double cantidad) {
        if (tieneCuenta(titular)) {
            CuentaBancaria cuenta = cuentas.get(titular);
            cuenta.sacarDinero(cantidad);
        } else  {
            throw new IllegalArgumentException("No hay ninguna cuenta a nombre de [" + titular + "]");
        }
    }

    public void transferirDineroDeUnaCuentaAOtra(String titularQueEnvia, String titularQueRecibe, Double cantidad) {
        String mensajeDeError = "";
        if (!tieneCuenta(titularQueEnvia)) {
            mensajeDeError += " No hay ninguna cuenta a nombre de [" + titularQueEnvia + "]";
        }
        if (!tieneCuenta(titularQueRecibe)) {
            mensajeDeError += " No hay ninguna cuenta a nombre de [" + titularQueRecibe + "]";
        }
        if (!mensajeDeError.isBlank()) {
            throw new IllegalArgumentException(mensajeDeError);
        }
        if (!tieneSaldoSuficiente(titularQueEnvia, cantidad)){
            throw new IllegalArgumentException("No hay suficiente saldo en la cuenta de " + titularQueEnvia);
        }
        CuentaBancaria cuentaDeDondeSacar = cuentas.get(titularQueEnvia);
        CuentaBancaria cuentaADondeIngresar = cuentas.get(titularQueRecibe);
        cuentaDeDondeSacar.sacarDinero(cantidad);
        cuentaADondeIngresar.ingresarDinero(cantidad);
    }

}
