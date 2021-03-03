package Persona;
import Tarea.Tarea;

import java.util.List;

public class Persona {
    private String nombre;           //nombre de la persona
    private String correo;           //correo de la persona
    private List<Tarea> listaTareas; //falta la lista de tareas

    public Persona(String nombre, String correo, List<Tarea> listaTareas){
        this.nombre = nombre;
        this.correo = correo;
        this.listaTareas = listaTareas; //falta la lista de tareas
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public List<Tarea> getListaTareas() {
        return listaTareas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setListaTareas(List<Tarea> listaTareas) {
        this.listaTareas = listaTareas;
    }
}
