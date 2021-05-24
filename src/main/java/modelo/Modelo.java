package modelo;

import modelo.Tarea.Tarea;

import java.util.List;

public interface Modelo {
    void iniciaProyecto(String nombreProyecto);

    void pulsadorJRadioButton(String actionCommand);

    void darAltaPersona(String nombre, String dni, String correo);

    void darAltaTarea(String titulotarea, String descrip, int priority, double coste, double descuento);

    void pulsandoAceptar(String acctionCommand, String nomTarea);

    void pulsandoInsertar(String actionCommand) throws Exception;

    void insertandoColaborador(String clave) throws Exception;

    void pulsandoEliminar(String actionCommand);

    void pulsadoListarPersona(String actionCommand);

    void finalizarProyecto();

    String[] conseguirListado(String cadena);

    void pulsadoListarTareas(String text);

    void marcarFinalizada(int index);

    void consultarPrecio();
}