package Facturación;

public class Descuento implements Facturacion{
    private double dto;

    public Descuento(double dto){
        this.dto = dto;
    }

    public String nombre(){
        return "DESCUENTO";
    }

    @Override
    public double conseguirCoste(double coste) {
        return coste - (dto*coste); //Al ser descuento le restamos un % de su precio
    }

}
