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
        if (participantes.size() == 0){
            participantes.add(persona);
            return true;
        }

        for (Persona personita : participantes){
            if (personita.getCorreo().equals(persona.getCorreo()) && personita.getNombre().equals(persona.getNombre())){
                System.out.println("La persona ya esta registrada en el proyecto");
                return false;
            }
        }

        participantes.add(persona);
        return true;
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
        for(Persona p : this.participantes){
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
        return tareas.add(tarea);
    }



    public boolean addEtiquetas(String etiqueta, Tarea tarea){
            if (!tarea.getLista_etiquetas().contains(etiqueta))
                return tarea.getLista_etiquetas().add(etiqueta);

            System.out.println("La etiqueta " + etiqueta + " ya esta en la lista de etiquetas de la tarea ");
            return false;
    }



    public boolean eliminarEtiqueta(String etiqueta,Tarea tarea) {
        if (tarea.getLista_etiquetas().contains(etiqueta))
            return tarea.getLista_etiquetas().remove(etiqueta);

        System.out.println("La etiqueta " + etiqueta + " no se encuentra en la lista de etiquetas");
        return false;
    }



    public  boolean addPersonaTarea(Persona persona, Tarea tarea){
        for (Persona p : tarea.getColaboradores()) {
            if(p.equals(persona)) {
                return false;
            }
        }
        tarea.getColaboradores().add(persona);
        return true;
    }


    public boolean eliminarPersonaTarea(String persona, Tarea tarea){
        for (Persona p : tarea.getColaboradores()) {
            if(p.getNombre().equals(persona)) {
                tarea.getColaboradores().remove(p);
                return true;
            }
        }
        return false;
    }



    public void addResponsable(String nomPersona, String nomTarea, Proyecto p){
        Tarea tarea = p.devuelveTarea(nomTarea);
        Persona persona = p.devuelvePersona(nomPersona);

        if (p.encuentraTarea(nomTarea)) { //Tarea existe en proyecto
            Tarea tarea = p.devuelveTarea(nomTarea);
            if (tarea.getResponsable() == null) { //Tarea no tiene responsable
                if (!p.encuentraPersona(persona.getNombre()))//Persona no esta en el proyecto
                    System.out.println("Esta persona no pertenece al proyecto, porfavor escoge una persona que " +
                            "este registrada en el proyecto");
                else if (!tarea.getColaboradores().contains(persona)) { //Persona no colabora Tarea
                    tarea.getColaboradores().add(persona);
                    tarea.setResponsable(persona);
                    persona.addTareaResponsable(tarea);
                }else{
                    tarea.setResponsable(persona);
                    persona.addTareaResponsable(tarea);
                }
            }
            else
                System.out.println("El responsable de la tarea es "+  tarea.getResponsable()
                       + " y solo puede hbaer un responsable por tarea");
        }
        else
            System.out.println("No existe ninguna tarea con ese nombre");
    }
}
