package controlador;

import modelo.Modelo;
import modelo.Persona;
import modelo.Proyecto;
import vista.Vista;
import vista.VistaAlta;

import java.util.List;

public class ControladorDarAlta implements Controlador{
    private Modelo modelo;
    private VistaAlta vista;

    private void setModelo(Modelo modelo){
        this.modelo=modelo;
    }

    private void setVista(VistaAlta vista){
        this.vista=vista;
    }

    @Override
    public void compruebaControlador() {

    }

    @Override
    public void pulsadoDarAlta() {
        vista.ejecuta();
    }

    @Override
    public void darAltaPersona() {


    }

    /*public void pulsadoPersona(String actionCommand){
        vista.altaPersona();
    }

    public void pulsadoTarea(String actionCommand){
        vista.altaTarea();
    }

    public void darAltaPersona(){
        String nombrePersona = vista.getNombrePersona();
        String dni = vista.getDNI();
        String correo = vista.getCorreo();
        modelo.darAltaPersona(nombrePersona,dni,correo);

    }*/

   //public List<Persona> getPersonas(String actionCommand){ return modelo.devuelvePersonas(); }
}
