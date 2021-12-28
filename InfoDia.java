import java.time.LocalDate;

public class InfoDia {
    private LocalDate fecha;
    private Emocion emocion;
    private InfoEjercicio infoEjercicio;
    private InfoAlimentacion infoAlimentacion;

    InfoDia(LocalDate fecha, Emocion emocion, InfoEjercicio infoEjercicio, InfoAlimentacion infoAlimentacion) {
        this.fecha = fecha;
        this.emocion = emocion;
        this.infoEjercicio = infoEjercicio;
        this.infoAlimentacion = infoAlimentacion;
    }

    // Getters and setters
    LocalDate getFecha() {
        return this.fecha;
    }

    Emocion getEmocion() {
        return this.emocion;
    }

    InfoEjercicio getInfoEjercicio() {
        return this.infoEjercicio;
    }

    InfoAlimentacion getInfoAlimentacion() {
        return this.infoAlimentacion;
    }
}
