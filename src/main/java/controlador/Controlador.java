package controlador;

import javax.swing.*;

public interface Controlador {
    void iniciaProyecto();

    void pulsadoDarAlta(String actionCommand);

    void darAltaPersona(JTextField nombre,JTextField dni,JTextField correo);

    void darAltaTarea(JTextField titulo, JTextField descripcion, JSlider prioridad);

    void pulsadoInsertarEliminar();

    void insertaPersona(JTextField clave);

    void insertaEtiqueta(JTextField clave);

    void eliminaPersona(JTextField clave);

    void eliminaEtiqueta(JTextField clave);
}
