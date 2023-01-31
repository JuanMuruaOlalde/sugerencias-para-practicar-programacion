package ProcesandoListas.muestras_de_posibles_soluciones.java;

public class Main {

    public static void main(String args[]) {

        Integer[] arrayOriginal = {34, 76, 295, 17, 861, 5, 95, 127, 3, 99, 26, 49, 117, 532, 15, 88, 2, 31};
        java.util.ArrayList<Integer> listaOriginal = new java.util.ArrayList<>();
        java.util.Collections.addAll(listaOriginal, arrayOriginal);
        System.out.println("La lista original: " + listaOriginal.toString());

        java.util.ArrayList<Integer> listaDuplicada = new java.util.ArrayList<>();
        for (Integer unNumero : listaOriginal) {
            listaDuplicada.add(unNumero * 2);
        }
        System.out.println("Multiplicando sus elementos por 2: " + listaDuplicada.toString());

        Integer suma = 0;
        for (Integer unNumero : listaOriginal) {
            suma = suma + unNumero;
        }
        System.out.format("Los elementos de la lista original suman %,d" , suma);



    }
    
}
