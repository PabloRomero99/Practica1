package Herramienta;

import Excepciones.ElementoNullException;
import Persona.Persona;
import Proyectos.Proyecto;
import Tarea.Tarea;

import java.util.List;
import java.util.Scanner;
import static Listas.UtilidadesParaListas.devuelveElementos;
import static Listas.UtilidadesParaListas.elementosConListaVacia;

public class InsertoresyPrinters {
    public static void insertResponsable(Proyecto p) {

        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Nombre de la tarea: ");
            String ntarea = sc.next();
            Tarea tarea = devuelveElementos(ntarea, p.getTareas());
            System.out.print("DNI de la persona: ");
            String dniPersona = sc.next();
            tarea.addResponsable(dniPersona, p);

            System.out.println("\n");

        } catch (ElementoNullException e) {
            System.out.println("La tarea no esta en el proyecto ");
        }
    }

    public static void mostrarListaTareaSinColab(Proyecto p){
        List<Tarea> listaNoCol = elementosConListaVacia(p.getTareas());
        for (Tarea t: listaNoCol)
            System.out.println(t);
    }

    public static void mostrarListTarea(Proyecto p) {
        if (p.getTareas() != null) {
            for (Tarea tarea : p.getTareas()) {
                System.out.println(tarea.toString() + '\n');
            }
        }else{
            System.out.println("En estos momentos no hay tareas registras.");
        }
    }
    public static void mostrarPersonaNoResponsable(Proyecto p) {
        List<Persona> listaNoResp = elementosConListaVacia(p.getParticipantes());
        for (Persona pers : listaNoResp)
            System.out.println(pers);
        System.out.println();
    }

    public static void mostrarListaPersona(Proyecto p){
        for (Persona persona : p.getParticipantes()) {
            System.out.println(persona.toString());
        }
        System.out.println();
    }

    public static double mostrarPrecios(Proyecto p){
        double resultado = 0;
        for (Tarea t: p.getTareas()){
            System.out.println("La tarea " + t.getTitulo() + " tiene un coste final de: " + t.calculaFacturacion());
            resultado += t.calculaFacturacion();
        }
        System.out.println("El proyecto tiene un coste final de: " + resultado);
        System.out.println("\n");
        return resultado;
    }
}
