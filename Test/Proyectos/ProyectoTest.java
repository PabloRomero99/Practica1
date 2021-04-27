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

    @Test
    void addParticipante() {
        System.out.println("Test addParticipante");

        Proyecto p = new Proyecto("listaVacia");
        List<Persona> comp2 = new ArrayList<>();

        //Para personas
        String[] nombres2 = {"peri", "juana", "andresito", "pakorro", "manoli", "pepita"};
        String[] correos = {"perico@mail", "juan@mail", "andres@mail", "pako@mail", "manolo@mail" ,"pepe@gmail.com"};
        String[] dnis2 = {"12345675M", "32564397W", "45827525M", "46898894Ñ", "15588962N", "32015487O"};

        for (int n = 0; n < nombres2.length; n++) {
            Persona pers = new Persona(nombres2[n], dnis2[n], correos[n]);
            assertEquals(p.addParticipante(pers), comp2.add(pers));


        }
    }

    @Test
    void addTarea() {
        System.out.println("Test addTarea");

        Proyecto p = new Proyecto("listaVacia");
        List<Tarea> comp1 = new ArrayList<>();

        String[] titulos = {"la noche", "el dia", "la tarde", "la hora", "la casa", "el gato"};
        String[] descrip = {"oscura", "claro", "corta", "puntual", "fantasma", "maulla"};
        int[] prioridad = {3, 2, 5, 1, 4, 2};
        String[] identificadores = {"Documentacion", "Documentacion", "Pagina Web", "Pagina Web", "Programa", "Programa"};
        double[] horas = {10,20,30,1,2,3};
        double[] precios = {203.2,56.2,35.0,89.9,100.2,325.4};
        boolean[] tipo_resultado = {true,false,true,false,true,true};
        LocalDate fecha_creacion = LocalDate.now();


        for (int n = 0; n < titulos.length; n++) {
            Resultado resultado = new Resultado(identificadores[n], horas[n], tipo_resultado[n]);
            Tarea tarea = new Tarea(titulos[n], descrip[n], prioridad[n], fecha_creacion, resultado, precios[n]);
            assertEquals(p.addTarea(tarea), comp1.add(tarea));
        }
    }
}