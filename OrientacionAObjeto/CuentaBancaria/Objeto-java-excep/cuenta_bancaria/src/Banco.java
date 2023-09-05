import java.util.HashMap;

public class Banco {
    java.util.HashMap<String, CuentaBancaria> cuentas;

    public Banco() {
        cuentas = new HashMap<>();
    }

    public void añadirCuenta(CuentaBancaria unaCuenta) {
        cuentas.put(unaCuenta.getTitular(), unaCuenta);
    }

    public void ingresarDineroEnLaCuenta(String titular, Double cantidad) {
        if (cuentas.containsKey(titular)) {
            CuentaBancaria cuenta = cuentas.get(titular);
            cuenta.ingresarDinero(cantidad);
        } else  {
            throw new IllegalArgumentException("No hay ninguna cuenta a nombre de [" + titular + "]");
        }
    }

    public void sacarDineroDeLaCuenta(String titular, Double cantidad) {
        if (cuentas.containsKey(titular)) {
            CuentaBancaria cuenta = cuentas.get(titular);
            cuenta.sacarDinero(cantidad);
        } else  {
            throw new IllegalArgumentException("No hay ninguna cuenta a nombre de [" + titular + "]");
        }
    }

    public void transferirDineroDeUnaCuentaAOtra(String titularQueEnvia, String titularQueRecibe, Double cantidad) {
        if (!cuentas.containsKey(titularQueEnvia)) {
            throw new IllegalArgumentException("No hay ninguna cuenta a nombre de [" + titularQueEnvia + "]");
        }
        if (!cuentas.containsKey(titularQueRecibe)) {
            throw new IllegalArgumentException("No hay ninguna cuenta a nombre de [" + titularQueRecibe + "]");
        }
        CuentaBancaria cuentaDeDondeSacar = cuentas.get(titularQueEnvia);
        CuentaBancaria cuentaADondeIngresar = cuentas.get(titularQueRecibe);
        try {
            cuentaDeDondeSacar.sacarDinero(cantidad);
            cuentaADondeIngresar.ingresarDinero(cantidad);
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("No hay suficiente saldo en la cuenta que envia."
                                               + " Se quiere transferir [" + cantidad + "]" 
                                               + " , pero solo hay [" + cuentaDeDondeSacar.getSaldo() + "]");
        }
    }

    public Double consultarSaldoDeLaCuentaDe(String titular) {
        if (cuentas.containsKey(titular)) {
            CuentaBancaria cuenta = cuentas.get(titular);
            return cuenta.getSaldo();
        } else  {
            throw new IllegalArgumentException("No hay ninguna cuenta a nombre de [" + titular + "]");
        }
    }
    
}
