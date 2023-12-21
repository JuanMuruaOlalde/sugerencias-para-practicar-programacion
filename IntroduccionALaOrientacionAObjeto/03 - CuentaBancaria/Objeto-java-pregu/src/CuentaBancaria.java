public class CuentaBancaria {
    private String titular;
    private Double saldo;

    public CuentaBancaria(String titular) {
        this.titular = titular;
        this.saldo = 0.0;
    }

    public String getTitular() {
        return titular;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void ingresarDinero(Double cantidad) {
        if(cantidad > 0) {
            saldo = saldo + cantidad;
        } else {
            throw new IllegalArgumentException("Se debe indicar una cantidad positiva. Se ha intentado ingresar [" + cantidad + "]");
        }
    }

    public Boolean tieneSaldoSuficiente(Double cantidadQueSeQuiereSacar) {
        return saldo >= cantidadQueSeQuiereSacar;
    }

    public void sacarDinero(Double cantidad) {
        if(cantidad <= 0) {
            throw new IllegalArgumentException("Se debe indicar una cantidad positiva. Se ha intentado sacar [" + cantidad + "]");
        } else if (!tieneSaldoSuficiente(cantidad)) {
            throw new IllegalArgumentException("No hay suficiente saldo. Se ha intentado sacar [" + cantidad + "], cuando solo hay un saldo de [" + saldo + "]");
        } else {
            saldo = saldo - cantidad;
        }
    }

}