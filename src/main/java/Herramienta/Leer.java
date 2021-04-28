package Herramienta;

import Excepciones.ElementoNullException;
import Excepciones.ProjectNullException;
import Facturación.ConsumoInterno;
import Facturación.Descuento;
import Facturación.Facturacion;
import Facturación.Urgente;
import Persona.Persona;
import Proyectos.Proyecto;
import Resultado.Resultado;
import Resultado.ResultadoDocumentacion;
import Resultado.ResultadoPrograma;
import Resultado.ResultadoPaginaWeb;
import Tarea.Tarea;

import java.io.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import static Listas.UtilidadesParaListas.*;
import static Resultado.Resultado.devolverResultado;

public class Leer {


    public static Proyecto leerproyecto() throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre del proyecto: ");
        String nombre = sc.nextLine();
        try {
            FileInputStream fis = new FileInputStream(nombre + ".bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Proyecto proyecto = (Proyecto) ois.readObject();
            ois.close();
            return proyecto;
        }catch(IOException e){
            System.out.println("El proyecto con nombre " + nombre + " se ha creado correctamente\n\n");
            return new Proyecto(nombre);
        }
    }

    public static Persona leerpersona() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nombre persona: ");
        String nom = scanner.nextLine();
        System.out.print("Correo electrónico: ");
        String correo = scanner.next();
        System.out.print("DNI de la persona: ");
        String dni = scanner.next().toUpperCase(Locale.ROOT);
        return new Persona(nom, correo, dni);
    }

    public static void leertarea(Proyecto p) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Titulo tarea: ");
        String titulo = scanner.nextLine();

        System.out.print("Descripcion: ");
        String descripcion = scanner.nextLine();

        System.out.print("De que tipo quieres que sea {1 - Documentacion | 2 - Página WEB | 3 - Programa } --> ");
        int tipoSeleccionado = tipoResultadoCorrecto(scanner.nextInt(),scanner);

        System.out.print("Tipo de resultado {1 - Resultado interno | 2 - Destinado a ser comercializado} -->   ");
        int internoOcomercializado = tipoResultadoInterno_ComercializadoCorrecto(scanner.nextInt(),scanner);
        boolean tiporesultadofinal = devolverResultado(internoOcomercializado);

        System.out.print("Prioridad(1-5) {1 = Baja Prioridad | 5 = Alta prioridad} --> ");
        int prioridad = scanner.nextInt();

        System.out.print("Coste esperado en euros (usar ',' para los decimales) -->");
        double coste = scanner.nextDouble();

        System.out.println("Tipo de facturación(1-3) {1 - Consumo interno | 2 - Con Descuento | 3 - Urgente} -->");
        int tipoFact = tipoFacturacionCorrecto(scanner.nextInt(), scanner);

        double porcentaje = 0;
        if(tipoFact==3 || tipoFact==2) {
            System.out.println("¿Que porcentaje quieres aplicar?");
            porcentaje=scanner.nextDouble();
        }

        Tarea tarea = new Tarea(titulo, descripcion, prioridadCorrecta(prioridad,scanner), LocalDate.now(), new Resultado(opcion(tipoSeleccionado),0,tiporesultadofinal), coste, devolverFacturacion(tipoFact,porcentaje));
        if (!encuentraElementos(tarea,p.getTareas()))
            p.addTarea(tarea);
        else
            System.out.println("No se pueden repetir tareas ");
    }


    public static String opcion(int opcion){
        if (opcion == 1)
            return "Documentacion";
        else if (opcion == 2 )
            return "Pagina WEB";
        else
            return "Programa";
    }

    public static void leerEtiquetas(Proyecto p) {

        try{
            Scanner sc = new Scanner(System.in);
            System.out.println("¿De que tarea quieres modificar las etiquetas?");
            String ntarea = sc.next();
            int decision = leerDecision();
            Tarea tarea = devuelveElementos(ntarea, p.getTareas());

            if (encuentraElementos(tarea, p.getTareas())) {

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
        }catch (ElementoNullException e){
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

    public static int tipoResultadoCorrecto(int tipo, Scanner sc){
        while(tipo < 1 || tipo > 3){
            System.out.print("De que tipo quieres que sea {1 - Documentacion | 2 - Página WEB | 3 - Programa } --> ");
            tipo = sc.nextInt();
        }
        return tipo;
    }

    public static int tipoResultadoInterno_ComercializadoCorrecto(int tipo, Scanner sc){
        while(tipo < 1 || tipo > 2){
            System.out.print("Tipo de resultado {1 - Resultado interno | 2 - Destinado a ser comercializado} -->   ");
            tipo = sc.nextInt();
        }
        return tipo;
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

    public static int tipoFacturacionCorrecto(int tipo, Scanner sc){
        while(tipo < 1 || tipo > 3){
            System.out.print("Tipo de facturación(1-3) {1 - Consumo interno | 2 - Con Descuento | 3 - Urgente} -->   ");
            tipo = sc.nextInt();
        }
        return tipo;
    }

    public static Facturacion devolverFacturacion(int tipo, double porcentaje){
        if (tipo == 1) {
            return new ConsumoInterno();
        }

        else if (tipo == 2){
            return new Descuento(porcentaje);
        }
        else {
            return new Urgente(porcentaje);
        }
    }
}