package journey.cli.units.loggedIn.visualizarInfoDiaria;

import java.util.Scanner;

import journey.Main;
import journey.cli.Unit;
import journey.cli.printer.InfoDiaPrinter;

public class VisualizarTodaInfoDiaria implements Unit {
    public void display(Main app, Scanner scanner) {
        if (app.loggedInPaciente.infoDiaria.isEmpty()) {
            System.out.println("¡No hay información diaria registrada!");
            return;
        }

        for (var infoDia : app.loggedInPaciente.infoDiaria) {
            InfoDiaPrinter.imprimirInfoDia(infoDia);
        }
    }
}
