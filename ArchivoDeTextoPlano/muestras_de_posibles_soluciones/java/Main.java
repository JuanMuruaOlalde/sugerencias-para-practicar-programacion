package ArchivoDeTextoPlano.muestras_de_posibles_soluciones.java;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Main {
    public static void main(String args[]) {
        final String PATHARCHIVO = "C:\\Users\\Public\\temp\\archivo para pruebas.txt";
        java.util.ArrayList<Persona> personas = new java.util.ArrayList<>();
        try {
            java.io.FileReader lectorArchivo = new java.io.FileReader(PATHARCHIVO);
            java.io.BufferedReader lector = new java.io.BufferedReader(lectorArchivo);

            String linea = lector.readLine(); // Se ignora la primera linea (son cabeceras).
            linea = lector.readLine(); // Los datos comienzan a partir de la segunda linea.
            while(linea != null) {
                String[] datos = linea.split("\s+:\s+");

                String nombre = datos[0];
                String apellidos = datos[1];

                DateTimeFormatter formateadorDeTiempo = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                java.time.LocalDate nacimiento = null;
                java.time.LocalDate fechaMedicion = null;
                try {
                        nacimiento = java.time.LocalDate.parse(datos[2], formateadorDeTiempo);
                        fechaMedicion = java.time.LocalDate.parse(datos[5], formateadorDeTiempo);
                } catch (DateTimeParseException ex) {
                    System.out.println("Error al leer alguna de las fechas en la linea: " + linea);
                }

                java.util.Locale localizacionES = new java.util.Locale("es");
                java.text.NumberFormat formateadorDeNumeros = java.text.NumberFormat.getInstance(localizacionES);
                Double peso = Double.NaN;
                Double altura = Double.NaN;
                try {
                    peso = formateadorDeNumeros.parse(datos[3]).doubleValue();
                    altura = formateadorDeNumeros.parse(datos[4]).doubleValue();
                } catch (ParseException ex) {
                    System.out.println("Error al leer alguno de los numeros en la linea: " + linea);
                }

                Persona unaPersona = new Persona(nombre, apellidos, nacimiento, peso, altura, fechaMedicion);
                personas.add(unaPersona);
                
                linea = lector.readLine();
            }
            lector.close();
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
