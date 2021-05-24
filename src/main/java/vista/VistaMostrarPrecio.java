package vista;

import controlador.ImplementacionControlador;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VistaMostrarPrecio {
    private ImplementacionControlador controlador = ImplementacionControlador.getInstancia();
    private VistaIndice vistaIndice;

    public void ejecutaMostrarPrecio() {

        String[] precios = controlador.consultarPrecioPorTarea();
        String[] tareas = controlador.conseguirListado("nombreTarea");
        JFrame ventana = new JFrame("JList");
        String[] datos = new String[tareas.length+1];
        for (int i=0; i<tareas.length;i++){
            datos[i] = tareas[i]+ " = " +precios[i] + "€";
        }

        datos[datos.length-1] ="PRECIO FINAL = " + controlador.consultarPrecioTotal();

        JList lTareas = new JList(datos);
        JScrollPane panelTareas = new JScrollPane(lTareas);
        lTareas.setVisibleRowCount(4);
        lTareas.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);


        ventana.getContentPane().add(panelTareas);
        ventana.pack();
        ventana.setVisible(true);
        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                vistaIndice=vistaIndice.getInstancia();
                vistaIndice.ejecuta();
                ventana.setVisible(true);
            }
        });
    }

}

