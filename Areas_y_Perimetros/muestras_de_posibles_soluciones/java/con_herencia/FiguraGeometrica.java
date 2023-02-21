package Areas_y_Perimetros.muestras_de_posibles_soluciones.java.con_herencia;

public class FiguraGeometrica {

    protected String color;
    protected Double area;
    protected Double perimetro;

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

    public Double getArea() {
        return area;
    }

    public Double getPerimetro() {
        return perimetro;
    }
}
