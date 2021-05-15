package vista;

import controlador.Controlador;
import modelo.Modelo;
import javax.swing.*;
import java.awt.*;

public class VistaIndice implements Vista{
    private Modelo modelo;
    private Controlador controlador;

    JFrame ventana = new JFrame("Dar de alta");
    Container contenedor = ventana.getContentPane();
    JButton boton = new JButton("Soy un botón sencillo");
    contenedor.add(boton);
    ventana.pack();
    ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ventana.setVisible(true);

}
