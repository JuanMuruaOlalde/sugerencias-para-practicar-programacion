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

    public Banco.resultadoDeLaOperacion ingresarDinero(Double cantidad) {
        if(cantidad < 0) {
            return Banco.resultadoDeLaOperacion.ERROR_LAS_CANTIDADES_HAN_DE_SER_SIEMPRE_POSITIVAS;
        }
        saldo = saldo + cantidad;
        return Banco.resultadoDeLaOperacion.OPERACION_COMPLETADA_CON_EXITO;
    }

    public Boolean tieneSaldoSuficiente(Double cantidadQueSeQuiereSacar) {
        return saldo >= cantidadQueSeQuiereSacar;
    }

    public Banco.resultadoDeLaOperacion sacarDinero(Double cantidad) {
        if(cantidad < 0) {
            return Banco.resultadoDeLaOperacion.ERROR_LAS_CANTIDADES_HAN_DE_SER_SIEMPRE_POSITIVAS;
        }
        if (!tieneSaldoSuficiente(cantidad)) {
            return Banco.resultadoDeLaOperacion.ERROR_SALDO_INSUFICIENTE;
        }
        saldo = saldo - cantidad;
        return Banco.resultadoDeLaOperacion.OPERACION_COMPLETADA_CON_EXITO;
    }

}