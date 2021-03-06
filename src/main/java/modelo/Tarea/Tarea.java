package modelo.Tarea;

import modelo.Persona;
import modelo.Proyecto;
import modelo.Tarea.Facturacion.Facturacion;
import modelo.Tarea.Resultado.Resultado;
import modelo.genericos.interfaces.tieneClave;
import modelo.genericos.interfaces.tieneLista;
import static modelo.genericos.clases.UtilidadesParaListas.devuelveElemento;
import static modelo.genericos.clases.UtilidadesParaListas.encuentraElementos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Tarea implements Serializable, tieneClave, tieneLista {
    private String Titulo;
    private String Descripcion;
    private List<Persona> colaboradores;
    private Persona responsable;
    private int prioridad;      //entre 1 (muy baja) y 5 (muy alta)
    private LocalDate fecha_creacion;
    private LocalDate fecha_finalización; //Puede estar en blanco si no ha finalizado
    private boolean finalizada;  //True = finalizado False = no finalizado
    private Resultado resultado; //el resultado esperado de la tarea
    private List<String> lista_etiquetas; //Un listado de etiquetas para asignar tópcios comunes
    private double coste;
    private Facturacion tipoFacturacion;

    //Constructor entero
    public Tarea(String titulo, String descripcion, List<Persona> colaboradores, Persona responsable, int prioridad, LocalDate fecha_creacion, LocalDate fecha_finalización, Resultado resultado, List<String> lista_etiquetas, double coste, Facturacion tipoFacturacion) {
        this.Titulo = titulo;
        this.Descripcion = descripcion;
        this.colaboradores = colaboradores;
        this.responsable = responsable;
        this.prioridad = prioridad;
        this.fecha_creacion = fecha_creacion;
        this.fecha_finalización = fecha_finalización;
        this.resultado = resultado;
        this.lista_etiquetas = lista_etiquetas;
        this.coste = coste;
        this.tipoFacturacion = tipoFacturacion;
    }

    //Constructor cuando queremos iniciar en proyecto
    public Tarea(String titulo, String descripcion,int prioridad, LocalDate fecha_creacion, Resultado resultado, double coste,Facturacion tipoFacturacion) {
        this.Titulo = titulo;
        this.Descripcion = descripcion;
        this.colaboradores = new ArrayList<Persona>();
        this.responsable = null;
        this.prioridad = prioridad;
        this.fecha_creacion = fecha_creacion;
        this.fecha_finalización = null;
        this.resultado = resultado;
        this.lista_etiquetas = new ArrayList<String>();
        this.coste = coste;
        this.tipoFacturacion = tipoFacturacion;
    }


    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public List<Persona> getColaboradores() {
        return colaboradores;
    }

    public void setColaboradores(List<Persona> colaboradores) {
        this.colaboradores = colaboradores;
    }

    public Persona getResponsable() {
        return responsable;
    }

    public void setResponsable(Persona responsable) {
        this.responsable = responsable;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public LocalDate getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(LocalDate fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public LocalDate getFecha_finalización() {
        return fecha_finalización;
    }

    public void setFecha_finalización(LocalDate fecha_finalización) {
        this.fecha_finalización = fecha_finalización;
    }

    public Resultado getResultado() {
        return resultado;
    }

    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }

    public List<String> getLista_etiquetas() {
        return lista_etiquetas;
    }

    public void setLista_etiquetas(List<String> lista_etiquetas) {
        this.lista_etiquetas = lista_etiquetas;
    }

    public double getCoste() {
        return coste;
    }

    public void setCoste(double coste) {
        this.coste = coste;
    }

    public Facturacion getTipoFacturacion() {
        return tipoFacturacion;
    }

    public void setTipoFacturacion(Facturacion tipoFacturacion) {
        this.tipoFacturacion = tipoFacturacion;
    }

    public String toString() {
        return "\t- // Titulo= " + Titulo + '\n' +
                "\t- // Descripcion= " + Descripcion + '\n' +
                "\t- // Colaboradores= " + listaNombres() + '\n' +
                "\t- // Responsable= " + devuelveResponsable() + '\n' +
                "\t- // Prioridad= " + prioridad + '\n' +
                "\t- // Fecha_creacion= " + fecha_creacion + '\n' +
                "\t- // Fecha_finalización= " + fecha_finalización + '\n' +
                "\t- // Finalizada= " + finalizada + '\n' +
                "\t- // Resultado= " + resultado + '\n' +
                "\t- // Lista de etiquetas= " + lista_etiquetas + '\n'+
                "\t- // Coste = " + coste + "€\n" +
                "\t- // Coste Final= " + calculaFacturacion() + "€\n" +
                "\t- // Facturacion= "+ tipoFacturacion.nombre() + '\n';

    }

    public String titulos() {
        return "\t- // Titulo= " + Titulo + '\n';

    }

    public void marcarFinalizada(){
        this.fecha_finalización=LocalDate.now(); this.finalizada = true;
    }

    public List<String> listaNombres(){
        List<String> nombres = new ArrayList<>();
        for (Persona p : colaboradores){
            nombres.add(p.getNombre());
        }
        return nombres;
    }

    public String devuelveResponsable(){
        if (responsable == null)
            return "Ninguno";
        else
            return responsable.getNombre();
    }

    @Override
    public List getLista() {
        return colaboradores;
    }

    @Override
    public Object getClave() {
        return Titulo;
    }


    public boolean addEtiquetas(String etiqueta){
        if (!lista_etiquetas.contains(etiqueta)) { //El metodo generico encuentraElementos no tolera String
            lista_etiquetas.add(etiqueta);
            System.out.println("La etiqueta '" + etiqueta + "' se ha añadido correctamente");
            return true;
        }
        else {
            System.out.println("La etiqueta '" + etiqueta + "' ya esta en la lista de etiquetas de la tarea ");
            return false;
        }
    }

    public boolean eliminarEtiqueta(String etiqueta) {
        if(!lista_etiquetas.remove(etiqueta)) {
            System.out.println("La etiqueta " + etiqueta + " no esta en la lista de etiquetas de la tarea ");
            return true;
        }
        else {
            System.out.println("La etiqueta " + etiqueta + " se ha borrado correctamente");
            return true;
        }
    }


    public boolean addColaboradores(Persona persona) {
        if (persona != null) {
            if (!encuentraElementos(persona, colaboradores)) {
                colaboradores.add(persona);
                System.out.println(persona.getClave() + " es nuevo colaborador en la tarea");
                return true;
            }else {
                System.out.println(persona.getClave() + " ya era colaborador en la tarea");
                return false;
            }
        }else {
            System.out.println("Esta persona no participa en el proyecto");
            return false;
        }
    }

    public boolean eliminarColaboradores(Persona persona){
        if (persona != null) {
            if (encuentraElementos(persona, colaboradores)) {
                colaboradores.remove(persona);
                System.out.println(persona.getClave() + " ya no es colaborador");
                return true;
            }else {
                System.out.println(persona.getClave() + " no era colaborador en la tarea");
                return false;
            }
        }else {
            System.out.println("Esta persona no participa en el proyecto");
            return false;
        }
    }

    public boolean fechaFinCorrecta(LocalDate fecha_fin) throws Exception {
        if (fecha_fin == null){
            return true;
        }throw new Exception();
    }

    public boolean addResponsable(String dniPersona, Proyecto p) throws Exception{
        try{
            if (this.fechaFinCorrecta(fecha_finalización)){
                Persona persona = devuelveElemento(dniPersona, p.getParticipantes());
                if (responsable == null) { //Tarea no tiene responsable
                    if (!encuentraElementos(persona, colaboradores)) { //Persona no colabora Tarea
                        colaboradores.add(persona);
                        responsable = persona;
                        persona.addTareaResponsable(this);
                        return true;
                    } else {
                        responsable = persona;
                        persona.addTareaResponsable(this);
                        return true;
                    }
                }else{
                    System.out.println("El responsable de la tarea es " + responsable
                            + " y solo puede haber un responsable por tarea");
                    return false;
                }
            }
        } catch (Exception e){
            System.out.println("Esta persona no pertenece al proyecto, o el DNI no es correcto , porfavor escoge una persona que " +
                    "este registrada en el proyecto o un DNI correcto(Elija opción 8 para consultar información).");
        }
        return false;
    }

    public String[] toArrayEtiquetas(){
        String[] res = new String[lista_etiquetas.size()];
        for (int n = 0; n < lista_etiquetas.size(); n++) {
            res[n] = lista_etiquetas.get(n);
        }
        return res;
    }

    public String[] toArrayNoColaboradores(){
        return null;
    }

    public double calculaFacturacion() {
        return tipoFacturacion.conseguirCoste(this.coste);
    }


}