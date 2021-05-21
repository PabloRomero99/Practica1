package modelo;

public interface Modelo {
    void iniciaProyecto(String nombreProyecto);

    void pulsadorJRadioButton(String actionCommand);

    void darAltaPersona(String nombre, String dni, String correo);

    void darAltaTarea(String titulotarea, String descrip, int priority);

    void pulsandoAceptar(String acctionCommand, String nomTarea);

    void pulsandoInsertar(String actionCommand);

    void insertandoColaborador(String clave) throws Exception;

    void pulsandoEliminar(String actionCommand);

    void pulsadoListarPersona(String actionCommand);

    void finalizarProyecto();
}