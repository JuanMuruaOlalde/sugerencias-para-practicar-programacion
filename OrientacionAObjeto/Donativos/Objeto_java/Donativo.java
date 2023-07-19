package Objeto_java;

public class Donativo {
    private Double cantidad;
    private Recurrencia recurrencia;

    public enum Recurrencia{
        unica,
        mensual,
        anual
    }

    public Donativo(Double cantidad, Recurrencia recurrencia){
        this.cantidad = cantidad;
        this.recurrencia = recurrencia;
    }

    public Double getCantidad(){
        return cantidad;
    }

    public Recurrencia getRecurrencia(){
        return recurrencia;
    }

}
