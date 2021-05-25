package vista;

import controlador.ImplementacionControlador;
import modelo.Tarea.Tarea;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class VistaMarcarFinalizada {
    private ImplementacionControlador controlador = ImplementacionControlador.getInstancia();
    private VistaIndice vistaIndice = VistaIndice.getInstancia();
    private int index;

    public void ejecuta(){
        String[] datos = controlador.conseguirListado("tarea");
        JFrame ventana = new JFrame("JList");
        JPanel cont = new JPanel();

        JList tareas = new JList(datos);
        JScrollPane panelTareas = new JScrollPane(tareas);
        tareas.setVisibleRowCount(4);

        tareas.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        //--------- Para saber que boton hemos pulsado
        MouseListener mouseListener = new MouseAdapter() {
            public void mouseClicked(MouseEvent c) {
                if (c.getClickCount() == 2) {
                    index = tareas.locationToIndex(c.getPoint());
                    System.out.println("Double clicked on Item " + index);

                }
            }
        };

        JTextField horas = new JTextField(30);
        cont.setLayout(new FlowLayout());
        cont.add(new JLabel("Introduce las horas invertidas en la tarea: "));
        cont.add(horas);

        JButton aceptar = new JButton("ACEPTAR");
        tareas.addMouseListener(mouseListener);
        aceptar.addActionListener(e -> controlador.marcarFinalizada(index,horas));
        aceptar.addActionListener(e -> vistaIndice.ejecuta());
        aceptar.addActionListener(e -> ventana.setVisible(false));
        cont.add(aceptar);

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,panelTareas,cont);
        //splitPane.setDividerLocation(500);
        ventana.getContentPane().add(splitPane);
        ventana.setSize(800,800);






        ventana.pack();
        ventana.setVisible(true);
    }


}
