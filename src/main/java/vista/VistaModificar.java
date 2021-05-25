package vista;

import controlador.ImplementacionControlador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class VistaModificar {
    private ImplementacionControlador controlador = ImplementacionControlador.getInstancia();
    private final static String ACEPTAR = "ACEPTAR";
    private VistaIndice vistaIndice= VistaIndice.getInstancia();



    public void ejecuta(){
        JFrame ventana = new JFrame("Modificación Coste o Tipo Facturación ");
        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {

                vistaIndice.ejecuta();
                ventana.setVisible(true);
            }
        });

        JRadioButton coste = new JRadioButton("Coste");
        coste.addItemListener(e -> controlador.pulsadorJRadioButton(coste.getText()));
        coste.addItemListener(e-> ventana.setVisible(false));

        JRadioButton tipo_fact = new JRadioButton("Tipo de Facturación");
        tipo_fact.addItemListener(e -> controlador.pulsadorJRadioButton(tipo_fact.getText()));
        tipo_fact.addItemListener(e-> ventana.setVisible(false));

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(coste);
        grupo.add(tipo_fact);

        JPanel radio = new JPanel();
        radio.setLayout(new BoxLayout(radio, BoxLayout.PAGE_AXIS));
        radio.add(coste);
        radio.add(tipo_fact);
        ventana.setContentPane(radio);
        ventana.pack();


        ventana.setVisible(true);

    }
    
    public void modificarCoste(){
        JFrame ventana = new JFrame("Modificacion Coste");
        //Container cont = ventana.getContentPane();
        Panel cont = new Panel();
        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                vistaIndice.ejecuta();
                ventana.setVisible(true);
            }
        });

        JTextField coste = new JTextField(30);
        cont.setLayout(new FlowLayout());
        cont.add(new JLabel("Introduce el nuevo coste: "));
        cont.add(coste);

        JTextField tarea = new JTextField(30);
        cont.setLayout(new FlowLayout());
        cont.add(new JLabel("Introduce la tarea donde: "));
        cont.add(tarea);

        String[] tareaslistado = controlador.conseguirListado("nombreTarea");
        JList tareas = new JList(tareaslistado);
        JScrollPane paneltareas = new JScrollPane(tareas);
        tareas.setVisibleRowCount(4);
        tareas.setSize(100,200);




        JButton aceptar = new JButton(ACEPTAR);
        aceptar.addActionListener(e -> {
            try {
                controlador.modificarCoste(coste,tarea);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });


        cont.add(aceptar);
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, cont, paneltareas);
        ventana.getContentPane().add(splitPane);
        splitPane.setDividerLocation(500);

        aceptar.addActionListener(e -> vistaIndice.ejecuta());
        aceptar.addActionListener(e -> ventana.setVisible(false));

        aceptar.addActionListener(e -> System.out.println("El boton Aceptar de ModificarCoste esta pulsado..."));



        ventana.pack();
        ventana.setVisible(true);
    }

    public void modificarTipoFact(){

        JFrame ventana = new JFrame("Modificacion Tipo de Facturacion");

        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                vistaIndice.ejecuta();
                ventana.setVisible(true);
            }
        });

        JRadioButton sin_costes = new JRadioButton("Facturación sin costes");
        sin_costes.addItemListener(e-> controlador.realizarModificacion(1));
        sin_costes.addActionListener(e -> ventana.setVisible(false));

        JRadioButton descuento = new JRadioButton("Facturación con descuento");
        descuento.addItemListener(e -> controlador.realizarModificacion(2));
        descuento.addActionListener(e -> ventana.setVisible(false));

        JRadioButton urgente = new JRadioButton("Facturación urgente");
        urgente.addItemListener(e -> controlador.realizarModificacion(3));
        urgente.addActionListener(e -> ventana.setVisible(false));


        ButtonGroup tipo_facturacion = new ButtonGroup();
        tipo_facturacion.add(sin_costes);
        tipo_facturacion.add(descuento);
        tipo_facturacion.add(urgente);


        JPanel radio = new JPanel();
        radio.setLayout(new BoxLayout(radio, BoxLayout.PAGE_AXIS));
        radio.add(sin_costes);
        radio.add(descuento);
        radio.add(urgente);
        ventana.setContentPane(radio);
        ventana.pack();

        ventana.pack();
        ventana.setVisible(true);

    }

    public void realizarModificacionSinCoste(int comprobante){
        JFrame ventana = new JFrame("Modificacion Coste");
        Container cont = ventana.getContentPane();
        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                vistaIndice.ejecuta();
                ventana.setVisible(true);
            }
        });
        JTextField tarea = new JTextField(30);
        cont.setLayout(new FlowLayout());
        cont.add(new JLabel("Introduce la tarea donde: "));
        cont.add(tarea);


        JButton aceptar = new JButton(ACEPTAR);
        aceptar.addActionListener(e -> {
            try {
                controlador.modificarTipoFact("0",tarea,comprobante);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        aceptar.addActionListener(e -> vistaIndice.ejecuta());
        aceptar.addActionListener(e -> ventana.setVisible(false));

        aceptar.addActionListener(e -> System.out.println("El boton Aceptar de ModificarCoste esta pulsado..."));
        cont.add(aceptar);

        ventana.pack();
        ventana.setVisible(true);
    }

    public void realizarModificacion(int comprobante){
        JFrame ventana = new JFrame("Modificacion Coste");
        Container cont = ventana.getContentPane();
        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                vistaIndice.ejecuta();
                ventana.setVisible(true);
            }
        });


        JTextField tarea = new JTextField(30);
        cont.setLayout(new FlowLayout());
        cont.add(new JLabel("Introduce la tarea donde: "));
        cont.add(tarea);

        JTextField descuento = new JTextField(30);
        cont.setLayout(new FlowLayout());
        cont.add(new JLabel("Introduce el nuevo porcentaje: "));
        cont.add(descuento);

        JButton aceptar = new JButton(ACEPTAR);
        aceptar.addActionListener(e -> {
            try {
               controlador.modificarTipoFact(descuento.getText(),tarea,comprobante);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        aceptar.addActionListener(e -> vistaIndice.ejecuta());
        aceptar.addActionListener(e -> ventana.setVisible(false));
        cont.add(aceptar);


        ventana.pack();
        ventana.setVisible(true);
    }


}


