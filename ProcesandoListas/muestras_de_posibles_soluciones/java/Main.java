package ProcesandoListas.muestras_de_posibles_soluciones.java;

import java.util.ArrayList;
import java.time.LocalDate;

public class Main {

    public static void main(String args[]) {

        Integer[] arrayOriginal = {34, 76, 295, 17, 861, 5, 95, 127, 3, 99, 26, 49, 117, 532, 15, 88, 2, 31};
        ArrayList<Integer> listaOriginal = new ArrayList<>();
        java.util.Collections.addAll(listaOriginal, arrayOriginal);
        System.out.println();
        System.out.println("La lista original: " + listaOriginal.toString());


        ArrayList<Integer> listaDuplicada = new ArrayList<>();
        for (Integer unNumero : listaOriginal) {
            listaDuplicada.add(unNumero * 2);
        }
        System.out.println();
        System.out.println("Multiplicando sus elementos por 2: " + listaDuplicada.toString());


        Integer suma = 0;
        for (Integer unNumero : listaOriginal) {
            suma = suma + unNumero;
        }
        System.out.println();
        System.out.format("Los elementos de la lista original suman %,d \n" , suma);


        ArrayList<Integer> soloImpares = new ArrayList<>();
        for (Integer unNumero : listaOriginal) {
            if(unNumero % 2 > 0) {
                soloImpares.add(unNumero);
            }
        }
        System.out.println();
        System.out.println("Los impares de la lista son: " + soloImpares.toString());


        ArrayList<Double> listaIncrementada = new ArrayList<>();
        for (Integer unNumero : listaOriginal) {
            listaIncrementada.add(unNumero + (unNumero * 0.30));
        }
        System.out.println();
        System.out.println("Incrementando sus elementos un 30%: " + listaIncrementada.toString());


        System.out.println();
        ArrayList<MedicionMetereologica> mediciones = new ArrayList<>();
        mediciones.add(new MedicionMetereologica(LocalDate.of(2023, 2, 14), 15.3, 4.6, 68, 45, 0.0));
        mediciones.add(new MedicionMetereologica(LocalDate.of(2023, 2, 15), 18.2, 3.5, 78, 54, 2.5));
        mediciones.add(new MedicionMetereologica(LocalDate.of(2023, 2, 16), 19.8, 2.6, 47, 41, 0.0));
        mediciones.add(new MedicionMetereologica(LocalDate.of(2023, 2, 17), 17.3, 1.9, 52, 35, 7.5));
        mediciones.add(new MedicionMetereologica(LocalDate.of(2023, 2, 18), 12.9, 3.7, 64, 43, 9.0));
        System.out.println();
        System.out.println("Con estos datos de partida:");
        Double sumaDeMaximas = 0.0;
        Double sumaDeMinimas = 0.0;
        for (MedicionMetereologica medicion : mediciones) {
            System.out.println();
            System.out.println(medicion.toString());
            sumaDeMaximas += medicion.getTemperatura_max_celsius();
            sumaDeMinimas += medicion.getTemperatura_min_celsius();
        }
        Double temperaturaMediaMax = sumaDeMaximas / mediciones.size();
        Double temperaturaMediaMin = sumaDeMinimas / mediciones.size();
        System.out.println();
        System.out.format("Nos da una temperatura media máxima de %.2f °C y mínima de %.2f °C",
                          temperaturaMediaMax, temperaturaMediaMin);
        System.out.println();
        System.out.println();

    }
    
}
