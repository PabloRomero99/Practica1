package vista;

import controlador.ControladorAlta;
import modelo.Modelo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.Serializable;

public class VistaIndice extends JFrame implements Serializable {
    private Modelo modelo;
    private ControladorAlta controlador;
    public JPanel panel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VistaIndice().ejecuta2();
            }
        });
    }

   public void ejecuta2() {

       JFrame ventana = new JFrame("Proyecto");
       ventana.addWindowListener(new WindowAdapter() {
           @Override
           public void windowClosing(WindowEvent e) {
               //Aqui es donde tenemos que añadir el código, para guardar los datos en el fichero.
               /**
                try {
                FileOutputStream fos = new FileOutputStream(nombre + ".bin");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(this);
                oos.close();
                System.out.println("Los datos se han guardado correctamente");
                }catch (IOException exception){
                System.out.println("No se han podido guardar los datos");
                }
                */
               System.exit(0);
           }
       });

       Container contenedor = ventana.getContentPane();
       contenedor.setLayout(new GridLayout(2,4));

/*
public void escribirFichero() throws IOException, ClassNotFoundException {
        FileOutputStream fos = new FileOutputStream( nombre + ".bin");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this);
        oos.close();
    }
 */

       ventana.pack();
       //ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

   }

private void radioButton(){
        JRadioButton darAlta = new JRadioButton("Dar de alta: ");
        darAlta.addItemListener(e -> System.out.println(e.getStateChange()));
        JRadioButton insertar = new JRadioButton("Insertar: ");
        insertar.addItemListener(e -> System.out.println(e.getStateChange()));
        JRadioButton eliminar = new JRadioButton("Eliminar: ");
        eliminar.addItemListener(e -> System.out.println(e.getStateChange()));
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(darAlta);
        grupo.add(insertar);
        grupo.add(eliminar);

       JFrame ventana = new JFrame("Proyecto ");

       JPanel radio = new JPanel();
       radio.setLayout(new BoxLayout(radio, BoxLayout.PAGE_AXIS));
       radio.add(darAlta);
       radio.add(insertar);
       radio.add(eliminar);
       ventana.setContentPane(radio);
       ventana.pack();
       ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       ventana.setVisible(true);

        }
}



/*
        public static Proyecto leerproyecto() throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre del proyecto: ");
        String nombre = sc.nextLine();
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
    }*/