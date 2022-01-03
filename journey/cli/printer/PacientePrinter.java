package journey.cli.printer;

import journey.Constantes;
import journey.paciente.Paciente;

public class PacientePrinter {
    public static void imprimirPerfilPaciente(Paciente paciente) {
        BannerPrinter.printHeader1("Información del paciente " + paciente.getUsername());

        System.out.println("Nombre: " + paciente.nombreCompleto());
        System.out.println("Fecha de nacimiento: " + paciente.getFechaNacimiento().format(Constantes.DATE_FORMATTER));
        System.out.println("Edad: " + paciente.edad() + " año(s).");
        System.out.println("Sexo: " + paciente.getSexo() + "\n");

        System.out.println("Peso: " + paciente.getPeso() + "kg");
        System.out.println("Altura: " + paciente.getAltura() + "cm\n");
        System.out.println("IMC: " + paciente.imc());

        System.out.println("Número de contacto: " + paciente.getNumeroContacto());
        System.out.println("Ocupación: " + paciente.getOcupacion() + "\n");

        BannerPrinter.printHeader2("Información de diagnóstico");
        System.out.println("- IMC: " + paciente.diagnosticoIMC());
        System.out.println("- Calorías diarias recomendadas: [" + paciente.idealCaloriasDiariasMinimo() + ", " + paciente.idealCaloriasDiariasMaximo() + "]");
    }
}
