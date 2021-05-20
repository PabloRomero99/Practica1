package controlador;

import modelo.Modelo;
import modelo.ModeloProyecto;
import vista.*;

import javax.swing.*;

public class ImplementacionControlador implements Controlador {
    private Vista vista;
    private VistaAlta vistaAlta ;
    private VistaInsertar vistaInsertar;
    private VistaEliminar vistaEliminar;
    private VistaListado vistaListado;
    private ModeloProyecto modelo= ModeloProyecto.getInstancia();

    private static ImplementacionControlador instancia = null;
    private ImplementacionControlador(){
        super();
    }
    public static ImplementacionControlador getInstancia(){
        if (instancia == null){
            instancia = new ImplementacionControlador();
        }
        return instancia;
    }

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

    public void setModelo(ModeloProyecto modelo) {
        this.modelo = modelo;
    }

    @Override
    public void iniciaProyecto() {
        String nombreProyecto = vista.getNombreProyecto();
        modelo.iniciaProyecto(nombreProyecto);

    }

    @Override
    public void pulsadoDarAlta(String actionCommand) {
        modelo.pulsadorDarAlta(actionCommand);
    }

    @Override
    public void darAltaPersona(JTextField nombre, JTextField dni, JTextField correo) {
        String n = nombre.getText();
        String d = dni.getText();
        String c = correo.getText();
        modelo.darAltaPersona(n,d,c);
    }

    @Override
    public void darAltaTarea(JTextField titulo, JTextField descripcion, JSlider prioridad) {
        String titulotarea = titulo.getText();
        String descrip = descripcion.getText();
        int priority = prioridad.getValue();
        modelo.darAltaTarea(titulotarea,descrip,priority);
    }

    @Override
    public void pulsadoAceptar(String actionCommand, String nomTarea) {
        modelo.pulsandoAceptar(actionCommand, nomTarea);
    }

    @Override
    public void pulsadoInsertar(String actionCommand) {
        modelo.pulsandoInsertar(actionCommand);
    }

    @Override
    public void pulsadoEliminar(String actionCommand) {
        modelo.pulsandoEliminar(actionCommand);
    }

    @Override
    public void insertaColaborador(String clave) throws Exception {
        modelo.insertandoColaborador(clave);
    }

    @Override
    public void insertaEtiqueta(String clave) {
        System.out.println("a");

    }

    @Override
    public void insertaResponsable(String clave) {

    }

    @Override
    public void eliminaPersona(String clave) {
        System.out.println("a");

    }

    @Override
    public void eliminaEtiqueta(String clave) {
        System.out.println("a");
    }

    @Override
    public void pulsadoListarPersona(String actionCommand){
        modelo.pulsadoListarPersona(actionCommand);
    }
}