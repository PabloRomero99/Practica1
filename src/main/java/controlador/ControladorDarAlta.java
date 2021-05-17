package controlador;

import modelo.Modelo;
import vista.VistaAlta;

public class ControladorDarAlta implements ControladorAlta {
    private Modelo modelo;
    private VistaAlta vista;


    public void setModelo(Modelo modelo){
        this.modelo=modelo;
    }

    public void setVista(VistaAlta vista){
        this.vista=vista;
    }

    @Override
    public void pulsadoDarAlta(int actionCommand) {
        modelo.pulsadorDarAlta(actionCommand);
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
