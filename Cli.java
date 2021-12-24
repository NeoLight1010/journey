import java.time.LocalDate;
import java.util.Scanner;

public class Cli {
    public static void menuNotLoggedIn(Main app, Scanner scanner) {
        System.out.println("Menú principal");
        System.out.println("1. Iniciar sesión.");
        System.out.println("2. Registrarse.");

        int opcion = Input.leerEnteroEntre(scanner, ": ", 1, 2);

        switch (opcion) {
            case 1:
                cliIniciarSesion(app, scanner);
                break;
            case 2:
                cliRegistrarUsuario(app, scanner);
                break;
            default:
                break;
        }
    }

    public static void menuLoggedIn(Main app, Scanner scanner) {
        System.out.println("Menú");
        System.out.println("1. Cerrar sesión.");

        int opcion = Input.leerEnteroEntre(scanner, ": ", 1, 1);

        switch (opcion) {
            case 1:
                app.loggedInPaciente = null;
                break;
            default:
                break;
        }
    }

    public static void cliIniciarSesion(Main app, Scanner scanner) {
        String username = Input.leerString(scanner, "Nombre de usuario: ");
        String password = Input.leerString(scanner, "Contraseña: ");

        // Si el usuario no existe o contraseña es inválida.
        if (!app.pacientes.containsKey(username) || !app.pacientes.get(username).getPassword().equals(password)) {
            imprimirErrorInicioSesion();
            return;
        }

        app.loggedInPaciente = app.pacientes.get(username);
        System.out.println("¡Inicio de sesión exitoso!");
    }

    public static void cliRegistrarUsuario(Main app, Scanner scanner) {
        String username = "";

        while (true) {
            username = Input.leerString(scanner, "Ingrese un nombre de usuario para el paciente:\n");

            // Si el nombre de usuario ya está ocupado.
            if (app.pacientes.containsKey(username)) {
                System.out.println("Nombre de usuario ya ocupado. Intente de nuevo.");
                continue;
            }

            break;
        }

        String password = Input.leerString(scanner, "Ingrese la contraseña del paciente:\n");

        String nombre = Input.leerString(scanner, "Ingrese el nombre del paciente:\n");
        String apellido = Input.leerString(scanner, "Ingrese el apellido del paciente:\n");
        LocalDate fechaNacimiento = Input.leerFecha(scanner, "Ingrese la fecha de nacimiento (dd-mm-yyyy):\n");

        int sexoInt = Input.leerEnteroEntre(scanner, "Ingrese el sexo del paciente (1. hombre, 2. mujer):\n", 1, 2);
        Sexo sexo = sexoInt == 1 ? Sexo.MASCULINO : Sexo.FEMENINO;

        float peso = Input.leerFloat(scanner, "Ingrese el peso del paciente (en kg):\n");
        int altura = Input.leerEntero(scanner, "Ingrese la altura del paciente (en cm):\n");

        String numeroContacto = Input.leerString(scanner, "Ingrese un número de contacto:\n");
        String ocupacion = Input.leerString(scanner, "Ingrese la ocupación del paciente:\n");

        Paciente paciente = new Paciente(username, password, nombre, apellido, fechaNacimiento, sexo, peso, altura,
                numeroContacto, ocupacion);
        app.pacientes.put(username, paciente);

        System.out.println("¡Registro exitoso!");
    }

    // Mensajes de error

    private static void imprimirErrorInicioSesion() {
        System.out.println("Nombre de usuario o contraseña inválida.");
    }
}
