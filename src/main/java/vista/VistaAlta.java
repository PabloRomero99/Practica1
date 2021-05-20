package vista;

import controlador.ImplementacionControlador;


import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VistaAlta extends JFrame implements VistaAltaInterfaz {
    private final static String ACEPTAR = "ACEPTAR";
    private ImplementacionControlador controlador = ImplementacionControlador.getInstancia();
    private VistaAlta vistaAlta;
    private VistaIndice vistaIndice;
    private JTextField nombre;
    private JTextField dni;
    private JTextField correo;

    public void setControlador(ImplementacionControlador controlador){
        this.controlador=controlador;
    }

    public void ejecuta(){

        JFrame ventana = new JFrame("Dar de alta ");
        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                vistaIndice=new VistaIndice();
                vistaIndice.ejecuta();
                ventana.setVisible(true);
            }
        });

        JRadioButton persona = new JRadioButton("Persona");

        persona.addItemListener(e -> controlador.pulsadorJRadioButton(persona.getText()));
        persona.addItemListener(e-> ventana.setVisible(false));

        JRadioButton tarea = new JRadioButton("Tarea");
        tarea.addItemListener(e -> controlador.pulsadorJRadioButton(tarea.getText()));
        tarea.addItemListener(e-> ventana.setVisible(false));


        ButtonGroup grupo = new ButtonGroup();
        grupo.add(persona);
        grupo.add(tarea);

        JPanel radio = new JPanel();
        radio.setLayout(new BoxLayout(radio, BoxLayout.PAGE_AXIS));
        radio.add(persona);
        radio.add(tarea);
        ventana.setContentPane(radio);
        ventana.pack();


        ventana.setVisible(true);
    }



    public void altaPersona(){

        JFrame ventana = new JFrame("Dar de alta a una Persona");
        Container cont = ventana.getContentPane();
        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                vistaAlta=new VistaAlta();
                vistaAlta.ejecuta();
                ventana.setVisible(true);
            }
        });

        nombre = new JTextField(30);
        cont.setLayout(new FlowLayout());
        cont.add(new JLabel("Nombre Persona: "));
        cont.add(nombre);


        dni = new JTextField(30);
        cont.setLayout(new FlowLayout());
        cont.add(new JLabel("NIF: "));
        cont.add(dni);


        correo = new JTextField(30);
        cont.setLayout(new FlowLayout());
        cont.add(new JLabel("Correo: "));
        cont.add(correo);


        JButton aceptar1 = new JButton(ACEPTAR);
        aceptar1.addActionListener(e -> controlador.darAltaPersona(nombre,dni,correo));
        vistaIndice = new VistaIndice();
        aceptar1.addActionListener(e -> vistaIndice.ejecuta());
        aceptar1.addActionListener(e -> ventana.setVisible(false));

        aceptar1.addActionListener(e -> System.out.println("El boton esta pulsado..."));
        cont.add(aceptar1);



        ventana.pack();
        //ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);

    }

    public void altaTarea() {
        JFrame ventana = new JFrame("Alta tarea");
        Container cont = ventana.getContentPane();

        JTextField titulo = new JTextField(30);
        JLabel nameTarea = new JLabel("Nombre Tarea: ");
        cont.setLayout(new FlowLayout());
        cont.add(nameTarea);
        cont.add(titulo);

        JTextField descripcion = new JTextField(30);
        JLabel descrip = new JLabel("Descrpción: ");
        cont.setLayout(new FlowLayout());
        cont.add(descrip);
        cont.add(descripcion);

        JLabel priority = new JLabel("Prioridad: ");
        JSlider prioridad = new JSlider(1,5);
        ventana.add(priority, BorderLayout.PAGE_START);
        ventana.add(prioridad, BorderLayout.CENTER);
        prioridad.addChangeListener(changeEvent -> {
            JSlider slider = (JSlider)changeEvent.getSource();
            priority.setText("Prioridad: " + slider.getValue());
        });

        priority.setText("Prioridad: " + prioridad.getValue());
        cont.setLayout(new FlowLayout());
        cont.add(prioridad);
        cont.add(priority);

        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                vistaAlta=new VistaAlta();
                vistaAlta.ejecuta();
                ventana.setVisible(true);
            }
        });


         JRadioButton doc = new JRadioButton("Documentación");
        doc.addItemListener(e-> controlador.pulsadorJRadioButton(doc.getText()));

         JRadioButton pagweb = new JRadioButton("Página Web");
         pagweb.addItemListener(e -> controlador.pulsadorJRadioButton(pagweb.getText()));

        JRadioButton prog = new JRadioButton("Programa");
        prog.addItemListener(e -> controlador.pulsadorJRadioButton(prog.getText()));


        ButtonGroup grupo = new ButtonGroup();
         grupo.add(doc);
         grupo.add(pagweb);
         grupo.add(prog);

         JPanel radio = new JPanel();
         radio.setLayout(new BoxLayout(radio, BoxLayout.PAGE_AXIS));
         radio.add(doc);
         radio.add(pagweb);
         radio.add(prog);
         cont.add(radio);



        JButton aceptar2 = new JButton(ACEPTAR);
        aceptar2.addActionListener(e -> System.out.println("El boton esta pulsado..."));
        aceptar2.addActionListener(e -> controlador.darAltaTarea(titulo,descripcion,prioridad));
        vistaIndice = new VistaIndice();
        aceptar2.addActionListener(e -> vistaIndice.ejecuta());
        aceptar2.addActionListener(e -> ventana.setVisible(false));
        cont.add(aceptar2);

        ventana.pack();
        //ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
    @Override
    public String getNombrePersona() {
        return nombre.getText();
    }

    @Override
    public String getDNI() {
        return dni.getText();
    }

    @Override
    public String getCorreo() {
        return correo.getText();
    }

}

