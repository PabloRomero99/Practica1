package vista;

import controlador.ImplementacionControlador;
import modelo.ModeloProyecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VistaEliminar extends JFrame implements Vista{
    private JTextField nombreProyecto;
    private static String ACEPTAR = "ACEPTAR";
    private JTextField clave;
    private JTextField nTarea;
    private VistaIndice vistaIndice;

    private VistaEliminar vistaEliminar;
    private ImplementacionControlador controlador = ImplementacionControlador.getInstancia();

    public void setControlador(ImplementacionControlador controlador){
        this.controlador=controlador;
    }

    public void ejecuta(){
        JFrame ventana = new JFrame("Inicio");
        Panel cont = new Panel();

        nTarea = new JTextField(30);
        JLabel nomTarea = new JLabel("Nombre de la tarea donde quieres modificar: ");
        cont.setLayout(new FlowLayout());
        cont.add(nomTarea);
        cont.add(nTarea);


        String[] tareaslistado = controlador.conseguirListado("nombreTarea");
        JList tareas = new JList(tareaslistado);
        JScrollPane paneltareas = new JScrollPane(tareas);
        tareas.setVisibleRowCount(4);
        tareas.setSize(100,50);

        JButton aceptar = new JButton(ACEPTAR);
        aceptar.addActionListener(e -> controlador.pulsadoAceptar("Eliminar",nTarea.getText()));
        aceptar.addActionListener(e -> ventana.setVisible(false));

        cont.add(aceptar);
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, cont, paneltareas);
        ventana.getContentPane().add(splitPane);

        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                vistaIndice = vistaIndice.getInstancia();
                vistaIndice.ejecuta();
                ventana.setVisible(true);
            }
        });

        ventana.pack();
        ventana.setVisible(true);
    }

    public void ejecutaEliminar(){
        JFrame ventana = new JFrame("Eliminar Persona o Etiqueta ");

        JRadioButton persona = new JRadioButton("Persona");

        //controlador = new ImplementacionControlador();
        persona.addItemListener(e -> {
            try {
                controlador.pulsadoEliminar(persona.getText());
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        persona.addItemListener(e-> ventana.setVisible(false));


        JRadioButton etiqueta = new JRadioButton("Etiqueta");
        etiqueta.addItemListener(e -> {
            try {
                controlador.pulsadoEliminar(etiqueta.getText());
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        etiqueta.addItemListener(e-> ventana.setVisible(false));


        ButtonGroup grupo = new ButtonGroup();
        grupo.add(persona);
        grupo.add(etiqueta);


        JPanel radio = new JPanel();
        radio.setLayout(new BoxLayout(radio, BoxLayout.PAGE_AXIS));
        radio.add(persona);
        radio.add(etiqueta);
        ventana.setContentPane(radio);
        ventana.pack();
        //ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);

        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                vistaIndice = vistaIndice.getInstancia();
                vistaIndice.ejecuta();
                ventana.setVisible(true);
            }
        });
        ventana.setVisible(true);
    }

    public void eliminarColaborador(String[] colaboradores){
        JFrame ventana = new JFrame("Eliminar un colaborador a la tarea");
        Panel cont = new Panel();

        clave = new JTextField(30);
        cont.add(new JLabel("Introduce el DNI del colaborador: "));
        cont.add(clave);

        JButton aceptar = new JButton(ACEPTAR);
        aceptar.addActionListener(e -> {
            try {
                controlador.eliminaPersona(clave.getText());
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        aceptar.addActionListener(e-> ventana.setVisible(false));
        cont.add(aceptar);

        JList personas = new JList(colaboradores);
        JScrollPane panelPersonas = new JScrollPane(personas);
        personas.setVisibleRowCount(4);
        personas.setSize(100,50);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, cont, panelPersonas);
        ventana.getContentPane().add(splitPane);

        ventana.pack();

        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                vistaEliminar=new VistaEliminar();
                vistaEliminar.ejecutaEliminar();
                ventana.setVisible(true);
            }
        });
        ventana.setVisible(true);
    }

    public void eliminarEtiqueta(String[] etiqueta){
        JFrame ventana = new JFrame("Eliminar una etiqueta a la tarea");
        Panel cont = new Panel();

        clave = new JTextField(30);
        cont.setLayout(new FlowLayout());
        cont.add(new JLabel("Etiqueta: "));
        cont.add(clave);

        JButton aceptar = new JButton(ACEPTAR);
        aceptar.addActionListener(e -> {
            try {
                controlador.eliminaEtiqueta(clave.getText());
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        aceptar.addActionListener(e-> ventana.setVisible(false));
        cont.add(aceptar);

        JList etiquetas = new JList(etiqueta);
        JScrollPane panelEtiquetas = new JScrollPane(etiquetas);
        etiquetas.setVisibleRowCount(4);
        etiquetas.setSize(100,50);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, cont, panelEtiquetas);
        ventana.getContentPane().add(splitPane);
        ventana.pack();

        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                vistaEliminar=new VistaEliminar();
                vistaEliminar.ejecutaEliminar();
                ventana.setVisible(true);
            }
        });
        ventana.setVisible(true);
    }

    public void satisfactorio(){
        JFrame ventana = new JFrame("Todo fue correctamente");
        Container cont = ventana.getContentPane();
        cont.add(new JLabel("Todo fue correctamente"),BorderLayout.CENTER);
        ventana.setSize(200,200);
        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                vistaIndice.ejecuta();
                ventana.setVisible(true);
            }
        });
        ventana.setVisible(true);}

    public void errorTarea(){
        JFrame ventana = new JFrame("Error");
        Container cont = ventana.getContentPane();
        cont.add(new JLabel("La tarea no existe"));
        ventana.setSize(200,200);
        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                vistaIndice.ejecuta();
                ventana.setVisible(true);
            }
        });
        ventana.setVisible(true);
    }

    public void errorColaborador(){
        JFrame ventana = new JFrame("Error");
        Container cont = ventana.getContentPane();
        cont.add(new JLabel("El colaborador no existe"));
        ventana.setSize(200,200);
        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                vistaIndice.ejecuta();
                ventana.setVisible(true);
            }
        });
        ventana.setVisible(true);    }

    public void errorEtiqueta(){
        JFrame ventana = new JFrame("Error");
        Container cont = ventana.getContentPane();
        cont.add(new JLabel("No se ha podido introducir la etiqueta"));
        ventana.setSize(200,200);
        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                vistaIndice.ejecuta();
                ventana.setVisible(true);
            }
        });
        ventana.setVisible(true);    }

    @Override
    public String getNombreProyecto(){
        return "si";
    }
}
