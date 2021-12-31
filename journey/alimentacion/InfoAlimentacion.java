package journey.alimentacion;

public class InfoAlimentacion {
    public InfoComida desayuno = new InfoComida();
    public InfoComida almuerzo = new InfoComida();
    public InfoComida merienda = new InfoComida();

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
