package Areas_y_Perimetros.muestras_de_posibles_soluciones.java.con_herencia;

public class Circulo extends FiguraGeometrica{
    
    private Double radio;

    public Circulo(Double radio)
    {
   	    this.radio = radio;
        area = Math.PI * Math.pow(radio, 2);
        perimetro = 2 * Math.PI * radio;
    }

    
    @Override
    public String toString() {
        return "Soy un círculo " + color + "  de radio " + radio;
    }

}
