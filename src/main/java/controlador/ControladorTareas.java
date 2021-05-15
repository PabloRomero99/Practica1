package controlador;

import modelo.Modelo;
import vista.Vista;

public class ControladorTareas implements Controlador {
    Modelo modelo;
    Vista vista;

    public void setModelo(Modelo modelo){
        this.modelo = modelo;
    }

    public void setVista(Vista vista){
        this.vista=vista;
    }

    @Override
    public void insertarPago() {
        String nomTarea = vista.getNombre();
        String tipo_fact = vista.getTipo_Fact();


        int cantidad;
        try{

        }catch (Exception e){}


    }
}