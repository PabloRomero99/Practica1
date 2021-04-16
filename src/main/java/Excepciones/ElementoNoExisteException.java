package Excepciones;

public class ElementoNoExisteException extends Exception{
    public ElementoNoExisteException(){
        super("La tarea no existe en el proyecto");
    }
}