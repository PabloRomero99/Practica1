package vista;

import controlador.Controlador;
import modelo.Modelo;
import vista.Insertar.BotonInsertar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VistaIndice extends JFrame {
    private Modelo modelo;
    private Controlador controlador;
    public JPanel panel;


   public void ejecuta(){
       JFrame ventana = new JFrame("Proyecto");
       ventana.addWindowListener(new WindowAdapter() {
           @Override
           public void windowClosing(WindowEvent e) {
               //Aqui es donde tenemos que añadir el código, para guardar los datos en el fichero.
               System.exit(0);
           }
       });

       Container contenedor = ventana.getContentPane();
       contenedor.setLayout(new GridLayout(2,4));




       /*
       JButton boton1 = new JButton("Dar Alta "); //Tarea, personas
       boton1.addActionListener(e -> controlador.pulsadoDarAlta());
       contenedor.add(boton1);


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
       darAlta.addItemListener(e -> System.out.println(e.getStateChange()) );
       JRadioButton insertar = new JRadioButton("Insertar: ");
       JRadioButton eliminar = new JRadioButton("Eliminar: ");
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
