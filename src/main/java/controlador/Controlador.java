package controlador;

import modelo.Tarea.Tarea;

import javax.swing.*;
import java.util.List;

public interface Controlador {
    void iniciaProyecto();

    void pulsadorJRadioButton(String actionCommand) throws Exception;

    void darAltaPersona(JTextField nombre,JTextField dni,JTextField correo);

    void darAltaTarea(JTextField titulo, JTextField descripcion, JSlider prioridad, JTextField coste,JTextField descuento);

    void pulsadoAceptar(String actionCommand, String nomTarea);

    void pulsadoInsertar(String actionCommand) throws Exception;

    void pulsadoEliminar(String actionCommand) throws Exception;

    void insertaColaborador(String clave) throws Exception;

    void insertaEtiqueta(String clave) throws Exception;

    void insertaResponsable(String clave);

    void eliminaPersona(String clave) throws Exception;

    void eliminaEtiqueta(String clave) throws Exception;

    void pulsadoListarPersona(String actionCommand);

    void finalizarProyecto();

    String[] conseguirListado(String cadena);

    void pulsadoListarTareas(String text);

    void marcarFinalizada(int index);

    void consultarPrecio();


    //void listaPersonas();
}
