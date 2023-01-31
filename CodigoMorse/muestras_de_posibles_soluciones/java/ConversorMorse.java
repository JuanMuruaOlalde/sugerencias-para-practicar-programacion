package CodigoMorse.muestras_de_posibles_soluciones.java;

public class ConversorMorse {

    private java.util.HashMap<Character, String> tablaMorse;

    public ConversorMorse() {
        tablaMorse = new java.util.HashMap<>();
        tablaMorse.put('A', ".-");
        tablaMorse.put('B', "-...");
        tablaMorse.put('C', "-.-.-");
        tablaMorse.put('D', "-..");
        tablaMorse.put('E', ".");
        tablaMorse.put('F', "..-.");
        tablaMorse.put('G', "--.");
        tablaMorse.put('H', "....");
        tablaMorse.put('I', "..");
        tablaMorse.put('J', ".---");
        tablaMorse.put('K', "-.-");
        tablaMorse.put('L', ".-..");
        tablaMorse.put('M', "--");
        tablaMorse.put('N', "-.");
        tablaMorse.put('O', "----");
        tablaMorse.put('P', ".--.");
        tablaMorse.put('Q', "--.-");
        tablaMorse.put('R', ".-.");
        tablaMorse.put('S', "...");
        tablaMorse.put('T', "-");
        tablaMorse.put('U', "..-");
        tablaMorse.put('V', "...-");
        tablaMorse.put('W', ".--");
        tablaMorse.put('X', "-..-");
        tablaMorse.put('Y', "-.--");
        tablaMorse.put('Z', "--.");
        tablaMorse.put('1', ".----");
        tablaMorse.put('2', "..---");
        tablaMorse.put('3', "...--");
        tablaMorse.put('4', "....-");
        tablaMorse.put('5', ".....");
        tablaMorse.put('6', "-....");
        tablaMorse.put('7', "--...");
        tablaMorse.put('8', "---..");
        tablaMorse.put('9', "----.");
        tablaMorse.put('0', "-----");
        tablaMorse.put('.', ".-.-.-");
        tablaMorse.put(',', "--..--");
        tablaMorse.put(':', "---...");
        tablaMorse.put(';', "-.-.-.");
    }

    public String convertirDeTextoAMorse(String texto) {
        StringBuilder respuesta = new StringBuilder();
        StringBuilder errores = new StringBuilder();
        for(char letra : texto.toUpperCase().toCharArray()) {
            if (letra != ' ') {
                String morse = tablaMorse.get(letra);
                if (morse != null) {
                    respuesta.append(morse + "  ");
                } else {
                    errores.append(letra + "  ");
                }
            }
        }
        if (errores.length() > 0) {
            respuesta.append("   Caracteres no convertidos: " + errores.toString());
        }
        return respuesta.toString();
    } 

}
