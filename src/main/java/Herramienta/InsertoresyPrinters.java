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
        for (Tarea tarea : p.getTareas()) {
            System.out.println(tarea.toString() + '\n');
        }
    }
    public static void mostrarPersonaNoResponsable(Proyecto p) {
        List<Persona> listaNoResp = elementosConListaVacia(p.getParticipantes());
        for (Persona pers : listaNoResp)
            System.out.println(pers);
    }

    public static void mostrarListaPersona(Proyecto p){
        for (Persona persona : p.getParticipantes()) {
            System.out.println(persona.toString());
        }
    }

}
