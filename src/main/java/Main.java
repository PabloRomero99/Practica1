import controlador.ImplementacionControlador;
import modelo.ModeloProyecto;
import vista.VistaPrincipal;

import javax.swing.*;

public class Main {
    public static void main(String[] args){
        final VistaPrincipal vista = new VistaPrincipal();
        final ImplementacionControlador controlador = ImplementacionControlador.getInstancia();
        final ModeloProyecto modelo = ModeloProyecto.getInstancia();


        vista.setControlador(controlador);
        controlador.setModelo(modelo);
        controlador.setVista(vista);
        modelo.setVista(vista);

        SwingUtilities.invokeLater(() -> vista.ejecuta());
    }
}
