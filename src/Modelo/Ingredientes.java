package Modelo;

import java.util.Objects;

public class Ingredientes {
    private int idIngredientes;
    private String nombre;
    private double caloriasPor100;
    private String noApto;
    private boolean estado;

    public Ingredientes() {
    }

    public Ingredientes(int idIngredientes) {
        this.idIngredientes = idIngredientes;
    }

    public Ingredientes(String nombre, double caloriasPor100, String noApto) {
        this.nombre = nombre;
        this.caloriasPor100 = caloriasPor100;
        this.noApto = noApto;
    }

    public Ingredientes(String nombre, double caloriasPor100,  String noApto, boolean estado) {
        this.nombre = nombre;
        this.caloriasPor100 = caloriasPor100;
        this.noApto = noApto;
        this.estado = estado;
    }

    public Ingredientes(int idIngredientes, String nombre, double caloriasPor100,  String noApto) {
        this.idIngredientes = idIngredientes;
        this.nombre = nombre;
        this.caloriasPor100 = caloriasPor100;
        this.noApto = noApto;
    }

    public Ingredientes(int idIngredientes, String nombre, double caloriasPor100, String noApto, boolean estado) {
        this.idIngredientes = idIngredientes;
        this.nombre = nombre;
        this.caloriasPor100 = caloriasPor100;
        this.noApto = noApto;
        this.estado = estado;
    }
    

    public int getIdIngredientes() {
        return idIngredientes;
    }

    public void setIdIngredientes(int idIngredientes) {
        this.idIngredientes = idIngredientes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCaloriasPor100() {
        return caloriasPor100;
    }

    public void setCaloriasPor100(double caloriasPor100) {
        this.caloriasPor100 = caloriasPor100;
    }

    public String getNoApto() {
        return noApto;
    }

    public void setNoApto(String noApto) {
        this.noApto = noApto;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
     @Override
    public String toString() {
        return idIngredientes+"-"+nombre+"-"+caloriasPor100+"-"+noApto;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + this.idIngredientes;
        hash = 31 * hash + Objects.hashCode(this.nombre);
        hash = 31 * hash + (int) (Double.doubleToLongBits(this.caloriasPor100) ^ (Double.doubleToLongBits(this.caloriasPor100) >>> 32));
        hash = 31 * hash + Objects.hashCode(this.noApto);
        hash = 31 * hash + (this.estado ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ingredientes other = (Ingredientes) obj;
        if (this.idIngredientes != other.idIngredientes) {
            return false;
        }
        if (Double.doubleToLongBits(this.caloriasPor100) != Double.doubleToLongBits(other.caloriasPor100)) {
            return false;
        }
        if (this.estado != other.estado) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.noApto, other.noApto);
    }
    
    
}

