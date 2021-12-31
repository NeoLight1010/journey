package journey.cli.printer.infoDia;

import java.util.HashMap;

import journey.Constantes;
import journey.alimentacion.Alimento;
import journey.dia.InfoDia;
import journey.cli.printer.banner.BannerPrinter;

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
        imprimirInfoComida(alimentacion.desayuno);

        BannerPrinter.printHeader3("Almuerzo");
        imprimirInfoComida(alimentacion.almuerzo);

        BannerPrinter.printHeader3("Merienda");
        imprimirInfoComida(alimentacion.merienda);

        System.out.println("Calorías totales: " + alimentacion.caloriasTotales());
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
}
