package modelo;

public interface Modelo {
    void iniciaProyecto(String nombreProyecto);

    void pulsadorDarAlta(int actionCommand);

    void darAltaPersona(String nombre, String dni, String correo);

    void darAltaTarea(String titulotarea, String descrip, int priority);

    void pulsadorInsertarEliminar();
}