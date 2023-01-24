package ArchivoDeTextoPlano.muestras_de_posibles_soluciones.java_simplificada;

import java.io.FileNotFoundException;
import java.io.IOException;

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
                String nacimiento = datos[2];
                String peso_kg = datos[3];
                String altura_cm = datos[4];
                String fecha_medicion = datos[5];

                Persona unaPersona = new Persona(nombre, apellidos, nacimiento, peso_kg, altura_cm, fecha_medicion);
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
