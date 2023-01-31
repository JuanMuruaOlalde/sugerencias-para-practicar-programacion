package CodigoMorse.muestras_de_posibles_soluciones.java;

public class Main {
    public static void main(String args[]) {
        java.util.Scanner lectorDeTeclado = new java.util.Scanner(System.in);
        System.out.println("Teclea un texto y termina con [Enter]: ");
        String texto = lectorDeTeclado.nextLine();
        lectorDeTeclado.close();
        ConversorMorse conversor = new ConversorMorse();
        System.out.println(conversor.convertirDeTextoAMorse(texto));
    }

}
