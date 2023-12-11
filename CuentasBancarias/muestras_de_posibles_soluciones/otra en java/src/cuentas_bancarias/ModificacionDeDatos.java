package cuentas_bancarias;
public class ModificacionDeDatos {

    private java.time.LocalDateTime estampaHoraria;
    private String descripcion;
    private String datosOriginales;
    private String nuevosDatos;

    public ModificacionDeDatos(String descripcion, String datosOriginales, String nuevosDatos) {
        this.estampaHoraria = java.time.LocalDateTime.now();;
        this.descripcion = descripcion;
        this.datosOriginales = datosOriginales;
        this.nuevosDatos = nuevosDatos;
    }

    public java.time.LocalDateTime getEstampaHoraria() {
        return estampaHoraria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getDatosOriginales() {
        return datosOriginales;
    }

    public String getNuevosDatos() {
        return nuevosDatos;
    }

    @Override
    public String toString() {
        return "[estampaHoraria=" + estampaHoraria + "]" + System.lineSeparator()
               + " : cambioRealizado=" + descripcion + System.lineSeparator()
               + " : datosOriginales=" + datosOriginales + System.lineSeparator()
               + " : nuevosDatos=" + nuevosDatos + System.lineSeparator();
    }

    
}
