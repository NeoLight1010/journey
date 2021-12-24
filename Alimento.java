public class Alimento {
    private String nombre;
    private float caloriasPorPorcion;
    private TipoAlimento tipo;

    Alimento(String nombre, float caloriasPorPorcion, TipoAlimento tipo) {
        this.nombre = nombre;
        this.caloriasPorPorcion = caloriasPorPorcion;
        this.tipo = tipo;
    }

    public String toString() {
        return this.nombre;
    }

    public String getNombre() {
        return this.nombre;
    }
}
