package journey.cli.units.loggedIn;

import java.util.Scanner;

import journey.cli.Input;
import journey.Main;
import journey.cli.Unit;
import journey.cli.units.loggedIn.visualizarInfoDiaria.VisualizarInfoDiaEspecifico;
import journey.cli.units.loggedIn.visualizarInfoDiaria.VisualizarTodaInfoDiaria;

public class VisualizarInfoDiaria implements Unit {
    public void display(Main app, Scanner scanner) {
        System.out.println("1. Visualizar toda la información diaria.");
        System.out.println("2. Visualizar información de un día especifico.");

        int opcion = Input.leerEnteroEntre(scanner, ": ", 1, 2);

        switch (opcion) {
            case 1:
                new VisualizarTodaInfoDiaria().display(app, scanner);
                break;
            case 2:
                new VisualizarInfoDiaEspecifico().display(app, scanner);
                break;
        }
    }
}
