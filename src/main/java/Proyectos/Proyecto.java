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
            if (personita.getDNI().equals(persona.getDNI())){
                System.out.println("La persona con DNI" + personita.getDNI() +" ya esta registrada en el proyecto");
                return false;
            }
        }

        participantes.add(persona);
        return true;
    }

    public boolean encuentraTarea(String nombreTarea){
        for(Tarea t : this.tareas){
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

    public boolean encuentraPersona(String dniPersona){
        for(Persona p : this.participantes){
            if(dniPersona.equals(p.getDNI()))
                return true;
        }
        return false;
    }

    public Persona devuelvePersona(String dniPersona){
        if (encuentraPersona(dniPersona)){
            for(Persona p : this.participantes){
                if(dniPersona.equals(p.getDNI()))
                    return p;
            }
        }
        return null;
    }

    public Persona devuelvePersona2(Persona persona){
        if (encuentraElementos(persona,participantes)){
            for(Persona p : participantes){
                if(persona.getClave().equals(p.getDNI()))
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
        if (persona == null || !encuentraPersona(persona.getDNI()))  //Persona no esta dentro del proyecto
            return false;
        else if (encuentraPersona(persona.getDNI())) {
            for (Persona p : tarea.getColaboradores()) {
                if (p.getDNI().equals(persona.getDNI()))
                    return false;
            }
        }

        tarea.getColaboradores().add(persona);
        return true;

    }


    public boolean eliminarPersonaTarea(String dniPersona, Tarea tarea){
        for (Persona p : tarea.getColaboradores()) {
            if (p.getDNI().equals(dniPersona)) {
                tarea.getColaboradores().remove(p);
                return true;
            }
        }

        return false;
    }

    public boolean addResponsable(String dniPersona, String nomTarea, Proyecto p){
        Persona persona = p.devuelvePersona(dniPersona);

        if (p.encuentraTarea(nomTarea)) { //Tarea existe en proyecto
            Tarea tarea = p.devuelveTarea(nomTarea);
            if (tarea.getResponsable() == null) { //Tarea no tiene responsable
                if (!p.encuentraPersona(dniPersona)) {//Persona no esta en el proyecto
                    System.out.println("Esta persona no pertenece al proyecto, porfavor escoge una persona que " +
                            "este registrada en el proyecto, o el DNI no es correcto.");
                    return false;
                } else if (!tarea.getColaboradores().contains(persona)) { //Persona no colabora Tarea
                    tarea.getColaboradores().add(persona);
                    tarea.setResponsable(persona);
                    persona.addTareaResponsable(tarea);
                    return true;
                } else {
                    tarea.setResponsable(persona);
                    persona.addTareaResponsable(tarea);
                    return true;
                }
            }else{
                System.out.println("El responsable de la tarea es " + tarea.getResponsable()
                        + " y solo puede haber un responsable por tarea");
                return false;
            }
        }
        else {
            System.out.println("No existe ninguna tarea con ese nombre");
            return false;
        }
    }
}