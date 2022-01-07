package journey.cli.units.loggedIn;

import java.util.Scanner;

import journey.Main;
import journey.cli.Unit;
import journey.cli.printer.PacientePrinter;

public class VisualizarPerfilPaciente implements Unit {
    public void display(Main app, Scanner scanner) {
        PacientePrinter.imprimirPerfilPaciente(app.loggedInPaciente);
    }
}
