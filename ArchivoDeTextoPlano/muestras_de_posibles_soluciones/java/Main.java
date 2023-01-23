package ArchivoDeTextoPlano.muestras_de_posibles_soluciones.java;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

public class Main {
    public static void main(String args[]) {
        final String PATHARCHIVO = "C:\\Users\\Public\\temp\\archivo para pruebas.txt";
        java.util.ArrayList<Persona> personas = new java.util.ArrayList<>();
        try {
            java.io.FileReader lectorArchivo = new java.io.FileReader(PATHARCHIVO);
            java.io.BufferedReader lector = new java.io.BufferedReader(lectorArchivo);

            String linea = lector.readLine(); // Se ignora la primera linea
            linea = lector.readLine(); // Se comienza a procesar por la segunda
            while(linea != null) {
                String[] datos = linea.split("\s+:\s+");

                String nombre = datos[0];
                String apellidos = datos[1];

                java.text.SimpleDateFormat formateadorDeTiempo = new java.text.SimpleDateFormat();
                java.util.Date nacimiento = null;
                java.util.Date fechaMedicion = null;
                try {
                        nacimiento = formateadorDeTiempo.parse(datos[2]);
                        fechaMedicion = formateadorDeTiempo.parse(datos[5]);
                } catch (ParseException ex) {
                    System.out.println("Error al leer alguna de las fechas en la linea: " + linea);
                }
                
                Double peso = Double.NaN;
                Double altura = Double.NaN;
                try {
                    peso = Double.parseDouble(datos[3]);
                    altura = Double.parseDouble(datos[4]);
                } catch (NumberFormatException ex) {
                    System.out.println("Error al leer alguno de los numeros en la linea: " + linea);
                }

                Persona unaPersona = new Persona(nombre, apellidos, nacimiento, peso, altura, fechaMedicion);
                personas.add(unaPersona);
                
                linea = lector.readLine();
            }

        } catch (FileNotFoundException ex) {
            System.out.println("No se ha encontrado el archivo " + PATHARCHIVO);
        } catch (IOException ex) {
            System.out.println("Error leyendo lineas del archivo " + PATHARCHIVO);
        }

        for (Persona unaPersona : personas) {
            System.out.println(unaPersona.toString());
        }
     }
 
}
