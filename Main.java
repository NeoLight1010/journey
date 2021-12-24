import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Main {
    ArrayList<Alimento> bancoAlimentos = new ArrayList<>();
    HashMap<String, Paciente> pacientes = new HashMap<>();
    Paciente loggedInPaciente = null;

    public static void main(String[] args) {
        Main app = new Main();
        app.setup();
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

    private void setup() {
        this.bancoAlimentos.add(new Alimento("Pan", 265, TipoAlimento.CEREAL));
        this.bancoAlimentos.add(new Alimento("Huevo", 155, TipoAlimento.PROTEINA));
        this.bancoAlimentos.add(new Alimento("Agua", 0, TipoAlimento.LIQUIDO));
    }

    private void testSetup() {
        Paciente testPaciente = new Paciente("anthony", "anthony", "Anthony", "Suárez", LocalDate.parse("2003-12-20"),
                Sexo.MASCULINO, 70f, 178, "102938", "Estudiante");

        this.pacientes.put("anthony", testPaciente);
    }
}
