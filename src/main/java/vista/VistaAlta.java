package vista;

import controlador.ImplementacionControlador;
import modelo.ModeloProyecto;


import javax.swing.*;
import java.awt.*;
import java.util.concurrent.atomic.AtomicInteger;

public class VistaAlta extends JFrame implements VistaAltaInterfaz {
    private static String ACEPTAR = "ACEPTAR";
    private ImplementacionControlador controlador = new ImplementacionControlador();
    private JTextField nombre;
    private JTextField dni;
    private JTextField correo;


public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                final VistaAlta vista = new VistaAlta();
                final ImplementacionControlador controlador = new ImplementacionControlador();
                final ModeloProyecto modelo = new ModeloProyecto();

                vista.setControlador(controlador);
                controlador.setModelo(modelo);
                controlador.setVistaAlta(vista);
                modelo.setVista2(vista);

                SwingUtilities.invokeLater(() -> vista.ejecuta());

            }
        });
    }



    public void setControlador(ImplementacionControlador controlador){
        this.controlador=controlador;
    }

    public void ejecuta(){

        JRadioButton persona = new JRadioButton("Persona ");

        //controlador = new ImplementacionControlador();
        persona.addItemListener(e -> controlador.pulsadoDarAlta(e.getStateChange()));

        JRadioButton tarea = new JRadioButton("Tarea ");

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(persona);
        grupo.add(tarea);

        JFrame ventana = new JFrame("Dar de alta ");

        JPanel radio = new JPanel();
        radio.setLayout(new BoxLayout(radio, BoxLayout.PAGE_AXIS));
        radio.add(persona);
        radio.add(tarea);
        ventana.setContentPane(radio);
        ventana.pack();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }






    public void altaPersona(){

        JFrame ventana = new JFrame("Dar de alta a una Persona");
        Container cont = ventana.getContentPane();

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




        JButton aceptar = new JButton(ACEPTAR);
        //aceptar.addActionListener(e -> controlador.darAltaPersona());
        aceptar.addActionListener(e -> controlador.darAltaPersona(nombre,dni,correo));
        aceptar.addActionListener(e -> System.out.println("El boton esta pulsado..."));
        cont.add(aceptar);

        ventana.pack();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

        //_____________________________________________________

        /**
         JRadioButton doc = new JRadioButton("Documentación ");
         //doc.addItemListener(e -> controlador.pulsadoDarAlta(e.getStateChange()));
         doc.addItemListener(e -> System.out.println((e.getStateChange())));

         JRadioButton pagweb = new JRadioButton("Página Web ");
         JRadioButton prog = new JRadioButton("Programa ");

         ButtonGroup grupo = new ButtonGroup();
         grupo.add(doc);
         grupo.add(pagweb);
         grupo.add(prog);

         JPanel radio = new JPanel();
         radio.setLayout(new BoxLayout(radio, BoxLayout.PAGE_AXIS));
         radio.add(doc);
         radio.add(pagweb);
         radio.add(prog);
         ventana.setContentPane(radio);
         */


        JButton aceptar = new JButton(ACEPTAR);
        aceptar.addActionListener(e -> System.out.println("El boton esta pulsado..."));
        aceptar.addActionListener(e -> controlador.darAltaTarea(titulo,descripcion,prioridad));

        cont.add(aceptar);

        ventana.pack();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

