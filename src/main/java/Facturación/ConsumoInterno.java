package Facturación;

public class ConsumoInterno implements Facturacion{

    public String nombre(){
        return "CONSUMO_INTERNO";
    }
    @Override
    public double conseguirCoste(double coste) {
        return coste; //Al ser consumo interno el precio se queda tal cual
    }
}
