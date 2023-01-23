package CuentaBancaria.muestras_de_posibles_soluciones.java_extendida;

public class CuentaBancaria {
    
    private java.util.UUID codigoDeCuenta;
    private String titular;
    Double saldo;
    java.util.ArrayList<String> historicoDeMovimientos;

    public CuentaBancaria(String titular) {
        codigoDeCuenta = java.util.UUID.randomUUID();
        this.titular = titular;
        saldo = 0.0;
        
        historicoDeMovimientos = new java.util.ArrayList<>();
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
            registrarMovimiento("Ingreso de " + String.format("%,.2f", cantidad));
        } else {
            throw new IllegalArgumentException("Se han de indicar siempre cantidades positivas.");
        }
    }

    public void hacerReintegro(Double cantidad) {
        if (cantidad > 0) {
            if (saldo > cantidad) {
                saldo = saldo - cantidad;
                registrarMovimiento("Reintegro de " + String.format("%,.2f", cantidad));
            } else {
                throw new IllegalArgumentException("El saldo es insuficiente para hacer este reintegro.");
            }
        } else {
            throw new IllegalArgumentException("Se han de indicar siempre cantidades positivas.");
        }
    }
    
    private void registrarMovimiento(String explicacion) {
        java.text.SimpleDateFormat formateadorFechaISO = new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss:SSS");
        java.util.Date ahora = new java.util.Date();
        historicoDeMovimientos.add(formateadorFechaISO.format(ahora) + " ==> " + explicacion);
    }

    public java.util.ArrayList<String> getHistoricoDeMovimientos(){
        return historicoDeMovimientos;
    }

}
