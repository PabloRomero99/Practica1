package Proyectos;

import Persona.Persona;
import Resultado.Resultado;
import Tarea.Tarea;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class ProyectoTest {

    //Pruebatest

    private final Proyecto p = new Proyecto("Proyecto");
    private final Proyecto p1 = new Proyecto("Proyecto1");
    private final Proyecto p2 = new Proyecto("Proyecto2");

    //Persona
    private String[] nombres2 = {"peri", "juana", "andresito", "pakorro", "manoli", "pepita"};
    private String[] correos = {"perico@mail", "juan@mail", "andres@mail", "pako@mail", "manolo@mail" ,"pepe@gmail.com"};
    private String[] dnis = {"12345678M", "32564897W", "45827425M", "46897894Ñ", "15788962N", "32005487O"};
    private String[] dnis2 = {"12345675M", "32564397W", "45827525M", "46898894Ñ", "15588962N", "32015487O"};

    //Tarea
    private String[] titulos = {"la noche", "el dia", "la tarde", "la hora", "la casa", "el gato"};
    private String[] titulos2 = {"la nota", "el llano", "la pradera", "la tarta", "la mansion", "el perro"};
    private String[] descrip = {"oscura", "claro", "corta", "puntual", "fantasma", "maulla"};
    private int[] prioridad = {3, 2, 5, 1, 4, 2};

    //Etiquetas
    private final String[] etiquetas = {"saludo", "despedida", "entrada", "salida", "dentro", "fuera"};

    //Resultado
    private final String[] identificadores = {"Documentacion", "Documentacion", "Pagina Web", "Pagina Web", "Programa", "Programa"};
    private final double[] horas = {10,20,30,1,2,3};
    private final boolean[] tipo_resultado = {true,false,true,false,true,true};
    LocalDate fecha_creacion = LocalDate.now();

    private final List<Persona> listaPersonas = new ArrayList<>();
    private final List<Tarea> listaTareas = new ArrayList<>();



    @Test
    void addParticipante(){
        System.out.println("Test addParticipante");
        String[] nombres = {"perico", "juan", "andres", "pako", "manolo", "pepe"};

        for (int c = 0; c < nombres.length; c++) {
            listaPersonas.add(new Persona(nombres[c], correos[c],dnis[c], null));
        }
        for (Persona persona : listaPersonas)
            assertTrue(p.addParticipante(persona));

        for (Persona persona : listaPersonas)
            assertFalse(p.addParticipante(persona));
    }

    @Test
    void addTarea() {
        System.out.println("\nTest addTarea");
        for(int i = 0; i < 6 ; i++){
            Resultado resultado = new Resultado(identificadores[i], horas[i], tipo_resultado[i]);
            Tarea tarea = new Tarea(titulos[i], descrip[i], prioridad[i], fecha_creacion,resultado);
            assertTrue(p.addTarea(tarea));
        }

        for (Tarea tarea : listaTareas)
            assertFalse(p.addTarea(tarea));
    }

    @Test
    void encuentraTarea() {
        System.out.println("\nTest encuentraTarea");
        for(int i = 0; i < 6 ; i++){
            Resultado resultado = new Resultado(identificadores[i], horas[i], tipo_resultado[i]);
            Tarea tarea = new Tarea(titulos[i], descrip[i], prioridad[i], fecha_creacion,resultado);
            p.addTarea(tarea);
        }

        for (String titulo : titulos)
            assertTrue(p.encuentraTarea(titulo));

        for (String titulo : etiquetas)
            assertFalse(p.encuentraTarea(titulo));
    }

    @Test
    void devuelveTarea() {
        System.out.println("\nTest devuelvetarea");
        for(int i = 0; i < 6 ; i++){
            Resultado resultado = new Resultado(identificadores[i], horas[i], tipo_resultado[i]);
            Tarea tarea = new Tarea(titulos[i], descrip[i], prioridad[i], fecha_creacion,resultado);
            p.addTarea(tarea);
        }

        List<Tarea> tareasNo = new ArrayList<>();

        for(int i = 0; i < 6 ; i++){
            Resultado resultado = new Resultado(identificadores[i], horas[i], tipo_resultado[i]);
            Tarea tarea = new Tarea(titulos2[i], descrip[i], prioridad[i], fecha_creacion,resultado);
            tareasNo.add(tarea);
        }

        for (int t = 0; t < titulos.length; t++)
            assertEquals(p.devuelveTarea(titulos[t]), p.getTareas().get(t));

        for (int t = 0; t < titulos.length; t++)
            assertNotEquals(p.devuelveTarea(titulos[t]), tareasNo.get(t));
    }

    @Test
    void encuentraPersona() {
        System.out.println("\nTest encuentraPersona");
        String[] nombres = {"perico", "juan", "andres", "pako", "manolo", "pepe"};

        for(int i = 0; i < 6 ; i++){
            Persona persona = new Persona(nombres[i], correos[i], dnis[i], null);
            p.addParticipante(persona);
        }

        for (String dni : dnis)
            assertTrue(p.encuentraPersona(dni));

        for (String dni : dnis2)
            assertFalse(p.encuentraPersona(dni));

    }

    @Test
    void devuelvePersona() {
        System.out.println("\nTest devuelvePersona");
        String[] nombres = {"perico", "juan", "andres", "pako", "manolo", "pepe"};
        for(int i = 0; i < 6 ; i++){
            Persona persona = new Persona(nombres[i], correos[i], dnis[i], null);
            p.addParticipante(persona);
        }
        for (int c = 0; c < dnis.length; c++){
            assertEquals(p.devuelvePersona(dnis[c]), p.getParticipantes().get(c));
        }

        List<Persona> personasNo = new ArrayList<>();
        for (int c = 0; c < dnis.length; c++) {
            personasNo.add(new Persona(nombres2[c], correos[c], dnis[c], null));
        }

        for (int t = 0; t < dnis.length; t++)
            assertNotEquals(p.devuelvePersona(dnis[t]), personasNo.get(t));
    }

    @Test
    void addPersonaTarea() {
        System.out.println("\nTest addPersonaTarea");
        String[] nombres = {"perico", "juan", "andres", "pako", "manolo", "pepe"};

        Resultado resultado = new Resultado(identificadores[0], horas[0], tipo_resultado[0]);
        Tarea tarea = new Tarea(titulos[0], descrip[0], prioridad[0], fecha_creacion,resultado);
        for(int i=0;i<6;i++) {
            Persona personita = new Persona(nombres[i], correos[i], dnis[i],null);
            p.addParticipante(personita);
        }

        for (Persona persona : listaPersonas)
            assertTrue(p.addPersonaTarea(persona, tarea));

        for (Persona persona : listaPersonas)
            assertFalse(p.addPersonaTarea(persona, tarea));

    }

    @Test
    void eliminarPersonaTarea() {
        System.out.println("\nTest eliminarPersonaTarea");
        String[] nombres = {"perico", "juan", "andres", "pako", "manolo", "pepe"};

        Resultado resultado = new Resultado(identificadores[0], horas[0], tipo_resultado[0]);
        Tarea tar = new Tarea(titulos[0], descrip[0], prioridad[0], fecha_creacion,resultado);
        for(int i=0;i<6;i++) {
            Persona personita = new Persona(nombres[i], correos[i], dnis[i],null);
            p.addParticipante(personita);
            p.addPersonaTarea(personita,tar);
        }

        for (String dniPersona : dnis){
            assertTrue(p.eliminarPersonaTarea(dniPersona,tar));
        }

        for (String dniPersona : dnis)
            assertFalse(p.eliminarPersonaTarea(dniPersona, tar));

    }

    @Test
    void addEtiquetas() {
        System.out.println("\nTest addEtiquetas");
        Resultado resultado = new Resultado(identificadores[0], horas[0], tipo_resultado[0]);
        Tarea tarea = new Tarea(titulos[0], descrip[0], prioridad[0], fecha_creacion,resultado);

        for (String etiqueta : etiquetas)
            assertTrue(p.addEtiquetas(etiqueta, tarea));

        for (String etiqueta : etiquetas)
            assertFalse(p.addEtiquetas(etiqueta, tarea));

    }


    @Test
    void eliminarEtiqueta() {
        System.out.println("\nTest eliminarEtiqueta");
        Resultado resultado = new Resultado(identificadores[0], horas[0], tipo_resultado[0]);
        Tarea tarea = new Tarea(titulos[0], descrip[0], prioridad[0], fecha_creacion,resultado);

        for (String etiqueta : etiquetas)
            p.addEtiquetas(etiqueta,tarea);

        for (String etiqueta : etiquetas)
            assertTrue(p.eliminarEtiqueta(etiqueta, tarea));

        for (String etiqueta : etiquetas)
            assertFalse(p.eliminarEtiqueta(etiqueta, tarea));
    }



    @Test
    void addResponsable() {
        System.out.println("\nTest addResponsable");
        String[] nombres = {"perico", "juan", "andres", "pako", "manolo", "pepe"};

        for(int i=0;i<6;i++) {
            Resultado resultado = new Resultado(identificadores[i], horas[i], tipo_resultado[i]);
            Tarea tarea = new Tarea(titulos[i], descrip[i], prioridad[i], fecha_creacion,resultado);
            Persona persona = new Persona(nombres[i], correos[i], dnis[i], null);
            p1.addParticipante(persona);
            p1.addTarea(tarea);

        }
        String dniPersona = dnis[0];
        String nomTarea = titulos[0];
        String dniPersonaFalso = "142414";
        String nombreTareaFalso = "Cocinar";


        assertTrue(p1.addResponsable(dniPersona, nomTarea, p1));
        assertFalse(p1.addResponsable(dniPersona, nomTarea, p1));
        assertFalse(p1.addResponsable(dniPersonaFalso, nomTarea, p1));
        assertFalse(p1.addResponsable(dniPersona, nombreTareaFalso, p1));


    }
}