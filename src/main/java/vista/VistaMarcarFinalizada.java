package vista;

import controlador.ImplementacionControlador;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class VistaMarcarFinalizada {
    private ImplementacionControlador controlador = ImplementacionControlador.getInstancia();

    public void ejecuta(){
        String[] datos = {"Enero", "Febrero", "Marzo", "Abril",
                "Mayo", "Junio", "Julio", "Agosto",
                "Septiembre", "Octubre", "Noviembre",
                "Diciembre"};
        //String[] datossh = controlador.listaTareas();
        JFrame ventana = new JFrame("JList");
        JList meses = new JList(datos);
        JScrollPane panelMeses = new JScrollPane(meses);
        meses.setVisibleRowCount(4);
        meses.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        //________ Para saber que boton hemos pulsado
        MouseListener mouseListener = new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int index = meses.locationToIndex(e.getPoint());
                    System.out.println("Double clicked on Item " + index);
                }
            }
        };
        meses.addMouseListener(mouseListener);
        //_______

        ventana.getContentPane().add(panelMeses);
        ventana.pack();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);

    }
}
