package es.susosise.excursiones;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import es.susosise.excursiones.personas.Persona;
import es.susosise.excursiones.personas.ManejoDePersonas;

@SpringBootTest
public class personasTests {

    @Autowired
    private ManejoDePersonas personas;

    @Test
    void noSeGuardanPersonasConNombreOApellidosEnBlanco() {
        Persona persona = new Persona();
        persona.setNombre("");
        persona.setApellidos("algo");
        assertThrows(IllegalArgumentException.class, () -> personas.guardar(persona));
        persona.setNombre("algo");
        persona.setApellidos("");
        assertThrows(IllegalArgumentException.class, () -> personas.guardar(persona));
        persona.setNombre("");
        persona.setApellidos("");
        assertThrows(IllegalArgumentException.class, () -> personas.guardar(persona));
    }
    
}
