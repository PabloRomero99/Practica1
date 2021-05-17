package modelo;

import vista.Vista;
import vista.VistaAlta;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class ModeloProyecto implements Modelo, Serializable {
    private Vista vista;
    private VistaAlta vistaAlta;

    public void setVista(Vista vista){
        this.vista=vista;
    }

    public void setVista2(VistaAlta vista){
        this.vistaAlta=vista;
    }

    @Override
    public void iniciaProyecto(String nombreProyecto) {
        System.out.println(nombreProyecto);
        try {
            FileInputStream fis = new FileInputStream(nombreProyecto + ".bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Proyecto proyecto = (Proyecto) ois.readObject();
            ois.close();
            //return proyecto;

        }catch(IOException | ClassNotFoundException e){
            System.out.println("El proyecto con nombre " + nombreProyecto + " se ha creado correctamente\n\n");
            //return new Proyecto(nombreProyecto);
        }
    }

    @Override
    public void pulsadorDarAlta(int actionCommand) {
        switch (actionCommand) {
            case 1:
                System.out.println("PERSONA ");

                break;
            case 2:
                System.out.println("TAREA ");
                break;
        }
    }

}










/*
    @Override
    public String getNombre() {
        return null;
    }

    @Override
    public double getPrecio() {
        return 0;
    }

    @Override
    public void ProyectocompruebaNProyecto(String nombre) {
        try {
            FileInputStream fis = new FileInputStream(nombre + ".bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Proyecto proyecto = (Proyecto) ois.readObject();
            ois.close();
            //return proyecto;


        }catch(IOException | ClassNotFoundException e){
            System.out.println("El proyecto con nombre " + nombre + " se ha creado correctamente\n\n");
            //return new Proyecto(nombre);

        }
    }

    @Override
    public void darAltaPersona(String nombrePersona, String dni, String correo) {

        if (participantes.size() == 0) {
            participantes.add(persona);
            return true;
        }
        for (Persona personita : participantes) {
            if (personita.getClave().equals(persona.getClave())) {
                System.out.println("La persona con DNI" + personita.getClave() + " ya esta registrada en el proyecto");
                return false;
            }
        }
        participantes.add(persona);
        return true;
         */
