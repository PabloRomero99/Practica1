package Herramienta;

import Proyectos.Proyecto;
import Resultado.Resultado;
import Tarea.Tarea;

import Resultado.Resultado;
import Resultado.ResultadoDocumentacion;
import Resultado.ResultadoPrograma;
import Resultado.ResultadoPaginaWeb;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

import static Herramienta.Leer.leerDecision;
import static Herramienta.Leer.leerValorTipo;


public class Modificadores {
    public static void marcandoTareaFinalizada(Proyecto p){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre de la tarea para marcar: ");
        String ntarea = sc.next();
        if (p.encuentraTarea(ntarea)) {
            Tarea t = p.devuelveTarea(ntarea);

            System.out.print("Cuantas horas se han invertido: ");
            int horas = sc.nextInt();
            t.getResultado().setHoras_invertidas(horas);
            t.setResultado(leerValorTipo(t.getResultado(), horas));
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
                    if(p.addPersonaTarea(p.devuelvePersona(nomPersona), p.devuelveTarea(ntarea)))
                        System.out.println(nomPersona + " es nuevo colaborador en la tarea");
                    else
                        System.out.println(dniPersona + " ya es colaborador en la tarea");
                    System.out.print("Escribe el DNI de las personas para añadir, o 'STOP' para terminar: ");
                    dniPersona = sc.next().toUpperCase(Locale.ROOT);
                }

            }else if(decision == 0){
                System.out.print("Escribe el DNI de las personas para eliminar, o 'STOP' para terminar: ");
                String dniPersona = sc.next().toUpperCase(Locale.ROOT);
                while (!dniPersona.equals("STOP")) {
                    if(p.eliminarPersonaTarea(dniPersona, p.devuelveTarea(ntarea))){
                        if (p.devuelvePersona(dniPersona).getListaTareasResponsable().contains(p.devuelveTarea(ntarea))){
                            p.devuelvePersona(dniPersona).eliminarTareaResponsable(p.devuelveTarea(ntarea));
                            p.devuelveTarea(ntarea).setResponsable(null);
                        }
                        System.out.println("La persona se ha borrado correctamente");
                    }

                    else
                        System.out.println(dniPersona + " no es colaborador/a en esta tarea");
                    System.out.print("Escribe el DNI de las personas para eliminar, o 'STOP' para terminar: ");
                    dniPersona = sc.next().toUpperCase(Locale.ROOT);
                }
            }else
                System.out.println("Operación no valida, solo se puede añadir o eliminar ");
            System.out.println('\n');
        }
    }
}
