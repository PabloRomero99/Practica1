package Herramienta;


import Excepciones.ElementoNoExisteException;
import Persona.Persona;
import Proyectos.Proyecto;
import Tarea.Tarea;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

import static Herramienta.Leer.*;
import static Listas.UtilidadesParaListas.devuelveElementos;
import static Listas.UtilidadesParaListas.encuentraElementos;


public class Modificadores {
    public static void marcandoTareaFinalizada(Proyecto p){
        //tratar t = null
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Nombre de la tarea para marcar: ");
            String ntarea = sc.next();

            Tarea t = devuelveElementos(ntarea, p.getTareas());

            System.out.print("Cuantas horas se han invertido: ");
            int horas = sc.nextInt();
                t.getResultado().setHoras_invertidas(horas);
                t.setResultado(leerValorTipo(t.getResultado(), horas));
                t.marcarFinalizada();
                t.setFecha_finalización(LocalDate.now());

        } catch(NullPointerException e) {
            System.out.println("No hemos encontrado la tarea dentro del proyecto\n");
        }
    }


    public static void modificarParticipantes(Proyecto p){
            Scanner sc = new Scanner(System.in);
            System.out.println("¿De que tarea quieres modificar los participantes?");
            String ntarea = sc.nextLine();
            Tarea tarea = devuelveElementos(ntarea, p.getTareas());

            //Tratar tarea == null

            if (tarea != null) {
                int decision = leerDecision();

                System.out.print("Escribe el DNI de las personas para añadir, o 'STOP' para terminar: ");
                String dniPersona = sc.next().toUpperCase(Locale.ROOT);
                Persona persona = devuelveElementos(dniPersona, p.getParticipantes()); //Tenemos que comprobar que la persona esta dentro del proyecto

                if (decision == 1) { //Decision=añadir

                    while (!dniPersona.equals("STOP")) {
                        tarea.addColaboradores(persona);
                        System.out.print("Escribe el DNI de las personas para añadir, o 'STOP' para terminar: ");
                        dniPersona = sc.next().toUpperCase(Locale.ROOT);
                    }

                } else if (decision == 0) {
                    while (!dniPersona.equals("STOP")){
                        tarea.eliminarColaboradores(persona);
                        System.out.print("Escribe el DNI de las personas para eliminar, o 'STOP' para terminar: ");
                        dniPersona = sc.next().toUpperCase(Locale.ROOT);
                    }
                }
            } else
                System.out.println("Operación no valida, solo se puede añadir o eliminar ");
            System.out.println('\n');
        }
}