package Areas_y_Perimetros.muestras_de_posibles_soluciones.java.con_interface;

public class Circulo implements FiguraGeometrica{
    
    private double radio;
    private String color;

    public Circulo(double radio)
    {
   	    this.radio = radio;
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
   	    return (Math.PI * Math.pow(radio, 2));
    }

    @Override
    public Double getPerimetro() {
        return (2 * Math.PI * radio);
    }
    
    @Override
    public String toString() {
        return "Soy un círculo " + color + "  de radio " + radio;
    }

}
