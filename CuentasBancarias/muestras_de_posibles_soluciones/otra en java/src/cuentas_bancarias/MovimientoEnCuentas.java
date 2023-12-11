package cuentas_bancarias;

public class MovimientoEnCuentas
{
    public enum TIPO_DE_MOVIMIENTO{
        Ingreso,
        Reintegro,
        RecibirTransferencia,
        EnviarTransferencia
    }

    private java.time.LocalDateTime estampaHoraria;
    private TIPO_DE_MOVIMIENTO tipoDeMovimiento;
    private String numeroDeLaOtraCuenta;
    private Double cantidad;
    private String explicacion;
    private Double saldoResultante;

    public MovimientoEnCuentas(TIPO_DE_MOVIMIENTO tipoDeMovimiento, String explicacion, Double cantidad, Double saldoResultante)
    {
        if (tipoDeMovimiento == TIPO_DE_MOVIMIENTO.Ingreso || tipoDeMovimiento == TIPO_DE_MOVIMIENTO.Reintegro) {
            this.estampaHoraria = java.time.LocalDateTime.now();
            this.tipoDeMovimiento = tipoDeMovimiento;
            this.explicacion = explicacion;
            this.cantidad = cantidad;
            this.saldoResultante = saldoResultante;
        } else {
            throw new java.lang.IllegalArgumentException("Para transferencias, hay que llamar al otro constructor.");
        }

    }
    
    public MovimientoEnCuentas(TIPO_DE_MOVIMIENTO tipoDeMovimiento, String numeroDeLaOtraCuenta, Double cantidad, Double saldoResultante, String explicacion)
    {
        if (numeroDeLaOtraCuenta.isEmpty()) {
            throw new java.lang.IllegalArgumentException("En las transferencias es obligatorio indicar el numero de la otra cuenta.");
        }
        if (!(tipoDeMovimiento == TIPO_DE_MOVIMIENTO.RecibirTransferencia || tipoDeMovimiento == TIPO_DE_MOVIMIENTO.EnviarTransferencia)) {
            throw new java.lang.IllegalArgumentException("Para movimientos simples, hay que llamar al otro constructor.");
        }
        this.estampaHoraria = java.time.LocalDateTime.now();
        this.tipoDeMovimiento = tipoDeMovimiento;
        this.explicacion = explicacion;
        this.numeroDeLaOtraCuenta = numeroDeLaOtraCuenta;
        this.cantidad = cantidad;
        this.saldoResultante = saldoResultante;
    }
    
    
    public java.time.LocalDateTime getEstampaHoraria() {
        return estampaHoraria;
    }

    public TIPO_DE_MOVIMIENTO getTipoDeMovimiento() {
        return tipoDeMovimiento;
    }

    public String getExplicacion() {
        return explicacion;
    }

    public String getNumeroDeLaOtraCuenta() {
        return numeroDeLaOtraCuenta;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public Double getSaldoResultante() {
        return saldoResultante;
    }

    public String toString()
    {
        if (tipoDeMovimiento == TIPO_DE_MOVIMIENTO.Ingreso || tipoDeMovimiento == TIPO_DE_MOVIMIENTO.Reintegro) {
            return this.estampaHoraria.toString() + " : "  + tipoDeMovimiento + System.lineSeparator()
                   + "  cantidad= " + this.cantidad + " : resultaSaldo=" + this.saldoResultante + System.lineSeparator()
                   + explicacion  + System.lineSeparator();
        }
        if (tipoDeMovimiento == TIPO_DE_MOVIMIENTO.RecibirTransferencia) {
            return this.estampaHoraria.toString() + System.lineSeparator()
                   + "  Transferencia  desde " + this.numeroDeLaOtraCuenta + System.lineSeparator()
                   + "  cantidad= " + this.cantidad + " : resultaSaldo=" + this.saldoResultante + System.lineSeparator()
                   + explicacion  + System.lineSeparator();
        }
        if (tipoDeMovimiento == TIPO_DE_MOVIMIENTO.EnviarTransferencia) {
            return this.estampaHoraria.toString() + System.lineSeparator()
                   + "  Transferencia  hacia " + this.numeroDeLaOtraCuenta + System.lineSeparator()
                   + "  cantidad= " + this.cantidad + " : resultaSaldo=" + this.saldoResultante + System.lineSeparator()
                   + explicacion  + System.lineSeparator();
        }
        return this.estampaHoraria.toString() + " : ERROR, tipo de movimiento (" + tipoDeMovimiento + ") desconocido";
    }
    
    

}
