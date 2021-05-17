package vista.Insertar;

import controlador.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotonInsertar implements ActionListener {
    Controlador controlador;

    @Override
    public void actionPerformed(ActionEvent e) {
        controlador.pulsadoDarAlta();

    }
}
