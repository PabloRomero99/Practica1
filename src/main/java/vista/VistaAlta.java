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
    private VistaIndice vistaIndice = VistaIndice.getInstancia();
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


        JButton aceptar = new JButton(ACEPTAR);
        aceptar.addActionListener(e -> controlador.darAltaPersona(nombre,dni,correo));

        aceptar.addActionListener(e -> vistaIndice.ejecuta());
        aceptar.addActionListener(e -> ventana.setVisible(false));

        aceptar.addActionListener(e -> System.out.println("El boton Aceptar de DarAltaPersona esta pulsado..."));
        cont.add(aceptar);



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


        ButtonGroup tipo_resultado = new ButtonGroup();
         tipo_resultado.add(doc);
         tipo_resultado.add(pagweb);
         tipo_resultado.add(prog);

         JPanel radio = new JPanel();
         radio.setLayout(new BoxLayout(radio, BoxLayout.PAGE_AXIS));
         radio.add(doc);
         radio.add(pagweb);
         radio.add(prog);
         cont.add(radio);

        JRadioButton res_interno = new JRadioButton("Resultado Interno");
        res_interno.addItemListener(e-> controlador.pulsadorJRadioButton(res_interno.getText()));

        JRadioButton comercializado = new JRadioButton("Destinado a ser comercializado");
        comercializado.addItemListener(e -> controlador.pulsadorJRadioButton(comercializado.getText()));


        ButtonGroup tipo_interno_comercializado = new ButtonGroup();
         tipo_interno_comercializado.add(res_interno);
         tipo_interno_comercializado.add(comercializado);


         JPanel radio2 = new JPanel();
         radio2.setLayout(new BoxLayout(radio2, BoxLayout.PAGE_AXIS));
         radio2.add(res_interno);
         radio2.add(comercializado);
         cont.add(radio2);



        JTextField coste  = new JTextField(30);
        JLabel dinero = new JLabel("        Coste: ");
        cont.setLayout(new FlowLayout());
        cont.add(dinero);
        cont.add(coste);


        JRadioButton sin_costes = new JRadioButton("Facturación sin costes");
        sin_costes.addItemListener(e-> controlador.pulsadorJRadioButton(sin_costes.getText()));

        JRadioButton descuento = new JRadioButton("Facturación con descuento");
        descuento.addItemListener(e -> controlador.pulsadorJRadioButton(descuento.getText()));

        JRadioButton urgente = new JRadioButton("Facturación urgente");
        urgente.addItemListener(e -> controlador.pulsadorJRadioButton(urgente.getText()));


        ButtonGroup tipo_facturacion = new ButtonGroup();
         tipo_facturacion.add(sin_costes);
         tipo_facturacion.add(descuento);
         tipo_facturacion.add(urgente);


        JTextField dto  = new JTextField(30);
        JLabel desc = new JLabel("          Porcentaje a aplicar: ");
        cont.setLayout(new FlowLayout());
        cont.add(desc);
        cont.add(dto);


         JPanel radio3 = new JPanel();
         radio3.setLayout(new BoxLayout(radio3, BoxLayout.PAGE_AXIS));
         radio3.add(sin_costes);
         radio3.add(descuento);
         radio3.add(urgente);
         cont.add(radio3);



        JButton aceptar = new JButton(ACEPTAR);
        aceptar.addActionListener(e -> System.out.println("El boton esta pulsado..."));
        aceptar.addActionListener(e -> controlador.darAltaTarea(titulo,descripcion,prioridad,coste,dto));

        aceptar.addActionListener(e -> vistaIndice.ejecuta());
        aceptar.addActionListener(e -> ventana.setVisible(false));
        cont.add(aceptar);


        ventana.pack();
        ventana.setSize(360,450);
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

