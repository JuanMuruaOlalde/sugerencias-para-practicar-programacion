package cuentas_bancarias;

public class Cliente
{
    private java.util.UUID IdInterno;
    private Boolean estaActivo;
	private String DNI;
    private String nombre;
    private String apellido1;
    private String apellido2;

    private java.util.ArrayList<ModificacionDeDatos> cambios;


    public Cliente(String DNI, String nombre, String apellido1, String apellido2)
    {
    	IdInterno = java.util.UUID.randomUUID();
    	estaActivo = true;
	    this.DNI = DNI;
	    this.nombre = nombre;
	    this.apellido1 = apellido1;
	    this.apellido2 = apellido2;
        cambios = new java.util.ArrayList<>();
        cambios.add(new ModificacionDeDatos("Creación del cliente", "no datos", this.toString()));
    }

    public java.util.UUID getIdInterno() {
        return IdInterno;
    }

    public Boolean estaActivo(){
        return estaActivo;
    }
    public void activar(){
        Boolean valorAnterior = estaActivo;
        estaActivo = true;
        cambios.add(new ModificacionDeDatos("Estado de activación del cliente", valorAnterior.toString(), estaActivo.toString()));
    }
    public void desactivar(){
        Boolean valorAnterior = estaActivo;
        estaActivo = false;
        cambios.add(new ModificacionDeDatos("Estado de activación del cliente", valorAnterior.toString(), estaActivo.toString()));
    }
    
    public String getDNI() {
        return DNI;
    }
 	public void setDNI(String dni) {
        String valorAnterior = this.DNI;
		this.DNI = dni;
        cambios.add(new ModificacionDeDatos("DNI del cliente", valorAnterior, this.DNI));
	}

    public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
        String valorAnterior = this.nombre;
		this.nombre = nombre;
        cambios.add(new ModificacionDeDatos("Nombre del cliente", valorAnterior, this.nombre));
	}

	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
        String valorAnterior = this.apellido1;
		this.apellido1 = apellido1;
        cambios.add(new ModificacionDeDatos("Primer apellido del cliente", valorAnterior, this.apellido1));
	}

	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
        String valorAnterior = this.apellido2;
		this.apellido2 = apellido2;
        cambios.add(new ModificacionDeDatos("Segundo apellido del cliente", valorAnterior, this.apellido2));
	}


	@Override
    public boolean equals(Object objetoConElQueComparar)
    {
        if (objetoConElQueComparar instanceof Cliente)
        {
            Cliente clienteConElQueComparar = (Cliente)objetoConElQueComparar;
            if (clienteConElQueComparar.DNI.equals(this.DNI)
                && clienteConElQueComparar.nombre.equals(this.nombre)
                && clienteConElQueComparar.apellido1.equals(this.apellido1)
                && clienteConElQueComparar.apellido2.equals(this.apellido2)
            )
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int hash = 7;
        hash = prime * hash + DNI.hashCode();
        hash = prime * hash + nombre.hashCode();
        hash = prime * hash + apellido1.hashCode();
        hash = prime * hash + apellido2.hashCode();
        return hash;
    }


    @Override
    public String toString()
    {
        return " : " + DNI + " : " + nombre + " : " + apellido1 + " : " + apellido2 + " : ";

    }



}
