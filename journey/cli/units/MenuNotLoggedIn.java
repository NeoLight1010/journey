package journey.cli.units;

import java.util.Scanner;

import journey.Input;
import journey.Main;
import journey.cli.Unit;
import journey.cli.printer.BannerPrinter;
import journey.cli.units.notLoggedIn.IniciarSesion;
import journey.cli.units.notLoggedIn.RegistrarUsuario;

public class MenuNotLoggedIn implements Unit {
    public void display(Main app, Scanner scanner) {
        BannerPrinter.printHeader1("Menú Principal");
        System.out.println("1. Iniciar sesión.");
        System.out.println("2. Registrarse.");
        System.out.println("3. Salir.");

        int opcion = Input.leerEnteroEntre(scanner, ": ", 1, 3);

        switch (opcion) {
            case 1:
                new IniciarSesion().display(app, scanner);
                break;
            case 2:
                new RegistrarUsuario().display(app, scanner);
                break;
            case 3:
                System.out.println("¡Gracias por usar Journey!");
                app.isRunning = false;
                return;
            default:
                break;
        }
    }
}
