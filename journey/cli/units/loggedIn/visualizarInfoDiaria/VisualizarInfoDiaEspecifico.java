package journey.cli.units.loggedIn.visualizarInfoDiaria;

import java.time.LocalDate;
import java.util.Scanner;

import journey.Constantes;
import journey.Input;
import journey.Main;
import journey.cli.Unit;
import journey.cli.printer.InfoDiaPrinter;
import journey.dia.InfoDia;

public class VisualizarInfoDiaEspecifico implements Unit {
    public void display(Main app, Scanner scanner) {
        LocalDate fecha = Input.leerFecha(scanner, "Ingrese la fecha: (" + Constantes.DATE_PATTERN + "): ");

        InfoDia infoDia = app.loggedInPaciente.buscarInfoDiaPorFecha(fecha);

        if (infoDia == null) {
            System.out.println("Información de fecha no encontrada.");
            return;
        }

        InfoDiaPrinter.imprimirInfoDia(infoDia);
    }
}
