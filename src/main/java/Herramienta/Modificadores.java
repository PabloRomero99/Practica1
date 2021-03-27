package Herramienta;

import Proyectos.Proyecto;
import Tarea.Tarea;

import java.time.LocalDate;
import java.util.Scanner;

import static Herramienta.Leer.leerDecision;

public class Modificadores {
    public static void marcandoTareaFinalizada(Proyecto p){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre de la tarea para marcar: ");
        String ntarea = sc.next();
        if (p.encuentraTarea(ntarea)) {
            Tarea t = p.devuelveTarea(ntarea);
            t.marcarFinalizada();
            t.setFecha_finalización(LocalDate.now());
        } else
            System.out.println("No hemos encontrado la tarea dentro del proyecto\n");
    }

    public static void modificarParticipantes(Proyecto p) {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿De que tarea quieres modificar los participantes?");
        String ntarea = sc.nextLine();
        int decision = leerDecision();
        if (p.encuentraTarea(ntarea)) {

            if (decision == 1) { //Decision=añadir
                System.out.print("Escribe el nombre de las personas para añadir, o 'STOP' para terminar: ");
                String nomPersona = sc.next();
                while (!nomPersona.equals("STOP")) {
                    if(p.addPersona(p.devuelvePersona(nomPersona), p.devuelveTarea(ntarea)))
                        System.out.println(nomPersona + " es nuevo colaborador en la tarea");
                    else
                        System.out.println(nomPersona + " ya es colaborador en la tarea");
                    System.out.print("Escribe el nombre de las personas para añadir, o 'STOP' para terminar: ");
                    nomPersona = sc.next();
                }

            }else if(decision == 0){
                System.out.print("Escribe el nombre de las personas para eliminar, o 'STOP' para terminar: ");
                String nomPersona = sc.next();
                while (!nomPersona.equals("STOP")) {
                    if(p.eliminarPersona(nomPersona, p.devuelveTarea(ntarea))){
                        if (p.devuelvePersona(nomPersona).getListaTareasResponsable().contains(p.devuelveTarea(ntarea))){
                            p.devuelvePersona(nomPersona).eliminarTareaResponsable(p.devuelveTarea(ntarea));
                            p.devuelveTarea(ntarea).setResponsable(null);
                        }
                        System.out.println("La persona se ha borrado correctamente");
                    }

                    else
                        System.out.println(nomPersona + " no es colaborador/a en esta tarea");
                    System.out.print("Escribe el nombre de las personas para eliminar, o 'STOP' para terminar: ");
                    nomPersona = sc.next();
                }
            }else
                System.out.println("Operación no valida, solo se puede añadir o eliminar ");
            System.out.println('\n');
        }
    }
}
