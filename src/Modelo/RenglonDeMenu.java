package Modelo;

public class RenglonDeMenu {

    private int idRenglon;
    private Alimento alimento;
    private double cantidadGrs;
    private int subtotalCalorias;

    public RenglonDeMenu(int idRenglon, Alimento alimento, double cantidadGrs, int subtotalCalorias) {
        this.idRenglon = idRenglon;
        this.alimento = alimento;
        this.cantidadGrs = cantidadGrs;
        this.subtotalCalorias = subtotalCalorias;
    }

    public RenglonDeMenu(Alimento alimento, double cantidadGrs, int subtotalCalorias) {
        this.alimento = alimento;
        this.cantidadGrs = cantidadGrs;
        this.subtotalCalorias = subtotalCalorias;
    }

    public RenglonDeMenu() {
    }

    public int getIdRenglon() {
        return idRenglon;
    }

    public void setIdRenglon(int idRenglon) {
        this.idRenglon = idRenglon;
    }

    public Alimento getAlimento() {
        return alimento;
    }

    public void setAlimento(Alimento alimento) {
        this.alimento = alimento;
    }

    public double getCantidadGrs() {
        return cantidadGrs;
    }

    public void setCantidadGrs(double cantidadGrs) {
        this.cantidadGrs = cantidadGrs;
    }

    public int getSubtotalCalorias() {
        return subtotalCalorias;
    }

    public void setSubtotalCalorias(int subtotalCalorias) {
        this.subtotalCalorias = subtotalCalorias;
    }

}
