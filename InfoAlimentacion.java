import java.util.HashMap;

public class InfoAlimentacion {
    HashMap<Alimento, Integer> desayuno = new HashMap<>();
    HashMap<Alimento, Integer> almuerzo = new HashMap<>();
    HashMap<Alimento, Integer> merienda = new HashMap<>();

    public float caloriasTotales() {
        float resultado = 0;

        for (var alimento : desayuno.keySet()) {
            int porciones = desayuno.get(alimento);

            resultado += alimento.getCaloriasPorPorcion() * porciones;
        }

        for (var alimento : almuerzo.keySet()) {
            int porciones = almuerzo.get(alimento);

            resultado += alimento.getCaloriasPorPorcion() * porciones;
        }

        for (var alimento : merienda.keySet()) {
            int porciones = merienda.get(alimento);

            resultado += alimento.getCaloriasPorPorcion() * porciones;
        }

        return resultado;
    }
}
