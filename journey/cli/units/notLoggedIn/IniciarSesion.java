package journey.cli.units.notLoggedIn;

import java.util.Scanner;

import journey.cli.Cli;
import journey.Input;
import journey.Main;
import journey.cli.Unit;

public class IniciarSesion implements Unit {
    public void display(Main app, Scanner scanner) {
        String username = Input.leerString(scanner, "Nombre de usuario: ");
        String password = Input.leerString(scanner, "Contraseña: ");

        // Si el usuario no existe o contraseña es inválida.
        if (!app.pacientes.containsKey(username) || !app.pacientes.get(username).getPassword().equals(password)) {
            Cli.imprimirErrorInicioSesion();
            return;
        }

        app.loggedInPaciente = app.pacientes.get(username);
        System.out.println("¡Inicio de sesión exitoso!");
    }
}
