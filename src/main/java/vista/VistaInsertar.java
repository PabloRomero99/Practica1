package vista;

import controlador.Controlador;
import controlador.ImplementacionControlador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VistaInsertar extends JFrame implements Vista{
    private JTextField nombreProyecto;
    private VistaIndice vistaIndice;
    private static String ACEPTAR = "ACEPTAR";
    private JTextField clave;
    private JTextField nTarea;

    private VistaInsertarEliminar vistaInsertarEliminar;
    private Controlador controlador = new ImplementacionControlador();

    public void setControlador(Controlador controlador){
        this.controlador=controlador;
    }

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
                vistaInsertarEliminar=new VistaInsertarEliminar();
                vistaInsertarEliminar.ejecuta();
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
                vistaInsertarEliminar=new VistaInsertarEliminar();
                vistaInsertarEliminar.ejecuta();
                ventana.setVisible(true);
            }
        });
        ventana.setVisible(true);
    }

    public void insertarEtiqueta(){

    }

    public void insertarResponsable(){

    }

    public String getNombreProyecto(){
        return "nombreProyecto";
    }

}
