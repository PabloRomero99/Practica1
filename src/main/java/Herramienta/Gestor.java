package Herramienta;

import Persona.Persona;
import Proyectos.Proyecto;
import Tarea.Tarea;

import java.time.LocalDate;
import java.util.Scanner;

public class Gestor {

    public enum Opciones{
        INICIAR_PROYECTO("Iniciar nuevo proyecto y dar nombre "),
        ALTA_PERSONA("Dar de alta una persona que trabajará en el proyecto "),
        ALTA_TAREAS("Dar de alta una tarea en el proyecto "),
        TAREA_FINALIZADA("Marcar tarea como finalizada "),
        MODIFICAR_PERSONAS_TAREA("Introducir o eliminar una persona de una tarea "),
        MODIFICAR_ETIQUETAS("Añadir o eliminar etiquetas en la tarea"),
        LISTA_PERSONAS("Lista las personas que trabajan en el proyecto "),
        LISTA_TAREAS("Lista de tareas del proyecto:\n\t  * Título\n\t " +
                " * Personas asignadas (destacando los responsables)\n\t  * Tarea finalizada o no\n\t " +
                " * Resultado de la tarea"),
        SALIR_PROYECTO("Salir del proyecto");

        private final String descripcion;
        Opciones(String descripcion) {
            this.descripcion = descripcion;
        }

        public String getDescripcion(){
            return descripcion;
        }

        public static Opciones getOpcion(int posicion) {
            return values()[posicion];
        }
        public static String getMenu() {
            StringBuilder sb = new StringBuilder();
            for (Opciones opcion : Opciones.values()) {
                sb.append(opcion.ordinal() + 1);
                sb.append(".- ");
                sb.append(opcion.getDescripcion());
                sb.append("\n");
            }
            return sb.toString();
        }
    }

    public static int elegirOpcion(){
        System.out.println(Opciones.getMenu());
        Scanner scanner = new Scanner(System.in);
        System.out.print("Elija una opción: ");
        int opcion = scanner.nextInt() - 1;
        Opciones opcionMenu = Opciones.getOpcion(opcion);
        System.out.println("Ha elegido: " + opcionMenu);
        return opcion;
    }

    public static Persona personaadded(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nombre persona: ");
        String nom = scanner.nextLine();
        System.out.print("Correo electrónico: ");
        String correo = scanner.next();
        return new Persona(nom,correo,null);
    }

    public static Tarea tareaadded(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Titulo tarea: ");
        String titulo = scanner.nextLine();
        System.out.print("Descripcion: ");
        String descripcion = scanner.nextLine();
        System.out.print("Prioridad: ");
        int prioridad = scanner.nextInt();
        return new Tarea(titulo,descripcion,prioridad, LocalDate.now());
    }


    public static void main(String[] args) {
        Proyecto p=null;

        int opcion = elegirOpcion();

        while (opcion != 8){
            switch (opcion){
                case 0:     //Iniciar proyecto
                    Scanner sc = new Scanner(System.in);
                    System.out.print("Nombre del proyecto: ");
                    String nombre = sc.next();
                    p = new Proyecto(nombre);
                    System.out.println("El proyecto con nombre " + nombre + " se ha creado correctamente\n\n");
                  break;

                case 1:
                    if (p != null){
                        p.addParticipante(personaadded());
                        System.out.println("\n");
                    }
                    else
                        System.out.println("Debes tener un proyecto creado para añadir Personas\n");
                    break;

                case 2:
                    if (p != null)
                        p.addTarea(tareaadded());
                    else
                        System.out.println("Debes tener un proyecto creado para añadir Tareas\n ");
                    break;

                case 3:
                    if (p != null){
                        Scanner scanner = new Scanner(System.in);
                        System.out.print("Nombre de la tarea para marcar: ");
                        String ntarea = scanner.next();
                        for (Tarea t: p.getTareas()){
                            if (ntarea.equals(t.getTitulo()))
                                t.marcarFinalizada();
                        }
                    }
                    else
                        System.out.println("Debes tener un proyecto creado para marcar la Tarea como finalizada\n ");
                    break;

                case 4:
                    if(p != null){
                        Scanner scanner = new Scanner(System.in);
                        System.out.println("¿De que tarea quieres modificar los participantes?");
                        String nomTarea = scanner.next();

                        System.out.println("¿Quieres añdir o eliminar a alguien de la tarea?");
                        String decision = scanner.next();
                        if (decision.equals("añadir") || decision.equals("Añadir")){
                            for (Tarea t: p.getTareas()) {
                                if (nomTarea.equals(t.getTitulo())) {
                                    t.getColaboradores().add(personaadded());

                                }
                                break;
                            }
                        }

                    }

                    break;

                case 5:
                    if(p!=null){
                        Scanner scr = new Scanner(System.in);
                        System.out.print("Nombre de la tarea donde añadir etiquetas: ");
                        String ntarea = scr.next();
                        if(p.encuentraTarea(ntarea)){
                            System.out.print("Escribe las etiquetas, o 'STOP' para terminar: ");
                            String etiqueta = scr.next();
                            while(!etiqueta.equals("STOP")) {
                                p.addEtiquetas(etiqueta,p.devuelveTarea(ntarea));
                                System.out.print("Escribe las etiquetas, o 'STOP' para terminar: ");
                                etiqueta = scr.next();
                            }
                        }
                    }
                    break;

                case 6:
                    if (p != null){
                        for (Persona persona:p.getParticipantes()){
                            System.out.println(persona.toString());
                        }
                    }
                    else
                        System.out.println("Debes tener un proyecto creado para listar las personas\n ");
                    System.out.println("\n\n");
                    break;

                case 7:
                    if (p != null){
                        for (Tarea tarea:p.getTareas()){
                            System.out.println(tarea.toString()+"\n");
                        }
                    }
                    else
                        System.out.println("Debes tener un proyecto creado para listar las tareas\n ");
                    System.out.println("\n\n");
                    break;
            }
            opcion = elegirOpcion();
        }
    }
}