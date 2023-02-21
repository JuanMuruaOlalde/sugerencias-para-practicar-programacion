package Areas_y_Perimetros.muestras_de_posibles_soluciones.java.con_interface;

public class Rectangulo implements FiguraGeometrica{
    private Double unLado;
    private Double otroLado;
    private String color;
    
    
    public Rectangulo(Double unLado, Double otroLado)
    {
        this.unLado = unLado;
        this.otroLado = otroLado;
    }

    public String getColor() {
        return color.toString();
    }

    public void setColor(String color) {
        if (color == "rojo" || color == "verde" || color == "rosa" || color == "naranja") {
            this.color = color;
        } else {
            throw new IllegalArgumentException("El color solo puede ser rojo, verde, rosa o naranja. No puede ser " + color);
        }
    }

    
    @Override
    public Double getArea() {
        return unLado * otroLado;
    }

    @Override
    public Double getPerimetro() {
        return (unLado + otroLado) * 2;
    }

    @Override
    public String toString() {
        return "Soy un rectangulo " + color + " de lados " + unLado + " y " + otroLado;
    }
    
     
}
