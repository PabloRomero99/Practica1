package modelo;

public interface Modelo {
    void iniciaProyecto(String nombreProyecto);

    void pulsadorDarAlta(String actionCommand);

    void darAltaPersona(String nombre, String dni, String correo);

    void darAltaTarea(String titulotarea, String descrip, int priority);

    void pulsadorAceptar(String acctionCommand);

    void pulsadorInsertar(String actionCommand);

    void pulsadorEliminar(String actionCommand);
}