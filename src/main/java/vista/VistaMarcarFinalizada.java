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
    private VistaIndice vistaIndice;

    public void ejecuta(){
        String[] datos = controlador.conseguirListado("tarea");
        JFrame ventana = new JFrame("JList");
        Container cont = ventana.getContentPane();
        JList tareas = new JList(datos);
        JScrollPane panelMeses = new JScrollPane(tareas);
        tareas.setVisibleRowCount(4);
        tareas.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        //________ Para saber que boton hemos pulsado
        MouseListener mouseListener = new MouseAdapter() {
            public void mouseClicked(MouseEvent c) {
                if (c.getClickCount() == 2) {
                    int index = tareas.locationToIndex(c.getPoint());
                    System.out.println("Double clicked on Item " + index);
                    JButton aceptar = new JButton("ACEPTAR");
                    aceptar.addActionListener(e -> controlador.marcarFinalizada(index));
                    aceptar.addActionListener(e -> vistaIndice.ejecuta());
                    cont.add(aceptar);
                }
            }
        };
        tareas.addMouseListener(mouseListener);
        //_______

        ventana.getContentPane().add(panelMeses);
        ventana.pack();
        ventana.setVisible(true);

    }
}
