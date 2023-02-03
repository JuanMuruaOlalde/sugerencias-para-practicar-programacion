package ContadorAlfabetico.muestras_de_posibles_soluciones.java;

public class ContadorAlfabetico {

    String ultimoCodigoQueSeHaGenerado;

    public ContadorAlfabetico(String ultimoCodigoAPartirDelCualSeguir) {
        if (esCodigoValido(ultimoCodigoAPartirDelCualSeguir)) {
            ultimoCodigoQueSeHaGenerado = ultimoCodigoAPartirDelCualSeguir;
        } else {
            throw new IllegalArgumentException(EXPLICACION_DE_VALIDACION);
        }
    }

    public final String EXPLICACION_DE_VALIDACION = 
        "Este ContadorAlfabetico solo funciona con códigos de 4 letras."
        + "Usando alguna de estas letras (mayúsculas): BCDFGHJKLMNPQRSTVWXYZ";

    public Boolean esCodigoValido(String codigo) {
        if (codigo.length() == 4
            && codigo.matches("[BCDFGHJKLMNPQRSTVWXYZ]+")) {
            return true;
        } else {
            return false;
        }
    }

    public String getSiguiente() {
        if (ultimoCodigoQueSeHaGenerado == "ZZZZ") {
            throw new java.util.NoSuchElementException("No hay siguiente más allá de ZZZZ");
        }
        StringBuilder resultado = new StringBuilder();
        Boolean laAnteriorEraZ = true;
        StringBuilder paraInvertir = new StringBuilder(ultimoCodigoQueSeHaGenerado).reverse();
        String invertido = paraInvertir.toString();
        for(char letra : invertido.toCharArray()) {
            if (laAnteriorEraZ) {
                if(letra != 'Z') {
                    laAnteriorEraZ = false;
                }
                resultado.append(siguienteLetraDetrasDe(letra));
            } else {
                resultado.append(letra);
            }
        }
        ultimoCodigoQueSeHaGenerado = resultado.reverse().toString();
        return ultimoCodigoQueSeHaGenerado;
    }

    private char siguienteLetraDetrasDe(char letra) {
        switch (letra) {
            case 'B':
                return 'C';
            case 'C':
                return 'D';
            case 'D':
                return 'F';
            case 'F':
                return 'G';
            case 'G':
                return 'H';
            case 'H':
                return 'J';
            case 'J':
                return 'K';
            case 'K':
                return 'L';
            case 'L':
                return 'M';
            case 'M':
                return 'N';
            case 'N':
                return 'P';
            case 'P':
                return 'Q';
            case 'Q':
                return 'R';
            case 'R':
                return 'S';
            case 'S':
                return 'T';
            case 'T':
                return 'V';
            case 'V':
                return 'W';
            case 'W':
                return 'X';
            case 'X':
                return 'Y';
            case 'Y':
                return 'Z';
            case 'Z':
                return 'B';
            default:
                throw new IllegalArgumentException("La letra " + letra + " no es válida.");
        }
    }
    
}
