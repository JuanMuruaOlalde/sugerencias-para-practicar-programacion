package Areas_y_Perimetros.muestras_de_posibles_soluciones.java.con_herencia;

public class Cuadrado extends Rectangulo {
    private Double lado;
    private String color;

    public Cuadrado(Double lado)
    {
   	    super(lado, lado);
        this.lado = lado;
    }


    @Override
    public String toString() {
        return "Soy un cuadrado " + color + "  de lado " + lado;
    }
   
}
