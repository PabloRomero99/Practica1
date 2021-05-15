package modelo.Tarea.Facturacion;

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
        return coste - ((dto/100)*coste); //Al ser descuento le restamos un % de su precio
    }

}
