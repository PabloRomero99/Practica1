package modelo;

import modelo.Tarea.Facturacion.ConsumoInterno;
import modelo.Tarea.Facturacion.Facturacion;
import modelo.Tarea.Resultado.Resultado;
import modelo.Tarea.Tarea;
import vista.*;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.time.LocalDate;


public class ModeloProyecto implements Modelo, Serializable {

    private Vista vista;
    private VistaAlta vistaAlta;
    private VistaInsertar vistaInsertar;
    private VistaEliminar vistaEliminar;
    private VistaListado vistaListado;
    private Proyecto proyecto;


    public void setVista(Vista vista){
        this.vista=vista;
    }

    public void setVistaAlta(VistaAlta vista){
        this.vistaAlta=vista;
    }

    public void setVistaListado(VistaListado vistaListado) {
        this.vistaListado = vistaListado;
    }

    public void setVistaInsertar(VistaInsertar vista){this.vistaInsertar = vista;}

    public void setVistaEliminar(VistaEliminar vista){this.vistaEliminar = vista;}

    @Override
    public void iniciaProyecto(String nombreProyecto) {
        System.out.println(nombreProyecto);
        try {
            FileInputStream fis = new FileInputStream(nombreProyecto + ".bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Proyecto proyecto = (Proyecto) ois.readObject();
            ois.close();
            this.proyecto = proyecto;

        }catch(IOException | ClassNotFoundException e){
            System.out.println("El proyecto con nombre " + nombreProyecto + " se ha creado correctamente\n\n");
            this.proyecto =  new Proyecto(nombreProyecto);
        }
    }

    @Override
    public void pulsadorDarAlta(String actionCommand) {
        vistaAlta = new VistaAlta();
        if (actionCommand.equals("Persona")){
            System.out.println("PERSONA ");
            vistaAlta.altaPersona();
        }else {
            System.out.println("TAREA ");
            vistaAlta.altaTarea();
        }
    }

    @Override
    public void darAltaPersona(String nombre, String dni, String correo) {
        Persona persona = new Persona(nombre,dni,correo);
        System.out.println("La persona "+ persona + " ha sido creada");
        //proyecto.addParticipante(persona);
    }

    @Override
    public void darAltaTarea(String titulotarea, String descrip, int priority) {//,String identificador, int horas_invertidas,int tipo_resultado,double coste, Facturacion facturacion
        Resultado resultado = new Resultado("identificador",15,true);
        Facturacion facturacion = new ConsumoInterno();
        Tarea tarea = new Tarea(titulotarea,descrip,priority,LocalDate.now(),resultado,25,facturacion);
        System.out.println("La tarea" + tarea + " ha sido creada");
    }

    @Override
    public void pulsandoAceptar(String actionCommand) {
        if (actionCommand.equals("Insertar")){
            System.out.println("INSERTAR");
            vistaInsertar = new VistaInsertar();
            vistaInsertar.ejecutaInsertar();
        }else{
            System.out.println("ELIMINAR");
            vistaEliminar = new VistaEliminar();
            vistaEliminar.ejecutaEliminar();
        }
    }

    @Override
    public void pulsandoInsertar(String actionCommand) {
        vistaInsertar = new VistaInsertar();
        if (actionCommand.equals("Colaborador")){
            System.out.println("COLABORADOR");
            vistaInsertar.insertarColaborador();

        }else if (actionCommand.equals("Etiqueta")){
            System.out.println("ETIQUETA");
            vistaInsertar.insertarEtiqueta();

        }else{
            System.out.println("RESPONSABLE");
            vistaInsertar.insertarResponsable();
        }
    }

    @Override
    public void insertandoColaborador(String clave) {
        System.out.println("guapo");
    }

    @Override
    public void pulsandoEliminar(String actionCommand) {
        if (actionCommand.equals("Colaborador")){
            System.out.println("COLABORADOR");
            vistaEliminar.eliminarColaborador();
        }else{
            System.out.println("ETIQUETA");
            vistaEliminar.eliminarEtiqueta();
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
