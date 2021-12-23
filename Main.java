import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;

class Main {
    HashMap<String, Paciente> pacientes = new HashMap<>();

    public static void main(String[] args) {
        Main app = new Main();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menú principal");
            System.out.println("1. Iniciar sesión.");
            System.out.println("2. Registrarse.");

            int opcion = Input.leerEntero(scanner, ": ");

            switch (opcion) {
                case 1:
                    app.iniciarSesion(scanner);
                    break;
                case 2:
                    app.registrarUsuario(scanner);
                    break;
                default:
                    break;
            }
        }
    }

    private void imprimirErrorInicioSesion() {
        System.out.println("Nombre de usuario o contraseña inválida.");
    }

    public void iniciarSesion(Scanner scanner) {
        String username = Input.leerString(scanner, "Nombre de usuario: ");
        String password = Input.leerString(scanner, "Contraseña: ");

        // Si el usuario no existe o contraseña es inválida.
        if (!this.pacientes.containsKey(username) || 
            !this.pacientes.get(username).getPassword().equals(password)) {
            imprimirErrorInicioSesion();
            return;
        }

        System.out.println("¡Inicio de sesión exitoso!");
    }

    public void registrarUsuario(Scanner scanner) {
        String username = "";

        while (true) {
            username = Input.leerString(scanner, "Ingrese un nombre de usuario para el paciente:\n");

            // Si el nombre de usuario ya está ocupado.
            if (this.pacientes.containsKey(username)) {
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

        Paciente paciente = new Paciente(username, password, nombre, apellido, fechaNacimiento, sexo, peso, altura, numeroContacto, ocupacion);
        this.pacientes.put(username, paciente);

        System.out.println("¡Registro exitoso!");
    }
}
