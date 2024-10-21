package Modelo;

public class Alimento {

    private int idAlimento;
    private String nombre;
    private String tipoComida;
    private int caloriasX100gr;
    private String detalle;
    private boolean estado;

    public Alimento() {
    }

    public Alimento(String nombre, String tipoComida, int caloriasX100gr, String detalle) {
        this.nombre = nombre;
        this.tipoComida = tipoComida;
        this.caloriasX100gr = caloriasX100gr;
        this.detalle = detalle;
    }

    public Alimento(String nombre, String tipoComida, int caloriasX100gr, String detalle, boolean estado) {
        this.nombre = nombre;
        this.tipoComida = tipoComida;
        this.caloriasX100gr = caloriasX100gr;
        this.detalle = detalle;
        this.estado = estado;
    }

    public Alimento(int idAlimento, String nombre, String tipoComida, int caloriasX100gr, String detalle, boolean estado) {
        this.idAlimento = idAlimento;
        this.nombre = nombre;
        this.tipoComida = tipoComida;
        this.caloriasX100gr = caloriasX100gr;
        this.detalle = detalle;
        this.estado = estado;
    }

    public int getIdAlimento() {
        return idAlimento;
    }

    public void setIdAlimento(int idAlimento) {
        this.idAlimento = idAlimento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoComida() {
        return tipoComida;
    }

    public void setTipoComida(String tipoComida) {
        this.tipoComida = tipoComida;
    }

    public int getCaloriasX100gr() {
        return caloriasX100gr;
    }

    public void setCaloriasX100gr(int caloriasX100gr) {
        this.caloriasX100gr = caloriasX100gr;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Alimento{" + "nombre=" + nombre + ", tipoComida=" + tipoComida + ", caloriasX100gr=" + caloriasX100gr + '}';
    }
    

}
