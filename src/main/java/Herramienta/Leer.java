package Herramienta;

import Persona.Persona;
import Tarea.Tarea;

import java.time.LocalDate;
import java.util.Scanner;

public class Leer {
    public static Persona leerpersona(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nombre persona: ");
        String nom = scanner.nextLine();
        System.out.print("Correo electrónico: ");
        String correo = scanner.next();
        return new Persona(nom,correo,null);
    }

    public static Tarea leertarea(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Titulo tarea: ");
        String titulo = scanner.nextLine();
        System.out.print("Descripcion: ");
        String descripcion = scanner.nextLine();
        System.out.print("Prioridad: ");
        int prioridad = scanner.nextInt();
        return new Tarea(titulo,descripcion,prioridad, LocalDate.now());
    }
}
