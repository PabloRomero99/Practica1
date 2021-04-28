/*
package Listas;

import Excepciones.ElementoNullException;
import Persona.Persona;
import Proyectos.Proyecto;
import Resultado.Resultado;
import Tarea.Tarea;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static Listas.UtilidadesParaListas.elementosConListaVacia;
import static Listas.UtilidadesParaListas.encuentraElementos;
import static Listas.UtilidadesParaListas.devuelveElementos;


import static org.junit.jupiter.api.Assertions.*;



class UtilidadesParaListasTest {

    @Test
    void elementosConListaVaciaTest() {
        System.out.println("Test elementosConListaVacia");

        Proyecto p = new Proyecto("listaVacia");
        List<Tarea> comp1 = new ArrayList<>();
        List<Persona> comp2 = new ArrayList<>();

        //Para tareas
        String[] titulos = {"la noche", "el dia", "la tarde", "la hora", "la casa", "el gato"};
        String[] descrip = {"oscura", "claro", "corta", "puntual", "fantasma", "maulla"};
        int[] prioridad = {3, 2, 5, 1, 4, 2};
        String[] identificadores = {"Documentacion", "Documentacion", "Pagina Web", "Pagina Web", "Programa", "Programa"};
        double[] precios = {203.2,56.2,35.0,89.9,100.2,325.4};
        double[] horas = {10,20,30,1,2,3};
        boolean[] tipo_resultado = {true,false,true,false,true,true};
        LocalDate fecha_creacion = LocalDate.now();

        //Para personas
        String[] nombres2 = {"peri", "juana", "andresito", "pakorro", "manoli", "pepita"};
        String[] correos = {"perico@mail", "juan@mail", "andres@mail", "pako@mail", "manolo@mail" ,"pepe@gmail.com"};
        String[] dnis2 = {"12345675M", "32564397W", "45827525M", "46898894Ñ", "15588962N", "32015487O"};

        for (int n = 0; n < nombres2.length; n++) {
            Persona pers = new Persona(nombres2[n], dnis2[n], correos[n]);
            p.addParticipante(pers);
            comp2.add(pers);

            Resultado resultado = new Resultado(identificadores[n], horas[n], tipo_resultado[n]);
            Tarea tarea = new Tarea(titulos[n], descrip[n], prioridad[n], fecha_creacion,resultado, precios[n]);
            p.addTarea(tarea);
            comp1.add(tarea);
        }

        assertEquals(elementosConListaVacia(p.getTareas()), comp1);
        assertEquals(elementosConListaVacia(p.getParticipantes()), comp2);
        assertNotEquals(elementosConListaVacia(p.getTareas()), comp2);
        assertNotEquals(elementosConListaVacia(p.getParticipantes()), comp1);
        comp1.remove(2);
        comp2.remove(2);
        assertNotEquals(elementosConListaVacia(p.getTareas()), comp1);
        assertNotEquals(elementosConListaVacia(p.getParticipantes()), comp2);

    }

    @Test
    void encuentraElementosTest() {
        System.out.println("Test encuentraElementos");

        Proyecto p = new Proyecto("encuentra");
        List<Tarea> comp1 = new ArrayList<>();
        List<Persona> comp2 = new ArrayList<>();

        //Para tareas
        String[] titulos = {"la noche", "el dia", "la tarde", "la hora", "la casa", "el gato"};
        String[] descrip = {"oscura", "claro", "corta", "puntual", "fantasma", "maulla"};
        int[] prioridad = {3, 2, 5, 1, 4, 2};
        String[] identificadores = {"Documentacion", "Documentacion", "Pagina Web", "Pagina Web", "Programa", "Programa"};
        double[] horas = {10,20,30,1,2,3};
        double[] precios = {203.2,56.2,35.0,89.9,100.2,325.4};
        boolean[] tipo_resultado = {true,false,true,false,true,true};
        LocalDate fecha_creacion = LocalDate.now();

        //Para personas
        String[] nombres2 = {"peri", "juana", "andresito", "pakorro", "manoli", "pepita"};
        String[] correos = {"perico@mail", "juan@mail", "andres@mail", "pako@mail", "manolo@mail" ,"pepe@gmail.com"};
        String[] dnis2 = {"12345675M", "32564397W", "45827525M", "46898894Ñ", "15588962N", "32015487O"};

        for (int n = 0; n < nombres2.length; n++) {
            Persona pers = new Persona(nombres2[n], dnis2[n], correos[n]);
            p.addParticipante(pers);
            comp2.add(pers);

            Resultado resultado = new Resultado(identificadores[n], horas[n], tipo_resultado[n]);
            Tarea tarea = new Tarea(titulos[n], descrip[n], prioridad[n], fecha_creacion,resultado, precios[n]);
            p.addTarea(tarea);
            comp1.add(tarea);
        }
        for (Tarea t : comp1)
            assertTrue(encuentraElementos(t, p.getTareas()));

        for (Persona per : comp2)
            assertTrue(encuentraElementos(per, p.getParticipantes()));

    }

    @Test
    void devuelveElementosTest() throws ElementoNullException {
        System.out.println("Test devuelveElemento");

        Proyecto p = new Proyecto("encuentra");
        List<Tarea> comp1 = new ArrayList<>();
        List<Persona> comp2 = new ArrayList<>();

        //Para tareas
        String[] titulos = {"la noche", "el dia", "la tarde", "la hora", "la casa", "el gato"};
        String[] descrip = {"oscura", "claro", "corta", "puntual", "fantasma", "maulla"};
        int[] prioridad = {3, 2, 5, 1, 4, 2};
        String[] identificadores = {"Documentacion", "Documentacion", "Pagina Web", "Pagina Web", "Programa", "Programa"};
        double[] horas = {10,20,30,1,2,3};
        double[] precios = {203.2,56.2,35.0,89.9,100.2,325.4};
        boolean[] tipo_resultado = {true,false,true,false,true,true};
        LocalDate fecha_creacion = LocalDate.now();

        //Para personas
        String[] nombres2 = {"peri", "juana", "andresito", "pakorro", "manoli", "pepita"};
        String[] correos = {"perico@mail", "juan@mail", "andres@mail", "pako@mail", "manolo@mail" ,"pepe@gmail.com"};
        String[] dnis2 = {"12345675M", "32564397W", "45827525M", "46898894Ñ", "15588962N", "32015487O"};

        for (int n = 0; n < nombres2.length; n++) {
            Persona pers = new Persona(nombres2[n], dnis2[n], correos[n]);
            p.addParticipante(pers);
            comp2.add(pers);

            Resultado resultado = new Resultado(identificadores[n], horas[n], tipo_resultado[n]);
            Tarea tarea = new Tarea(titulos[n], descrip[n], prioridad[n], fecha_creacion,resultado, precios[n]);
            p.addTarea(tarea);
            comp1.add(tarea);
        }

        for (int n = 0; n <dnis2.length; n++) {
            try {
                assertEquals(devuelveElementos(dnis2[n], p.getParticipantes()), p.getParticipantes().get(n));
            }catch (ElementoNullException e){

            }
        }
        for (int n = 0; n <titulos.length; n++) {
            try {
                assertEquals(devuelveElementos(titulos[n], p.getTareas()), p.getTareas().get(n));
            }catch (ElementoNullException e){

            }
        }
    }
}
 */