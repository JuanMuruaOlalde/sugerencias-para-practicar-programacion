package excursiones;

import java.util.ArrayList;
import java.util.HashMap;

public class GestorDeExcursiones {

    HashMap<String, Persona> personas;
    ArrayList<Excursion> excursiones;

    public GestorDeExcursiones() {
        personas = new HashMap<>();
        excursiones = new ArrayList<>();
    }



    public String añadirPersona(Persona persona) {
        if (personas.containsKey(persona.getDni_cedula_pasaporte_o_similar())) {
            return "Ya existe una persona con ese DNI.";
        } else {
            personas.put(persona.getDni_cedula_pasaporte_o_similar(), persona);
            return "Se ha añadido la pesona.";
        }
    }

    public ArrayList<Persona> getTodasLasPersonas() {
        ArrayList<Persona> todasLasPersonas = new ArrayList<>();
        for(Persona persona : personas.values()) {
            todasLasPersonas.add(persona);
        }
        return todasLasPersonas;
    }

    public void añadirExcursion(Excursion excursion) {
        excursiones.add(excursion);
    }
    
}
