package Excepciones;

public class TareaNoExisteException extends Exception{
    public TareaNoExisteException(){
        super("La tarea no existe en el proyecto");
    }
}