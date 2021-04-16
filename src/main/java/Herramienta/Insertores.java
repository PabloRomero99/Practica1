package Herramienta;

import Proyectos.Proyecto;

import java.util.Scanner;

public class Insertores {
    public static void insertResponsable(Proyecto p){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre de la tarea: ");
        String ntarea = sc.next();
        System.out.print("Nombre de la DNI: ");
        String dniPersona = sc.next();
        p.addResponsable(dniPersona, ntarea, p);
        System.out.println("\n");
    }

}
