package Persona;
import Tarea.Tarea;

import java.util.List;

public class Persona {
    private String nombre;           //nombre de la persona
    private String correo;           //correo de la persona
    private List<Tarea> listaTareasResponsable; //lista de tareas de las cual es responsable esta Persona

    public Persona(String nombre, String correo, List<Tarea> listaTareas){
        this.nombre = nombre;
        this.correo = correo;
        this.listaTareasResponsable = listaTareas; //falta la lista de tareas
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public List<Tarea> getListaTareasResponsable() {
        return listaTareasResponsable;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setListaTareasResponsable(List<Tarea> listaTareasResponsable) {
        this.listaTareasResponsable = listaTareasResponsable;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", listaTareasResponsable=" + listaTareasResponsable +
                '}';
    }
}
