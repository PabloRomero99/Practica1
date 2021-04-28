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

    public static void editarCostesTarea(Proyecto p){
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Nombre de la tarea: ");
            String ntarea = sc.next();
            Tarea tarea = devuelveElementos(ntarea, p.getTareas());
            System.out.print("(1 - Editar coste | 2 - Cambiar tipo de facturación)--> ");
            int opcion = opcionCorrecta(sc.nextInt(), sc);

            if (opcion == 1){
                System.out.print("Indica el nuevo coste de la tarea (usa ',' para los decimales): ");
                tarea.setCoste(sc.nextDouble());
                System.out.println("Ahora el coste de la tarea es "+ tarea.getCoste() +"€");
            }
            else{
                System.out.print("¿A que tipo de facturación quieres cambiar?(1-3) {1 - Consumo interno | 2 - Con Descuento | 3 - Urgente} -->");
                int tipoFact = tipoFacturacionCorrecto(sc.nextInt(), sc);
                double porcentaje = 0;
                if(tipoFact==3 || tipoFact==2) {
                    System.out.print("Porcentaje que vamos a aplicar --> ");
                    porcentaje=sc.nextDouble();
                }
                tarea.setTipoFacturacion(devolverFacturacion(tipoFact, porcentaje));
            }


            System.out.println("\n");

        } catch (ElementoNullException e) {
            System.out.println("La tarea no esta en el proyecto ");
        }
    }

    public static int opcionCorrecta(int tipo, Scanner sc){
        while(tipo < 1 || tipo > 2){
            System.out.print("1 - Editar coste | 2 - Cambiar tipo de facturación");
            tipo = sc.nextInt();
        }
        return tipo;
    }
}