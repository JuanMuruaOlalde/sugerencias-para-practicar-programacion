package excursiones;

import java.util.ArrayList;

public class Excursion {

    public static enum TipoDeExcursion {
        VISITA_HISTORICA,
        CONCIERTO_MUSICAL,
        ACTUACION_TEATRAL,
        RUTA_NATURAL
    }
    private TipoDeExcursion tipo;
    private String descripcion;
    private String dia;
    private String hora;
    private Double coste;
    private String lugarDePartida;

    private ArrayList<Persona> participantes;

    
    public Excursion(TipoDeExcursion tipo,String descripcion, String destino,  
                     String dia, String hora, Double coste, String lugarDePartida) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.dia = dia;
        this.hora = hora;
        this.coste = coste;
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


    public TipoDeExcursion getTipo() {
        return tipo;
    }


    public String getDescripcion() {
        return descripcion;
    }


    public String getDia() {
        return dia;
    }


    public String getHora() {
        return hora;
    }


    public Double getCoste() {
        return coste;
    }


    public String getLugarDePartida() {
        return lugarDePartida;
    }


    public ArrayList<Persona> getParticipantes() {
        return participantes;
    }



    
}
