package journey.cli.units.loggedIn;

import java.time.LocalDate;
import java.util.Scanner;

import journey.Input;
import journey.Main;
import journey.alimentacion.Alimento;
import journey.alimentacion.InfoAlimentacion;
import journey.cli.Unit;
import journey.cli.printer.BannerPrinter;
import journey.dia.Emocion;
import journey.dia.InfoDia;
import journey.ejercicio.InfoEjercicio;
import journey.ejercicio.IntensidadEjercicio;

public class IngresarDatosDia implements Unit {
    public void display(Main app, Scanner scanner) {
        LocalDate fecha = Input.leerFecha(scanner, "Ingrese la fecha: ");
        // TODO: validar registros dobles en el mismo día.
        // NOTE: dar opción para sobreescribir registro.

        Emocion emocion = Input.leerEnum(scanner, "Ingrese la emoción predominante: ", Emocion.class);

        // Leer InfoEjercicio
        int tiempoEjercicio = Input.leerEntero(scanner, "¿Cuántos minutos de ejercicio hizo en el día?: ");

        IntensidadEjercicio intensidad = Input.leerEnum(scanner, "Ingrese la intensidad de ejercicio realizado: ",
                IntensidadEjercicio.class);

        var infoEjercicio = new InfoEjercicio(tiempoEjercicio, intensidad);

        // Leer InfoAlimentacion.
        var infoAlimentacion = new InfoAlimentacion();

        BannerPrinter.printHeader1("DESAYUNO");
        int n = Input.leerEntero(scanner, "¿Cuántos alimentos distintos consumió en el desayuno?");

        for (int i = 0; i < n; i++) {

            Alimento alimento = Input.leerArrayListOpciones(scanner, ": ", app.bancoAlimentos);
            var porciones = Input.leerEntero(scanner, "¿Cuántas porciones de " + alimento.getNombre() + " consumió?: ");

            infoAlimentacion.desayuno.put(alimento, porciones);
        }

        BannerPrinter.printHeader1("ALMUERZO");
        n = Input.leerEntero(scanner, "¿Cuántos alimentos distintos consumió en el almuerzo?");

        for (int i = 0; i < n; i++) {
            Alimento alimento = Input.leerArrayListOpciones(scanner, ": ", app.bancoAlimentos);
            var porciones = Input.leerEntero(scanner, "¿Cuántas porciones de " + alimento.getNombre() + " consumió?: ");

            infoAlimentacion.almuerzo.put(alimento, porciones);
        }

        BannerPrinter.printHeader1("MERIENDA");
        n = Input.leerEntero(scanner, "¿Cuántos alimentos distintos consumió en la merienda?");

        for (int i = 0; i < n; i++) {
            Alimento alimento = Input.leerArrayListOpciones(scanner, ": ", app.bancoAlimentos);
            var porciones = Input.leerEntero(scanner, "¿Cuántas porciones de " + alimento.getNombre() + " consumió?: ");

            infoAlimentacion.merienda.put(alimento, porciones);
        }

        // Actualizar datos
        var infoDia = new InfoDia(app.loggedInPaciente, fecha, emocion, infoEjercicio, infoAlimentacion);
        app.loggedInPaciente.infoDiaria.add(infoDia);

        System.out.println("¡Información diaria añadida exitosamente!");
    }
}
