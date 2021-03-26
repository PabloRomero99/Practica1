package Herramienta;

import Persona.Persona;
import Proyectos.Proyecto;
import Tarea.Tarea;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

public class Leer {
    public static Persona leerpersona() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nombre persona: ");
        String nom = scanner.nextLine();
        System.out.print("Correo electrónico: ");
        String correo = scanner.next();
        return new Persona(nom, correo, null);
    }

    public static Tarea leertarea() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Titulo tarea: ");
        String titulo = scanner.nextLine();
        System.out.print("Descripcion: ");
        String descripcion = scanner.nextLine();
        System.out.print("Prioridad(1-5) {1 = Baja Prioridad | 5 = Alta prioridad} --> ");
        int prioridad = scanner.nextInt();
        System.out.println();
        return new Tarea(titulo, descripcion, prioridadCorrecta(prioridad,scanner), LocalDate.now());
    }

    public static int prioridadCorrecta(int prioridad, Scanner sc){
        while(prioridad < 1 || prioridad > 5){
            System.out.print("Prioridad(1-5) {1 = Baja Prioridad | 5 = Alta prioridad} --> ");
            prioridad = sc.nextInt();
            System.out.println();
        }
        return prioridad;
    }

    public static int decision() {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Quieres añadir o eliminar a alguien de la tarea?");
        String decision = sc.next();
        decision = decision.toLowerCase(Locale.ROOT);
        if(decision.equals("añadir"))
            return 1;
        else if(decision.equals("eliminar"))
            return 0;
        else
            return -1;
    }


    public static void leerEtiquetas(Proyecto p) {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿De que tarea quieres modificar las etiquetas?");
        String ntarea = sc.next();
        int decision = decision();
        if (p.encuentraTarea(ntarea)) {

            if (decision == 1) { //Decision=añadir
                System.out.print("Escribe el nombre de las etiquetas para añadir, o 'STOP' para terminar: ");
                String etiqueta = sc.next();
                while (!etiqueta.equals("STOP")) {
                    p.addEtiquetas(etiqueta, p.devuelveTarea(ntarea));
                    System.out.print("Escribe el nombre de las etiquetas para añadir, o 'STOP' para terminar: ");
                    etiqueta = sc.next();
                }
            }else if (decision == 0){
                System.out.print("Escribe el nombre de las etiquetas para eliminar, o 'STOP' para terminar: ");
                String etiqueta = sc.next();
                while (!etiqueta.equals("STOP")) {
                    p.eliminarEtiqueta(etiqueta, p.devuelveTarea(ntarea));
                    System.out.print("Escribe el nombre de las etiquetas para eliminar, o 'STOP' para terminar: ");
                    etiqueta = sc.next();
                }
            }
            else
                System.out.println("Operación no valida, solo se puede añadir o eliminar ");

            System.out.println('\n');

        }
    }

    public static void marcandoTareaFinalizada(Proyecto p){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre de la tarea para marcar: ");
        String ntarea = sc.next();
        if (p.encuentraTarea(ntarea)) {
            Tarea t = p.devuelveTarea(ntarea);
            t.marcarFinalizada();
        } else
            System.out.println("No hemos encontrado la tarea dentro del proyecto\n");
    }



    public static void modificarParticipantes(Proyecto p) {
    Scanner sc = new Scanner(System.in);
    System.out.println("¿De que tarea quieres modificar los participantes?");
    String ntarea = sc.nextLine();
    if (p.encuentraTarea(ntarea)) {

        if (decision() == 1) { //Decision=añadir
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

        }else if(decision() == 0){
            System.out.print("Escribe el nombre de las personas para eliminar, o 'STOP' para terminar: ");
            String nomPersona = sc.next();
            while (!nomPersona.equals("STOP")) {
                if(p.eliminarPersona(nomPersona, p.devuelveTarea(ntarea)))
                    System.out.println("La persona se ha borrado correctamente");
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
