package controlador;

import modelo.ModeloProyecto;
import modelo.Tarea.Tarea;
import vista.*;

import javax.swing.*;
import java.util.List;

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
    public void pulsadorJRadioButton(String actionCommand) {
        modelo.pulsadorJRadioButton(actionCommand);
    }

    @Override
    public void darAltaPersona(JTextField nombre, JTextField dni, JTextField correo) {
        String n = nombre.getText();
        String d = dni.getText();
        String c = correo.getText();
        modelo.darAltaPersona(n,d,c);
    }

    @Override
    public void darAltaTarea(JTextField titulo, JTextField descripcion, JSlider prioridad, JTextField coste,JTextField dto) {
        String titulotarea = titulo.getText();
        String descrip = descripcion.getText();
        int priority = prioridad.getValue();
        double cost = Double.parseDouble(coste.getText());
        double descuento = Double.parseDouble(dto.getText());
        modelo.darAltaTarea(titulotarea,descrip,priority,cost,descuento);
    }

    @Override
    public void pulsadoAceptar(String actionCommand, String nomTarea) {
        modelo.pulsandoAceptar(actionCommand, nomTarea);
    }

    @Override
    public void pulsadoInsertar(String actionCommand) throws Exception {
        modelo.pulsandoInsertar(actionCommand);
    }

    @Override
    public void pulsadoEliminar(String actionCommand) throws Exception{
        modelo.pulsandoEliminar(actionCommand);
    }

    @Override
    public void insertaColaborador(String clave) throws Exception {
        modelo.insertandoColaborador(clave);
    }

    @Override
    public void insertaEtiqueta(String etiqueta) throws Exception {
        modelo.insertandoEtiqueta(etiqueta);

    }

    @Override
    public void insertaResponsable(String clave) throws Exception{
        modelo.insertandoResponsable(clave);
    }

    @Override
    public void eliminaPersona(String clave) throws Exception {
        modelo.eliminandoColaborador(clave);

    }

    @Override
    public void eliminaEtiqueta(String clave) throws Exception {
        modelo.eliminandoEtiqueta(clave);
    }

    @Override
    public void pulsadoListarPersona(String actionCommand){
        modelo.pulsadoListarPersona(actionCommand);
    }

    @Override
    public void finalizarProyecto() {
        modelo.finalizarProyecto();
    }

    @Override
    public String[] conseguirListado(String cadena) {
        return modelo.conseguirListado(cadena);
    }

    @Override
    public void pulsadoListarTareas(String text) {
        modelo.pulsadoListarTareas(text);
    }

    @Override
    public void marcarFinalizada(int index) {
        modelo.marcarFinalizada(index);
    }

    @Override
    public String[] consultarPrecioPorTarea() {
        return modelo.consultarPrecioPorTarea();
    }

    @Override
    public double consultarPrecioTotal() {
        return modelo.consultarPrecioTotal();
    }

    @Override
    public void modificarTipoFact(double dto, JTextField tarea,int tipo_fac) throws Exception {
        modelo.modificarTipoFact(dto,tarea,tipo_fac);
    }

    @Override
    public void modificarCoste(JTextField coste, JTextField tarea) throws Exception {
        modelo.modificarCoste(coste, tarea);
    }

    @Override
    public void realizarModificacion(int i) {
        modelo.realizarModificacion(i);
    }


}