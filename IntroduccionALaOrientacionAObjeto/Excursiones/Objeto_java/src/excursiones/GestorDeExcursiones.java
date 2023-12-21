package excursiones;

import java.util.ArrayList;
import java.util.HashMap;

public class GestorDeExcursiones {

    ContadoresParaIDs contadores;

    HashMap<String, Poblacion> poblaciones;
    HashMap<String, Persona> personas;
    HashMap<String, Excursion> excursiones;

    public GestorDeExcursiones() {
        contadores = new ContadoresParaIDs();
        poblaciones = new HashMap<>();
        personas = new HashMap<>();
        excursiones = new HashMap<>();
    }

    public void añadirPoblacion(Poblacion poblacion) {
        poblaciones.put(poblacion.getCodigoPostal(), poblacion);
    }

    public ArrayList<Poblacion> getTodasLasPoblaciones() {
        ArrayList<Poblacion> todasLasPoblaciones = new ArrayList<>();
        for(Poblacion poblacion : poblaciones.values()) {
            todasLasPoblaciones.add(poblacion);
        }
        return todasLasPoblaciones;
    }


    public String añadirPersona(Persona persona) {
        persona.setIdInterno(contadores.getSiguienteIdParaPersona());
        if (personas.containsKey(persona.getDni_cedula_pasaporte_o_similar())) {
            return "Ya existe una persona con ese DNI";
        } else {
            personas.put(persona.getDni_cedula_pasaporte_o_similar(), persona);
            return persona.getIdInterno();
        }
    }

    public ArrayList<Persona> getTodasLasPersonas() {
        ArrayList<Persona> todasLasPersonas = new ArrayList<>();
        for(Persona persona : personas.values()) {
            todasLasPersonas.add(persona);
        }
        return todasLasPersonas;
    }

    public String añadirExcursion(Excursion excursion) {
        excursion.setIdInterno(contadores.getSiguienteIdParaExcursion());
        excursiones.put(excursion.getIdInterno(), excursion);
        return excursion.getIdInterno();
    }
    
}
