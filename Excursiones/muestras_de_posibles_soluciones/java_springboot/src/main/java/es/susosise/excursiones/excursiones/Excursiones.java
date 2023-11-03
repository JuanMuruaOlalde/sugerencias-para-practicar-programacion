package es.susosise.excursiones.excursiones;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.susosise.excursiones.personas.Personas;

@Service
public class Excursiones {
    
    @Autowired
    private PersistenciaDeExcursiones persistencia;

    
    public void guardar(Excursion excursion) {
        persistencia.save(excursion);
    }

    
    // public List<Excursion> getExcursionesParaPruebas() {
    //     ArrayList<Excursion> excursionesParaPruebas = new ArrayList<>();
    //     Optional<Excursion> excursion01 = buscarPorTitulo("Paseo campestre de pruebasYexperimentos");
    //     if (excursion01.isPresent()) {
    //         excursionesParaPruebas.add(excursion01.get());
    //     }
    //     return excursionesParaPruebas;
    // }
    
    // public void crearExcursionesParaPruebas(Personas personas) {
    //     if(buscarPorTitulo("Paseo campestre de pruebasYexperimentos").isEmpty()) {
    //         Excursion excursion = new Excursion();
    //         excursion.setDescripcion("Un idílico recorrido por los prados que bordean el rio Drwasf, con merienda sobre el cesped en la ermita de Santa Dewos.");
    //         excursion.setDia("miercoles 24 Junio");
    //         excursion.setHora("10:00");
    //         excursion.setLugarDePartida("frente al ambulatorio");
    //         excursion.setParticipantes(new HashSet<>(personas.getPersonasParaPruebas()));
    //         guardar(excursion);
    //     }
    // }

    //TODO pendiente añadir mas excursiones para pruebas
    
}
