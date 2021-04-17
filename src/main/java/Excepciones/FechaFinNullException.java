package Excepciones;

public class FechaFinNullException extends Exception {
    public FechaFinNullException(){
        super("La tarea ya esta finalizada ");
    }
}
