package Herramienta;

import Persona.Persona;
import Proyectos.Proyecto;
import Resultado.Resultado;
import Resultado.ResultadoDocumentacion;
import Resultado.ResultadoPrograma;
import Resultado.ResultadoPaginaWeb;
import Tarea.Tarea;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

import static Listas.UtilidadesParaListas.devuelveElementos;
import static Listas.UtilidadesParaListas.encuentraElementos;

import static Resultado.Resultado.devolverResultado;

public class Leer {

    public static Proyecto leerproyecto(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre del proyecto: ");
        String nombre = sc.nextLine();
        System.out.println("El proyecto con nombre " + nombre + " se ha creado correctamente\n\n");
        return new Proyecto(nombre);
    }


    public static Persona leerpersona() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nombre persona: ");
        String nom = scanner.nextLine();
        System.out.print("Correo electrónico: ");
        String correo = scanner.next();
        System.out.print("DNI de la persona: ");
        String dni = scanner.next().toUpperCase(Locale.ROOT);
        return new Persona(nom, correo, dni, null);
    }

    public static void leertarea(Proyecto p) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Titulo tarea: ");
        String titulo = scanner.nextLine();
        for (Tarea t : p.getTareas()) {
            if (t.getTitulo().equals(titulo)) {
                System.out.println("No pueden haber dos tareas con el mismo nombre, ya que coincide con: \n");
                return;
            }
        }
        System.out.print("Descripcion: ");
        String descripcion = scanner.nextLine();

        System.out.print("De que tipo quieres que sea {1 - Documentacion | 2 - Página WEB | 3 - Programa } --> ");
        int tipoSeleccionado = scanner.nextInt();

        System.out.print("Tipo de resultado {1 - Resultado interno | 2 - Destinado a ser comercializado} -->   ");
        boolean tiporesultadofinal = devolverResultado(scanner.nextInt());

        System.out.print("Prioridad(1-5) {1 = Baja Prioridad | 5 = Alta prioridad} --> ");
        int prioridad = scanner.nextInt();
        System.out.println();

        p.addTarea(new Tarea(titulo, descripcion, prioridadCorrecta(prioridad,scanner), LocalDate.now(), new Resultado(opcion(tipoSeleccionado), 0, tiporesultadofinal)));
    }

    public static String opcion(int opcion){
        if (opcion == 1)
            return "Documentacion";
        else if (opcion == 2)
            return "Pagina WEB";
        else
            return "Programa";
    }

    public static void leerEtiquetas(Proyecto p) {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿De que tarea quieres modificar las etiquetas?");
        String ntarea = sc.next();
        int decision = leerDecision();
        Tarea tarea = devuelveElementos(ntarea, p.getTareas());
        try{

            if (encuentraElementos(tarea, p.getTareas()) && tarea != null) {

                if (decision == 1) { //Decision=añadir
                    System.out.print("Escribe el nombre de las etiquetas para añadir, o 'STOP' para terminar: ");
                    String etiqueta = sc.next();
                    while (!etiqueta.equals("STOP")) {
                        tarea.addEtiquetas(etiqueta);
                        System.out.print("Escribe el nombre de las etiquetas para añadir, o 'STOP' para terminar: ");
                        etiqueta = sc.next();
                    }
                }else if (decision == 0){
                    System.out.print("Escribe el nombre de las etiquetas para eliminar, o 'STOP' para terminar: ");
                    String etiqueta = sc.next();
                    while (!etiqueta.equals("STOP")) {
                        tarea.eliminarEtiqueta(etiqueta);
                        System.out.print("Escribe el nombre de las etiquetas para eliminar, o 'STOP' para terminar: ");
                        etiqueta = sc.next();
                    }
                }
                else
                    System.out.println("Operación no valida, solo se puede añadir o eliminar ");

                System.out.println('\n');

            }
        }catch (NullPointerException e){
            System.out.println("La tarea no existe");
        }
    }

    public static int leerDecision() {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Quieres añadir o eliminar?");
        String decision = sc.next().toLowerCase(Locale.ROOT);
        if(decision.equals("añadir"))
            return 1;
        else if(decision.equals("eliminar"))
            return 0;
        else
            return -1;
    }

    public static int prioridadCorrecta(int prioridad, Scanner sc){
        while(prioridad < 1 || prioridad > 5){
            System.out.print("Prioridad(1-5) {1 = Baja Prioridad | 5 = Alta prioridad} --> ");
            prioridad = sc.nextInt();
        }
        return prioridad;
    }

    public static Resultado leerValorTipo(Resultado resultado, int horas){
        if ("Documentacion".equals(resultado.getIdentificador())) { //Tipo_Resultado = Documentacion
            ResultadoDocumentacion resultadoDoc = new ResultadoDocumentacion("Documentacion", horas, resultado.isTipo_resultado());
            resultadoDoc.resultado();
            return resultadoDoc;
        }
        else if ("Pagina WEB".equals(resultado.getIdentificador())) { //Tipo_Resultado = Pagina WEB
            ResultadoPaginaWeb resultadoWeb = new ResultadoPaginaWeb("Pagina WEB", horas, resultado.isTipo_resultado());
            resultadoWeb.resultado();
            return resultadoWeb;

        }
        else if("Programa".equals(resultado.getIdentificador())) { //Tipo_Resultado = Programa
            ResultadoPrograma resultadoPro = new ResultadoPrograma("Programa", horas, resultado.isTipo_resultado());
            resultadoPro.resultado();
            return resultadoPro;
        }
        return null;
    }

}