import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;

class Main {
    HashMap<String, Paciente> pacientes = new HashMap<>();
    Paciente loggedInPaciente = null;

    public static void main(String[] args) {
        Main app = new Main();
        app.testSetup();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            if (app.loggedInPaciente == null) {
                Cli.menuNotLoggedIn(app, scanner);
            } else {
                Cli.menuLoggedIn(app, scanner);
            }
        }
    }

    private void testSetup() {
        Paciente testPaciente = new Paciente("anthony", "anthony", "Anthony", "Suárez", LocalDate.parse("2003-12-20"),
                Sexo.MASCULINO, 70f, 178, "102938", "Estudiante");

        this.pacientes.put("anthony", testPaciente);
    }
}
