package Persona;
import Interfaces.tieneLista;
import Interfaces.tieneClave;
import Tarea.Tarea;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Persona implements tieneLista, tieneClave, Serializable {
    private String nombre;           //nombre de la persona
    private String DNI;              //identificador principal de una persona
    private String correo;           //correo de la persona
    private List<Tarea> listaTareasResponsable; //lista de tareas de las cual es responsable esta Persona

    public Persona(String nombre, String correo,String DNI){
        this.nombre = nombre;
        this.correo = correo;
        this.DNI = DNI;
        this.listaTareasResponsable = new ArrayList<Tarea>();
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

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public boolean eliminarTareaResponsable(Tarea t){
        if (listaTareasResponsable == null || !listaTareasResponsable.contains(t))
            return false;
        listaTareasResponsable.remove(t);
        return true;
    }

    public void addTareaResponsable(Tarea t){
        if (listaTareasResponsable == null)
            listaTareasResponsable = new ArrayList<>();
        listaTareasResponsable.add(t);
    }

    public List<String> devuelveNombreTarea(){
        if (listaTareasResponsable == null)
            listaTareasResponsable = new ArrayList<>();
        List<String> nombres = new ArrayList<>();
        for (Tarea t : listaTareasResponsable){
            nombres.add(t.getTitulo());
        }
        return nombres;
    }


    @Override
    public String toString() {
        return "- Nombre = " + nombre + ", Correo = " + correo + ", DNI = " + DNI +", Responsable en las tareas = " + devuelveNombreTarea();
    }

    @Override
    public List getLista() {
        return listaTareasResponsable;
    }

    @Override
    public Object getClave() {
        return DNI;
    }
}
