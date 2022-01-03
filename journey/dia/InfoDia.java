package journey.dia;

import java.time.LocalDate;

import journey.alimentacion.InfoAlimentacion;
import journey.ejercicio.InfoEjercicio;

public class InfoDia {
    private LocalDate fecha;
    private Emocion emocion;
    private InfoEjercicio infoEjercicio;
    private InfoAlimentacion infoAlimentacion;

    public InfoDia(LocalDate fecha, Emocion emocion, InfoEjercicio infoEjercicio, InfoAlimentacion infoAlimentacion) {
        this.fecha = fecha;
        this.emocion = emocion;
        this.infoEjercicio = infoEjercicio;
        this.infoAlimentacion = infoAlimentacion;
    }

    // Getters and setters
    public LocalDate getFecha() {
        return this.fecha;
    }

    public Emocion getEmocion() {
        return this.emocion;
    }

    public InfoEjercicio getInfoEjercicio() {
        return this.infoEjercicio;
    }

    public InfoAlimentacion getInfoAlimentacion() {
        return this.infoAlimentacion;
    }
}
