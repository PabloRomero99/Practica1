package Proyectos;

import Persona.Persona;
import Tarea.Tarea;

import java.util.ArrayList;
import java.util.List;

import static Listas.UtilidadesParaListas.encuentraElementos;

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
        if (participantes.size() == 0){
            participantes.add(persona);
            return true;
        }
        for (Persona personita : participantes){
            if (personita.getDNI().equals(persona.getClave())){
                System.out.println("La persona con DNI" + personita.getDNI() +" ya esta registrada en el proyecto");
                return false;
            }
        }
        participantes.add(persona);
        return true;
    }

    public boolean addTarea(Tarea tarea){
        if (tareas.size() == 0){
            tareas.add(tarea);
            return true;
        }
        for (Persona personita : participantes){
            if (personita.getDNI().equals(tarea.getClave())){
                System.out.println("La persona con DNI" + personita.getDNI() +" ya esta registrada en el proyecto");
                return false;
            }
        }
        tareas.add(tarea);
        return true;
    }

    public Tarea devuelveTarea(String nombreTarea){
        if (encuentraElementos(tareaVacia(nombreTarea), tareas)){
            for(Tarea t:this.tareas){
                if(nombreTarea.equals(t.getTitulo()))
                    return t;
            }
        }
        return null;
    }

    public static Tarea tareaVacia(String nom){ //metodo para usar getelemento (temporal)
        return new Tarea(nom,null,0,null,null);
    }
}
