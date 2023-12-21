package excursiones;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Tests {
    
    @Test
    public void seGeneraBienLosTresPrimerosIdParaPersona() {
        ContadoresParaIDs contadores = new ContadoresParaIDs();
        assertEquals("BBBC", contadores.getSiguienteIdParaPersona());
        assertEquals("BBBD", contadores.getSiguienteIdParaPersona());
        assertEquals("BBBF", contadores.getSiguienteIdParaPersona());
    }

    @Test
    public void seGeneraBienLosTresPrimerosIdParaPoblacion() {
        ContadoresParaIDs contadores = new ContadoresParaIDs();
        assertEquals("BBBC", contadores.getSiguienteIdParaPoblacion());
        assertEquals("BBBD", contadores.getSiguienteIdParaPoblacion());
        assertEquals("BBBF", contadores.getSiguienteIdParaPoblacion());
    }

    @Test
    public void seGeneraBienLosTresPrimerosIdParaExcursion() {
        ContadoresParaIDs contadores = new ContadoresParaIDs();
        assertEquals("BBBC", contadores.getSiguienteIdParaExcursion());
        assertEquals("BBBD", contadores.getSiguienteIdParaExcursion());
        assertEquals("BBBF", contadores.getSiguienteIdParaExcursion());
    }

    @Test
    public void noSePermitenPersonasConDNIRepetido() {
        GestorDeExcursiones gestor = new GestorDeExcursiones();

        Persona persona1 = new Persona("23456789B", "Pedro", "Gomez", 
                                       new Poblacion("Madrid", "28001"), 
                                 "pgomez@pruebas.com", "234567890");
        String codigoPersona1 = gestor.añadirPersona(persona1);
        assertEquals("BBBC", codigoPersona1);
        
        Persona persona2 = new Persona("23456789B", "Carlos", "Rodriguez", 
                                       new Poblacion("Valencia", "46001"), 
                                 "crodriguez@pruebas.com", "456789012");
        String codigoPersona2 = gestor.añadirPersona(persona2);
        assertEquals("Ya existe una persona con ese DNI", codigoPersona2);
    }




}    
