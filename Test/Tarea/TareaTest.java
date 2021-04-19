package Tarea;

import Persona.Persona;
import Proyectos.Proyecto;
import Resultado.Resultado;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TareaTest {
    String[] nombres = {"perico", "juan", "andres", "pako", "manolo", "pepe"};
    String[] dnis = {"12345678M", "32564897W", "45827425M", "46897894Ñ", "15788962N", "32005487O"};
    List<Persona> listaPersonas = new ArrayList<>();
    @Test
    void devuelveResponsable() {
        Proyecto p = new Proyecto("Proyecto");
        System.out.println("Test devuelveResponsable");
        String[] titulos = {"la noche", "el dia", "la tarde", "la hora", "la casa", "el gato"};
        String[] descrip = {"oscura", "claro", "corta", "puntual", "fantasma", "maulla"};
        int[] prioridad = {3, 2, 5, 1, 4, 2};
        String[] identificadores = {"Documentacion", "Documentacion", "Pagina Web", "Pagina Web", "Programa", "Programa"};
        double[] horas = {10,20,30,1,2,3};
        boolean[] tipo_resultado = {true,false,true,false,true,true};
        LocalDate fecha_creacion = LocalDate.now();
        String[] nombres = {"perico", "juan", "andres", "pako", "manolo", "pepe"};
        String[] correos = {"perico@mail", "juan@mail", "andres@mail", "pako@mail", "manolo@mail" ,"pepe@gmail.com"};
        String[] dnis = {"12345678M", "32564897W", "45827425M", "46897894Ñ", "15788962N", "32005487O"};

        for(int i = 0; i < 6 ; i++) {
            Resultado resultado = new Resultado(identificadores[i], horas[i], tipo_resultado[i]);
            Tarea tarea = new Tarea(titulos[i], descrip[i], prioridad[i], fecha_creacion, resultado);
            Persona persona = new Persona(nombres[i], correos[i], dnis[i]);
            tarea.addResponsable(dnis[i], p);
            p.addParticipante(persona);
            p.addTarea(tarea);
            tarea.addResponsable(persona.getDNI(), p);
        }
        for (int i = 0, n = 5; i < 6 ; i++, n--){
            Tarea tarea = p.getTareas().get(i);
            assertEquals(tarea.devuelveResponsable(), p.getParticipantes().get(i).getNombre());
            assertNotEquals(tarea.devuelveResponsable(), p.getParticipantes().get(n).getNombre());
        }
    }

    @Test
    void addEtiquetas() {
        Proyecto p = new Proyecto("Proyecto");
        System.out.println("Test addResponsable");
        String[] titulos = {"la noche", "el dia", "la tarde", "la hora", "la casa", "el gato"};
        String[] descrip = {"oscura", "claro", "corta", "puntual", "fantasma", "maulla"};
        int[] prioridad = {3, 2, 5, 1, 4, 2};
        String[] identificadores = {"Documentacion", "Documentacion", "Pagina Web", "Pagina Web", "Programa", "Programa"};
        double[] horas = {10,20,30,1,2,3};
        boolean[] tipo_resultado = {true,false,true,false,true,true};
        LocalDate fecha_creacion = LocalDate.now();
        String[] etiquetas = {"sol", "playa", "dentro", "fuera", "espacioso", "estrecho", "corriente"};

        for(int i = 0; i < 6 ; i++) {
            Resultado resultado = new Resultado(identificadores[i], horas[i], tipo_resultado[i]);
            Tarea tarea = new Tarea(titulos[i], descrip[i], prioridad[i], fecha_creacion, resultado);
            p.addTarea(tarea);
        }

        Tarea tarea = p.getTareas().get(0);
        for (int i = 0; i < 6 ; i++) {
            tarea.addEtiquetas(etiquetas[i]);
            assertEquals(tarea.getLista_etiquetas().get(i), etiquetas[i]);
        }
    }

    @Test
    void eliminarEtiqueta() {
        Proyecto p = new Proyecto("Proyecto");
        System.out.println("Test addResponsable");
        String[] titulos = {"la noche", "el dia", "la tarde", "la hora", "la casa", "el gato"};
        String[] descrip = {"oscura", "claro", "corta", "puntual", "fantasma", "maulla"};
        int[] prioridad = {3, 2, 5, 1, 4, 2};
        String[] identificadores = {"Documentacion", "Documentacion", "Pagina Web", "Pagina Web", "Programa", "Programa"};
        double[] horas = {10,20,30,1,2,3};
        boolean[] tipo_resultado = {true,false,true,false,true,true};
        LocalDate fecha_creacion = LocalDate.now();
        String[] etiquetas = {"sol", "playa", "dentro", "fuera", "espacioso", "estrecho", "corriente"};


        for(int i = 0; i < 6 ; i++) {
            Resultado resultado = new Resultado(identificadores[i], horas[i], tipo_resultado[i]);
            Tarea tarea = new Tarea(titulos[i], descrip[i], prioridad[i], fecha_creacion, resultado);
            p.addTarea(tarea);
        }

        Tarea tarea = p.getTareas().get(0);
        for (int i = 0; i < 6 ; i++) {

            tarea.addEtiquetas(etiquetas[i]);
        }

        for (int i = 0; i < 6 ; i++) {
            tarea.eliminarEtiqueta(etiquetas[i]);

        }
        assertFalse(tarea.getLista_etiquetas().size()!=0);

    }

    @Test
    void addColaboradores() {
        Proyecto p = new Proyecto("Proyecto");
        System.out.println("Test addResponsable");
        String[] titulos = {"la noche", "el dia", "la tarde", "la hora", "la casa", "el gato"};
        String[] descrip = {"oscura", "claro", "corta", "puntual", "fantasma", "maulla"};
        int[] prioridad = {3, 2, 5, 1, 4, 2};
        String[] identificadores = {"Documentacion", "Documentacion", "Pagina Web", "Pagina Web", "Programa", "Programa"};
        double[] horas = {10,20,30,1,2,3};
        boolean[] tipo_resultado = {true,false,true,false,true,true};
        LocalDate fecha_creacion = LocalDate.now();
        String[] nombres = {"perico", "juan", "andres", "pako", "manolo", "pepe"};
        String[] correos = {"perico@mail", "juan@mail", "andres@mail", "pako@mail", "manolo@mail" ,"pepe@gmail.com"};
        String[] dnis = {"12345678M", "32564897W", "45827425M", "46897894Ñ", "15788962N", "32005487O"};

        for(int i = 0; i < 6 ; i++) {
            Resultado resultado = new Resultado(identificadores[i], horas[i], tipo_resultado[i]);
            Tarea tarea = new Tarea(titulos[i], descrip[i], prioridad[i], fecha_creacion, resultado);
            Persona persona = new Persona(nombres[i], correos[i], dnis[i]);
            p.addParticipante(persona);
            p.addTarea(tarea);
        }

        Tarea t = p.getTareas().get(0);

        for (int i = 0; i < 6 ; i++) {
            Persona per = p.getParticipantes().get(i);
            t.addColaboradores(per);
        }

        for (int i = 0; i < 6 ; i++){
            assertEquals(dnis[i],t.getColaboradores().get(i).getDNI());
        }
    }

    @Test
    void eliminarColaboradores() {
        Proyecto p = new Proyecto("Proyecto");
        System.out.println("Test addResponsable");
        String[] titulos = {"la noche", "el dia", "la tarde", "la hora", "la casa", "el gato"};
        String[] descrip = {"oscura", "claro", "corta", "puntual", "fantasma", "maulla"};
        int[] prioridad = {3, 2, 5, 1, 4, 2};
        String[] identificadores = {"Documentacion", "Documentacion", "Pagina Web", "Pagina Web", "Programa", "Programa"};
        double[] horas = {10,20,30,1,2,3};
        boolean[] tipo_resultado = {true,false,true,false,true,true};
        LocalDate fecha_creacion = LocalDate.now();
        String[] nombres = {"perico", "juan", "andres", "pako", "manolo", "pepe"};
        String[] correos = {"perico@mail", "juan@mail", "andres@mail", "pako@mail", "manolo@mail" ,"pepe@gmail.com"};
        String[] dnis = {"12345678M", "32564897W", "45827425M", "46897894Ñ", "15788962N", "32005487O"};

        for(int i = 0; i < 6 ; i++) {
            Resultado resultado = new Resultado(identificadores[i], horas[i], tipo_resultado[i]);
            Tarea tarea = new Tarea(titulos[i], descrip[i], prioridad[i], fecha_creacion, resultado);
            Persona persona = new Persona(nombres[i], correos[i], dnis[i]);
            p.addParticipante(persona);
            p.addTarea(tarea);
        }
        Tarea t = p.getTareas().get(0);

        for (int i = 0; i < 6 ; i++) {

            Persona per = p.getParticipantes().get(i);
            t.addColaboradores(per);
        }

        for (int i = 0; i < 6 ; i++) {
            Persona per = p.getParticipantes().get(i);
            t.eliminarColaboradores(per);

        }
        assertFalse(t.getColaboradores().size()!=0);
    }

    @Test
    void addResponsable() {
        Proyecto p = new Proyecto("Proyecto");
        System.out.println("Test addResponsable");
        String[] titulos = {"la noche", "el dia", "la tarde", "la hora", "la casa", "el gato"};
        String[] descrip = {"oscura", "claro", "corta", "puntual", "fantasma", "maulla"};
        int[] prioridad = {3, 2, 5, 1, 4, 2};
        String[] identificadores = {"Documentacion", "Documentacion", "Pagina Web", "Pagina Web", "Programa", "Programa"};
        double[] horas = {10,20,30,1,2,3};
        boolean[] tipo_resultado = {true,false,true,false,true,true};
        LocalDate fecha_creacion = LocalDate.now();
        String[] nombres = {"perico", "juan", "andres", "pako", "manolo", "pepe"};
        String[] correos = {"perico@mail", "juan@mail", "andres@mail", "pako@mail", "manolo@mail" ,"pepe@gmail.com"};
        String[] dnis = {"12345678M", "32564897W", "45827425M", "46897894Ñ", "15788962N", "32005487O"};

        for(int i = 0; i < 6 ; i++){
            Resultado resultado = new Resultado(identificadores[i], horas[i], tipo_resultado[i]);
            Tarea tarea = new Tarea(titulos[i], descrip[i], prioridad[i], fecha_creacion,resultado);
            p.addParticipante(new Persona(nombres[i],correos[i],dnis[i]));
            p.addTarea(tarea);
            tarea.addResponsable(dnis[i],p);
        }

        for (int i = 0; i < 6; i++) {
            assertEquals(nombres[i],p.getTareas().get(i).devuelveResponsable());
        }
    }
}