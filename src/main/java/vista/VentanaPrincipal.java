package vista;

import controlador.Controlador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VentanaPrincipal{
    private JTextField nombreProyecto;
    private static String ACEPTAR = "ACEPTAR";

    private Controlador controlador;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VentanaPrincipal().ejecuta();
            }
        });
    }

    public void ejecuta(){
        JFrame ventana = new JFrame("Inicio");
        Container cont = ventana.getContentPane();
        JTextField proyecto = new JTextField(30);
        JLabel nameproject = new JLabel("Nombre Proyecto: ");
        cont.setLayout(new FlowLayout());
        cont.add(nameproject);
        cont.add(proyecto);


        JButton aceptar = new JButton(ACEPTAR);
        aceptar.addActionListener(e -> controlador.pulsadoDarAlta());
        aceptar.addActionListener(e -> System.out.println("El boton esta pulsado..."));
        cont.add(aceptar);

        ventana.pack();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);




    }
    /*
        try {
            FileInputStream fis = new FileInputStream(nombre + ".bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Proyecto proyecto = (Proyecto) ois.readObject();
            ois.close();
            return proyecto;
        }catch(IOException e){
            System.out.println("El proyecto con nombre " + nombre + " se ha creado correctamente\n\n");
            return new Proyecto(nombre);
        }
     */
}
