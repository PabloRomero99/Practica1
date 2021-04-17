package Herramienta;


import Excepciones.FechaFinNullException;
import Excepciones.ElementoNullException;
import Persona.Persona;
import Proyectos.Proyecto;
import Tarea.Tarea;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

import static Herramienta.Leer.*;
import static Listas.UtilidadesParaListas.devuelveElementos;


public class Modificadores {
    public static void marcandoTareaFinalizada(Proyecto p) {

        try {

            Scanner sc = new Scanner(System.in);
            System.out.print("Nombre de la tarea para marcar: ");
            String ntarea = sc.next();

            Tarea t = devuelveElementos(ntarea, p.getTareas());

            if (t.fechaFinCorrecta(t.getFecha_finalización())){
                System.out.print("Cuantas horas se han invertido: ");
                int horas = sc.nextInt();
                t.getResultado().setHoras_invertidas(horas);
                t.setResultado(leerValorTipo(t.getResultado(), horas));
                t.marcarFinalizada();
                t.setFecha_finalización(LocalDate.now());
            }

        } catch(ElementoNullException e) {
            System.out.println("No hemos encontrado la tarea dentro del proyecto\n");
        }catch (FechaFinNullException f){
            System.out.println("La tarea ya esta terminada ");
        }
    }


    public static void modificarParticipantes(Proyecto p){

        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("¿De que tarea quieres modificar los participantes?");
            String ntarea = sc.nextLine();
            Tarea tarea = devuelveElementos(ntarea, p.getTareas());


            if (tarea.fechaFinCorrecta(tarea.getFecha_finalización())) {
                int decision = leerDecision();

                System.out.print("Escribe el DNI de las personas para añadir, o 'STOP' para terminar: ");
                String dniPersona = sc.next().toUpperCase(Locale.ROOT);
                Persona persona ;

                if (decision == 1) { //Decision=añadir

                    while (!dniPersona.equals("STOP")) {
                        persona = devuelveElementos(dniPersona, p.getParticipantes()); //Tenemos que comprobar que la persona esta dentro del proyecto
                        tarea.addColaboradores(persona);
                        System.out.print("Escribe el DNI de las personas para añadir, o 'STOP' para terminar: ");
                        dniPersona = sc.next().toUpperCase(Locale.ROOT);
                    }

                } else if (decision == 0) {
                    while (!dniPersona.equals("STOP")){
                        persona = devuelveElementos(dniPersona, p.getParticipantes());
                        tarea.eliminarColaboradores(persona);
                        System.out.print("Escribe el DNI de las personas para eliminar, o 'STOP' para terminar: ");
                        dniPersona = sc.next().toUpperCase(Locale.ROOT);
                    }
                }
            } else
                System.out.println("Operación no valida, solo se puede añadir o eliminar ");
            System.out.println('\n');
        }catch(ElementoNullException e) {
            System.out.println("No esta dentro del proyecto\n");
        }catch (FechaFinNullException f){
            System.out.println("La tarea ya esta terminada ");
        }
    }
}

