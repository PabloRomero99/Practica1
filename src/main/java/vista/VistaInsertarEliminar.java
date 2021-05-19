package vista;

import controlador.Controlador;
import controlador.ImplementacionControlador;
import modelo.ModeloProyecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VistaInsertarEliminar extends JFrame implements Vista{
    private JTextField nombreProyecto;
    private static String ACEPTAR = "ACEPTAR";
    private JTextField clave;
    private JTextField nTarea;

    private VistaIndice vistaIndice;
    private Controlador controlador = new ImplementacionControlador();

    public void setControlador(Controlador controlador){
        this.controlador=controlador;
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                final VistaInsertarEliminar vista = new VistaInsertarEliminar();
                final ImplementacionControlador controlador = new ImplementacionControlador();
                final ModeloProyecto modelo = new ModeloProyecto();

                vista.setControlador(controlador);
                controlador.setModelo(modelo);
                controlador.setVistaInseElim(vista);
                modelo.setVistaInsertarEliminar(vista);

                SwingUtilities.invokeLater(() -> vista.ejecuta());

            }
        });
    }

    public void ejecuta(){
        JFrame ventana = new JFrame("Escoge tarea");

        Container cont = ventana.getContentPane();

        nTarea = new JTextField(30);
        cont.setLayout(new FlowLayout());
        cont.add(new JLabel("Nombre de la tarea donde quieres modificar: "));
        cont.add(nTarea);

        JButton aceptar = new JButton(ACEPTAR);
        aceptar.addActionListener(e -> controlador.pulsadoAceptarInsertarEliminar());
        aceptar.addActionListener(e -> System.out.println("El boton esta pulsado..."));
        aceptar.addItemListener(e-> ventana.setVisible(false));

        cont.add(aceptar);

        ventana.pack();
        //ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

    public void ventanaInsertarEliminar(){

        JFrame ventana = new JFrame("Insertar o Eliminar de " + nTarea);

        JRadioButton insertar = new JRadioButton("Insertar ");

        //controlador = new ImplementacionControlador();
        insertar.addItemListener(e -> controlador.pulsadoInsertarEliminar(insertar.getText()));
        insertar.addItemListener(e -> ventana.setVisible(false));

        JRadioButton eliminar = new JRadioButton("Eliminar ");
        eliminar.addItemListener(e -> controlador.pulsadoInsertarEliminar(eliminar.getText()));
        insertar.addItemListener(e -> ventana.setVisible(false));

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(insertar);
        grupo.add(eliminar);


        JPanel radio = new JPanel();
        radio.setLayout(new BoxLayout(radio, BoxLayout.PAGE_AXIS));
        radio.add(insertar);
        radio.add(eliminar);
        ventana.setContentPane(radio);

        ventana.pack();
        //ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
/*
    public void ejecutaInsertar(){
        JFrame ventana = new JFrame("Insertar Persona, Etiqueta o Responsable ");

        JRadioButton persona = new JRadioButton("Persona ");

        controlador = new ImplementacionControlador();
        persona.addItemListener(e -> controlador.pulsadoDarAlta(persona.getText()));

        JRadioButton etiqueta = new JRadioButton("Etiqueta ");

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
*/
    /*
    public void ejecutaEliminar(){
        JFrame ventana = new JFrame("Eliminar Persona o Etiqueta ");

        System.out.println("Llego aqui");
        JRadioButton persona = new JRadioButton("Persona ");

        controlador = new ImplementacionControlador();
        persona.addItemListener(e -> controlador.pulsadoDarAlta(persona.getText()));
        persona.addItemListener(e-> ventana.setVisible(false));


        JRadioButton etiqueta = new JRadioButton("Etiqueta ");
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
                vistaIndice=new VistaIndice();
                vistaIndice.ejecuta();
                ventana.setVisible(true);
            }
        });
        ventana.setVisible(true);
    }

    public void insertarPersona(){

        JFrame ventana = new JFrame("Insertar una persona en la tarea");
        Container cont = ventana.getContentPane();

        clave = new JTextField(30);
        cont.setLayout(new FlowLayout());
        cont.add(new JLabel("Nombre Persona: "));
        cont.add(clave);

        JButton aceptar = new JButton(ACEPTAR);
        //aceptar.addActionListener(e -> controlador.darAltaPersona());
        aceptar.addActionListener(e -> controlador.insertaPersona(clave));
        aceptar.addActionListener(e -> System.out.println("El boton esta pulsado..."));
        cont.add(aceptar);

        ventana.pack();
        //ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);

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

    public void insertarEtiqueta(){

    }
     */



    public void eliminarPersona(){

    }

    public void eliminarEtiqueta(){

    }


    @Override
    public String getNombreProyecto() {
        return null;
    }
}
