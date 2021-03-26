package Herramienta;

import Persona.Persona;
import Proyectos.Proyecto;
import Tarea.Tarea;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

import static Herramienta.Leer.*;


public class Gestor {

    public enum Opciones{
        INICIAR_PROYECTO("Iniciar nuevo proyecto y dar nombre "),
        ALTA_PERSONA("Dar de alta una persona que trabajará en el proyecto "),
        ALTA_TAREAS("Dar de alta una tarea en el proyecto "),
        INSERTAR_RESPONSABLE("Insertar una persona como responsable de una tarea"),
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

   /* public static int elegirOpcion(){
        System.out.println(Opciones.getMenu());
        Scanner scanner = new Scanner(System.in);
        System.out.print("Elija una opción: ");
         try {
                int opcion = scanner.nextInt() - 1;
                Opciones opcionMenu = Opciones.getOpcion(opcion);
                System.out.println("Ha elegido: " + opcionMenu);
                return opcion;
            }catch (Exception e){
                System.out.println("la opcion ha de ser un numero entre 1 y 10\n");
                elegirOpcion();
            }
        return 8;

    }*/


    public static void main(String[] args) {
        Proyecto p=null;
        Scanner sc = new Scanner(System.in);
        int opcion = elegirOpcion();
        while (opcion != 9) {
            switch (opcion) {
                case 0: //INICIAR_PROYECTO
                    System.out.print("Nombre del proyecto: ");
                    String nombre = sc.nextLine();
                    p = new Proyecto(nombre);
                    System.out.println("El proyecto con nombre " + nombre + " se ha creado correctamente\n\n");
                    break;

                case 1: //ALTA_PERSONA
                    if (p != null) {
                        p.addParticipante(leerpersona());
                        System.out.println("\n");
                    } else
                        System.out.println("Debes tener un proyecto creado para añadir Personas\n");
                    break;

                case 2: //ALTA_TAREA
                    if (p != null)
                        p.addTarea(leertarea());
                    else
                        System.out.println("Debes tener un proyecto creado para añadir Tareas\n ");
                    break;

                case 3: //INSERTAR_RESPONSABLE
                    if (p != null) {
                        System.out.print("Nombre de la tarea: ");
                        String ntarea = sc.next();
                        System.out.print("Nombre de la persona: ");
                        String npersona = sc.next();
                        p.addResponsable(npersona, ntarea, p);
                    }

                    break;

                case 4: //TAREA_FINALIZADA
                    if (p != null) {
                        System.out.print("Nombre de la tarea para marcar: ");
                        String ntarea = sc.next();
                        if (p.encuentraTarea(ntarea)) {
                            Tarea t = p.devuelveTarea(ntarea);
                            t.marcarFinalizada();
                        } else
                            System.out.println("No hemos encontrado la tarea dentro del proyecto\n");
                    } else
                        System.out.println("Debes tener un proyecto creado para marcar la Tarea como finalizada\n ");
                    break;

                case 5: //MODIFICAR_PERSONAS_TAREA
                    if (p != null) {
                        modificarParticipantes(p);
                    }
                    break;

                case 6:  //MODIFICAR_ETIQUETAS
                    if (p != null) {
                        leerEtiquetas(p);
                    }
                    break;

                case 7: //LISTA_PERSONAS
                    if (p != null) {
                        for (Persona persona : p.getParticipantes()) {
                            System.out.println(persona.toString());
                        }
                    } else
                        System.out.println("Debes tener un proyecto creado para listar las personas\n ");
                    System.out.println("\n\n");
                    break;

                case 8: //LISTA_TAREAS
                    if (p != null) {
                        for (Tarea tarea : p.getTareas()) {
                            System.out.println(tarea.toString() + '\n');
                        }
                    } else
                        System.out.println("Debes tener un proyecto creado para listar las tareas\n ");
                    System.out.println("\n\n");
                    break;
            }
            opcion = elegirOpcion();
        }
    }
}