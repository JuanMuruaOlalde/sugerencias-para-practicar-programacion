package excursiones;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ContadoresParaIDs {
    
    private static final String ALPHABET = "BCDFGHJKLMNPQRSTVWXYZ";

    private String ultimoIdPersona;
    private String ultimoIdPoblacion;
    private String ultimoIdExcursion;

    public ContadoresParaIDs() {
        ultimoIdPersona = "BBBB";
        ultimoIdPoblacion = "BBBB";
        ultimoIdExcursion = "BBBB";
    }

    public String getUltimoIdDePersonaQueSeHaAsignado() {
        return ultimoIdPersona;
    }

    public String getSiguienteIdParaPersona() {
        ultimoIdPersona = siguienteId(ultimoIdPersona);
        return ultimoIdPersona;
    }

    public String getUltimoIdDePoblacionQueSeHaAsignado() {
        return ultimoIdPoblacion;
    }

    public String getSiguienteIdParaPoblacion() {
        ultimoIdPoblacion = siguienteId(ultimoIdPoblacion);
        return ultimoIdPoblacion;
    }   

    public String getUltimoIdDeExcursionQueSeHaAsignado() {
        return ultimoIdExcursion;
    }

    public String getSiguienteIdParaExcursion() {
        ultimoIdExcursion = siguienteId(ultimoIdExcursion);
        return ultimoIdExcursion;
    }

    private String siguienteId(String IdAnterior) {
        StringBuilder nuevoID = new StringBuilder();

        int caracter = ALPHABET.indexOf(IdAnterior.charAt(IdAnterior.length() - 1));
        Boolean avanzar = ((caracter + 1) / ALPHABET.length() == 0);

        for (int i = IdAnterior.length() - 1; i >= 0; i--) {
            caracter = ALPHABET.indexOf(IdAnterior.charAt(i));
            if (avanzar && ((caracter + 1) / ALPHABET.length() == 0)) {
                int avanzarCaracter = (caracter + 1) % ALPHABET.length();
                nuevoID.insert(0, ALPHABET.charAt(avanzarCaracter));
                avanzar = false;
            } else {
                nuevoID.insert(0, ALPHABET.charAt(caracter));
                avanzar = ((caracter + 1) / ALPHABET.length() == 1);
            }
        }
        return nuevoID.toString();
    }

    @Test
    public void seGeneraBienElSiguienteAPartirDelInicial() {
        assertEquals("BBBC", siguienteId("BBBB"));
    }
    @Test
    public void seGeneraBienElSiguienteCuandoHayQueIncrementarElSegundo() {
        assertEquals("BBCZ", siguienteId("BBBZ"));
    }
    @Test
    public void seGeneraBienElSiguienteCuandoHayQueIncrementarElTercero() {
        assertEquals("BCZZ", siguienteId("BBZZ"));
    }



}
