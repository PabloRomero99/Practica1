package vista;

import controlador.Controlador;
import controlador.ImplementacionControlador;

import javax.swing.*;
import java.awt.*;

public class VistaInsertarEliminar extends JFrame implements Vista{
    private JTextField nombreProyecto;
    private static String ACEPTAR = "ACEPTAR";
    private JTextField clave;

    private VistaIndice vistaIndice;
    private Controlador controlador = new ImplementacionControlador();

    public void setControlador(Controlador controlador){
        this.controlador=controlador;
    }

    /**
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                final VistaAlta vista = new VistaAlta();
                final ImplementacionControlador controlador = new ImplementacionControlador();
                final ModeloProyecto modelo = new ModeloProyecto();

                vista.setControlador(controlador);
                controlador.setModelo(modelo);
                controlador.setVista2(vista);
                modelo.setVista2(vista);

                SwingUtilities.invokeLater(() -> vista.ejecuta());

            }
        });
    }
     */

    public void ejecuta(){

        JRadioButton insertar = new JRadioButton("Insertar ");

        //controlador = new ImplementacionControlador();
        insertar.addItemListener(e -> controlador.pulsadoDarAlta(e.getStateChange()));

        JRadioButton eliminar = new JRadioButton("Eliminar ");

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(insertar);
        grupo.add(eliminar);

        JFrame ventana = new JFrame("Insertar o Eliminar ");

        JPanel radio = new JPanel();
        radio.setLayout(new BoxLayout(radio, BoxLayout.PAGE_AXIS));
        radio.add(insertar);
        radio.add(eliminar);
        ventana.setContentPane(radio);
        ventana.pack();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }

    public void ejecutaInsertar(){
        System.out.println("Llego aqui");
        JRadioButton persona = new JRadioButton("Persona ");

        controlador = new ImplementacionControlador();
        persona.addItemListener(e -> controlador.pulsadoDarAlta(e.getStateChange()));

        JRadioButton etiqueta = new JRadioButton("Etiqueta ");

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(persona);
        grupo.add(etiqueta);

        JFrame ventana = new JFrame("Insertar Persona o Etiqueta ");

        JPanel radio = new JPanel();
        radio.setLayout(new BoxLayout(radio, BoxLayout.PAGE_AXIS));
        radio.add(persona);
        radio.add(etiqueta);
        ventana.setContentPane(radio);
        ventana.pack();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }

    public void ejecutaEliminar(){
        System.out.println("Llego aqui");
        JRadioButton persona = new JRadioButton("Persona ");

        controlador = new ImplementacionControlador();
        persona.addItemListener(e -> controlador.pulsadoDarAlta(e.getStateChange()));

        JRadioButton etiqueta = new JRadioButton("Etiqueta ");

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(persona);
        grupo.add(etiqueta);

        JFrame ventana = new JFrame("Eliminar Persona o Etiqueta ");

        JPanel radio = new JPanel();
        radio.setLayout(new BoxLayout(radio, BoxLayout.PAGE_AXIS));
        radio.add(persona);
        radio.add(etiqueta);
        ventana.setContentPane(radio);
        ventana.pack();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }

    public void insertarPersona(){

        JFrame ventana = new JFrame("Dar de alta a una Persona");
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
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);

    }

    public void insertarEtiqueta(){

    }

    public void eliminarPersona(){

    }

    public void eliminarEtiqueta(){

    }


    @Override
    public String getNombreProyecto() {
        return null;
    }
}
