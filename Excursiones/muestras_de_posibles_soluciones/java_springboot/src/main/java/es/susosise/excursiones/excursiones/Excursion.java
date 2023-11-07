package es.susosise.excursiones.excursiones;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import es.susosise.excursiones.personas.Persona;
import es.susosise.excursiones.poblaciones.Poblacion;

@Entity
@Table(name = "excursiones")
public class Excursion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="excursion_id")
    private Long idInterno;

    public static enum TipoDeExcursion {
        VISITA_HISTORICA,
        CONCIERTO_MUSICAL,
        ACTUACION_TEATRAL,
        RUTA_NATURAL
    }
    private TipoDeExcursion tipo;
	@OneToOne
	@JoinColumn(name="poblacion_destino", referencedColumnName="poblacion_id")
    private Poblacion poblacionDestino;
    private String descripcion;
    private String dia;
    private String hora;
    private Double coste;
	@OneToOne
	@JoinColumn(name="poblacion_origen", referencedColumnName="poblacion_id")
    private Poblacion poblacionOrigen;
    private String lugarDePartida;
    @ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
	        name = "excursion_persona",
	        joinColumns = { @JoinColumn(name="excursion_id") },
	        inverseJoinColumns = { @JoinColumn(name="persona_id") }
	)
    private Set<Persona> participantes;

    
    public void apuntarAUnaPersona(Persona persona) {
        if(!estaApuntada(persona)) {
            participantes.add(persona);
        }
    }

    public Boolean estaApuntada(Persona persona) {
        return participantes.contains(persona);
    }

    public Excursion() {
        participantes = new HashSet<>();
    }


    public Excursion(Long idInterno, TipoDeExcursion tipo, Poblacion poblacionDestino, String descripcion, String dia,
            String hora, Double coste, Poblacion poblacionOrigen, String lugarDePartida, Set<Persona> participantes) {
        this.idInterno = idInterno;
        this.tipo = tipo;
        this.poblacionDestino = poblacionDestino;
        this.descripcion = descripcion;
        this.dia = dia;
        this.hora = hora;
        this.coste = coste;
        this.poblacionOrigen = poblacionOrigen;
        this.lugarDePartida = lugarDePartida;
        this.participantes = participantes;
    }


    public Long getIdInterno() {
        return idInterno;
    }


    public void setIdInterno(Long idInterno) {
        this.idInterno = idInterno;
    }


    public TipoDeExcursion getTipo() {
        return tipo;
    }


    public void setTipo(TipoDeExcursion tipo) {
        this.tipo = tipo;
    }


    public Poblacion getPoblacionDestino() {
        return poblacionDestino;
    }


    public void setPoblacionDestino(Poblacion poblacionDestino) {
        this.poblacionDestino = poblacionDestino;
    }


    public String getDescripcion() {
        return descripcion;
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public String getDia() {
        return dia;
    }


    public void setDia(String dia) {
        this.dia = dia;
    }


    public String getHora() {
        return hora;
    }


    public void setHora(String hora) {
        this.hora = hora;
    }

    public double getCoste() {
        return coste;
    }

    public void setCoste(Double value) {
        this.coste = value;
    }

    public Poblacion getPoblacionOrigen() {
        return poblacionOrigen;
    }


    public void setPoblacionOrigen(Poblacion poblacionOrigen) {
        this.poblacionOrigen = poblacionOrigen;
    }


    public String getLugarDePartida() {
        return lugarDePartida;
    }


    public void setLugarDePartida(String lugarDePartida) {
        this.lugarDePartida = lugarDePartida;
    }


    public Set<Persona> getParticipantes() {
        return participantes;
    }


    public void setParticipantes(Set<Persona> participantes) {
        this.participantes = participantes;
    }

    
}
