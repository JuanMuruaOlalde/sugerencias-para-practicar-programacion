package CuentaBancaria.muestras_de_posibles_soluciones.java;

public class CuentaBancaria {
    
    private java.util.UUID codigoDeCuenta;
    private String titular;
    Double saldo;

    public CuentaBancaria(String titular) {
        codigoDeCuenta = java.util.UUID.randomUUID();
        this.titular = titular;
        saldo = 0.0;
    }

    public String getCodigoDeCuenta() {
        return codigoDeCuenta.toString();
    }

    public String getTitular() {
        return titular;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void hacerIngreso(Double cantidad) {
        if (cantidad > 0) {
            saldo = saldo + cantidad;
        } else {
            throw new IllegalArgumentException("Se han de indicar siempre cantidades positivas.");
        }
    }

    public void hacerReintegro(Double cantidad) {
        if (cantidad > 0) {
            if (saldo > cantidad) {
                saldo = saldo - cantidad;
            } else {
                throw new IllegalArgumentException("El saldo es insuficiente para hacer este reintegro.");
            }
        } else {
            throw new IllegalArgumentException("Se han de indicar siempre cantidades positivas.");
        }
    }
    
}
