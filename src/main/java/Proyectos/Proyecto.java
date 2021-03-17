package Proyectos;

import Persona.Persona;
import Tarea.Tarea;

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

    public boolean añadirParticipante(Persona persona){
        if (participantes.size() == 0 || !participantes.contains(persona)) {
            participantes.add(persona);
            return true;
        }else {
            return true;
        }
    }

    public boolean añadirTarea(Tarea tarea){
        if (tareas.contains(tarea))
            return false;
        else {
            tareas.add(tarea);
            return true;
        }

    }

    public boolean añadirTarea(String titulo, String descripcion, List<Persona> colaboradores, Persona responsable, int prioridad, LocalDate fecha_creacion, LocalDate fecha_finalización, Resultado resultado, List<String> lista_etiquetas){
        Tarea nueva = new Tarea(titulo, descripcion, colaboradores, responsable, prioridad, fecha_creacion, fecha_finalización, resultado, lista_etiquetas);
        if (tareas.contains(nueva))
            return false;
        else {
            tareas.add(nueva);
            return true;
        }
    }
}
