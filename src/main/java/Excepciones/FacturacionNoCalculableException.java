package Excepciones;

public class FacturacionNoCalculableException extends Exception{
    public FacturacionNoCalculableException(){super("El tipo de facturación escogido no es valido");}
}
