package es.susosise.excursiones.personas;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import es.susosise.excursiones.excursiones.Excursion;
import es.susosise.excursiones.excursiones.Excursion.TipoDeExcursion;
import es.susosise.excursiones.poblaciones.Poblacion;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "personas")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="persona_id")
    private Long idInterno;
    
	private String dni_cedula_pasaporte_o_similar;
	private String nombre;
	private String apellidos;

	@OneToOne
	@JoinColumn(name="poblacion_id")
	private Poblacion poblacion;

	private String email;
	private String telefono;
	
	private ArrayList<Excursion.TipoDeExcursion> preferenciasParaExcursiones;

	@ManyToMany(mappedBy="participantes")
	private Set<Excursion> excursiones;


	public Persona() {
		preferenciasParaExcursiones = new ArrayList<>();
		excursiones = new HashSet<>();
	}

	public void añadirPreferencia(Excursion.TipoDeExcursion tipo){
		preferenciasParaExcursiones.add(tipo);
	}
	
	public Persona(Long idInterno, String dni_cedula_pasaporte_o_similar, String nombre, String apellidos,
			Poblacion poblacion, String email, String telefono, ArrayList<TipoDeExcursion> preferenciasParaExcursiones,
			Set<Excursion> excursiones) {
		this.idInterno = idInterno;
		this.dni_cedula_pasaporte_o_similar = dni_cedula_pasaporte_o_similar;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.poblacion = poblacion;
		this.email = email;
		this.telefono = telefono;
		this.preferenciasParaExcursiones = preferenciasParaExcursiones;
		this.excursiones = excursiones;
	}
	public Long getIdInterno() {
		return idInterno;
	}
	public void setIdInterno(Long id) {
		this.idInterno = id;
	}
	
	public String getDni_cedula_pasaporte_o_similar() {
		return dni_cedula_pasaporte_o_similar;
	}

	public void setDni_cedula_pasaporte_o_similar(String id) {
		this.dni_cedula_pasaporte_o_similar = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


    public Poblacion getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(Poblacion poblacion) {
        this.poblacion = poblacion;
    }
    
    public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public ArrayList<Excursion.TipoDeExcursion> getPreferenciasParaExcursiones() {
		return preferenciasParaExcursiones;
	}
	public void setPreferenciasParaExcursiones(ArrayList<Excursion.TipoDeExcursion> preferenciasParaExcursiones) {
		this.preferenciasParaExcursiones = preferenciasParaExcursiones;
	}
	public Set<Excursion> getExcursiones() {
        return excursiones;
    }

    public void setExcursiones(Set<Excursion> excursiones) {
        this.excursiones = excursiones;
    }

    public void actualizarDatos(Persona personaActualizada) {
        this.dni_cedula_pasaporte_o_similar = personaActualizada.getDni_cedula_pasaporte_o_similar();
        this.nombre = personaActualizada.getNombre();
        this.apellidos = personaActualizada.getApellidos();
        this.poblacion = personaActualizada.getPoblacion();
	}



}
