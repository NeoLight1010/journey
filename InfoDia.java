import java.time.LocalDate;

public class InfoDia {
    private LocalDate fecha;
    private Emocion emocion;

    InfoDia(LocalDate fecha, Emocion emocion) {
        this.fecha = fecha;
        this.emocion = emocion;
    }
}
