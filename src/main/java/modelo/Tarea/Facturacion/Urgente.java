package modelo.Tarea.Facturacion;

public class Urgente implements Facturacion{
    private double urg;

    public Urgente(double urg){
        this.urg = urg;
    }

    public String nombre(){
        return "URGENTE";
    }

    @Override
    public double conseguirCoste(double coste) {
        return coste + ((urg/100)*coste); //Al ser urgente le sumamos un % de su precio
    }
}
