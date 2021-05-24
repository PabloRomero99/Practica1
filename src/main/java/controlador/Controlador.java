package controlador;

import modelo.Tarea.Tarea;

import javax.swing.*;
import java.util.List;

public interface Controlador {
    void iniciaProyecto();

    void pulsadorJRadioButton(String actionCommand);

    void darAltaPersona(JTextField nombre,JTextField dni,JTextField correo);

    void darAltaTarea(JTextField titulo, JTextField descripcion, JSlider prioridad, JTextField coste,JTextField descuento);

    void pulsadoAceptar(String actionCommand, String nomTarea);

    void pulsadoInsertar(String actionCommand) throws Exception;

    void pulsadoEliminar(String actionCommand);

    void insertaColaborador(String clave) throws Exception;

    void insertaEtiqueta(String clave);

    void insertaResponsable(String clave);

    void eliminaPersona(String clave);

    void eliminaEtiqueta(String clave);

    void pulsadoListarPersona(String actionCommand);

    void finalizarProyecto();

    String[] conseguirListado(String cadena);

    void pulsadoListarTareas(String text);

    void marcarFinalizada(int index);

    void consultarPrecio();


    //void listaPersonas();
}
