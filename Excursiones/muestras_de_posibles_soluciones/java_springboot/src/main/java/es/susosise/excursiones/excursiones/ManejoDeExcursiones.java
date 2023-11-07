package es.susosise.excursiones.excursiones;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.susosise.excursiones.personas.Persona;
import es.susosise.excursiones.poblaciones.ManejoDePoblaciones;

@Service
public class ManejoDeExcursiones {
    
    @Autowired
    private PersistenciaDeExcursiones persistencia;


    public void apuntarPersonaAExcursion(Persona persona, Excursion excursion) {
        excursion.apuntarAUnaPersona(persona);
        guardar(excursion);
    }

   
    //@Secured({"ROLE_CURRELA, ROLE_ADMINISTRADOR"})
    public void guardar(Excursion excursion) {
        persistencia.save(excursion);
    }

    //@Secured({"ROLE_CURRELA, ROLE_ADMINISTRADOR"})
    public void eliminar(Excursion excursion) {
        persistencia.delete(excursion);
    }



    public Excursion getExcursionParaPruebas() {
        Optional<Excursion> excursion01 = persistencia.findByDescripcionContaining("Excursión para pruebas");
        if (excursion01.isPresent()) {
            return excursion01.get();
        }else {
            throw new NoSuchElementException("La excursión de pruebas no está registrada en la base de datos.");
        } 
    }   
    
    public void crearExcursionParaPruebas(ManejoDePoblaciones poblaciones) {
        if(persistencia.findByDescripcionContaining("Excursión para pruebas").isEmpty()) {
            Excursion excursion = new Excursion();
            excursion.setDescripcion("Excursión para pruebas. Un idílico recorrido por los prados que bordean el rio Drwasf, con merienda sobre el cesped en la ermita de Santa Dewos.");
            excursion.setDia("miercoles 24 Junio");
            excursion.setHora("10:00");
            excursion.setPoblacionOrigen(poblaciones.getPoblacionParaPruebas());
            excursion.setLugarDePartida("frente al ambulatorio");
            excursion.setPoblacionDestino(poblaciones.getPoblacionParaPruebas());
            excursion.setParticipantes(new HashSet<Persona>());
            guardar(excursion);
        }
    }





    
}
