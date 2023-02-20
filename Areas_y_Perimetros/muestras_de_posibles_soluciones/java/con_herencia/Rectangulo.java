package Areas_y_Perimetros.muestras_de_posibles_soluciones.java.con_herencia;

public class Rectangulo extends FiguraGeometrica{
    private Double unLado;
    private Double otroLado;
    private String color;
    
    
    public Rectangulo(Double unLado, Double otroLado)
    {
        this.unLado = unLado;
        this.otroLado = otroLado;
        area = unLado * otroLado;
        perimetro = (unLado + otroLado) * 2;
    }

    
    @Override
    public String toString() {
        return "Soy un rectangulo " + color + " de lados " + unLado + " y " + otroLado;
    }
    
     
}
