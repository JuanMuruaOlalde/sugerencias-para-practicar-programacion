package Areas_y_Perimetros.muestras_de_posibles_soluciones.java.con_interface;

public class Main {

    public static void main(String[] args)
    {
   	 Rectangulo unRectangulo = new Rectangulo(77.0, 33.0);
   	 Rectangulo otroRectangulo = new Rectangulo(22.0, 44.0);
   	 Rectangulo unCuadrado = new Cuadrado(8.3);
   	 Cuadrado otroCuadrado = new Cuadrado(25.0);
   	 Circulo unCirculo = new Circulo(5.0);

	 java.util.ArrayList<FiguraGeometrica> figuras = new java.util.ArrayList<>();
	 figuras.add(unRectangulo);
	 figuras.add(otroRectangulo);
	 figuras.add(unCuadrado);
	 figuras.add(otroCuadrado);
	 figuras.add(unCirculo);

	 for(FiguraGeometrica figura : figuras) {
		System.out.println(figura.toString()
							+ " con un area de " + figura.getArea()
							+ " y un perímetro de " + figura.getPerimetro());
	 }
    }

}
