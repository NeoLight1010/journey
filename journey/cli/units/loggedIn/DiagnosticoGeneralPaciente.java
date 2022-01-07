package journey.cli.units.loggedIn;

import java.util.Scanner;

import journey.Main;
import journey.cli.Unit;
import journey.cli.printer.BannerPrinter;

public class DiagnosticoGeneralPaciente implements Unit {
    public void display(Main app, Scanner scanner) {
        BannerPrinter.printHeader1("Diagnóstico general");

        BannerPrinter.printHeader2("Ejercicio");
        System.out.println("Factor de actividad: " + app.loggedInPaciente.factorActividad());
    }
}
