package modelo;

import modelo.Tarea.Facturacion.ConsumoInterno;
import modelo.Tarea.Facturacion.Descuento;
import modelo.Tarea.Facturacion.Facturacion;
import modelo.Tarea.Facturacion.Urgente;
import modelo.Tarea.Resultado.Resultado;
import modelo.Tarea.Tarea;
import vista.*;

import javax.swing.*;
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
    boolean interno_comercializado; //true --> resultado interno | false --> destinado a ser comercializado
    int tipo_fac;

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
    public void pulsadorJRadioButton(String actionCommand){
        vistaAlta = new VistaAlta();
        vistaEliminar = new VistaEliminar();
        if (actionCommand.equals("Persona")){
            System.out.println("PERSONA ");
            vistaAlta.altaPersona();

        }else if (actionCommand.equals("Tarea")){
            System.out.println("TAREA ");
            vistaAlta.altaTarea();
        }

        else if (actionCommand.equals("Documentación")){
            this.identificador=actionCommand;
            System.out.println("DOCUMENTACIÓN");
        }

        else if (actionCommand.equals("Página Web")){
            this.identificador=actionCommand;
            System.out.println("PÁGINA WEB");
        }

        else if(actionCommand.equals("Programa")){
            this.identificador=actionCommand;
            System.out.println("PROGRAMA");
        }

        else if(actionCommand.equals("Resultado Interno")){
            System.out.println("RESULTADO INTERNO");
            this.interno_comercializado=true;
        }

        else if(actionCommand.equals("Destinado a ser comercializado")){
            System.out.println("DESTINADO A SER COMERCIALIZADO");
            this.interno_comercializado=false;
        }

        else if (actionCommand.equals("Facturación sin costes")){
            System.out.println("FACTURCION SIN COSTES");
            this.tipo_fac= 1;
        }

        else if(actionCommand.equals("Facturación con descuento")){
            System.out.println("FACTURACION DESCUENTO");
            this.tipo_fac=2;
        }

        else if(actionCommand.equals("Facturación urgente")){
            System.out.println("FACTURACION URGENTE");
            this.tipo_fac=3;
        }
    }

    @Override
    public void darAltaPersona(String nombre, String dni, String correo) {
        Persona persona = new Persona(nombre,correo,dni);
        System.out.println("La persona "+ persona + " ha sido creada");
        proyectoFinal.addParticipante(persona);
    }

    @Override
    public void darAltaTarea(String titulotarea, String descrip, int priority, double coste, double descuento) {//int tipo_resultado,double coste, Facturacion facturacion
        Resultado resultado = new Resultado(identificador,0,interno_comercializado);
        Facturacion facturacion;
        if (tipo_fac==1)
            facturacion = new ConsumoInterno();
        else if(tipo_fac==2)
            facturacion = new Descuento(descuento);
        else
            facturacion = new Urgente(descuento);

        Tarea tarea = new Tarea(titulotarea,descrip,priority,LocalDate.now(),resultado,coste,facturacion);
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
    public void pulsandoInsertar(String actionCommand) throws Exception {
        vistaInsertar = new VistaInsertar();
        if (actionCommand.equals("Colaborador")){
            System.out.println("COLABORADOR");
            Tarea t = devuelveElemento(this.nombreTarea, proyectoFinal.getTareas());
            vistaInsertar.insertarColaborador(proyectoFinal.toArrayParticipantes(t));//puede explotar

        }else if (actionCommand.equals("Etiqueta")){
            System.out.println("ETIQUETA");
            Tarea t = devuelveElemento(this.nombreTarea, proyectoFinal.getTareas());
            vistaInsertar.insertarEtiqueta(t.toArrayEtiquetas());

        }else{
            System.out.println("RESPONSABLE");
            vistaInsertar.insertarResponsable(proyectoFinal.toArrayListado("persona"));
        }
    }

    @Override
    public void insertandoColaborador(String clave) throws Exception {
        vistaInsertar = new VistaInsertar();
        if (proyectoFinal.getTareas() == null || proyectoFinal.getTareas().isEmpty()) {
            vistaInsertar.errorTarea();
        } else {
            Persona p = devuelveElemento(clave, proyectoFinal.getParticipantes());
            Tarea t = devuelveElemento(this.nombreTarea, proyectoFinal.getTareas());
            if(t.addColaboradores(p))
                vistaInsertar.satisfactorio();
            else
                vistaInsertar.errorColaborador();
        }
    }

    @Override
    public void insertandoEtiqueta(String etiqueta) throws Exception {
        vistaInsertar = new VistaInsertar();
        if (proyectoFinal.getTareas() == null || proyectoFinal.getTareas().isEmpty()) {
            vistaInsertar.errorTarea();
        } else {
            Tarea t = devuelveElemento(nombreTarea, proyectoFinal.getTareas());
            if (t.addEtiquetas(etiqueta))
                vistaInsertar.satisfactorio();
            else
                vistaInsertar.errorEtiqueta();
        }
    }

    @Override
    public void insertandoResponsable(String clave) throws Exception {
        vistaInsertar = new VistaInsertar();
        if (proyectoFinal.getTareas() == null || proyectoFinal.getTareas().isEmpty()) {
            vistaInsertar.errorTarea();
        }else {
            Tarea t = devuelveElemento(nombreTarea, proyectoFinal.getTareas());
            if (t.addResponsable(clave, proyectoFinal))
                vistaInsertar.satisfactorio();
            else
                vistaInsertar.errorResponsable();
        }
    }

    @Override
    public void eliminandoColaborador(String clave) throws Exception {
        vistaEliminar = new VistaEliminar();
        if (proyectoFinal.getTareas() == null || proyectoFinal.getTareas().isEmpty()) {
            vistaInsertar.errorTarea();
        } else {
            Persona p = devuelveElemento(clave, proyectoFinal.getParticipantes());
            Tarea t = devuelveElemento(this.nombreTarea, proyectoFinal.getTareas());
            if(t.eliminarColaboradores(p))
                vistaEliminar.satisfactorio();
            else
                vistaEliminar.errorColaborador();
        }
    }

    @Override
    public void eliminandoEtiqueta(String etiqueta) throws Exception {
        vistaEliminar = new VistaEliminar();
        if (proyectoFinal.getTareas() == null || proyectoFinal.getTareas().isEmpty()) {
            vistaEliminar.errorTarea();
        } else {
            Tarea t = devuelveElemento(nombreTarea, proyectoFinal.getTareas());
            if (t.eliminarEtiqueta(etiqueta))
                vistaEliminar.satisfactorio();
            else
                vistaEliminar.errorEtiqueta();
        }
    }


    @Override
    public void pulsandoEliminar(String actionCommand) throws Exception{
        if (actionCommand.equals("Persona")){
            System.out.println("Persona");
            vistaEliminar.eliminarColaborador(proyectoFinal.toArrayListado("colaboradores"));
        }else{
            System.out.println("ETIQUETA");
            Tarea t = devuelveElemento(nombreTarea, proyectoFinal.getTareas());
            vistaEliminar.eliminarEtiqueta(t.toArrayEtiquetas());
        }
    }

    @Override
    public void pulsadoListarPersona(String actionCommand) {
        vistaListado = new VistaListado();
        if (actionCommand.equals("Personas que participan en el proyecto")) {
            System.out.println("PERSONAS QUE PARTICIPAN");
            vistaListado.mostrarListadoPersonas();//
        }else {
            System.out.println("PERSONAS QUE NO PARTICIPAN EN NINGUNA TAREA");
            vistaListado.mostrarListadoPersonasNoResponsables();
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

    @Override
    public String[] conseguirListado(String cadena) {
        if (cadena.equals("tarea"))
            return proyectoFinal.toArrayListado(cadena);
        else if (cadena.equals("persona"))
            return proyectoFinal.toArrayListado(cadena);
        else if (cadena.equals("nombreTarea"))
            return proyectoFinal.toArrayListado(cadena);
        else if (cadena.equals("personaSinResp")){
            return proyectoFinal.toArrayListado(cadena);
        }else if (cadena.equals("tareaNoColab")){
            return proyectoFinal.toArrayListado(cadena);
        }
        String[] noExiste = new String[1];
        noExiste[0] = "No se ha podido obtener la lista";
        return noExiste;
    }

    @Override
    public void pulsadoListarTareas(String text) {
        vistaListado = new VistaListado();
        if (text.equals("Tareas que existen en el proyecto")) {
            System.out.println("TAREAS QUE EXISTEN");
            vistaListado.mostrarListadoTareas();
    }else {
            System.out.println("TAREAS SIN COLABORADORES");
            vistaListado.mostrarListadoTareasSinColaboradores();
        }
    }

    @Override
    public void marcarFinalizada(int index) {
        proyectoFinal.getTareas().get(index).marcarFinalizada();
    }

    @Override
    public String[] consultarPrecioPorTarea() {
        return proyectoFinal.mostrarPrecioTareas();
    }
    @Override
    public double consultarPrecioTotal() {
        return proyectoFinal.mostrarPrecioTotal();
    }

    @Override
    public void modificarCoste(JTextField coste,JTextField tarea) throws Exception {
        devuelveElemento(tarea.getText(),proyectoFinal.getTareas()).setCoste(Double.parseDouble(coste.getText()));
    }

    @Override
    public void modificarTipoFact(String dto, JTextField tarea,int tipo_fac) throws Exception {
        Facturacion facturacion;
        if (tipo_fac==1)
            facturacion = new ConsumoInterno();
        else if(tipo_fac==2)
            facturacion = new Descuento(Integer.parseInt(dto));
        else
            facturacion = new Urgente(Integer.parseInt(dto));
        devuelveElemento(tarea.getText(),proyectoFinal.getTareas()).setTipoFacturacion(facturacion);
    }

}
