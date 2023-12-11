package cuentas_bancarias;

import cuentas_bancarias.MovimientoEnCuentas.TIPO_DE_MOVIMIENTO;

public class Cuenta
{
    private java.util.UUID IdInterno;
    private String numeroDeCuenta;
    private Double saldo; 

    java.util.ArrayList<MovimientoEnCuentas> movimientos;
   
    public Cuenta()
    {
        IdInterno = java.util.UUID.randomUUID();
        saldo = 0.0;
        movimientos = new java.util.ArrayList<>(); 
    }


    public java.util.UUID getIdInterno() {
        return IdInterno;
    }

    public String getNumeroDeCuenta() {
        return numeroDeCuenta;
    }

    public void setNumeroDeCuenta(String numeroDeCuenta) {
        this.numeroDeCuenta = numeroDeCuenta;
    }

    public Double getSaldoActual() {
        return saldo;
    }
    
    public void ingresarDinero(Double cantidad, String explicacion) {
        if (cantidad < 0) {
            throw new java.lang.IllegalArgumentException("La cantidad ha de ser positiva.");
        }
        saldo = saldo + cantidad;
        movimientos.add(new MovimientoEnCuentas(TIPO_DE_MOVIMIENTO.Ingreso, explicacion, cantidad, saldo));
    }

    public void sacarDinero(Double cantidad, String explicacion) {
        if (cantidad < 0) {
            throw new java.lang.IllegalArgumentException("La cantidad ha de ser positiva.");
        }
        if (cantidad > saldo) {
            throw new java.lang.IllegalArgumentException("No se puede sacar mas dinero del que hay.");
        }
        saldo = saldo - cantidad;
        movimientos.add(new MovimientoEnCuentas(TIPO_DE_MOVIMIENTO.Reintegro, explicacion, cantidad, saldo));
    }

   
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((numeroDeCuenta == null) ? 0 : numeroDeCuenta.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cuenta other = (Cuenta) obj;
        if (numeroDeCuenta == null) {
            if (other.numeroDeCuenta != null)
                return false;
        } else if (!numeroDeCuenta.equals(other.numeroDeCuenta))
            return false;
        return true;
    }

    @Override
    public String toString()
    {
        return " : " + this.numeroDeCuenta + " : " + this.saldo + " : ";
    }
    

}

