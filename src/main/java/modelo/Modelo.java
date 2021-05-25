package modelo;

import modelo.Tarea.Tarea;

import javax.swing.*;
import java.util.List;

public interface Modelo {
    void iniciaProyecto(String nombreProyecto);

    void pulsadorJRadioButton(String actionCommand) throws Exception;

    void darAltaPersona(String nombre, String dni, String correo);

    void darAltaTarea(String titulotarea, String descrip, int priority, double coste, double descuento);

    void pulsandoAceptar(String acctionCommand, String nomTarea);

    void pulsandoInsertar(String actionCommand) throws Exception;

    void insertandoColaborador(String clave) throws Exception;

    void insertandoEtiqueta(String etiqueta) throws Exception;

    void insertandoResponsable(String clave)throws Exception;

    void eliminandoColaborador(String clave) throws Exception;

    void eliminandoEtiqueta(String etiqueta) throws Exception;

    void pulsandoEliminar(String actionCommand) throws Exception;

    void pulsadoListarPersona(String actionCommand);

    void finalizarProyecto();

    String[] conseguirListado(String cadena);

    void pulsadoListarTareas(String text);

    void marcarFinalizada(int index,JTextField horas);

    String[] consultarPrecioPorTarea();

    double consultarPrecioTotal();

    void modificarCoste(JTextField coste,JTextField tarea) throws Exception;

    void modificarTipoFact(String dto, JTextField tarea,int tipo_fac) throws Exception;

    void realizarModificacion(int i);



}