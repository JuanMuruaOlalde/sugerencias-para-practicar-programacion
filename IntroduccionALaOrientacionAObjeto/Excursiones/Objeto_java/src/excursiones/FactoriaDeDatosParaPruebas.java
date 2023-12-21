package excursiones;

import java.util.ArrayList;

public class FactoriaDeDatosParaPruebas {


    public static ArrayList<Persona> getAlgunasPersonas() {
        ArrayList<Persona> personas = new ArrayList<>();

        personas.add(new Persona("12345678A", "Juan", "Perez", 
                           "jperez@pruebas.com", "123456789"));
        personas.add(new Persona("23456789B", "Pedro", "Gomez", 
                                "pgomez@pruebas.com", "234567890"));
        personas.add(new Persona("34567890C", "Ana", "Martinez", 
                                "amartinez@pruebas.com", "345678901"));
        personas.add(new Persona("45678901D", "Carlos", "Rodriguez", 
                                "crodriguez@pruebas.com", "456789012"));
        personas.add(new Persona("56789012E", "Laura", "Gonzalez", 
                                "lgonzalez@pruebas.com", "567890123")); 

        return personas;
    }

    public static ArrayList<Excursion> getAlgunasExcursiones() {
        ArrayList<Excursion> excursiones = new ArrayList<>();

        excursiones.add(new Excursion(Excursion.TipoDeExcursion.VISITA_HISTORICA, 
                                      "Visita a la Torre de Hércules", "A Coruña",
                                      "2020-12-01", "10:00", 25.0, 
                                      "Puerta principal de la Biblioteca Municipal"));
        excursiones.add(new Excursion(Excursion.TipoDeExcursion.CONCIERTO_MUSICAL,
                                        "Concierto de la Orquesta Sinfónica de Madrid", "Madrid",
                                        "2020-12-02", "08:00", 570.0, 
                                        "Estación de tren, andén AVE"));
                                        
        return excursiones;
    }

}
