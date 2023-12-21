package excursiones;

import java.util.ArrayList;

public class Excursion {
    private String idInterno;

    public static enum TipoDeExcursion {
        VISITA_HISTORICA,
        CONCIERTO_MUSICAL,
        ACTUACION_TEATRAL,
        RUTA_NATURAL
    }
    private TipoDeExcursion tipo;
    private Poblacion poblacionDestino;
    private String descripcion;
    private String dia;
    private String hora;
    private Double coste;
    private Poblacion poblacionOrigen;
    private String lugarDePartida;

    private ArrayList<Persona> participantes;

    
    public Excursion(TipoDeExcursion tipo, Poblacion poblacionDestino, String descripcion, 
                     String dia, String hora, Double coste, Poblacion poblacionOrigen, String lugarDePartida) {
        this.tipo = tipo;
        this.poblacionDestino = poblacionDestino;
        this.descripcion = descripcion;
        this.dia = dia;
        this.hora = hora;
        this.coste = coste;
        this.poblacionOrigen = poblacionOrigen;
        this.lugarDePartida = lugarDePartida;
        this.participantes = new ArrayList<>();
    }


    public void apuntarAUnaPersona(Persona persona) {
        if(!estaApuntada(persona)) {
            participantes.add(persona);
        }
    }

    public Boolean estaApuntada(Persona persona) {
        return participantes.contains(persona);
    }

    public Excursion() {
        participantes = new ArrayList<>();
    }



    public String getIdInterno() {
        return idInterno;
    }


    public void setIdInterno(String idInterno) {
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

    
}
