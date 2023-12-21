package excursiones;

import java.util.ArrayList;

public class FactoriaDeDatosParaPruebas {

    public static ArrayList<Poblacion> getAlgunasPoblaciones() {
        ArrayList<Poblacion> poblaciones = new ArrayList<>();
        
        poblaciones.add(new Poblacion("A Coruña", "15001"));
        poblaciones.add(new Poblacion("Madrid", "28001"));
        poblaciones.add(new Poblacion("Barcelona", "08001"));
        poblaciones.add(new Poblacion("Valencia", "46001"));
        poblaciones.add(new Poblacion("Sevilla", "41001"));
        poblaciones.add(new Poblacion("Zaragoza", "50001"));
        poblaciones.add(new Poblacion("Málaga", "29001"));
        poblaciones.add(new Poblacion("Murcia", "30001"));
        poblaciones.add(new Poblacion("Palma", "07001"));
        poblaciones.add(new Poblacion("Las Palmas", "35001"));
        
        return poblaciones;
    }

    public static ArrayList<Persona> getAlgunasPersonas() {
        ArrayList<Persona> personas = new ArrayList<>();

        personas.add(new Persona("12345678A", "Juan", "Perez", 
                                 new Poblacion("Málaga", "29001"), 
                           "jperez@pruebas.com", "123456789"));
        personas.add(new Persona("23456789B", "Pedro", "Gomez", 
                                new Poblacion("Madrid", "28001"), 
                                "pgomez@pruebas.com", "234567890"));
        personas.add(new Persona("34567890C", "Ana", "Martinez", 
                                new Poblacion("Barcelona", "08001"), 
                                "amartinez@pruebas.com", "345678901"));
        personas.add(new Persona("45678901D", "Carlos", "Rodriguez", 
                                new Poblacion("Valencia", "46001"), 
                                "crodriguez@pruebas.com", "456789012"));
        personas.add(new Persona("56789012E", "Laura", "Gonzalez", 
                                new Poblacion("Sevilla", "41001"), 
                                "lgonzalez@pruebas.com", "567890123")); 

        return personas;
    }

    public static ArrayList<Excursion> getAlgunasExcursiones() {
        ArrayList<Excursion> excursiones = new ArrayList<>();

        excursiones.add(new Excursion(Excursion.TipoDeExcursion.VISITA_HISTORICA, 
                                      new Poblacion("A Coruña", "15001"), 
                                      "Visita a la Torre de Hércules", 
                                      "2020-12-01", "10:00", 25.0, 
                                      new Poblacion("A Coruña", "15001"), 
                                      "Puerta principal de la Biblioteca Municipal"));
        excursiones.add(new Excursion(Excursion.TipoDeExcursion.CONCIERTO_MUSICAL,
                                        new Poblacion("Madrid", "28001"), 
                                        "Concierto de la Orquesta Sinfónica de Madrid", 
                                        "2020-12-02", "08:00", 570.0, 
                                        new Poblacion("Sevilla", "41001"), 
                                        "Estación de tren, andén AVE"));
                                        
        return excursiones;
    }

}
