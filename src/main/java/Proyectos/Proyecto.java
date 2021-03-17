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

    public void iniciarProyecto(String nombre){
        Proyecto nuevoproyecto = new Proyecto();
        nuevoproyecto.nombre = nombre;
        nuevoproyecto.participantes = null;
        nuevoproyecto.tareas = null;
        nuevoproyecto.responsables = null;
        System.out.println("El proyecto con nombre " + nombre + " se ha creado correctamente");
    }

    public boolean añadirParticipante(String nombre, String correo, List<Tarea> lista){
        Persona nueva = new Persona(nombre, correo, lista);
        if (participantes.contains(nueva))
            return false;
        else {
            participantes.add(nueva);
            return true;
        }
    }

    public boolean añadirTarea(String titulo, String descripcion, List<Persona> colaboradores, Persona responsable, int prioridad, LocalDate fecha_creacion, LocalDate fecha_finalización, Resultado resultado, List<String> lista_etiquetas){
        Tarea nueva = new Tarea(titulo, descripcion, colaboradores, responsable, prioridad, fecha_creacion, fecha_finalización, resultado, lista_etiquetas);
        if (participantes.contains(nueva))
            return false;
        else {
            tareas.add(nueva);
            return true;
        }
    }

    public boolean añadirResponsables(Persona persona){
        if (responsables.contains(persona))
            return false;
        else {
            responsables.add(persona);
            return true;
        }
    }

    public List<Persona> consultarParticipantes(){
        return participantes;
    }
}
