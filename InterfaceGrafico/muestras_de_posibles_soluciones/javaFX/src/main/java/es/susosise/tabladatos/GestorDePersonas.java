package es.susosise.tabladatos;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

public class GestorDePersonas {
    //TODO _pendiente_ Esta clase se encargará de interactuar con la base de datos para guardar/recuperar datos de personas.

    public DatosPersona crearUnaNueva(String DNI, String Nombre, String Apellidos) {
        DatosPersona personaCreada = new DatosPersona(DNI, Nombre, Apellidos);
        personaCreada.asignarleUnUUID();
        return personaCreada;
    }

    public List<DatosPersona> getAlgunasPersonasParaPruebas() {
        ArrayList<DatosPersona> personas = new ArrayList<>();

        DatosPersona unaPersona = crearUnaNueva("123456789F", "Benzirpi", "Mirvento Sartinelli");
        unaPersona.setFechaDeNacimiento(LocalDate.of(1970, 11, 23));
        personas.add(unaPersona);

        DatosPersona otraPersona = crearUnaNueva("987654321K", "Rigoberta", "Lirtine Waltztorrei");
        otraPersona.setFechaDeNacimiento(LocalDate.of(1973, 4, 17));
        personas.add(otraPersona);

        DatosPersona otramas = crearUnaNueva("192837465C", "Godofredo", "Riuwtz");
        otramas.setFechaDeNacimiento(LocalDate.of(1982, 1, 13));
        personas.add(otramas);

        DatosPersona unacuarta = crearUnaNueva("918273645W", "Hatz", "Quevinet Valrt");
        unacuarta.setFechaDeNacimiento(LocalDate.of(1977, 7, 17));
        personas.add(unacuarta);

        return personas;
    }
}
