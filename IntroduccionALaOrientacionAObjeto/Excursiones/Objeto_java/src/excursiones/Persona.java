package excursiones;

import java.util.ArrayList;

public class Persona {
    
	private String dni_cedula_pasaporte_o_similar;
	private String nombre;
	private String apellidos;
	private String email;
	private String telefono;
	
	private ArrayList<Excursion.TipoDeExcursion> preferenciasParaExcursiones;


	public Persona() {
		preferenciasParaExcursiones = new ArrayList<>();
	}

	public void añadirPreferencia(Excursion.TipoDeExcursion tipo){
		preferenciasParaExcursiones.add(tipo);
	}
	
	public Persona(String dni_cedula_pasaporte_o_similar, String nombre, String apellidos,
				   String email, String telefono) {
		this.dni_cedula_pasaporte_o_similar = dni_cedula_pasaporte_o_similar;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.telefono = telefono;
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

    public void actualizarDatos(Persona personaActualizada) {
        this.dni_cedula_pasaporte_o_similar = personaActualizada.getDni_cedula_pasaporte_o_similar();
        this.nombre = personaActualizada.getNombre();
        this.apellidos = personaActualizada.getApellidos();
	}



}
