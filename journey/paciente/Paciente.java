package journey.paciente;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
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

    // Métodos

    /**
     * Busca un infoDia dada una fecha específica.
     *
     * Si no se encuentra, devuelve null.
     */
    public InfoDia buscarInfoDiaPorFecha(LocalDate fecha) {
        InfoDia encontrado = null;

        for (var infoDia : this.infoDiaria) {
            if (infoDia.getFecha().equals(fecha)) {
                encontrado = infoDia;
            }
        }

        return encontrado;
    }

    public String nombreCompleto() {
        return this.getPrimerNombre() + " " + this.getApellido();
    }

    public int edad() {
        return (int) ChronoUnit.YEARS.between(this.getFechaNacimiento(), LocalDate.now());
    }

    public float bmi() {
        float alturaM = (float) this.getAltura() / 100f;

        return (this.getPeso()) / (alturaM * alturaM);
    }

    // Getters and setters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public String getApellido() {
        return apellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public float getPeso() {
        return peso;
    }

    public int getAltura() {
        return altura;
    }

    public String getNumeroContacto() {
        return numeroContacto;
    }

    public String getOcupacion() {
        return ocupacion;
    }
}
