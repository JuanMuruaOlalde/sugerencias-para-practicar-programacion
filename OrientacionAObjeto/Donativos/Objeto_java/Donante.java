package Objeto_java;

class Donante {
    private String nombre;
    private String correo;
    private Donativo donativo;

    public Donante(String nombre, String correo, Donativo donativo){
        this.nombre = nombre;
        this.correo = correo;
        this.donativo = donativo;
    }

    public String toString(){
        return "Me llamo " + nombre + " y mi correo es " + correo;
    }

    public Donativo getDonativo() {
        return donativo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

}