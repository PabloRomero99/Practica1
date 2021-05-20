package vista;

import controlador.ImplementacionControlador;

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
    private ImplementacionControlador controlador = ImplementacionControlador.getInstancia();

    public void setControlador(ImplementacionControlador controlador){
        this.controlador=controlador;
    }

    public void ejecuta(){
        JFrame ventana = new JFrame("Escoge tarea");

        Container cont = ventana.getContentPane();

        nTarea = new JTextField(30);
        cont.setLayout(new FlowLayout());
        cont.add(new JLabel("Nombre de la tarea donde quieres modificar: "));
        cont.add(nTarea);

        JButton aceptar = new JButton(ACEPTAR);
        aceptar.addActionListener(e -> controlador.pulsadoAceptar("Eliminar",nTarea.getText()));
        aceptar.addActionListener(e -> System.out.println("El boton esta pulsado..."));
        cont.add(aceptar);

        ventana.pack();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }

    public void ejecutaEliminar(){
        JFrame ventana = new JFrame("Eliminar Persona o Etiqueta ");

        System.out.println("Llego aqui");
        JRadioButton persona = new JRadioButton("Persona ");

        //controlador = new ImplementacionControlador();
        persona.addItemListener(e -> controlador.pulsadorJRadioButton(persona.getText()));
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

    public void eliminarColaborador(){

    }

    public void eliminarEtiqueta(){

    }

    @Override
    public String getNombreProyecto(){
        return "si";
    }
}
