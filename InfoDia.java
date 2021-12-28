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
}
