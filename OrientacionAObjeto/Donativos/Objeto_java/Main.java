package Objeto_java;

import java.util.ArrayList;
import java.util.stream.Collectors;

import Objeto_java.Donativo.Recurrencia;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class Main {
    
    public static void main(String[] args) {
        ArrayList<Donante> datos = CargarDatosDeDonantesYDonaciones("subscripciones y donativos.csv");
        ImprimirDonantes(datos);
        ImprimirDonativos(datos);
    }


    private static ArrayList<Donante> CargarDatosDeDonantesYDonaciones(String ARCHIVO_A_LEER) {
        ArrayList<Donante> listaDeDonantes = new ArrayList<>();
        try{
            FileReader archivo = new FileReader(ARCHIVO_A_LEER);
            BufferedReader lector = new BufferedReader(archivo);
            String lineaLeida = lector.readLine(); // La primera linea contiene cabeceras.
            lineaLeida = lector.readLine(); // En la segunda linea comienzan los datos.
            while(lineaLeida != null){
                String datosLeidos[] = lineaLeida.split(",");
                Donativo unDonativo = new Donativo(Double.parseDouble(datosLeidos[3])
                                                ,Donativo.Recurrencia.valueOf(datosLeidos[2])
                                                );
                Donante unDonante = new Donante(datosLeidos[0]
                                            ,datosLeidos[1]
                                            ,unDonativo
                                            );
                listaDeDonantes.add(unDonante);
                lineaLeida = lector.readLine();
            }
            lector.close();
        }catch(FileNotFoundException ex) {
            System.out.println("No se encuentra el archivo " + ARCHIVO_A_LEER);
        }catch(IOException ex) {
            System.out.println("El archivo " + ARCHIVO_A_LEER + " está vacio.");
        }
        return listaDeDonantes;
    }


    private static void ImprimirDonantes(ArrayList<Donante> listaDeDonantes) {
        for(Donante donante : listaDeDonantes){
            System.out.println(donante);
        }
    }


    private static void ImprimirDonativos(ArrayList<Donante> listaDeDonantes) {
        Double totalUnicas = 0.0;
        Double totalMensuales = 0.0;
        Double totalAnuales = 0.0;
        for (Donante donante : listaDeDonantes){
            Donativo donativo = donante.getDonativo();
            switch(donativo.getRecurrencia()){
                case unica:
                    totalUnicas = totalUnicas + donativo.getCantidad();
                    break;
                case mensual:
                    totalMensuales = totalMensuales + donativo.getCantidad();
                    break;
                case anual:
                    totalAnuales = totalAnuales + donativo.getCantidad();
                    break;
            }
        }
        System.out.println();
        System.out.println("Contribuciones unicas: " + String.format("%.2f", totalUnicas));
        System.out.println("  donadas por:");
        ArrayList<Donante> donantesUnicos = 
          (ArrayList<Donante>)listaDeDonantes.stream()
            .filter(donante -> donante.getDonativo().getRecurrencia().equals(Recurrencia.unica))
            .collect(Collectors.toList());
        for (Donante donante : donantesUnicos) {
            System.out.println("    " + donante.getNombre() + " (" + donante.getCorreo() + ")");
        }
        System.out.println();
        System.out.println("Contribuciones mensuales: "+ String.format("%.2f", totalMensuales));
        System.out.println("  donadas por:");
        ArrayList<Donante> donantesMensuales = 
          (ArrayList<Donante>)listaDeDonantes.stream()
            .filter(donante -> donante.getDonativo().getRecurrencia().equals(Recurrencia.mensual))
            .collect(Collectors.toList());
        for (Donante donante : donantesMensuales) {
            System.out.println("    " + donante.getNombre() + " (" + donante.getCorreo() + ")");
        }
        System.out.println();
        System.out.println("Contribuciones anuales: "+ String.format("%.2f", totalAnuales));
        System.out.println("  donadas por:");
        ArrayList<Donante> donantesAnuales = 
          (ArrayList<Donante>)listaDeDonantes.stream()
            .filter(donante -> donante.getDonativo().getRecurrencia().equals(Recurrencia.anual))
            .collect(Collectors.toList());
        for (Donante donante : donantesAnuales) {
            System.out.println("    " + donante.getNombre() + " (" + donante.getCorreo() + ")");
        }
    }

}
