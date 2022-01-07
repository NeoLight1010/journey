package journey.cli.units;

import java.util.Scanner;

import journey.Input;
import journey.Main;
import journey.cli.Unit;
import journey.cli.printer.BannerPrinter;
import journey.cli.units.loggedIn.DiagnosticoGeneralPaciente;
import journey.cli.units.loggedIn.IngresarDatosDia;
import journey.cli.units.loggedIn.VisualizarInfoDiaria;
import journey.cli.units.loggedIn.VisualizarPerfilPaciente;

public class MenuLoggedIn implements Unit {
    public void display(Main app, Scanner scanner) {
        BannerPrinter.printHeader1("Menú");
        System.out.println("1. Ingresar información de un día.");
        System.out.println("2. Visualizar información y diagnósticos diarios.");
        System.out.println("3. Visualizar perfil de paciente.");
        System.out.println("4. Diagnóstico general del paciente.");
        System.out.println("5. Cerrar sesión.");

        int opcion = Input.leerEnteroEntre(scanner, ": ", 1, 5);

        switch (opcion) {
            case 1:
                new IngresarDatosDia().display(app, scanner);
                break;
            case 2:
                new VisualizarInfoDiaria().display(app, scanner);
                break;
            case 3:
                new VisualizarPerfilPaciente().display(app, scanner);
                break;
            case 4:
                new DiagnosticoGeneralPaciente().display(app, scanner);
                break;
            default:
                app.loggedInPaciente = null;
                break;
        }
    }
}
