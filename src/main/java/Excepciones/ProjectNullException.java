package Excepciones;

public class ProjectNullException extends Exception {
    public ProjectNullException(){
        super("No hemos inicializado el proyecto");
    }
}
