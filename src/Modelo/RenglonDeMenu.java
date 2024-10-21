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

}
