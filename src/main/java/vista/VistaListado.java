package vista;

import controlador.ImplementacionControlador;
import modelo.ModeloProyecto;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VistaListado {
    private ImplementacionControlador controlador = ImplementacionControlador.getInstancia();
    private VistaIndice vistaIndice;
    private VistaListado vistaListado;

    public void setControlador(ImplementacionControlador controlador) {
        this.controlador = controlador;
    }

    public void ejecutaListadoPersonas(){
        JFrame ventana = new JFrame("Listado Personas ");

        JRadioButton participante = new JRadioButton("Personas que participan en el proyecto");
        participante.addItemListener(e -> controlador.pulsadoListarPersona(participante.getText()));
        participante.addItemListener(e-> ventana.setVisible(false));


        JRadioButton no_participante = new JRadioButton("Personas que no participan en ninguna tarea");
        no_participante.addItemListener(e -> controlador.pulsadoListarPersona(no_participante.getText()));
        no_participante.addItemListener(e-> ventana.setVisible(false));


        ButtonGroup grupo = new ButtonGroup();
        grupo.add(participante);
        grupo.add(no_participante);

        JPanel radio = new JPanel();
        radio.setLayout(new BoxLayout(radio, BoxLayout.PAGE_AXIS));
        radio.add(participante);
        radio.add(no_participante);
        ventana.setContentPane(radio);
        ventana.pack();

        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                vistaIndice=vistaIndice.getInstancia();
                vistaIndice.ejecuta();
                ventana.setVisible(true);
            }
        });
        ventana.setVisible(true);
    }

    public void mostrarListadoPersonas(){


    }
}
