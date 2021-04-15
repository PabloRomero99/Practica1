package Tarea;
import Interfaces.tieneClave;
import Interfaces.tieneLista;
import Persona.Persona;
import Resultado.Resultado;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Tarea implements tieneLista {
    private String Titulo;
    private String Descripcion;
    private List<Persona> colaboradores;
    private Persona responsable;
    private int prioridad;      //entre 1 (muy baja) y 5 (muy alta)
    private LocalDate fecha_creacion;
    private LocalDate fecha_finalización; //Puede estar en blanco si no ha finalizado
    private boolean finalizada;  //True = finalizado False = no finalizado
    private Resultado resultado; //el resultado esperado de la tarea
    private List<String> lista_etiquetas; //Un listado de etiquetas para asignar tópcios comunes

    //Constructor entero
    public Tarea(String titulo, String descripcion, List<Persona> colaboradores, Persona responsable, int prioridad, LocalDate fecha_creacion, LocalDate fecha_finalización, Resultado resultado, List<String> lista_etiquetas) {
        this.Titulo = titulo;
        this.Descripcion = descripcion;
        this.colaboradores = colaboradores;
        this.responsable = responsable;
        this.prioridad = prioridad;
        this.fecha_creacion = fecha_creacion;
        this.fecha_finalización = fecha_finalización;
        this.resultado = resultado;
        this.lista_etiquetas = lista_etiquetas;
    }

    //Constructor cuando queremos iniciar en proyecto
    public Tarea(String titulo, String descripcion,int prioridad, LocalDate fecha_creacion, Resultado resultado) {
        this.Titulo = titulo;
        this.Descripcion = descripcion;
        this.colaboradores = new ArrayList<Persona>();
        this.responsable = null;
        this.prioridad = prioridad;
        this.fecha_creacion = fecha_creacion;
        this.fecha_finalización = null;
        this.resultado = resultado;
        this.lista_etiquetas = new ArrayList<String>();
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public List<Persona> getColaboradores() {
        return colaboradores;
    }

    public void setColaboradores(List<Persona> colaboradores) {
        this.colaboradores = colaboradores;
    }

    public Persona getResponsable() {
        return responsable;
    }

    public void setResponsable(Persona responsable) {
        this.responsable = responsable;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public LocalDate getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(LocalDate fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public LocalDate getFecha_finalización() {
        return fecha_finalización;
    }

    public void setFecha_finalización(LocalDate fecha_finalización) {
        this.fecha_finalización = fecha_finalización;
    }

    public Resultado getResultado() {
        return resultado;
    }

    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }

    public List<String> getLista_etiquetas() {
        return lista_etiquetas;
    }

    public void setLista_etiquetas(List<String> lista_etiquetas) {
        this.lista_etiquetas = lista_etiquetas;
    }

    public String toString() {
        return "\t- Titulo= " + Titulo + '\n' +
                "\t- Descripcion= " + Descripcion + '\n' +
                "\t- Colaboradores= " + listaNombres() + '\n' +
                "\t- Responsable= " + devuelveResponsable() + '\n' +
                "\t- Prioridad= " + prioridad + '\n' +
                "\t- Fecha_creacion= " + fecha_creacion + '\n' +
                "\t- Fecha_finalización= " + fecha_finalización + '\n' +
                "\t- Finalizada= " + finalizada + '\n' +
                "\t- Resultado= " + resultado + '\n' +
                "\t- Lista de etiquetas= " + lista_etiquetas + '\n';
    }

    public void marcarFinalizada(){
        this.finalizada = true;
    }

    public List<String> listaNombres(){
        List<String> nombres = new ArrayList<>();
        for (Persona p : colaboradores){
            nombres.add(p.getNombre());
        }
        return nombres;
    }

    public String devuelveResponsable(){
        if (responsable == null)
            return "Ninguno";
        else
            return responsable.getNombre();
    }

}