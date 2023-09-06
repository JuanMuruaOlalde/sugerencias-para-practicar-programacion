
public class CuentaBancaria {
    private Double saldo;
    private String titular;

    private CuentaBancaria() {
        // Esto es para evitar el constructor por defecto de Java.
    }

    public CuentaBancaria(String titular) {
        this.titular = titular;
        saldo = 0.0;
    }

    public double getSaldo() {
        return  saldo;
    }

    public String getTitular() {
        return titular;
    }


    public Banco.ResultadoDeLaOperacion ingresarDinero(double cantidad) {
        if (cantidad <= 0.0) {
            throw new java.lang.IllegalArgumentException("Las cantidades han de ser positivas."
                                                         + " Se ha intentado ingresar [" + cantidad + "]");
        }
        saldo = saldo + cantidad;
        return Banco.ResultadoDeLaOperacion.OK_OPERACION_REALIZADA;
    }

    public Banco.ResultadoDeLaOperacion sacarDinero(double cantidad) {
        if (cantidad <= 0.0) {
            throw new java.lang.IllegalArgumentException("Las cantidades han de ser positivas."
                                                         + " Se ha intentado sacar [" + cantidad + "]");
        }
        if (cantidad > saldo) {
            return Banco.ResultadoDeLaOperacion.SALDO_INSUFICIENTE;
        }
        saldo = saldo - cantidad;
        return Banco.ResultadoDeLaOperacion.OK_OPERACION_REALIZADA;
    }


}
