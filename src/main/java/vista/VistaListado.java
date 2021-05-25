package vista;

import controlador.ImplementacionControlador;
import modelo.ModeloProyecto;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VistaListado {
    private ImplementacionControlador controlador = ImplementacionControlador.getInstancia();
    private VistaIndice vistaIndice;

    public void setControlador(ImplementacionControlador controlador) {
        this.controlador = controlador;
    }

    public void ejecutaListadoPersonas(){
        JFrame ventana = new JFrame("Listado Personas ");

        JRadioButton participante = new JRadioButton("Personas que participan en el proyecto");
        participante.addItemListener(e -> controlador.pulsadoListarPersona(participante.getText()));
        participante.addItemListener(e-> ventana.setVisible(false));


        JRadioButton no_participante = new JRadioButton("Personas que no son responsables de ninguna tarea");
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

    public void ejecutaListadoTareas(){
        JFrame ventana = new JFrame("Listado Tareas ");

        JRadioButton tarea = new JRadioButton("Tareas que existen en el proyecto");
        tarea.addItemListener(e -> controlador.pulsadoListarTareas(tarea.getText()));
        tarea.addItemListener(e-> ventana.setVisible(false));


        JRadioButton no_colaborador = new JRadioButton("Tareas que no tienen ningun colaborador");
        no_colaborador.addItemListener(e -> controlador.pulsadoListarTareas(no_colaborador.getText()));
        no_colaborador.addItemListener(e-> ventana.setVisible(false));


        ButtonGroup grupo = new ButtonGroup();
        grupo.add(tarea);
        grupo.add(no_colaborador);

        JPanel radio = new JPanel();
        radio.setLayout(new BoxLayout(radio, BoxLayout.PAGE_AXIS));
        radio.add(tarea);
        radio.add(no_colaborador);
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
        String[] datos = controlador.conseguirListado("persona");
        JFrame ventana = new JFrame("Listado personas del proyecto");
        JList meses = new JList(datos);
        JScrollPane panelMeses = new JScrollPane(meses);
        meses.setVisibleRowCount(4);
        meses.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        ventana.getContentPane().add(panelMeses);
        ventana.pack();
        ventana.setVisible(true);
        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                vistaIndice=vistaIndice.getInstancia();
                vistaIndice.ejecuta();
                ventana.setVisible(true);
            }
        });
    }

    public void mostrarListadoPersonasNoResponsables(){
        String[] datos = controlador.conseguirListado("personaSinResp");
        JFrame ventana = new JFrame("Listado personas que no son responsables");
        JList meses = new JList(datos);
        JScrollPane panelMeses = new JScrollPane(meses);
        meses.setVisibleRowCount(4);
        meses.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        ventana.getContentPane().add(panelMeses);
        ventana.pack();
        ventana.setVisible(true);
        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                vistaIndice=vistaIndice.getInstancia();
                vistaIndice.ejecuta();
                ventana.setVisible(true);
            }
        });
    }

    public void mostrarListadoTareas(){
        String[] datos = controlador.conseguirListado("tarea");
        JFrame ventana = new JFrame("Listado tareas del proyecto");
        JList lTareas = new JList(datos);
        JScrollPane panelTareas = new JScrollPane(lTareas);
        lTareas.setVisibleRowCount(4);
        lTareas.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        ventana.getContentPane().add(panelTareas);
        ventana.pack();
        ventana.setVisible(true);
        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                vistaIndice=vistaIndice.getInstancia();
                vistaIndice.ejecuta();
                ventana.setVisible(true);
            }
        });
    }

    public void mostrarListadoTareasSinColaboradores(){
        String[] datos = controlador.conseguirListado("tareaNoColab");
        JFrame ventana = new JFrame("Listado tareas del proyecto sin colaboradores");
        JList lTareas = new JList(datos);
        JScrollPane panelTareas = new JScrollPane(lTareas);
        lTareas.setVisibleRowCount(4);
        lTareas.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        ventana.getContentPane().add(panelTareas);
        ventana.pack();
        ventana.setVisible(true);
        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                vistaIndice=vistaIndice.getInstancia();
                vistaIndice.ejecuta();
                ventana.setVisible(true);
            }
        });
    }




}
