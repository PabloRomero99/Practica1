package Herramienta;

import Excepciones.ProjectNullException;
import Persona.Persona;
import Proyectos.Proyecto;
import Tarea.Tarea;

import java.io.*;
import java.util.List;
import java.util.Scanner;

import static Herramienta.InsertoresyPrinters.*;
import static Herramienta.InsertoresyPrinters.mostrarPersonaNoResponsable;
import static Herramienta.Leer.*;
import static Herramienta.Modificadores.*;
import static Listas.UtilidadesParaListas.elementosConListaVacia;


public class Gestor {
    Proyecto proyecto = new Proyecto();

    public enum Opciones{
        //INICIAR_PROYECTO("Iniciar nuevo proyecto y dar nombre "),
        CAMBIAR_NOMBRE_PROYECTO("Cambiar el nombre al proyecto "),
        ALTA_PERSONA("Dar de alta una persona que trabajará en el proyecto "),
        ALTA_TAREAS("Dar de alta una tarea en el proyecto "),
        INSERTAR_RESPONSABLE("Insertar una persona como responsable de una tarea"),
        TAREA_FINALIZADA("Marcar tarea como finalizada "),
        MODIFICAR_PERSONAS_TAREA("Introducir o eliminar una persona de una tarea "),
        MODIFICAR_ETIQUETAS("Añadir o eliminar etiquetas en la tarea"),
        LISTA_PERSONAS("Lista las personas que trabajan en el proyecto "),
        LISTA_PERSONAS_NO_RESPONSABLES("Lista las personas que no son responsables en ninguna tarea del proyecto "),
        LISTA_TAREAS("Lista de tareas del proyecto:\n\t  * Título\n\t " +
                " * Personas asignadas (destacando los responsables)\n\t  * Tarea finalizada o no\n\t " +
                " * Resultado de la tarea "),
        LISTA_TAREAS_SIN_COLABORADORES("Lista las tareas en las cuales no trabaja nadie "),
        CALCULO_PRECIOS("Precio final de la tarea que se indique o precio total del proyecto"),
        EDICION_COSTES_TAREA("Modificación del coste y tipo de facturación"),
        SALIR_PROYECTO("Salir del proyecto");

        private final String descripcion;
        Opciones(String descripcion) {
            this.descripcion = descripcion;
        }

        public String getDescripcion(){
            return descripcion;
        }

        public static Opciones getOpcion(Integer posicion) {
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
        String opcion = scanner.next();
        if(isNumeric(opcion)){
            int opcionelegida = Integer.parseInt(opcion)-1;
            Opciones opcionMenu = Opciones.getOpcion(opcionelegida);
            System.out.println("Ha elegido: " + opcionMenu);
            return opcionelegida;
        }
        return -1;
    }

   private static boolean isNumeric(String cadena){
	    try {
		    Integer.parseInt(cadena);
		    return true;
	    } catch (NumberFormatException nfe){
		    return false;
	    }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
            Proyecto p = leerproyecto(); //leer en el proyecto
            int opcion = elegirOpcion();
            while (opcion != 13) {
                switch (opcion) {
                    case 0: //CAMBIAR_NOMBRE_PROYECTO
                        Scanner sc = new Scanner(System.in);
                        System.out.println("¿Que nombre quieres que tenga el proyecto? ");
                        p.setNombre(sc.next());
                        break;

                    case 1: //ALTA_PERSONA
                        p.addParticipante(leerpersona());
                        System.out.println("\n");
                        break;

                    case 2: //ALTA_TAREA
                        leertarea(p);
                        break;

                    case 3: //INSERTAR_RESPONSABLE
                        insertResponsable(p);
                        break;

                    case 4: //TAREA_FINALIZADA
                        marcandoTareaFinalizada(p);
                        break;

                    case 5: //MODIFICAR_PERSONAS_TAREA
                        modificarParticipantes(p);
                        /*
                        if (p != null)
                            modificarParticipantes(p);
                         */
                        break;

                    case 6:  //MODIFICAR_ETIQUETAS
                        leerEtiquetas(p);
                        break;

                    case 7: //LISTA_PERSONAS
                        mostrarListaPersona(p);

                        break;

                    case 8: //LISTA_PERSONAS_NO_RESPONSABLES
                        mostrarPersonaNoResponsable(p);

                        break;

                    case 9: //LISTA_TAREAS
                        mostrarListTarea(p);
                        break;

                    case 10://LISTA_TAREAS_SIN_COLABORADORES
                        mostrarListaTareaSinColab(p);
                        break;
                    case 11://CALCULO_PRECIOS
                        mostrarPrecios(p);
                        break;
                    case 12://EDICION_COSTES_TAREA
                        editarCostesTarea(p);
                        break;
                    default:
                        System.out.println("La opcion no es valida, elige una entre 1 y 11\n");
                }
                opcion = elegirOpcion();
            }
            //escribir en el archivo
            p.escribirFichero();
    }
}