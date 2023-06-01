package es.susosise.tabladatos;

// Muchas gracias a Marco Jakob por compartir conocimiento y recursos con la comunidad.
// Este código tiene muchos elementos de este tutorial:
// https://code.makery.ch/es/library/javafx-tutorial/part2/

import java.time.LocalDate;

import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class DatosPersona {

    private java.util.UUID id;
    private StringProperty DNI;
    private StringProperty nombre;
    private StringProperty apellidos;
    private ObjectProperty<LocalDate> fechaDeNacimiento;
    
    public DatosPersona(String DNI, String Nombre, String Apellidos) {
        this.id = null;
        this.DNI = new SimpleStringProperty(DNI);
        this.nombre = new SimpleStringProperty(Nombre);
        this.apellidos = new SimpleStringProperty(Apellidos);
        this.fechaDeNacimiento = new SimpleObjectProperty<LocalDate>();
    }

    public java.util.UUID getId() {
        return id;
    }

    public void asignarleUnUUID() {
        if (this.id == null) {
            this.id = java.util.UUID.randomUUID();
        }
    }

    public String getDNI() {
        return DNI.get();
    }
    public StringProperty dNIProperty() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI.set(DNI);
    }

    public String getNombre() {
        return nombre.get();
    }
    public StringProperty nombreProperty() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public String getApellidos() {
        return apellidos.get();
    }
    public StringProperty apellidosProperty() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos.set(apellidos);
    }

    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento.get();
    }
    public ObjectProperty<LocalDate> fechaDeNacimientoProperty() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
        this.fechaDeNacimiento.set(fechaDeNacimiento);
    }


    @Override
    public String toString() {
        return getNombre() + " " + getApellidos();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((DNI == null) ? 0 : getDNI().hashCode());
        result = prime * result + ((nombre == null) ? 0 : getNombre().hashCode());
        result = prime * result + ((apellidos == null) ? 0 : getApellidos().hashCode());
        result = prime * result + ((fechaDeNacimiento == null) ? 0 : getFechaDeNacimiento().hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DatosPersona other = (DatosPersona) obj;
        if (DNI == null) {
            if (other.DNI != null)
                return false;
        } else if (!getDNI().equals(other.getDNI()))
            return false;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!getNombre().equals(other.getNombre()))
            return false;
        if (apellidos == null) {
            if (other.apellidos != null)
                return false;
        } else if (!getApellidos().equals(other.getApellidos()))
            return false;
        if (fechaDeNacimiento == null) {
            if (other.fechaDeNacimiento != null)
                return false;
        } else if (!getFechaDeNacimiento().equals(other.getFechaDeNacimiento()))
            return false;
        return true;
    }

}
