package cuentas_bancarias;

import java.util.HashMap;

public final class FactoriaDeDatosParaPruebas {

    public static HashMap<String, Cliente> getAlgunosClientesParaPruebas() {
        HashMap<String, Cliente> clientes = new HashMap<>();
        clientes.put("12345678R", new Cliente("12345678R", "Benzirpi", "Mirvento", "Riverti"));
        clientes.put("11223344H", new Cliente("11223344H", "Maria", "Vimter", "Lecturm"));
        clientes.put("12123123Z", new Cliente("12123123Z", "Luis", "Erixar", "Walrtimo"));
        clientes.put("12341234T", new Cliente("12341234T", "Ana", "Baquirt", "Jomfite"));
        return clientes;
    }

    public static void crearCuentasDePruebaEnUnBanco(Banco unBanco, HashMap<String, Cliente> algunosClientesParaPruebas) {
        for (Cliente cliente : algunosClientesParaPruebas.values()) {
            unBanco.darDeAltaUnNuevoCliente(cliente);
            //unBanco.asignarUnaCuentaAUnCliente(unBanco.crearUnaNuevaCuenta(), cliente);
        }
    }


}
