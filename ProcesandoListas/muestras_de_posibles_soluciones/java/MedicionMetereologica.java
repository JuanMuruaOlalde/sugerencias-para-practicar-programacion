package ProcesandoListas.muestras_de_posibles_soluciones.java;

public class MedicionMetereologica {
    private java.time.LocalDate fecha;
    private Double temperatura_max_celsius;
    private Double temperatura_min_celsius;
    private Integer humedad_max_porcentaje;
    private Integer humedad_min_porcentaje;
    private Double lluvia_litrospormetrocuadrado;
    
    public MedicionMetereologica(java.time.LocalDate fecha, 
                                 Double temperatura_max_celsius, Double temperatura_min_celsius,
                                 Integer humedad_max_porcentaje, Integer humedad_min_porcentaje, 
                                 Double lluvia_litrospormetrocuadrado) {
        this.fecha = fecha;
        this.temperatura_max_celsius = temperatura_max_celsius;
        this.temperatura_min_celsius = temperatura_min_celsius;
        this.humedad_max_porcentaje = humedad_max_porcentaje;
        this.humedad_min_porcentaje = humedad_min_porcentaje;
        this.lluvia_litrospormetrocuadrado = lluvia_litrospormetrocuadrado;
    }

    public java.time.LocalDate getFecha() {
        return fecha;
    }

    public Double getTemperatura_max_celsius() {
        return temperatura_max_celsius;
    }

    public Double getTemperatura_min_celsius() {
        return temperatura_min_celsius;
    }

    public Integer getHumedad_max_porcentaje() {
        return humedad_max_porcentaje;
    }

    public Integer getHumedad_min_porcentaje() {
        return humedad_min_porcentaje;
    }

    public Double getLluvia_litrospormetrocuadrado() {
        return lluvia_litrospormetrocuadrado;
    }

    @Override
    public String toString() {
        java.time.format.DateTimeFormatter formateador = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Mediciones del día " + fecha.format(formateador) + "\n"
                + String.format("Temperatura:  max = %.2f °C y min = %.2f °C", temperatura_max_celsius, temperatura_min_celsius) + "\n"  
                + String.format("Humedad: max = %d %% y min = %d %%", humedad_max_porcentaje, humedad_min_porcentaje) + "\n"
                + String.format("Precipitación: %.1f l/m2", lluvia_litrospormetrocuadrado);
    }

    

}
