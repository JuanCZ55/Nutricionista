package Modelo;

import java.util.ArrayList;

public class MenuDiario {
private int idMenu;    
private int dia;
private ArrayList <Comidas> comidas;
private double caloriasDelMenu;
private int idDieta;
private boolean estado;

    public MenuDiario() {
    }

    public MenuDiario(int dia, ArrayList<Comidas> comidas, double caloriasDelMenu, int idDieta) {
        this.dia = dia;
        this.comidas = comidas;
        this.caloriasDelMenu = caloriasDelMenu;
        this.idDieta = idDieta;
    }

    public MenuDiario(int dia, ArrayList<Comidas> comidas, double caloriasDelMenu, int idDieta, boolean estado) {
        this.dia = dia;
        this.comidas = comidas;
        this.caloriasDelMenu = caloriasDelMenu;
        this.idDieta = idDieta;
        this.estado = estado;
    }

    public MenuDiario(int idMenu, int dia, ArrayList<Comidas> comidas, double caloriasDelMenu, int idDieta, boolean estado) {
        this.idMenu = idMenu;
        this.dia = dia;
        this.comidas = comidas;
        this.caloriasDelMenu = caloriasDelMenu;
        this.idDieta = idDieta;
        this.estado = estado;
    }

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public ArrayList<Comidas> getComidas() {
        return comidas;
    }

    public void setComidas(ArrayList<Comidas> comidas) {
        this.comidas = comidas;
    }

    public double getCaloriasDelMenu() {
        return caloriasDelMenu;
    }

    public void setCaloriasDelMenu(double caloriasDelMenu) {
        this.caloriasDelMenu = caloriasDelMenu;
    }

    public int getIdDieta() {
        return idDieta;
    }

    public void setIdDieta(int idDieta) {
        this.idDieta = idDieta;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "MenuDiario{" + "idMenu=" + idMenu + ", dia=" + dia + ", caloriasDelMenu=" + caloriasDelMenu + '}';
    }

    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
  
}
