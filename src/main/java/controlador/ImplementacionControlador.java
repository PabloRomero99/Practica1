package controlador;

import modelo.Modelo;
import modelo.ModeloProyecto;
import vista.*;

import javax.swing.*;

public class ImplementacionControlador implements Controlador {
    private Modelo modelo;
    private Vista vista;
    private VistaAlta vistaAlta ;
    private VistaInsertar vistaInsertar;
    private VistaEliminar vistaEliminar;
    private VistaListado vistaListado;

    public void setVistaListado(VistaListado vistaListado) {
        this.vistaListado = vistaListado;
    }

    public void setVista(Vista vista){
        this.vista=vista;
    }

    public void setVistaAlta(VistaAlta vista){
        this.vistaAlta =vista;
    }

    public void setVistaInsertar(VistaInsertar vista){this.vistaInsertar = vista; }

    public void setVistaEliminar(VistaEliminar vista){this.vistaEliminar = vista; }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    @Override
    public void iniciaProyecto() {
        String nombreProyecto = vista.getNombreProyecto();
        modelo.iniciaProyecto(nombreProyecto);

    }

    @Override
    public void pulsadoDarAlta(String actionCommand) {
        modelo = new ModeloProyecto();
        modelo.pulsadorDarAlta(actionCommand);
    }

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
    public void pulsadoAceptar(String actionCommand) {
        modelo = new ModeloProyecto();
        modelo.pulsadorAceptar(actionCommand);
    }

    @Override
    public void pulsadoInsertar(String actionCommand) {
        modelo = new ModeloProyecto();
        modelo.pulsadorInsertar(actionCommand);
    }

    /*
    @Override
    public void pulsadoEliminar() {

    }
     */

    @Override
    public void insertaPersona(String clave) {
        System.out.println("a");

    }

    @Override
    public void insertaEtiqueta(String clave) {
        System.out.println("a");

    }

    @Override
    public void eliminaPersona(String clave) {
        System.out.println("a");

    }

    @Override
    public void eliminaEtiqueta(String clave) {
        System.out.println("a");
    }


}
