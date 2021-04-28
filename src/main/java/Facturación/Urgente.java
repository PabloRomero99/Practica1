package Facturación;

public class Urgente implements Facturacion{
    private final double urg = 0.2;

    public String nombre() { return "Urgente"; }

    @Override
    public double conseguirCoste(double coste) {
        return coste + (urg*coste); //Al ser urgente le sumamos un 20% de su precio
    }
}