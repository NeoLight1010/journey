import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;

public class Cli {
    public static void menuNotLoggedIn(Main app, Scanner scanner) {
        System.out.println("Menú principal");
        System.out.println("1. Iniciar sesión.");
        System.out.println("2. Registrarse.");
        System.out.println("3. Salir.");

        int opcion = Input.leerEnteroEntre(scanner, ": ", 1, 3);

        switch (opcion) {
            case 1:
                cliIniciarSesion(app, scanner);
                break;
            case 2:
                cliRegistrarUsuario(app, scanner);
                break;
            case 3:
                System.out.println("¡Gracias por usar Journey!");
                app.isRunning = false;
                return;
            default:
                break;
        }
    }

    public static void menuLoggedIn(Main app, Scanner scanner) {
        System.out.println("Menú");
        System.out.println("1. Ingresar información de un día.");
        System.out.println("2. Visualizar información diaria.");
        System.out.println("3. Cerrar sesión.");

        int opcion = Input.leerEnteroEntre(scanner, ": ", 1, 3);

        switch (opcion) {
            case 1:
                cliIngresarDatosDia(app, scanner);
                break;
            case 2:
                cliVisualizarInfoDiaria(app, scanner);
                break;
            default:
                app.loggedInPaciente = null;
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

    public static void cliIngresarDatosDia(Main app, Scanner scanner) {
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

        printHeader1("DESAYUNO");
        int n = Input.leerEntero(scanner, "¿Cuántos alimentos distintos consumió en el desayuno?");

        for (int i = 0; i < n; i++) {

            Alimento alimento = Input.leerArrayListOpciones(scanner, ": ", app.bancoAlimentos);
            var porciones = Input.leerEntero(scanner, "¿Cuántas porciones de " + alimento.getNombre() + " consumió?: ");

            infoAlimentacion.desayuno.put(alimento, porciones);
        }

        printHeader1("ALMUERZO");
        n = Input.leerEntero(scanner, "¿Cuántos alimentos distintos consumió en el almuerzo?");

        for (int i = 0; i < n; i++) {
            Alimento alimento = Input.leerArrayListOpciones(scanner, ": ", app.bancoAlimentos);
            var porciones = Input.leerEntero(scanner, "¿Cuántas porciones de " + alimento.getNombre() + " consumió?: ");

            infoAlimentacion.almuerzo.put(alimento, porciones);
        }

        printHeader1("MERIENDA");
        n = Input.leerEntero(scanner, "¿Cuántos alimentos distintos consumió en la merienda?");

        for (int i = 0; i < n; i++) {
            Alimento alimento = Input.leerArrayListOpciones(scanner, ": ", app.bancoAlimentos);
            var porciones = Input.leerEntero(scanner, "¿Cuántas porciones de " + alimento.getNombre() + " consumió?: ");

            infoAlimentacion.merienda.put(alimento, porciones);
        }

        // Actualizar datos
        var infoDia = new InfoDia(fecha, emocion, infoEjercicio, infoAlimentacion);
        app.loggedInPaciente.infoDiaria.add(infoDia);

        System.out.println("¡Información diaria añadida exitosamente!");
    }

    public static void cliVisualizarInfoDiaria(Main app, Scanner scanner) {
        System.out.println("1. Visualizar toda la información diaria.");
        System.out.println("2. Visualizar información de un día especifico.");

        int opcion = Input.leerEnteroEntre(scanner, ": ", 1, 2);

        switch (opcion) {
            case 1:
                cliVisualizarTodaInfoDiaria(app, scanner);
                break;
            case 2:
                break;
        }
    }

    //

    public static void cliVisualizarTodaInfoDiaria(Main app, Scanner scanner) {
        if (app.loggedInPaciente.infoDiaria.isEmpty()) {
            System.out.println("¡No hay información diaria registrada!");
            return;
        }

        for (var infoDia : app.loggedInPaciente.infoDiaria) {
            printHeader1(infoDia.getFecha().format(Constantes.DATE_FORMATTER));

            System.out.println("Emoción: " + infoDia.getEmocion());

            // Ejercicio
            printHeader2("Ejercicio");

            var ejercicio = infoDia.getInfoEjercicio();
            System.out.println("Tiempo: " + ejercicio.getTiempo() + " min.");
            System.out.println("Intensidad: " + ejercicio.getIntensidad());

            // Alimentación
            printHeader2("Alimentación");
            var alimentacion = infoDia.getInfoAlimentacion();

            printHeader3("Desayuno");
            imprimirInfoComida(alimentacion.desayuno);

            printHeader3("Almuerzo");
            imprimirInfoComida(alimentacion.almuerzo);

            printHeader3("Merienda");
            imprimirInfoComida(alimentacion.merienda);

            System.out.println("Calorías totales: " + alimentacion.caloriasTotales());
        }
    }

    /**
     * Imprime la información de una comida del día (desayuno, almuerzo o merienda)
     * de un {@link InfoAlimentacion}.
     */
    private static void imprimirInfoComida(HashMap<Alimento, Integer> comida) {
        for (var alimento : comida.keySet()) {
            var porciones = comida.get(alimento);

            System.out.println("Nombre: " + alimento.getNombre());
            System.out.println("Tipo: " + alimento.getTipo());
            System.out.println("Porciones: " + porciones);
            System.out.println("Calorías: " + alimento.getCaloriasPorPorcion() * porciones);
            System.out.println();
        }
    }

    // Utils

    public static void printBanner(String border, String title) {
        System.out.println(border + " " + title + " " + border);
    }

    public static void printHeader1(String title) {
        printBanner("###########", title);
    }

    public static void printHeader2(String title) {
        printBanner("+++++++++++", title);
    }

    public static void printHeader3(String title) {
        printBanner("-----------", title);
    }

    // Mensajes de error

    private static void imprimirErrorInicioSesion() {
        System.out.println("Nombre de usuario o contraseña inválida.");
    }
}
