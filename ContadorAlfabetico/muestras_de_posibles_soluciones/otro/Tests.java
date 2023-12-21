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




}    
