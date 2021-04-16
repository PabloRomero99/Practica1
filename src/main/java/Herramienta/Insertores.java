package Herramienta;

import Excepciones.ElementoNoExisteException;
import Proyectos.Proyecto;
import Tarea.Tarea;

import java.util.Scanner;
import static Listas.UtilidadesParaListas.devuelveElementos;

public class Insertores {
    public static void insertResponsable(Proyecto p) {
        //tratar tarea = null

        try {

            Scanner sc = new Scanner(System.in);
            System.out.print("Nombre de la tarea: ");
            String ntarea = sc.next();
            Tarea tarea = devuelveElementos(ntarea, p.getTareas());
            System.out.print("DNI de la persona: ");
            String dniPersona = sc.next();
            tarea.addResponsable(dniPersona, p);

            System.out.println("\n");

        } catch (NullPointerException e) {
            System.out.println("Tarea ");
        }
    }
}
