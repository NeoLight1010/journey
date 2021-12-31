package journey;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import journey.alimentacion.Alimento;
import journey.alimentacion.InfoAlimentacion;
import journey.alimentacion.TipoAlimento;
import journey.dia.Emocion;
import journey.dia.InfoDia;
import journey.ejercicio.InfoEjercicio;
import journey.ejercicio.IntensidadEjercicio;
import journey.paciente.Paciente;
import journey.paciente.Sexo;

class Main {
    boolean isRunning = true;

    ArrayList<Alimento> bancoAlimentos = new ArrayList<>();
    HashMap<String, Paciente> pacientes = new HashMap<>();
    Paciente loggedInPaciente = null;

    public static void main(String[] args) {
        Main app = new Main();
        app.setup();
        app.testSetup();

        Scanner scanner = new Scanner(System.in);

        while (app.isRunning) {
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
        Paciente testPaciente = new Paciente("admin", "admin", "Anthony", "Suárez", LocalDate.parse("2003-12-20"),
                Sexo.MASCULINO, 70f, 178, "102938", "Estudiante");

        InfoAlimentacion testAlimentacion = new InfoAlimentacion();
        testAlimentacion.desayuno.put(bancoAlimentos.get(0), 10);
        testAlimentacion.desayuno.put(bancoAlimentos.get(1), 5);
        testAlimentacion.desayuno.put(bancoAlimentos.get(2), 7);

        testAlimentacion.almuerzo.put(bancoAlimentos.get(0), 8);
        testAlimentacion.almuerzo.put(bancoAlimentos.get(1), 9);
        testAlimentacion.almuerzo.put(bancoAlimentos.get(2), 5);

        testAlimentacion.merienda.put(bancoAlimentos.get(0), 6);
        testAlimentacion.merienda.put(bancoAlimentos.get(1), 10);
        testAlimentacion.merienda.put(bancoAlimentos.get(2), 2);

        testPaciente.infoDiaria.add(
                new InfoDia(LocalDate.now(), Emocion.FELIZ, new InfoEjercicio(30, IntensidadEjercicio.FUERTE),
                        testAlimentacion));

        this.pacientes.put(testPaciente.getUsername(), testPaciente);
    }
}
