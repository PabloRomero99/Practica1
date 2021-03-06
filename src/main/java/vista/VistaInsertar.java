package vista;

import controlador.Controlador;
import controlador.ImplementacionControlador;
import modelo.Persona;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class VistaInsertar extends JFrame implements Vista{
    private static String ACEPTAR = "ACEPTAR";
    private JTextField clave;
    private JTextField nTarea;
    //private String nombreTarea;
    private VistaIndice vistaIndice = VistaIndice.getInstancia();


    private VistaInsertar vistaInsertar;
    private ImplementacionControlador controlador = ImplementacionControlador.getInstancia();

    public void setControlador(ImplementacionControlador controlador){
        this.controlador=controlador;
    }


     public void ejecuta() {
         JFrame ventana = new JFrame("Inicio");
         Panel cont = new Panel();

         nTarea = new JTextField(30);
         JLabel nomTarea = new JLabel("Titulo de la tarea donde quieres modificar: ");
         cont.setLayout(new FlowLayout());
         cont.add(nomTarea);
         cont.add(nTarea);

        String[] tareaslistado = controlador.conseguirListado("nombreTarea");
        JList tareas = new JList(tareaslistado);
        JScrollPane paneltareas = new JScrollPane(tareas);
        tareas.setVisibleRowCount(4);
        tareas.setSize(100,50);

         JButton aceptar = new JButton(ACEPTAR);
         aceptar.addActionListener(e -> controlador.pulsadoAceptar("Insertar", nTarea.getText()));
         aceptar.addActionListener(e -> ventana.setVisible(false));

         cont.add(aceptar);
         JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, cont, paneltareas);
         ventana.getContentPane().add(splitPane);

         ventana.addWindowListener(new WindowAdapter() {
             @Override
             public void windowClosing(WindowEvent e) {
                 vistaIndice.ejecuta();
                 ventana.setVisible(true);
             }
         });


         ventana.pack();
         ventana.setVisible(true);
     }

    public void ejecutaInsertar(){
        JFrame ventana = new JFrame("Insertar Colaborador, Etiqueta o Responsable ");


        JRadioButton colaborador = new JRadioButton("Colaborador");

        //controlador = new ImplementacionControlador();
        colaborador.addItemListener(e -> {
            try {
                controlador.pulsadoInsertar(colaborador.getText());
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        colaborador.addItemListener(e-> ventana.setVisible(false));


        JRadioButton etiqueta = new JRadioButton("Etiqueta");
        etiqueta.addItemListener(e -> {
            try {
                controlador.pulsadoInsertar(etiqueta.getText());
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        etiqueta.addItemListener(e-> ventana.setVisible(false));


        JRadioButton responsable = new JRadioButton("Responsable");
        responsable.addItemListener(e -> {
            try {
                controlador.pulsadoInsertar(responsable.getText());
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        responsable.addItemListener(e-> ventana.setVisible(false));


        ButtonGroup grupo = new ButtonGroup();
        grupo.add(colaborador);
        grupo.add(etiqueta);
        grupo.add(responsable);


        JPanel radio = new JPanel();
        radio.setLayout(new BoxLayout(radio, BoxLayout.PAGE_AXIS));
        radio.add(colaborador);
        radio.add(etiqueta);
        radio.add(responsable);
        ventana.setContentPane(radio);
        ventana.pack();
        ventana.setVisible(true);

        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                vistaInsertar=new VistaInsertar();
                vistaInsertar.ejecuta();
                ventana.setVisible(true);
            }
        });
        ventana.setVisible(true);

    }

    public void insertarColaborador(String[] participantes){
        JFrame ventana = new JFrame("Insertar un colaborador a la tarea");
        Panel cont = new Panel();

        clave = new JTextField(30);
        cont.add(new JLabel("Introduce el DNI del colaborador: "));
        cont.add(clave);

        JButton aceptar = new JButton(ACEPTAR);
        aceptar.addActionListener(e -> {
            try {
                controlador.insertaColaborador(clave.getText());
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        aceptar.addActionListener(e-> ventana.setVisible(false));
        cont.add(aceptar);

        JList personas = new JList(participantes);
        JScrollPane panelPersonas = new JScrollPane(personas);
        personas.setVisibleRowCount(4);
        personas.setSize(100,50);


        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, cont, panelPersonas);
        ventana.getContentPane().add(splitPane);

        ventana.pack();

        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                vistaIndice.ejecuta();
                ventana.setVisible(true);
            }
        });

        ventana.setVisible(true);

    }

    public void insertarEtiqueta(String[] etiquetas) throws Exception{
        JFrame ventana = new JFrame("Insertar una etiqueta a la tarea");
        Panel cont = new Panel();

        clave = new JTextField(30);
        cont.setLayout(new FlowLayout());
        cont.add(new JLabel("Etiqueta: "));
        cont.add(clave);

        JButton aceptar = new JButton(ACEPTAR);
        aceptar.addActionListener(e -> {
            try {
                controlador.insertaEtiqueta(clave.getText());
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        aceptar.addActionListener(e-> ventana.setVisible(false));
        cont.add(aceptar);

        JList etiqueta = new JList(etiquetas);
        JScrollPane panelEtiquetas = new JScrollPane(etiqueta);
        etiqueta.setVisibleRowCount(4);
        etiqueta.setSize(100,50);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, cont, panelEtiquetas);
        ventana.getContentPane().add(splitPane);
        ventana.pack();
        //ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                vistaIndice.ejecuta();
                ventana.setVisible(true);
            }
        });
        ventana.setVisible(true);

    }

    public void insertarResponsable(String[] personas){
        JFrame ventana = new JFrame("Insertar un responsable a la tarea");
        Panel cont = new Panel();

        clave = new JTextField(30);
        cont.setLayout(new FlowLayout());
        cont.add(new JLabel("Identificador del responsable: "));
        cont.add(clave);

        JButton aceptar = new JButton(ACEPTAR);
        aceptar.addActionListener(e -> {
            try {
                controlador.insertaResponsable(clave.getText());
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        aceptar.addActionListener(e-> ventana.setVisible(false));

        cont.add(aceptar);

        JList respons = new JList(personas);
        JScrollPane panelPersonas = new JScrollPane(respons);
        respons.setVisibleRowCount(4);
        respons.setSize(100,50);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, cont, panelPersonas);
        ventana.getContentPane().add(splitPane);
        ventana.pack();

        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                vistaIndice.ejecuta();
                ventana.setVisible(true);
            }
        });
        ventana.setVisible(true);

    }

    public void satisfactorio(){
        JFrame ventana = new JFrame("Todo fue correctamente");
        Container cont = ventana.getContentPane();
        cont.add(new JLabel("   Todo fue correctamente"),BorderLayout.CENTER);
        ventana.setSize(200,200);
        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                vistaIndice.ejecuta();
                ventana.setVisible(true);
            }
        });
        ventana.setVisible(true);
    }

    public void errorTarea(){
        JFrame ventana = new JFrame("Error");
        Container cont = ventana.getContentPane();
        cont.add(new JLabel("   La tarea no se pudo añadir"), BorderLayout.CENTER);
        ventana.setSize(200,200);
        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                vistaIndice.ejecuta();
                ventana.setVisible(true);
            }
        });
        ventana.setVisible(true);

    }

    public void errorColaborador(){
        JFrame ventana = new JFrame("Error");
        Container cont = ventana.getContentPane();
        cont.add(new JLabel("   El colaborador no existe"), BorderLayout.CENTER);
        ventana.setSize(200,200);
        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                vistaIndice.ejecuta();
                ventana.setVisible(true);
            }
        });
        ventana.setVisible(true);
    }

    public void errorEtiqueta(){
        JFrame ventana = new JFrame("Error");
        Container cont = ventana.getContentPane();
        cont.add(new JLabel("No se ha podido introducir la etiqueta"), BorderLayout.CENTER);
        ventana.setSize(200,200);
        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                vistaIndice.ejecuta();
                ventana.setVisible(true);
            }
        });
        ventana.setVisible(true);
    }

    public void errorResponsable(){
        JFrame ventana = new JFrame("Error");
        Container cont = ventana.getContentPane();
        cont.add(new JLabel("No se ha podido introducir como responsable"), BorderLayout.CENTER);
        ventana.setSize(200,200);
        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                vistaIndice.ejecuta();
                ventana.setVisible(true);
            }
        });
        ventana.setVisible(true);
    }

    /*
    public void setNombreTarea(String nombreTarea){
        this.nombreTarea = nombreTarea;
    }

    public String getNombreTarea(){
        return nombreTarea;
    }

     */
    public String getNombreProyecto(){
        return "nombreProyecto";
    }

}
