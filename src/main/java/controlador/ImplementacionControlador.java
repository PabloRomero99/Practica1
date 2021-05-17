package controlador;

import modelo.Modelo;
import modelo.ModeloProyecto;
import vista.Vista;
import vista.VistaAlta;

public class ImplementacionControlador implements Controlador {
    private Modelo modelo;
    private Vista vista;
    private VistaAlta vista2;

    public void setVista(Vista vista){
        this.vista=vista;
    }

    public void setVista2(VistaAlta vista){
        this.vista2=vista;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    @Override
    public void iniciaProyecto() {
        String nombreProyecto = vista.getNombreProyecto();
        modelo.iniciaProyecto(nombreProyecto);

    }

    @Override
    public void pulsadoDarAlta(int actionCommand) {
        modelo.pulsadorDarAlta(actionCommand);
    }

}
