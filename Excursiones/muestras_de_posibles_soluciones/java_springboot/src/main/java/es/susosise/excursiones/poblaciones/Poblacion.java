package es.susosise.excursiones.poblaciones;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name="poblaciones")
public class Poblacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="poblacion_id")
    private Long idInterno;

    private String nombre;
    private String codigoPostal;
    
    public Poblacion() {
    }

    public Poblacion(Long idInterno, String nombre, String codigoPostal) {
        this.idInterno = idInterno;
        this.nombre = nombre;
        this.codigoPostal = codigoPostal;
    }

    public Long getIdInterno() {
        return idInterno;
    }

    public void setIdInterno(Long idInterno) {
        this.idInterno = idInterno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

       

}
