package es.susosise.excursiones.poblaciones;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManejoDePoblaciones {

    @Autowired
    PersistenciaDePoblaciones persistencia;
    
    public ManejoDePoblaciones(PersistenciaDePoblaciones persistencia) {
        this.persistencia = persistencia;
    }
    
    public Long getCuantasHay() {
        return persistencia.count();
    }
    
    public List<Poblacion> getTodas() {
        return persistencia.findAll();
    }
    
    public Optional<Poblacion>  buscarPorCodigoPostal(String codigoPostal) {
        return persistencia.findByCodigoPostal(codigoPostal);
    }
    
    public Optional<Poblacion>  buscarPorNombre(String nombre) {
        return persistencia.findByNombre(nombre);
    }

    
    public Object buscarPorIdentificador(Long idInterno) {
        Optional<Poblacion> poblacion = persistencia.findById(idInterno);
        if (poblacion.isPresent()) {
            return poblacion.get();
        } else {
            return new Poblacion();
        }
    }
    
    //@Secured({"ROLE_CURRELA, ROLE_ADMINISTRADOR"})
    public void guardar(Poblacion poblacion) {
        if (!poblacion.getCodigoPostal().isBlank()
            && !poblacion.getNombre().isBlank()) {
            persistencia.save(poblacion);
        }
    }
    
    //@Secured({"ROLE_CURRELA, ROLE_ADMINISTRADOR"})
    public void eliminar(Poblacion poblacion) {
        persistencia.delete(poblacion);
    }

    
    public Poblacion getPoblacionParaPruebas() {
        Optional<Poblacion> poblacion = buscarPorCodigoPostal("99999");
        if (poblacion.isPresent()) {
            return poblacion.get();
        }
        else {
            throw new NoSuchElementException("La poblacion de pruebas no está registrada en la base de datos.");
        }
        
    }
    
    public void crearPoblacionesParaPruebas() {
        if(buscarPorNombre("poblacionPruebas01").isEmpty()) {
            Poblacion poblacion = new Poblacion();
            poblacion.setNombre("poblacionPruebas01");
            poblacion.setCodigoPostal("99999");
            guardar(poblacion);
        }
    }
    
}
