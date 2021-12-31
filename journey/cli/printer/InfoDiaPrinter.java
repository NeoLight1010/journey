package journey.cli.printer;

import journey.Constantes;
import journey.dia.InfoDia;

public class InfoDiaPrinter {
    public static void imprimirInfoDia(InfoDia infoDia) {
        BannerPrinter.printHeader1(infoDia.getFecha().format(Constantes.DATE_FORMATTER));

        System.out.println("Emoción: " + infoDia.getEmocion());

        // Ejercicio
        BannerPrinter.printHeader2("Ejercicio");

        var ejercicio = infoDia.getInfoEjercicio();
        System.out.println("Tiempo: " + ejercicio.getTiempo() + " min.");
        System.out.println("Intensidad: " + ejercicio.getIntensidad());

        // Alimentación
        BannerPrinter.printHeader2("Alimentación");
        var alimentacion = infoDia.getInfoAlimentacion();

        BannerPrinter.printHeader3("Desayuno");
        InfoComidaPrinter.imprimirInfoComida(alimentacion.desayuno);

        BannerPrinter.printHeader3("Almuerzo");
        InfoComidaPrinter.imprimirInfoComida(alimentacion.almuerzo);

        BannerPrinter.printHeader3("Merienda");
        InfoComidaPrinter.imprimirInfoComida(alimentacion.merienda);

        System.out.println("Calorías totales: " + alimentacion.caloriasTotales());
    }
}
