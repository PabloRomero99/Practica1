package Facturación;

public class Descuento implements Facturacion{
    private final double dto = 0.1;
    public String nombre() { return "Descuento"; }

    @Override
    public double conseguirCoste(double coste) {
        return coste - (dto*coste); //Al ser descuento le restamos un 10% de su precio
    }

}
