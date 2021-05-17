package vista;

import controlador.Controlador;
import modelo.Modelo;
import vista.Insertar.BotonInsertar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class VistaIndice extends JFrame implements Serializable {
    private Modelo modelo;
    private Controlador controlador;
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
    }







       JButton boton2 = new JButton("Insertar "); //Responsable, colaborador, participante o etiqueta
       boton2.addActionListener(new BotonInsertar());
       contenedor.add(boton2);


       JButton boton3 = new JButton("Eliminar "); //Responsable, colaborador, participante o etiqueta
       boton3.addActionListener(new BotonInsertar());
       contenedor.add(boton3);


       JButton boton4 = new JButton("Marcar tarea finalizada ");
       boton4.addActionListener(new BotonInsertar());
       contenedor.add(boton4);


       JButton boton5 = new JButton("Listado de Personas "); //(participantes) o (NO colaboradores en ninguna tarea)
       boton5.addActionListener(new BotonInsertar());
       contenedor.add(boton5);


       JButton boton6 = new JButton("Listado de Tareas "); //(generales) o (listado tareas no trabaja nadie)
       boton6.addActionListener(new BotonInsertar());
       contenedor.add(boton6);


       JButton boton7 = new JButton("Precio total tareas y proyecto ");
       boton7.addActionListener(new BotonInsertar());
       contenedor.add(boton7);


       JButton boton8 = new JButton("Modificar Coste o tipo de facturacion ");
       boton8.addActionListener(new BotonInsertar());
       contenedor.add(boton8);
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
 */