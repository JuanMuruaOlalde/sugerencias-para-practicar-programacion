package ArchivoDeTextoPlano.muestras_de_posibles_soluciones.java;

import java.util.Date;

public class Persona {
    String nombre;
    String apellidos;
    Date nacimiento;
    Double peso_kg;
    Double altura_cm;
    Date fecha_medicion;

    public Persona(String nombre, String apellidos, Date nacimiento, Double peso_kg, Double altura_cm,
            Date fecha_medicion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nacimiento = nacimiento;
        this.peso_kg = peso_kg;
        this.altura_cm = altura_cm;
        this.fecha_medicion = fecha_medicion;
    }

    public String toString() {
        return nombre + " " + apellidos
        + "\n Fecha de nacimiento: " + nacimiento
        + "\n Altura: " + altura_cm
        + "\n Peso: " + peso_kg + "(el " + fecha_medicion + ")"
        + "\n =================================";
    }

}
