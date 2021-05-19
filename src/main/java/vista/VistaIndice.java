package vista;

import controlador.Controlador;
import modelo.Modelo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class VistaIndice extends JFrame implements Serializable {
    private Controlador controlador;
    private VistaAlta vistaAlta;
    private VistaInsertarEliminar vistaInsertarEliminar;
    private VistaPrincipal vistaPrincipal;
    private VistaAlta vistaMarcarFinalizada;
    private VistaAlta vistaListado;
    private VistaAlta vistaConsultaPrecio;
    private VistaAlta vistaModificaciones;
    private VistaIndice vistaIndice;
    public JPanel panel;
    String nombreProyecto;


    public void setNombreProject(String nombreproyecto){
        this.nombreProyecto=nombreproyecto;
        ejecuta();
    }


   public void ejecuta() {

       System.out.println(nombreProyecto);

       JFrame ventana = new JFrame(nombreProyecto);
       ventana.addWindowListener(new WindowAdapter() {
           @Override
           public void windowClosing(WindowEvent e) {
               //Aqui es donde tenemos que añadir el código, para guardar los datos en el fichero.
                try {
                FileOutputStream fos = new FileOutputStream(nombreProyecto + ".bin");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(this);
                oos.close();
                System.out.println("Los datos se han guardado correctamente");
                }catch (IOException exception){
                System.out.println("No se han podido guardar los datos");
                }

               System.exit(0);
           }
       });

       Container contenedor = ventana.getContentPane();
       contenedor.setLayout(new GridLayout(4,2));


       JButton boton1 = new JButton("Dar Alta "); //Personas(participantes del proyecto), Tarea
       boton1.addActionListener(e -> System.out.println("Boton dar alta pulsado"));
       vistaAlta = new VistaAlta();
       boton1.addActionListener(e -> vistaAlta.ejecuta());
       //boton1.addActionListener(e-> ventana.setVisible(false));
       contenedor.add(boton1);

       JButton boton2 = new JButton("Insertar "); //Responsables, Colaboradores, Etiqutas
       boton2.addActionListener(e -> System.out.println("Boton de insertar pulsado"));
       vistaInsertarEliminar = new VistaInsertarEliminar();
       boton2.addActionListener(e -> vistaInsertarEliminar.ejecuta());
       contenedor.add(boton2);

       JButton boton3 = new JButton("Eliminar "); //Colaboradores,Etiquetas
       //boton1.addActionListener(e -> controlador.pulsadoDarAlta(e.getActionCommand()));
       boton3.addActionListener(e -> System.out.println("Boton de eliminar pulsado "));
       contenedor.add(boton3);

       JButton boton4 = new JButton("Marcar tarea finalizada ");
       //boton1.addActionListener(e -> controlador.pulsadoDarAlta(e.getActionCommand()));
       boton4.addActionListener(e -> System.out.println("Boton tarea finalizada pulsado"));
       contenedor.add(boton4);

       JButton boton5 = new JButton("Listado de Personas");//Totales del proyecto, las cuales no son responsables en ninguna tarea
       //boton1.addActionListener(e -> controlador.pulsadoDarAlta(e.getActionCommand()));
       boton5.addActionListener(e -> System.out.println("Boton Listado de Personas pulsado"));
       contenedor.add(boton5);

       JButton boton6 = new JButton("Listado de Tareas ");//Totales en el proyecto, en las cuales no participa nadie
       //boton1.addActionListener(e -> controlador.pulsadoDarAlta(e.getActionCommand()));
       boton6.addActionListener(e -> System.out.println("Boton Listado de Tareas pulsado"));
       contenedor.add(boton6);


       JButton boton7 = new JButton("Consultar precio "); //Total del proyecto + tarea
       //boton1.addActionListener(e -> controlador.pulsadoDarAlta(e.getActionCommand()));
       boton7.addActionListener(e -> System.out.println("Boton consultar precio pulsado"));
       contenedor.add(boton7);


       JButton boton8 = new JButton("Modificaciones "); //Coste, Tipo de facturacion
       //boton1.addActionListener(e -> controlador.pulsadoDarAlta(e.getActionCommand()));
       boton8.addActionListener(e -> System.out.println("Boton modificaciones pulsado"));
       contenedor.add(boton8);

       ventana.pack();
       ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       ventana.setVisible(true);

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

/*
public void escribirFichero() throws IOException, ClassNotFoundException {
        FileOutputStream fos = new FileOutputStream( nombre + ".bin");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this);
        oos.close();
    }
 */