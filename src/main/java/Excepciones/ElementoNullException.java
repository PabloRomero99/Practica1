package Excepciones;

public class ElementoNullException extends Exception{
    public ElementoNullException(){
        super("La tarea no existe dentro del proyecto ");
    }
}
