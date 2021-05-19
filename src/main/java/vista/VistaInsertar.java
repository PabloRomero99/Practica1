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

    private VistaInsertar vistaInsertar;
    private Controlador controlador = new ImplementacionControlador();

    public void setControlador(Controlador controlador){
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
        aceptar.addActionListener(e -> controlador.pulsadoAceptar("Insertar"));
        aceptar.addActionListener(e -> System.out.println("El boton esta pulsado..."));
        cont.add(aceptar);

        ventana.pack();
        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                vistaIndice=new VistaIndice();
                vistaIndice.ejecuta();
                ventana.setVisible(true);
            }
        });
        ventana.setVisible(true);    }

    public void ejecutaInsertar(){
        JFrame ventana = new JFrame("Insertar Colaborador, Etiqueta o Responsable ");

        JRadioButton persona = new JRadioButton("Colaborador");

        controlador = new ImplementacionControlador();
        persona.addItemListener(e -> controlador.pulsadoInsertar(persona.getText()));
        persona.addItemListener(e-> ventana.setVisible(false));


        JRadioButton etiqueta = new JRadioButton("Etiqueta");
        persona.addItemListener(e -> controlador.pulsadoInsertar(etiqueta.getText()));
        persona.addItemListener(e-> ventana.setVisible(false));


        JRadioButton responsable = new JRadioButton("Responsable");
        persona.addItemListener(e -> controlador.pulsadoInsertar(responsable.getText()));
        persona.addItemListener(e-> ventana.setVisible(false));


        ButtonGroup grupo = new ButtonGroup();
        grupo.add(persona);
        grupo.add(etiqueta);


        JPanel radio = new JPanel();
        radio.setLayout(new BoxLayout(radio, BoxLayout.PAGE_AXIS));
        radio.add(persona);
        radio.add(etiqueta);
        radio.add(responsable);
        ventana.setContentPane(radio);
        ventana.pack();
        //ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                vistaInsertar=new VistaInsertar();
                vistaInsertar.ejecuta();
                ventana.setVisible(true);
            }
        });
        ventana.setVisible(true);
    }

    public void insertarColaborador(){

        JFrame ventana = new JFrame("Insertar un colaborador a la tarea");
        Container cont = ventana.getContentPane();

        clave = new JTextField(30);
        cont.setLayout(new FlowLayout());
        cont.add(new JLabel("Identificador del colaborador: "));
        cont.add(clave);

        JButton aceptar = new JButton(ACEPTAR);
        //aceptar.addActionListener(e -> controlador.darAltaPersona());
        aceptar.addActionListener(e -> controlador.insertaPersona(clave.getText()));
        aceptar.addActionListener(e -> System.out.println("El boton esta pulsado..."));
        cont.add(aceptar);

        ventana.pack();
        //ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);

        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                vistaInsertar=new VistaInsertar();
                vistaInsertar.ejecutaInsertar();
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
