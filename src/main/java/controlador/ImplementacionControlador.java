package controlador;

import modelo.Modelo;
import modelo.ModeloProyecto;
import vista.Vista;
import vista.VistaAlta;
import vista.VistaInsertarEliminar;

import javax.swing.*;

public class ImplementacionControlador implements Controlador {
    private Modelo modelo;
    private Vista vista;
    private VistaAlta vistaAlta ;
    private VistaInsertarEliminar vistaInsertarEliminar;

    public void setVista(Vista vista){
        this.vista=vista;
    }

    public void setVistaAlta(VistaAlta vista){
        this.vistaAlta =vista;
    }

    public void setVistaInseElim(VistaInsertarEliminar vista){this.vistaInsertarEliminar = vista; }

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
        modelo = new ModeloProyecto();
        modelo.pulsadorDarAlta(actionCommand);
    }

    /*
    @Override
    public void darAltaPersona() {
        vistaAlta= new VistaAlta();
        String nombre = vistaAlta.getNombrePersona();
        String dni = vistaAlta.getDNI();
        String correo = vistaAlta.getCorreo();
        modelo.darAltaPersona(nombre,dni,correo);
    }
     */
    @Override
    public void darAltaPersona(JTextField nombre, JTextField dni, JTextField correo) {
        modelo = new ModeloProyecto();
        String n = nombre.getText();
        String d = dni.getText();
        String c = correo.getText();
        modelo.darAltaPersona(n,d,c);
    }

    @Override
    public void darAltaTarea(JTextField titulo, JTextField descripcion, JSlider prioridad) {
        modelo = new ModeloProyecto();
        String titulotarea = titulo.getText();
        String descrip = descripcion.getText();
        int priority = prioridad.getValue();
        modelo.darAltaTarea(titulotarea,descrip,priority);

    }

    @Override
    public void pulsadoInsertarEliminar() {
        System.out.println("si");
        modelo = new ModeloProyecto();
        modelo.pulsadorInsertarEliminar();
    }

    @Override
    public void insertaPersona(JTextField clave) {
        System.out.println("a");

    }

    @Override
    public void insertaEtiqueta(JTextField clave) {
        System.out.println("a");

    }

    @Override
    public void eliminaPersona(JTextField clave) {
        System.out.println("a");

    }

    @Override
    public void eliminaEtiqueta(JTextField clave) {
        System.out.println("a");
    }


}
