package controlador;

import javax.swing.*;

public interface Controlador {
    void iniciaProyecto();

    void pulsadoDarAlta(String actionCommand);

    void darAltaPersona(JTextField nombre,JTextField dni,JTextField correo);

    void darAltaTarea(JTextField titulo, JTextField descripcion, JSlider prioridad);

    void pulsadoAceptar(String actionCommand);

    void pulsadoInsertar(String actionCommand);

    void insertaPersona(String clave);

    void insertaEtiqueta(String clave);

    void eliminaPersona(String clave);

    void eliminaEtiqueta(String clave);
}
