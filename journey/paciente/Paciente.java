package journey.paciente;

import java.time.LocalDate;
import java.util.ArrayList;

import journey.dia.InfoDia;

public class Paciente {
    private String username;
    private String password;
    private String primerNombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private Sexo sexo;
    /** Peso en kg. */
    private float peso;
    /** Altura en cm. */
    private int altura;

    private String numeroContacto;
    private String ocupacion;

    public ArrayList<InfoDia> infoDiaria = new ArrayList<>();

    public Paciente(String username, String password, String primerNombre, String apellido, LocalDate fechaNacimiento,
            Sexo sexo, float peso, int altura, String numeroContacto, String ocupacion) {
        this.username = username;
        this.password = password;

        this.primerNombre = primerNombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
        this.numeroContacto = numeroContacto;
        this.ocupacion = ocupacion;
    }

    /**Busca un infoDia dada una fecha específica.
     *
     * Si no se encuentra, devuelve null.*/
    public InfoDia buscarInfoDiaPorFecha(LocalDate fecha) {
        InfoDia encontrado = null;

        for (var infoDia : this.infoDiaria) {
            if (infoDia.getFecha().equals(fecha)) {
                encontrado = infoDia;
            }
        }

        return encontrado;
    }

    // Getters and setters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
