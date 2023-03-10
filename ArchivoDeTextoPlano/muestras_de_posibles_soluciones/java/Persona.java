package ArchivoDeTextoPlano.muestras_de_posibles_soluciones.java;

import java.time.LocalDate;

public class Persona {
    String nombre;
    String apellidos;
    java.time.LocalDate nacimiento;
    Double peso_kg;
    Double altura_cm;
    java.time.LocalDate fecha_medicion;

    public Persona(String nombre, String apellidos, LocalDate nacimiento, Double peso_kg, Double altura_cm,
    LocalDate fecha_medicion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nacimiento = nacimiento;
        this.peso_kg = peso_kg;
        this.altura_cm = altura_cm;
        this.fecha_medicion = fecha_medicion;
    }

    public String toString() {
        return nombre + " " + apellidos
        + "\nFecha de nacimiento: " + nacimiento
        + "\nAltura: " + altura_cm + " cm"
        + "\nPeso: " + peso_kg + " kg   (medido el " + fecha_medicion + ")"
        + "\n=================================";
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public LocalDate getNacimiento() {
        return nacimiento;
    }

    public Double getPeso_kg() {
        return peso_kg;
    }

    public Double getAltura_cm() {
        return altura_cm;
    }

    public LocalDate getFecha_medicion() {
        return fecha_medicion;
    }

    public void setPeso_kg(Double peso_kg, LocalDate fecha_medicion) {
        this.peso_kg = peso_kg;
        this.fecha_medicion = fecha_medicion;
    }

    

}
