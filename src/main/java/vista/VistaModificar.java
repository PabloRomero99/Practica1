package vista;

import controlador.ImplementacionControlador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class VistaModificar {
    private ImplementacionControlador controlador = ImplementacionControlador.getInstancia();
    private VistaIndice vistaIndice= VistaIndice.getInstancia();
    private String dto = "0";

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
        Container cont = ventana.getContentPane();
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



        JButton aceptar = new JButton("ACEPTAR");
        aceptar.addActionListener(e -> {
            try {
                controlador.modificarCoste(coste,tarea);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        aceptar.addActionListener(e -> vistaIndice.ejecuta());
        aceptar.addActionListener(e -> ventana.setVisible(false));

        aceptar.addActionListener(e -> System.out.println("El boton Aceptar de ModificarCoste esta pulsado..."));
        cont.add(aceptar);



        ventana.pack();
        //ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        VistaModificar vistaModificar = new VistaModificar();

        JRadioButton sin_costes = new JRadioButton("Facturación sin costes");

        sin_costes.addItemListener(e-> vistaModificar.realizarModificacion(1));

        JRadioButton descuento = new JRadioButton("Facturación con descuento");
        descuento.addItemListener(e -> vistaModificar.realizarModificacion(2));

        JRadioButton urgente = new JRadioButton("Facturación urgente");
        urgente.addItemListener(e -> vistaModificar.realizarModificacion(3));


        ButtonGroup tipo_facturacion = new ButtonGroup();
        tipo_facturacion.add(sin_costes);
        tipo_facturacion.add(descuento);
        tipo_facturacion.add(urgente);



        ventana.pack();
        //ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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


        if (comprobante==1){//Sin costes

        }else if(comprobante==2){//Descuento
            JTextField descuento = new JTextField(30);
            cont.setLayout(new FlowLayout());
            cont.add(new JLabel("Introduce el nuevo coste: "));
            cont.add(descuento);
            dto = descuento.getText();

        }else{//Urgente
            JTextField descuento = new JTextField(30);
            cont.setLayout(new FlowLayout());
            cont.add(new JLabel("Introduce el nuevo coste: "));
            cont.add(descuento);
            dto = descuento.getText();
        }


        JButton aceptar = new JButton("ACEPTAR");
        aceptar.addActionListener(e -> {
            try {
                controlador.modificarTipoFact(dto,tarea,comprobante);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        aceptar.addActionListener(e -> vistaIndice.ejecuta());
        aceptar.addActionListener(e -> ventana.setVisible(false));

        aceptar.addActionListener(e -> System.out.println("El boton Aceptar de ModificarCoste esta pulsado..."));
        cont.add(aceptar);



        ventana.pack();
        //ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }


}
