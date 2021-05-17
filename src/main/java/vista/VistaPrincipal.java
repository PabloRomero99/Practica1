package vista;

import controlador.Controlador;

import javax.swing.*;
import java.awt.*;

public class VistaPrincipal implements Vista{
    private JTextField nombreProyecto;
    private static String ACEPTAR = "ACEPTAR";

    private VistaIndice vistaIndice;
    private Controlador controlador;

    public void setControlador(Controlador controlador){
        this.controlador=controlador;
    }

    public void ejecuta(){
        JFrame ventana = new JFrame("Inicio");
        Container cont = ventana.getContentPane();
        nombreProyecto = new JTextField(30);
        JLabel nameproject = new JLabel("Nombre Proyecto: ");
        cont.setLayout(new FlowLayout());
        cont.add(nameproject);
        cont.add(nombreProyecto);


        JButton aceptar = new JButton(ACEPTAR);
        aceptar.addActionListener(e -> controlador.iniciaProyecto());
        aceptar.addActionListener(e -> System.out.println("El boton esta pulsado..."));


        vistaIndice = new VistaIndice();
        aceptar.addActionListener(e -> vistaIndice.ejecuta());
        aceptar.addActionListener(e-> ventana.setVisible(false));
        cont.add(aceptar);


        ventana.pack();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);

    }

    public String getNombreProyecto() {
        return nombreProyecto.getText();
    }


}
