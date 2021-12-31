package journey.cli.printer;

import java.util.HashMap;

import journey.alimentacion.Alimento;

public class InfoComidaPrinter {
    /**
     * Imprime la información de una comida del día (desayuno, almuerzo o merienda)
     * de un {@link InfoAlimentacion}.
     */
    public static void imprimirInfoComida(HashMap<Alimento, Integer> comida) {
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
