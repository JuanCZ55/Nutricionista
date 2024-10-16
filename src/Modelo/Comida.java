/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author juanz
 */
public class Comida {
    private int idComida;
    private String nombre,detalle;
    private int cantCalorias;

    public Comida() {
    }

    public Comida(int idComida, String nombre, String detalle, int cantCalorias) {
        this.idComida = idComida;
        this.nombre = nombre;
        this.detalle = detalle;
        this.cantCalorias = cantCalorias;
    }

    public Comida(String nombre, String detalle, int cantCalorias) {
        this.nombre = nombre;
        this.detalle = detalle;
        this.cantCalorias = cantCalorias;
    }

    public int getIdComida() {
        return idComida;
    }

    public void setIdComida(int idComida) {
        this.idComida = idComida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getCantCalorias() {
        return cantCalorias;
    }

    public void setCantCalorias(int cantCalorias) {
        this.cantCalorias = cantCalorias;
    }
    
}
