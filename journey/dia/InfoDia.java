package journey.dia;

import java.time.LocalDate;

import journey.alimentacion.InfoAlimentacion;
import journey.ejercicio.InfoEjercicio;
import journey.ejercicio.IntensidadEjercicio;

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

    public String diagnosticoDia() {
        int tiempo = this.getInfoEjercicio().getTiempo();
        var intensidad = this.getInfoEjercicio().getIntensidad();

        if (tiempo == 0)
            return "Debes realizar más ejercicio para mantenerte saludable.";

        if (tiempo < 30) {
            if (intensidad == IntensidadEjercicio.LEVE)
                return "Es una buena manera de iniciar.";
            if (intensidad == IntensidadEjercicio.MODERADO)
                return "Es una buena manera de iniciar. Solo recuerda no sobreesforzarte.";
            if (intensidad == IntensidadEjercicio.FUERTE)
                return "¡Ten cuidado! No te sobreesfuerces.";
        }

        if (tiempo <= 60) {
            if (intensidad == IntensidadEjercicio.LEVE)
                return "¡Tienes un buen ritmo! Si te sientes bien, ¡sigue así!";
            if (intensidad == IntensidadEjercicio.MODERADO)
                return "¡Continúa así! Mantienes un buen ritmo de ejercicio.";
            if (intensidad == IntensidadEjercicio.FUERTE)
                return "¡Ten cuidado! Procura bajar la intensidad.";
        }

        // Más de una hora
        if (intensidad == IntensidadEjercicio.LEVE)
            return "Si te sientes bien así, está correcto, siempre que no aumentes la intensidad.";
        if (intensidad == IntensidadEjercicio.MODERADO)
            return "¡Ten cuidado! Recuerda que calidad es antes que tiempo.";
        if (intensidad == IntensidadEjercicio.FUERTE)
            return "¡Detente ahora mismo! ¡Te estás haciendo daño!";

        return "Error de diagnóstico";
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
