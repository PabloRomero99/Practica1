package Tarea;
import Persona.Persona;
import Resultado.Resultado;

import java.time.LocalDate;
import java.util.List;

public class Tarea {
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

    //Constructor cuando hay fecha  de finalización
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


    public void marcarFinalizada(){
        finalizada = true;
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "Titulo='" + Titulo + '\n' +
                "\tDescripcion='" + Descripcion + '\n' +
                "\tcolaboradores=" + colaboradores + '\n' +
                "\tresponsable=" + responsable + '\n' +
                "\tprioridad=" + prioridad + '\n' +
                "\tfecha_creacion=" + fecha_creacion + '\n' +
                "\tfecha_finalización=" + fecha_finalización + '\n' +
                "\tfinalizada=" + finalizada + '\n' +
                "\tresultado=" + resultado + '\n' +
                "\tlista_etiquetas=" + lista_etiquetas + '\n' +
                '}';
    }

    public void marcarFinalizada(){
        this.finalizada = true;
    }

    public void añadirPersona(Persona persona){
        if (!colaboradores.contains(persona))
            colaboradores.add(persona);
        else
            System.out.println(persona.getNombre() + " ya es colaborador en esta tarea");
    }

    public void eliminarPersona(Persona persona){
        if (colaboradores.contains(persona))
            colaboradores.remove(persona);
        else
            System.out.println(persona.getNombre() + " no es colaborador en esta tarea");
    }
}
