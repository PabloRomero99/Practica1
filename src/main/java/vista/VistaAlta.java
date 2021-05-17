package vista;

import controlador.Controlador;
import modelo.Persona;

import javax.swing.*;
import java.awt.*;

public class VistaAlta {
    private static String ACEPTAR = "ACEPTAR";
    private Controlador controlador;

    public void ejecuta(){
        JFrame ventana = new JFrame("Dar de alta");

        Container cont = ventana.getContentPane();
        cont.setLayout(new FlowLayout());

        JButton boton1 = new JButton("Persona ");
        //boton1.addActionListener(e -> cont.pulsadoDarAlta(e.getActionCommand()));
        boton1.addActionListener(e -> System.out.println("Boton dar alta pulsado"));
        cont.add(boton1);

        JButton boton2 = new JButton("Tarea ");
        //boton1.addActionListener(e -> cont.pulsadoDarAlta(e.getActionCommand()));
        boton2.addActionListener(e -> System.out.println("Boton dar alta pulsado"));
        cont.add(boton2);

        ventana.pack();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);

    }

    /*
    public void altaPersona(){

        JFrame ventana = new JFrame("Dar de alta a una Persona");
        Container cont = ventana.getContentPane();

        JTextField nombrePersona = new JTextField(30);
        JLabel namePersona = new JLabel("Nombre Persona: ");
        cont.setLayout(new FlowLayout());
        cont.add(namePersona);
        cont.add(nombrePersona);


        JTextField nifPersona = new JTextField(30);
        JLabel nif = new JLabel("NIF: ");
        cont.setLayout(new FlowLayout());
        cont.add(nif);
        cont.add(nifPersona);


        JTextField correoPersona = new JTextField(30);
        JLabel correo = new JLabel("Correo: ");
        cont.setLayout(new FlowLayout());
        cont.add(correo);
        cont.add(correoPersona);


        JButton aceptar = new JButton(ACEPTAR);
        aceptar.addActionListener(e -> controlador.darAltaPersona());
        aceptar.addActionListener(e -> System.out.println("El boton esta pulsado..."));
        cont.add(aceptar);

        ventana.pack();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);

    }

    public void altaTarea() {
        JFrame ventana = new JFrame("Alta tarea");
        Container cont = ventana.getContentPane();

        JTextField tarea = new JTextField(30);
        JLabel nameTarea = new JLabel("Nombre Tarea: ");
        cont.setLayout(new FlowLayout());
        cont.add(nameTarea);
        cont.add(tarea);

        JTextField tarea1 = new JTextField(30);
        JLabel descrip = new JLabel("Descrpción: ");
        cont.setLayout(new FlowLayout());
        cont.add(descrip);
        cont.add(tarea1);

        JLabel titulo = new JLabel("Prioridad: ");
        JSlider prioridad = new JSlider(1,5);
        ventana.add(titulo, BorderLayout.PAGE_START);
        ventana.add(prioridad, BorderLayout.CENTER);
        prioridad.addChangeListener(changeEvent -> {
            JSlider slider = (JSlider)changeEvent.getSource();
            titulo.setText("Prioridad: " + slider.getValue());
        });
        cont.setLayout(new FlowLayout());
        cont.add(prioridad);
        cont.add(titulo);


        JButton aceptar = new JButton(ACEPTAR);
        //aceptar.addActionListener(e -> controlador.compruebaProyecto(e.getActionCommand()));
        aceptar.addActionListener(e -> System.out.println("El boton esta pulsado..."));
        cont.add(aceptar);

        ventana.pack();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }

    public String getNombrePersona() {
        return "Paco";
    }

    public String getDNI() {
        return "42";
    }

    public String getCorreo() {
        return "paco@gmail.com";
    }
     */
}
