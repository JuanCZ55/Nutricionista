package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Dieta {

    private int idDieta;
    private String nombreD;
    private ArrayList<MenuDiario> Menus;
    private Paciente paciente;
    private LocalDate fechaIni;
    private LocalDate fechaFin;
    private double totalCalorias;
    private boolean estado;

    public Dieta() {
    }

    public Dieta(int idDieta) {
        this.idDieta = idDieta;
    }

    public Dieta(int idDieta, String nombreD, Paciente paciente, LocalDate fechaIni, LocalDate fechaFin, int totalCalorias, boolean estado) {
        this.idDieta = idDieta;
        this.nombreD = nombreD;
        this.paciente = paciente;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.totalCalorias = totalCalorias;
        this.estado = estado;
        this.Menus = new ArrayList<>();
        
    }
    
    
    public Dieta(String nombreD, ArrayList<MenuDiario> Menus, LocalDate fechaIni, LocalDate fechaFin, int totalCalorias, Paciente paciente) {
        this.nombreD = nombreD;
        this.Menus = Menus;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.totalCalorias = totalCalorias;
        this.paciente = paciente;
    }

    public Dieta(String nombreD, ArrayList<MenuDiario> Menus, LocalDate fechaIni, LocalDate fechaFin, int totalCalorias, Paciente paciente, boolean estado) {
        this.nombreD = nombreD;
        this.Menus = Menus;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.totalCalorias = totalCalorias;
        this.paciente = paciente;
        this.estado = estado;
    }

    public Dieta(int idDieta, String nombreD, ArrayList<MenuDiario> Menus, LocalDate fechaIni, LocalDate fechaFin, int totalCalorias, Paciente paciente, boolean estado) {
        this.idDieta = idDieta;
        this.nombreD = nombreD;
        this.Menus = Menus;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.totalCalorias = totalCalorias;
        this.paciente = paciente;
        this.estado = estado;
    }
    
    public int getIdDieta() {
        return idDieta;
    }

    public void setIdDieta(int idDieta) {
        this.idDieta = idDieta;
    }

    public String getNombreD() {
        return nombreD;
    }

    public void setNombreD(String nombreD) {
        this.nombreD = nombreD;
    }

    public ArrayList<MenuDiario> getMenus() {
        if (Menus == null) {
            return new ArrayList<>(); // Retorna una lista vacía en lugar de null
        }else {
            return Menus;
        }
    }

    public void setMenus(ArrayList<MenuDiario> Menus) {
        this.Menus = Menus;
    }

    public LocalDate getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(LocalDate fechaIni) {
        this.fechaIni = fechaIni;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public double getTotalCalorias() {
        return totalCalorias;
    }

    public void setTotalCalorias(double totalCalorias) {
        this.totalCalorias = totalCalorias;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return idDieta + " " + nombreD;
    }

   
}
