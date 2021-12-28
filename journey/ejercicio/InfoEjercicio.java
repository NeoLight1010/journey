package journey.ejercicio;

public class InfoEjercicio {
    /**Duración del ejercicio en minutos.*/
    private int tiempo;
    private IntensidadEjercicio intensidad;

    public InfoEjercicio(int tiempo, IntensidadEjercicio intensidad) {
        this.tiempo = tiempo;
        this.intensidad = intensidad;
    }

    // Getters and setters

    public int getTiempo() {
        return tiempo;
    }

    public IntensidadEjercicio getIntensidad() {
        return intensidad;
    }

}
