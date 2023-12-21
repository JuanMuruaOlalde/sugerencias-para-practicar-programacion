package excursiones;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        GestorDeExcursiones gestor = new GestorDeExcursiones();

        ArrayList<Persona> personasParaPruebas = FactoriaDeDatosParaPruebas.getAlgunasPersonas();
        for (Persona persona : personasParaPruebas) {
            gestor.añadirPersona(persona);
        }
        ArrayList<Excursion> excursionesParaPruebas = FactoriaDeDatosParaPruebas.getAlgunasExcursiones();
        for (Excursion excursion : excursionesParaPruebas) {
            gestor.añadirExcursion(excursion);
        }

        InterfaceDeUsuario interfaz = new InterfaceDeUsuario(gestor);
        interfaz.iniciar();
    }
}
