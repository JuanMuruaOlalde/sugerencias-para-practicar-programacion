package ArchivoDeTextoPlano.muestras_de_posibles_soluciones.java_simplificada;

public class Persona {
    String nombre;
    String apellidos;
    String nacimiento;
    String peso_kg;
    String altura_cm;
    String fecha_medicion;

    public Persona(String nombre, String apellidos, String nacimiento, String peso_kg, String altura_cm,
    String fecha_medicion) {
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

    public String getNacimiento() {
        return nacimiento;
    }

    public String getPeso_kg() {
        return peso_kg;
    }

    public String getAltura_cm() {
        return altura_cm;
    }

    public String getFecha_medicion() {
        return fecha_medicion;
    }

    public void setPeso_kg(String peso_kg, String fecha_medicion) {
        this.peso_kg = peso_kg;
        this.fecha_medicion = fecha_medicion;
    }

    

}
