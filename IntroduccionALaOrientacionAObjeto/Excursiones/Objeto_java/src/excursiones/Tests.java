package excursiones;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Tests {
    
    @Test
    public void noSePermitenPersonasConDNIRepetido() {
        GestorDeExcursiones gestor = new GestorDeExcursiones();

        Persona persona1 = new Persona("23456789B", "Pedro", "Gomez", 
                                 "pgomez@pruebas.com", "234567890");
        gestor.añadirPersona(persona1);
        
        Persona persona2 = new Persona("23456789B", "Carlos", "Rodriguez", 
                                 "crodriguez@pruebas.com", "456789012");
        String codigoPersona2 = gestor.añadirPersona(persona2);
        assertEquals("Ya existe una persona con ese DNI", codigoPersona2);
    }




}    
