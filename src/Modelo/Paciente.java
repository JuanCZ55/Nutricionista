package Modelo;

import java.util.HashSet;

/**
 *
 * @author juanz
 */
public class Paciente {

    private int idPaciente;
    private String nombre;
    private int edad;
    private double altura;
    HashSet<String> condicionSalud;
    //la condicion de salud recordar usar
    //Dividir (split): Usamos split(",") para dividir el String en un array condicionSalud.split(",")
    //Unir (join): Finalmente, usamos String.join(",", condicionesList)
    // para volver a unir los elementos de la lista en una cadena cuando sea necesario guardarla.
    private double pesoActual;
    private double pesoBuscado;
    private double pesoInicial;
    private boolean estado;

    public Paciente() {
    }

    /**
     * Constructor para actualizar datos de un paciente sin información de peso.
     * Este constructor se usa para {@link PacienteData#actualizarPaciente()}.
     *
     * @param idPaciente El ID del paciente.
     * @param nombre El nombre del paciente.
     * @param edad La edad del paciente.
     * @param altura La altura del paciente en metros.
     * @param CondicionSalud Un conjunto de condiciones de salud del paciente.
     */
    public Paciente(int idPaciente, String nombre, int edad, double altura, HashSet<String> CondicionSalud) {
        this.idPaciente = idPaciente;
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
        this.condicionSalud = CondicionSalud;
    }

    /**
     * Constructor para crear un paciente.
     *
     * Este constructor se usa para un nuevo paciente para guardarPaciente()
     *
     * @param nombre El nombre del paciente.
     * @param edad La edad del paciente.
     * @param altura La altura del paciente en metros.
     * @param pesoActual El peso actual del paciente en kilogramos.
     * @param pesoBuscado El peso que el paciente desea alcanzar en kilogramos.
     * @param pesoInicial El peso inicial del paciente al comenzar el
     * tratamiento en kilogramos.
     */
    public Paciente(String nombre, int edad, double altura, HashSet<String> CondicionSalud, double pesoActual, double pesoBuscado, double pesoInicial) {
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
        this.condicionSalud = CondicionSalud;
        this.pesoActual = pesoActual;
        this.pesoBuscado = pesoBuscado;
        this.pesoInicial = pesoInicial;
    }

    public Paciente(int idPaciente, String nombre, int edad, double altura, HashSet<String> CondicionSalud, double pesoActual, double pesoBuscado, double pesoInicial, boolean estado) {
        this.idPaciente = idPaciente;
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
        this.condicionSalud = CondicionSalud;
        this.pesoActual = pesoActual;
        this.pesoBuscado = pesoBuscado;
        this.pesoInicial = pesoInicial;
        this.estado = estado;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPesoActual() {
        return pesoActual;
    }

    public void setPesoActual(double pesoActual) {
        this.pesoActual = pesoActual;
    }

    public double getPesoBuscado() {
        return pesoBuscado;
    }

    public void setPesoBuscado(double pesoBuscado) {
        this.pesoBuscado = pesoBuscado;
    }

    public HashSet<String> getCondicionSalud() {
        return condicionSalud;
    }

    public void setCondicionSalud(HashSet<String> CondicionSalud) {
        this.condicionSalud = CondicionSalud;
    }

    public double getPesoInicial() {
        return pesoInicial;
    }

    public void setPesoInicial(double pesoInicial) {
        this.pesoInicial = pesoInicial;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Id: " + idPaciente + ", " + nombre ;
    }
}
