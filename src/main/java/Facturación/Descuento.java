package Facturación;

public class Descuento implements Facturacion{
    public String nombre() { return "Descuento"; }

    @Override
    public double conseguirCoste(double coste) {
        return coste - (0.1*coste); //Al ser descuento le restamos un 10% de su precio
    }

}
