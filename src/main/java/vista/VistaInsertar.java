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
     aceptar.addItemListener(e-> ventana.setVisible(false));
     aceptar.addActionListener(e -> System.out.println("El boton esta pulsado..."));

     cont.add(aceptar);

     ventana.addWindowListener(new WindowAdapter() {
    @Override
    public void windowClosing(WindowEvent e) {
    vistaIndice=new VistaIndice();
    vistaIndice.ejecuta();
    ventana.setVisible(true);
    }
    });
     ventana.pack();
     ventana.setVisible(true);
     }


    public void ejecutaInsertar(){
        JFrame ventana = new JFrame("Insertar Colaborador, Etiqueta o Responsable ");


        JRadioButton colaborador = new JRadioButton("Colaborador");

        controlador = new ImplementacionControlador();
        colaborador.addItemListener(e -> controlador.pulsadoInsertar(colaborador.getText()));
        colaborador.addItemListener(e-> ventana.setVisible(false));


        JRadioButton etiqueta = new JRadioButton("Etiqueta");
        etiqueta.addItemListener(e -> controlador.pulsadoInsertar(etiqueta.getText()));
        etiqueta.addItemListener(e-> ventana.setVisible(false));


        JRadioButton responsable = new JRadioButton("Responsable");
        responsable.addItemListener(e -> controlador.pulsadoInsertar(responsable.getText()));
        responsable.addItemListener(e-> ventana.setVisible(false));


        ButtonGroup grupo = new ButtonGroup();
        grupo.add(colaborador);
        grupo.add(etiqueta);
        grupo.add(responsable);


        JPanel radio = new JPanel();
        radio.setLayout(new BoxLayout(radio, BoxLayout.PAGE_AXIS));
        radio.add(colaborador);
        radio.add(etiqueta);
        radio.add(responsable);
        ventana.setContentPane(radio);
        ventana.pack();
        ventana.setVisible(true);
        //ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                vistaInsertar=new VistaInsertar();
                vistaInsertar.ejecuta();
                ventana.setVisible(true);
            }
        });

    }

    public void insertarColaborador(){
        JFrame ventana = new JFrame("Insertar un colaborador a la tarea");
        Container cont = ventana.getContentPane();

        clave = new JTextField(30);
        cont.setLayout(new FlowLayout());
        cont.add(new JLabel("Identificador del colaborador: "));
        cont.add(clave);

        JButton aceptar = new JButton(ACEPTAR);
        aceptar.addActionListener(e -> controlador.insertaColaborador(clave.getText()));
        aceptar.addActionListener(e -> System.out.println("El boton esta pulsado..."));
        aceptar.addItemListener(e-> ventana.setVisible(false));

        cont.add(aceptar);

        ventana.pack();

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
        JFrame ventana = new JFrame("Insertar una etiqueta a la tarea");
        Container cont = ventana.getContentPane();

        clave = new JTextField(30);
        cont.setLayout(new FlowLayout());
        cont.add(new JLabel("IEtiqueta: "));
        cont.add(clave);

        JButton aceptar = new JButton(ACEPTAR);
        //aceptar.addActionListener(e -> controlador.darAltaPersona());
        aceptar.addActionListener(e -> controlador.insertaEtiqueta(clave.getText()));
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

    public void insertarResponsable(){
        JFrame ventana = new JFrame("Insertar un responsable a la tarea");
        Container cont = ventana.getContentPane();

        clave = new JTextField(30);
        cont.setLayout(new FlowLayout());
        cont.add(new JLabel("Identificador del responsable: "));
        cont.add(clave);

        JButton aceptar = new JButton(ACEPTAR);
        aceptar.addActionListener(e -> controlador.insertaResponsable(clave.getText()));
        aceptar.addActionListener(e -> System.out.println("El boton esta pulsado..."));
        cont.add(aceptar);

        ventana.pack();
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

    public String getNombreProyecto(){
        return "nombreProyecto";
    }

}
