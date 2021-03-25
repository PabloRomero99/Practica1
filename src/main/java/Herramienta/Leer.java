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
        System.out.println("Prioridad(1-5)\n 1 = Baja Prioridad\n 5 = Alta prioridad ");
        int prioridad = scanner.nextInt();
        return new Tarea(titulo, descripcion, prioridadCorrecta(prioridad,scanner), LocalDate.now());
    }

    public static int prioridadCorrecta(int prioridad, Scanner sc){
        while(prioridad<0 || prioridad>5){
            System.out.println("Prioridad(1-5)\n 1 = Baja Prioridad\n 5 = Alta prioridad ");
            prioridad = sc.nextInt();
        }
        return prioridad;
    }

    public static boolean decision() {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Quieres añadir o eliminar a alguien de la tarea?");
        String decision = sc.next();
        decision = decision.toLowerCase(Locale.ROOT);
        return decision.equals("añadir");
    }



    public static void leerEtiquetas(Proyecto p) {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿De que tarea quieres modificar las etiquetas?");
        String ntarea = sc.next();
        if (p.encuentraTarea(ntarea)) {

            if (decision()) { //Decision=añadir
                System.out.print("Escribe el nombre de las etiquetas para añadir, o 'STOP' para terminar: ");
                String etiqueta = sc.next();
                while (!etiqueta.equals("STOP")) {
                    p.addEtiquetas(etiqueta, p.devuelveTarea(ntarea));
                    System.out.print("Escribe el nombre de las etiquetas para añadir, o 'STOP' para terminar: ");
                    etiqueta = sc.next();
                }
            }else{
                System.out.print("Escribe el nombre de las etiquetas para eliminar, o 'STOP' para terminar: ");
                String etiqueta = sc.next();
                while (!etiqueta.equals("STOP")) {
                    p.eliminarEtiqueta(etiqueta, p.devuelveTarea(ntarea));
                    System.out.print("Escribe el nombre de las etiquetas para eliminar, o 'STOP' para terminar: ");
                    etiqueta = sc.next();
                }
            }

        }
    }
    /*Mira esto Jose, es modificarParticipantes pero utilitzant decision()
        public static void modificarParticipantes(Proyecto p) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre de la tarea donde añadir etiquetas: ");
        System.out.println("¿De que tarea quieres modificar los participantes?");
        String ntarea = sc.next();
        if (p.encuentraTarea(ntarea)) {

            if (decision()) { //Decision=añadir
                System.out.print("Escribe el nombre de las personas para añadir, o 'STOP' para terminar: ");
                String nomPersona = sc.next();
                while (!nomPersona.equals("STOP")) {
                    p.addPersona(etiqueta, p.devuelveTarea(ntarea));
                    System.out.print("Escribe el nombre de las personas para añadir, o 'STOP' para terminar: ");
                    nomPersona = sc.next();
                }
            }else{
                System.out.print("Escribe el nombre de las personas para eliminar, o 'STOP' para terminar: ");
                String nomPersona = sc.next();
                while (!nomPersona.equals("STOP")) {
                    p.eliminarPersonaa(nomPersona, p.devuelveTarea(ntarea));
                    System.out.print("Escribe el nombre de las personas para eliminar, o 'STOP' para terminar: ");
                    nomPersona = sc.next();
                }
            }

        }
    }
     */

    public static void modificarParticipantes(Proyecto p){
        Scanner sc = new Scanner(System.in);
        System.out.println("¿De que tarea quieres modificar los participantes?");
        String nomTarea = sc.next();
        if (p.encuentraTarea(nomTarea)) {
            System.out.println("¿Quieres añadir o eliminar a alguien de la tarea?");
            String decision = sc.next();
            decision = decision.toLowerCase(Locale.ROOT);
            if (decision.equals("añadir")) {
                System.out.println("¿Cual es el nombre de la persona que quieres añadir?");
                String nomPersona = sc.next();
                p.addPersona(nomPersona, p.devuelveTarea(nomTarea));
            } else if (decision.equals("eliminar")) {
                System.out.println("¿Cual es el nombre de la persona que quieres eliminar?");
                String nomPersona = sc.next();
                p.eliminarPersona(nomPersona, p.devuelveTarea(nomTarea));
            }
        }else{
            System.out.println("La tarea no existe");
        }
    }
}
