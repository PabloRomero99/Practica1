package controlador;

import modelo.Modelo;
import vista.Vista;

public class ControladorStartProject implements ControladorInicioProyecto {
    private Modelo modelo;
    private Vista vista;

    public void setVista(Vista vista){
        this.vista=vista;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    @Override
    public void iniciaProyecto() {
        String nombreProyecto = vista.getNombreProyecto();
        modelo.iniciaProyecto(nombreProyecto);

    }
}
