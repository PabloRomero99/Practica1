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

import static Resultado.Resultado.devolverResultado;

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

        System.out.println("De que tipo quieres que sea {1 - Documentacion | 2 - Página WEB | 3 - Programa } --> ");
        int tipoSeleccionado = scanner.nextInt();


        System.out.print("Horas invertidas: ");
        int horas = scanner.nextInt();

        System.out.print("Tipo de resultado {1 - Resultado interno | 2 - Destinado a ser comercializado} -->   ");
        boolean tiporesultadofinal = devolverResultado(scanner.nextInt());



        System.out.print("Prioridad(1-5) {1 = Baja Prioridad | 5 = Alta prioridad} --> ");
        int prioridad = scanner.nextInt();
        System.out.println();

        return new Tarea(titulo, descripcion, prioridadCorrecta(prioridad,scanner), LocalDate.now(),valortipo(tipoSeleccionado,horas,tiporesultadofinal));
    }



    public static Resultado leerValorTipo(int opcion, int horas, boolean tiporesultadofinal){
        if (opcion == 1) { //Tipo_Resultado = Documentacion
            ResultadoDocumentacion resultadoDoc = new ResultadoDocumentacion("Documentacion", horas, tiporesultadofinal);
            resultadoDoc.resultado();
            return resultadoDoc;
        }
        else if (opcion == 2) { //Tipo_Resultado = Pagina WEB
            ResultadoPaginaWeb resultadoWeb = new ResultadoPaginaWeb("Pagina WEB", horas, tiporesultadofinal);
            resultadoWeb.resultado();
            return resultadoWeb;

        }
        else if(opcion == 3) { //Tipo_Resultado = Programa
            ResultadoPrograma resultadoPro = new ResultadoPrograma("Pagina WEB", horas, tiporesultadofinal);
            resultadoPro.resultado();
            return resultadoPro;
        }

        return null;
    }




    public static int prioridadCorrecta(int prioridad, Scanner sc){
        while(prioridad < 1 || prioridad > 5){
            System.out.print("Prioridad(1-5) {1 = Baja Prioridad | 5 = Alta prioridad} --> ");
            prioridad = sc.nextInt();
        }
        return prioridad;
    }

}
