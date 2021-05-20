
package modelo;

import modelo.Tarea.Tarea;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

    public String[] toArrayParticipantes(){
        String[] res = new String[participantes.size()];
        for (int n = 0; n < participantes.size(); n++){
            res[n] = participantes.get(n).toString();
        }
        return res;
    }
    /*



    public void escribirFichero() throws IOException, ClassNotFoundException {
        FileOutputStream fos = new FileOutputStream( nombre + ".bin");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this);
        oos.close();
    }

     */
}
