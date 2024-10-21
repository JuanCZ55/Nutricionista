package Modelo;

import java.util.ArrayList;

public class MenuDiario {
private int idMenu;    
private int dia;
private ArrayList <RenglonDeMenu> comidas;
private int caloriasDelMenu;
private Dieta dieta;
private boolean estado;

    public MenuDiario() {
    }

    public MenuDiario(int dia, ArrayList<RenglonDeMenu> comidas, int caloriasDelMenu, Dieta dieta) {
        this.dia = dia;
        this.comidas = comidas;
        this.caloriasDelMenu = caloriasDelMenu;
        this.dieta = dieta;
    }

    public MenuDiario(int dia, ArrayList<RenglonDeMenu> comidas, int caloriasDelMenu, Dieta dieta, boolean estado) {
        this.dia = dia;
        this.comidas = comidas;
        this.caloriasDelMenu = caloriasDelMenu;
        this.dieta = dieta;
        this.estado = estado;
    }

    public MenuDiario(int idMenu, int dia, ArrayList<RenglonDeMenu> comidas, int caloriasDelMenu, Dieta dieta, boolean estado) {
        this.idMenu = idMenu;
        this.dia = dia;
        this.comidas = comidas;
        this.caloriasDelMenu = caloriasDelMenu;
        this.dieta = dieta;
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

    public ArrayList<RenglonDeMenu> getComidas() {
        return comidas;
    }

    public void setComidas(ArrayList<RenglonDeMenu> comidas) {
        this.comidas = comidas;
    }

    public int getCaloriasDelMenu() {
        return caloriasDelMenu;
    }

    public void setCaloriasDelMenu(int caloriasDelMenu) {
        this.caloriasDelMenu = caloriasDelMenu;
    }

    public Dieta getDieta() {
        return dieta;
    }

    public void setDieta(Dieta dieta) {
        this.dieta = dieta;
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
  
}
