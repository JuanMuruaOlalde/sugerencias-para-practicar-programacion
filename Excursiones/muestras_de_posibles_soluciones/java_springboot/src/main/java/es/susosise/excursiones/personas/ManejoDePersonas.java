package es.susosise.excursiones.personas;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.susosise.excursiones.excursiones.Excursion.TipoDeExcursion;
import es.susosise.excursiones.poblaciones.ManejoDePoblaciones;


@Service
public class ManejoDePersonas {
    
    @Autowired
    private PersistenciaDePersonas persistencia;
    
    public Long getCuantasHay() {
        return persistencia.count();
    }

    public List<Persona> getTodas() {
        return persistencia.findAll();
    }
    
    public Optional<Persona> buscarPorNombreYApellidos(String nombre, String apellidos) {
        return persistencia.findByNombreAndApellidos(nombre, apellidos);
    }
    
    public Object buscarPorIdentificador(Long idInterno) {
        Optional<Persona> persona = persistencia.findById(idInterno);
        if (persona.isPresent()) {
            return persona.get();
        } else {
            return new Persona();
        }
    }
    
    //@Secured({"ROLE_CURRELA, ROLE_ADMINISTRADOR"})
    public void guardar(Persona persona) {
        if (!persona.getNombre().isBlank() 
            && !persona.getApellidos().isBlank()) {
            persistencia.save(persona);
        } else {
            throw new IllegalArgumentException("El nombre y apellidos no pueden estar en blanco.");
        }
    }
    
    //@Secured({"ROLE_CURRELA, ROLE_ADMINISTRADOR"})
    public void eliminar(Persona persona) {
        persistencia.delete(persona);
    }
 
    
    public Persona getPersonaParaPruebas() {
        Optional<Persona> persona = buscarPorNombreYApellidos("nombrePruebas01", "apellidosPruebas01");
        if (persona.isPresent()) {
            return persona.get();
        }else {
            throw new NoSuchElementException("El cliente de pruebas no está registrado en la base de datos.");
        }
    }
    
    public void crearPersonaParaPruebas(ManejoDePoblaciones poblaciones) {
        if(buscarPorNombreYApellidos("nombrePruebas01", "apellidosPruebas01").isEmpty()) {
            Persona persona = new Persona();
            persona.setNombre("nombrePruebas01");
            persona.setApellidos("apellidosPruebas01");
            persona.setDni_cedula_pasaporte_o_similar("documentoPruebas01");
            persona.setPoblacion(poblaciones.getPoblacionParaPruebas());
            persona.setTelefono("999-99-99-99");
            persona.setEmail("pruebas01@proveedordecorreo.es");
            persona.añadirPreferencia(TipoDeExcursion.RUTA_NATURAL);
            persona.añadirPreferencia(TipoDeExcursion.VISITA_HISTORICA);
            guardar(persona);
        }
    }
   

}
