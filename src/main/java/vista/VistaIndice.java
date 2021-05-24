package vista;

import controlador.Controlador;
import controlador.ImplementacionControlador;
import modelo.Modelo;
import modelo.ModeloProyecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class VistaIndice extends JFrame implements Serializable {
    private Controlador controlador = ImplementacionControlador.getInstancia();
    private VistaAlta vistaAlta;
    private VistaInsertar vistaInsertar;
    private VistaEliminar vistaEliminar;
    private VistaPrincipal vistaPrincipal;
    private VistaMarcarFinalizada vistaMarcarFinalizada;
    private VistaListado vistaListado;
    //private VistaConsultarPrecio vistaConsultaPrecio;
    //private VistaAlta vistaModificaciones;
    private VistaIndice vistaIndice;
    public JPanel panel;
    String nombreProyecto;

    private static VistaIndice instancia = null;
    private VistaIndice(){
        super();
    }
    public static VistaIndice getInstancia(){
        if (instancia == null){
            instancia = new VistaIndice();
        }
        return instancia;
    }


    public void setNombreProject(String nombreproyecto){
        this.nombreProyecto=nombreproyecto;
        ejecuta();
    }


   public void ejecuta() {

       System.out.println("NombreProyecto VistaIndice -->"+nombreProyecto);

       JFrame ventana = new JFrame(nombreProyecto);
       ventana.addWindowListener(new WindowAdapter() {
           @Override
           public void windowClosing(WindowEvent e) {
               //Aqui es donde tenemos que añadir el código, para guardar los datos en el fichero.
               controlador.finalizarProyecto();
               System.exit(0);
           }
       });

       Container contenedor = ventana.getContentPane();
       contenedor.setLayout(new GridLayout(4,2));


       JButton boton1 = new JButton("Dar Alta "); //Personas(participantes del proyecto), Tarea
       boton1.addActionListener(e -> System.out.println("Boton dar alta pulsado"));
       vistaAlta = new VistaAlta();
       boton1.addActionListener(e -> vistaAlta.ejecuta());
       boton1.addActionListener(e-> ventana.setVisible(false));
       contenedor.add(boton1);

       JButton boton2 = new JButton("Insertar "); //Responsables, Colaboradores, Etiqutas
       boton2.addActionListener(e -> System.out.println("Boton de insertar pulsado"));
       vistaInsertar = new VistaInsertar();
       boton2.addActionListener(e -> vistaInsertar.ejecuta());
       boton2.addActionListener(e-> ventana.setVisible(false));
       contenedor.add(boton2);

       JButton boton3 = new JButton("Eliminar "); //Colaboradores,Etiquetas
       boton3.addActionListener(e -> System.out.println("Boton de eliminar pulsado "));
       vistaEliminar = new VistaEliminar();
       boton3.addActionListener(e -> vistaEliminar.ejecuta());
       boton3.addActionListener(e-> ventana.setVisible(false));
       contenedor.add(boton3);

       JButton boton4 = new JButton("Marcar tarea finalizada ");
       vistaMarcarFinalizada = new VistaMarcarFinalizada();
       boton4.addActionListener(e -> System.out.println("Boton tarea finalizada pulsado"));
       boton4.addActionListener(e -> vistaMarcarFinalizada.ejecuta());
       contenedor.add(boton4);

       JButton boton5 = new JButton("Listado de Personas");//Totales del proyecto, las cuales no son responsables en ninguna tarea
       boton5.addActionListener(e -> System.out.println("Boton Listado de Personas pulsado"));
       vistaListado = new VistaListado();
       boton5.addActionListener(e -> vistaListado.ejecutaListadoPersonas());
       boton5.addActionListener(e-> ventana.setVisible(false));
       contenedor.add(boton5);

       JButton boton6 = new JButton("Listado de Tareas ");//Totales en el proyecto, en las cuales no participa nadie
       boton6.addActionListener(e -> System.out.println("Boton Listado de Tareas pulsado"));
       vistaListado = new VistaListado();
       boton6.addActionListener(e -> vistaListado.ejecutaListadoTareas());
       boton6.addActionListener(e-> ventana.setVisible(false));
       contenedor.add(boton6);


       JButton boton7 = new JButton("Consultar precio "); //Total del proyecto + tarea
       boton7.addActionListener(e -> System.out.println("Boton consultar precio pulsado"));
       vistaMostrarPrecio = new VistaMostrarPrecio();
       boton7.addActionListener(e -> vistaMostrarPrecio.ejecutaMostrarPrecio());
       boton7.addActionListener(e-> ventana.setVisible(false));
       contenedor.add(boton7);


       JButton boton8 = new JButton("Modificaciones "); //Coste, Tipo de facturacion
       boton8.addActionListener(e -> System.out.println("Boton modificaciones pulsado"));
       contenedor.add(boton8);

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