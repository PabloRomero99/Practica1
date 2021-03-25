package Proyectos;

import Persona.Persona;
import Resultado.Resultado;
import Tarea.Tarea;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Proyecto {
    private String nombre; //Nombre del proyecto
    private List<Persona> participantes;
    private List<Tarea> tareas;
    private List<Persona> responsables; //Ordenado posicion 0 correspondra a posicion 0 de la lista tareas

    public Proyecto() {
        super();
    }

    public Proyecto(String nombre){
        this.nombre = nombre;
        this.participantes = new ArrayList<>();
        this.tareas = new ArrayList<>();
        this.responsables = new ArrayList<>();
    }

    public List<Persona> getParticipantes() {       //Este serviria como Listar personas asignadas a un proyecto
        return participantes;
    }

    public List<Tarea> getTareas(){
        return tareas;
    }

    public boolean addParticipante(Persona persona){
        if (participantes.size() == 0 || !participantes.contains(persona)) {
            participantes.add(persona);
            return true;
        }else {
            return true;
        }
    }

    public boolean encuentraTarea(String nombreTarea){
        for(Tarea t:this.tareas){
            if(nombreTarea.equals(t.getTitulo()))
                return true;
        }
        return false;
    }
    public Tarea devuelveTarea(String nombreTarea){
        if (encuentraTarea(nombreTarea)){
            for(Tarea t:this.tareas){
                if(nombreTarea.equals(t.getTitulo()))
                    return t;
            }
        }
       return null;
    }

    public boolean encuentraPersona(String nombrePersona){
        for(Persona p:this.participantes){
            if(nombrePersona.equals(p.getNombre()))
                return true;
        }
        return false;
    }

    public Persona devuelvePersona(String nombrePersona){
        if (encuentraPersona(nombrePersona)){
            for(Persona p:this.participantes){
                if(nombrePersona.equals(p.getNombre()))
                    return p;
            }
        }
        return null;
    }

    public boolean addTarea(Tarea tarea){
        Tarea nueva = new Tarea(tarea.getTitulo(),tarea.getDescripcion(),tarea.getColaboradores(),tarea.getResponsable(),tarea.getPrioridad(),tarea.getFecha_creacion(),tarea.getFecha_finalización(),tarea.getResultado(),tarea.getLista_etiquetas());
        if (tareas.contains(nueva))
            return false;
        else {
            tareas.add(nueva);
            return true;
        }

    }

    public boolean addTarea(String titulo, String descripcion, List<Persona> colaboradores, Persona responsable, int prioridad, LocalDate fecha_creacion, LocalDate fecha_finalización, Resultado resultado, List<String> lista_etiquetas) {
        Tarea nueva = new Tarea(titulo, descripcion, colaboradores, responsable, prioridad, fecha_creacion, fecha_finalización, resultado, lista_etiquetas);
        if (tareas.contains(nueva))
            return false;
        else {
            tareas.add(nueva);
            return true;
        }
    }

    public void addEtiquetas(String etiqueta, Tarea tarea){
            if (!tarea.getLista_etiquetas().contains(etiqueta))
                tarea.getLista_etiquetas().add(etiqueta);
            else
                System.out.println("La etiqueta " + etiqueta + "ya esta en la lista de etiquetas de la tarea ");

    }
    public void eliminarEtiqueta(String etiqueta,Tarea tarea) {
        if (tarea.getLista_etiquetas().contains(etiqueta))
            tarea.getLista_etiquetas().remove(etiqueta);
        else
            System.out.println("La etiqueta " + etiqueta + "no se encuentra en la lista de etiquetas");
    }

    public void addPersona(Persona persona, Tarea tarea){
        for (Persona p : tarea.getColaboradores()) {
            if(p.equals(persona)) {
                System.out.println(persona.getNombre() + " ya es colaborador en esta tarea");
                break;
            }
        }
        tarea.getColaboradores().add(persona);
        System.out.println("La persona se ha añadido correctamente");
    }

    public void eliminarPersona(String persona, Tarea tarea){
        for (Persona p : tarea.getColaboradores()) {
            if(p.getNombre().equals(persona)) {
                tarea.getColaboradores().remove(p);
                System.out.println("La persona se ha borrado correctamente");
                break;
            }
        }
        System.out.println(persona + "no es colaborador/a en esta tarea");
    }
}
