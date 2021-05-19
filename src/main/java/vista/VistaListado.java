package vista;

import controlador.ImplementacionControlador;
import modelo.ModeloProyecto;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VistaListado {
    private ImplementacionControlador controlador = new ImplementacionControlador();
    private VistaIndice vistaIndice;
    private VistaListado vistaListado;



    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                final VistaListado vista = new VistaListado();
                final ImplementacionControlador controlador = new ImplementacionControlador();
                final ModeloProyecto modelo = new ModeloProyecto();

                vista.setControlador(controlador);
                controlador.setModelo(modelo);
                controlador.setVistaListado(vista);
                modelo.setVistaListado(vista);

                SwingUtilities.invokeLater(() -> vista.ejecutaListadoPersonas());

            }
        });
    }


    public void setControlador(ImplementacionControlador controlador) {
        this.controlador = controlador;
    }

    public void ejecutaListadoPersonas(){
        JFrame ventana = new JFrame("Listado Personas ");

        JRadioButton participante = new JRadioButton("Personas que participan en el proyecto");
        //participante.addItemListener(e -> controlador.pulsadoListarPersona(persona.getText()));
        participante.addItemListener(e-> ventana.setVisible(false));


        JRadioButton no_participante = new JRadioButton("Personas que no participan en ninguna tarea");
        //no_participante.addItemListener(e -> controlador.pulsadoListarPersona(no_participante.getText()));
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
                vistaIndice=new VistaIndice();
                vistaIndice.ejecuta();
                ventana.setVisible(true);
            }
        });
        ventana.setVisible(true);

    }
}
