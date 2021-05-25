
package modelo;

import modelo.Tarea.Tarea;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static modelo.genericos.clases.UtilidadesParaListas.elementosConListaVacia;

public class Proyecto implements Serializable {
    private String nombre; //Nombre del proyecto
    private List<Persona> participantes;
    private List<Tarea> tareas;
    //private List<Persona> responsables; //Ordenado posicion 0 correspondra a posicion 0 de la lista tareas

    public Proyecto() {
        super();
    }

    public Proyecto(String nombre) {
        this.nombre = nombre;
        this.participantes = new ArrayList<>();
        this.tareas = new ArrayList<>();
        //this.responsables = new ArrayList<>();
    }

    public List<Persona> getParticipantes() {       //Este serviria como Listar personas asignadas a un proyecto
        return participantes;
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean addParticipante(Persona persona) {
        if (participantes.size() == 0) {
            participantes.add(persona);
            return true;
        }
        for (Persona personita : participantes) {
            if (personita.getDNI().equals(persona.getDNI())) {
                System.out.println("La persona con DNI" + personita.getDNI() + " ya esta registrada en el proyecto");
                return false;
            }
        }
        participantes.add(persona);
        return true;
    }


    public boolean addTarea(Tarea tarea) {
        if (tareas.size() == 0) {
            tareas.add(tarea);
            return true;
        }
        for (Tarea tareita : tareas) {
            if (tareita.getTitulo().equals(tarea.getClave())) {
                System.out.println("La persona con DNI" + tareita.getClave() + " ya esta registrada en el proyecto");
                return false;
            }
        }
        tareas.add(tarea);
        return true;
    }

    public String[] toArrayParticipantes(Tarea t){
        String[] res = new String[participantes.size()];
        for (int n = 0; n < participantes.size(); n++){
            if (!t.getColaboradores().contains(participantes.get(n)))
                res[n] = participantes.get(n).toString();
        }
        return res;
    }

    public String[] toArrayListado(String accion){
        String[] res;
        if (accion.equals("persona")){
            res = new String[participantes.size()];
            for (int n = 0; n < participantes.size(); n++){
                res[n] = participantes.get(n).toString();
            }
        }else if (accion.equals("tarea")){
                res = new String[tareas.size()];
            for (int n=0;n<tareas.size();n++){
                res[n] = tareas.get(n).toString();
            }
        }else if (accion.equals("colaboradores")) {
            res = new String[tareas.size()];
            for (int n=0;n<tareas.size();n++) {
                res[n] = tareas.get(n).getColaboradores().toString();
            }
        }else if (accion.equals("personaSinResp")){
            List<Persona> listaVacia = elementosConListaVacia(participantes);
            int longitud = listaVacia.size();
            res = new String[longitud];
            for (int n = 0; n < longitud; n++) {
                res[n] = listaVacia.get(n).toString();
            }
        }else if (accion.equals("tareaNoColab")){
            List<Tarea> listaVacia = elementosConListaVacia(tareas);
            int longitud = listaVacia.size();
            res = new String[longitud];
            for (int n = 0; n < longitud; n++) {
                res[n] = listaVacia.get(n).toString();
            }
        }else {//if(accion.equals("nombreTarea"))
            res = new String[tareas.size()];
            for (int n=0;n<tareas.size();n++) {
                res[n] = tareas.get(n).getTitulo();
            }
        }
        return res;
    }

    public String[] mostrarPrecioTareas(){
        List<Tarea> listTarea = this.getTareas();
        String[] precioTarea = new String[listTarea.size()];
        for (int i = 0; i < listTarea.size(); i++) {
            precioTarea[i] = String.valueOf(listTarea.get(i).calculaFacturacion());
        }
        return precioTarea;
    }

    public double mostrarPrecioTotal(){
        double suma = 0;
        for (String precio:mostrarPrecioTareas()){
            suma += Double.parseDouble(precio);
        }
        return suma;
    }

}
