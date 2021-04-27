package Facturación;

public class Urgente implements Facturacion{
    public String nombre() { return "Urgente"; }

    @Override
    public double conseguirCoste(double coste) {
        return coste + (0.2*coste); //Al ser urgente le sumamos un 20% de su precio
    }
}