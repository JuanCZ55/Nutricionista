/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author juanz
 */
public class Dieta {

    private int idDieta;
    private String nombreD;
    private ArrayList<MenuDiario> Menus;
    private LocalDate fechaIni;
    private LocalDate fechaFin;
    private double pesoInicial;
    private double pesoFinal;
    private int totalCalorias;
    private Paciente paciente;
    private boolean estado;

    public Dieta() {
    }

    public Dieta(String nombreD, ArrayList<MenuDiario> Menus, LocalDate fechaIni, LocalDate fechaFin, double pesoInicial, double pesoFinal, int totalCalorias, Paciente paciente) {
        this.nombreD = nombreD;
        this.Menus = Menus;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.pesoInicial = pesoInicial;
        this.pesoFinal = pesoFinal;
        this.totalCalorias = totalCalorias;
        this.paciente = paciente;
    }

    public Dieta(String nombreD, ArrayList<MenuDiario> Menus, LocalDate fechaIni, LocalDate fechaFin, double pesoInicial, double pesoFinal, int totalCalorias, Paciente paciente, boolean estado) {
        this.nombreD = nombreD;
        this.Menus = Menus;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.pesoInicial = pesoInicial;
        this.pesoFinal = pesoFinal;
        this.totalCalorias = totalCalorias;
        this.paciente = paciente;
        this.estado = estado;
    }

    public Dieta(int idDieta, String nombreD, ArrayList<MenuDiario> Menus, LocalDate fechaIni, LocalDate fechaFin, double pesoInicial, double pesoFinal, int totalCalorias, Paciente paciente, boolean estado) {
        this.idDieta = idDieta;
        this.nombreD = nombreD;
        this.Menus = Menus;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.pesoInicial = pesoInicial;
        this.pesoFinal = pesoFinal;
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
        return Menus;
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

    public double getPesoInicial() {
        return pesoInicial;
    }

    public void setPesoInicial(double pesoInicial) {
        this.pesoInicial = pesoInicial;
    }

    public double getPesoFinal() {
        return pesoFinal;
    }

    public void setPesoFinal(double pesoFinal) {
        this.pesoFinal = pesoFinal;
    }

    public int getTotalCalorias() {
        return totalCalorias;
    }

    public void setTotalCalorias(int totalCalorias) {
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

}
