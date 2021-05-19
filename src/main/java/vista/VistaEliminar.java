package vista;

import controlador.Controlador;
import controlador.ImplementacionControlador;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VistaEliminar extends JFrame implements Vista{
    private JTextField nombreProyecto;
    private static String ACEPTAR = "ACEPTAR";
    private JTextField clave;
    private JTextField nTarea;

    private VistaInsertarEliminar vistaInsertarEliminar;
    private Controlador controlador = new ImplementacionControlador();

    public void setControlador(Controlador controlador){
        this.controlador=controlador;
    }

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
                vistaInsertarEliminar=new VistaInsertarEliminar();
                vistaInsertarEliminar.ejecuta();
                ventana.setVisible(true);
            }
        });
        ventana.setVisible(true);
    }

    @Override
    public String getNombreProyecto(){
        return "si";
    }
}
