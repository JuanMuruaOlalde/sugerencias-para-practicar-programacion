package es.susosise.excursiones;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import es.susosise.excursiones.excursiones.Excursion;
import es.susosise.excursiones.excursiones.ManejoDeExcursiones;
import es.susosise.excursiones.personas.Persona;
import es.susosise.excursiones.personas.ManejoDePersonas;

@SpringBootTest
public class excursionesTests {

    @Autowired
    private ManejoDeExcursiones excursiones;
    @Autowired
    private ManejoDePersonas personas;

    @Test
    void sePuedeApuntarUnaPersonaAUnaExcursion() {
        Persona persona = personas.getPersonaParaPruebas();
        Excursion excursion = excursiones.getExcursionParaPruebas();
        assertFalse(excursion.estaApuntada(persona));
        excursiones.apuntarPersonaAExcursion(persona, excursion);
        assertTrue(excursion.estaApuntada(persona));
    }

    
}
