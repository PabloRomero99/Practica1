package modelo;

import controlador.ImplementacionControlador;
import modelo.Tarea.Facturacion.ConsumoInterno;
import modelo.Tarea.Facturacion.Facturacion;
import modelo.Tarea.Resultado.Resultado;
import modelo.Tarea.Tarea;
import vista.*;
import modelo.genericos.clases.UtilidadesParaListas;

import java.io.*;
import java.time.LocalDate;

import static modelo.genericos.clases.UtilidadesParaListas.devuelveElemento;


public class ModeloProyecto implements Modelo, Serializable {

    private Vista vista;
    private VistaAlta vistaAlta;
    private VistaInsertar vistaInsertar;
    private VistaEliminar vistaEliminar;
    private VistaListado vistaListado;
    private Proyecto proyectoFinal;
    String identificador;
    String nombreTarea;

    private static ModeloProyecto instancia = null;
    private ModeloProyecto(){
        super();
    }
    public static ModeloProyecto getInstancia(){
        if (instancia == null){
            instancia = new ModeloProyecto();
        }
        return instancia;
    }


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

    public void setProyecto(Proyecto p){
        System.out.println(p.getNombre());
        this.proyectoFinal = p;
    }

    public Proyecto getProyecto(){
        System.out.println(proyectoFinal.getNombre());
        return this.proyectoFinal;
    }

    @Override
    public void iniciaProyecto(String nombreProyecto) {
        System.out.println("Nombre proyecto --> "+nombreProyecto);

        try {
            FileInputStream fis = new FileInputStream(nombreProyecto + ".bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Proyecto proyecto = (Proyecto) ois.readObject();
            ois.close();
            proyectoFinal=proyecto;
        }catch(IOException | ClassNotFoundException e){
            System.out.println("El proyecto con nombre " + nombreProyecto + " se ha creado correctamente\n\n");
            proyectoFinal=new Proyecto(nombreProyecto);
        }
    }

    @Override
    public void pulsadorJRadioButton(String actionCommand) {
        vistaAlta = new VistaAlta();
        if (actionCommand.equals("Persona")){
            System.out.println("PERSONA ");
            vistaAlta.altaPersona();
        }else if (actionCommand.equals("Tarea")){
            System.out.println("TAREA ");
            vistaAlta.altaTarea();
        }else if (actionCommand.equals("Documentación")){
            this.identificador=actionCommand;
            System.out.println("DOCUMENTACIÓN");
        }else if (actionCommand.equals("Página Web")){
            this.identificador=actionCommand;
            System.out.println("PÁGINA WEB");
        }else if(actionCommand.equals("Programa")){
            this.identificador=actionCommand;
            System.out.println("PROGRAMA");
        }
    }

    @Override
    public void darAltaPersona(String nombre, String dni, String correo) {
        Persona persona = new Persona(nombre,correo,dni);
        System.out.println("La persona "+ persona + " ha sido creada");
        proyectoFinal.addParticipante(persona);
    }

    @Override
    public void darAltaTarea(String titulotarea, String descrip, int priority) {//int tipo_resultado,double coste, Facturacion facturacion
        Resultado resultado = new Resultado(identificador,0,true);
        Facturacion facturacion = new ConsumoInterno();
        Tarea tarea = new Tarea(titulotarea,descrip,priority,LocalDate.now(),resultado,25,facturacion);
        proyectoFinal.addTarea(tarea);
        System.out.println("La tarea" + tarea + " ha sido creada");
    }

    @Override
    public void pulsandoAceptar(String actionCommand, String nomTarea) {
        this.nombreTarea = nomTarea;
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
            vistaInsertar.insertarColaborador(proyectoFinal.toArrayParticipantes());

        }else if (actionCommand.equals("Etiqueta")){
            System.out.println("ETIQUETA");
            vistaInsertar.insertarEtiqueta();

        }else{
            System.out.println("RESPONSABLE");
            vistaInsertar.insertarResponsable();
        }
    }

    @Override
    public void insertandoColaborador(String clave) throws Exception {
        vistaInsertar = new VistaInsertar();
        System.out.println(nombreTarea + " nomtarea");
        if (proyectoFinal.getTareas() == null || proyectoFinal.getTareas().isEmpty()) {
            System.out.println("tareas vacia");
            vistaInsertar.errorTarea();
        } else {
            System.out.println(proyectoFinal.getTareas().toString());
            if (!proyectoFinal.getParticipantes().isEmpty()) {
                System.out.println("participantes lleno");
                System.out.println(proyectoFinal.getParticipantes().toString());
                try {
                    Persona p = devuelveElemento(clave, proyectoFinal.getParticipantes());
                    System.out.println("1" + p.toString());
                    System.out.println(proyectoFinal.getTareas().toString());
                    Tarea t = devuelveElemento(this.nombreTarea, proyectoFinal.getTareas());
                    System.out.println("2");
                    t.addColaboradores(p);
                    System.out.println("Todo fue bien");
                    vistaInsertar.satisfactorio();
                } catch (Exception e) {
                    System.out.println("Ha ocurrido un problema");
                    vistaInsertar.errorColaborador();
                }
            }else{
                vistaInsertar.errorColaborador();
            }
        }
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

    @Override
    public void pulsadoListarPersona(String actionCommand) {
        vistaListado = new VistaListado();
        if (actionCommand.equals("Personas que participan en el proyecto")) {
            System.out.println("PERSONAS QUE PARTICIPAN");
            //
        }else {
            System.out.println("PERSONAS QUE NO PARTICIPAN EN NINGUNA TAREA");
            //vistaInsertar.insertarResponsable();
        }
    }

    @Override
    public void finalizarProyecto() {
        try {
            FileOutputStream fos = new FileOutputStream(proyectoFinal.getNombre() + ".bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this.proyectoFinal);
            oos.close();
            System.out.println("Los datos se han guardado correctamente");
        }catch (IOException exception){
            System.out.println("No se han podido guardar los datos");
        }

    }

}




/*
    /*
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

    */
