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

    private final Proyecto p = new Proyecto("Proyecto");
    private final Proyecto p1 = new Proyecto("Proyecto1");
    private final Proyecto p2 = new Proyecto("Proyecto2");

    //Persona
    private final String[] nombres = {"perico", "juan", "andres", "pako", "manolo", "pepe"};
    private final String[] nombres2 = {"peri", "juana", "andresito", "pakorro", "manoli", "pepita"};
    private final String[] correos = {"perico@mail", "juan@mail", "andres@mail", "pako@mail", "manolo@mail" ,"pepe@gmail.com"};

    //Tarea
    private final String[] titulos = {"la noche", "el dia", "la tarde", "la hora", "la casa", "el gato"};
    private final String[] titulos2 = {"la nota", "el llano", "la pradera", "la tarta", "la mansion", "el perro"};
    private final String[] descrip = {"oscura", "claro", "corta", "puntual", "fantasma", "maulla"};
    private final int[] prioridad = {3, 2, 5, 1, 4, 2};
        //Etiquetas
        private final String[] etiquetas = {"saludo", "despedida", "entrada", "salida", "dentro", "fuera"};

    //Resultado
    private final String[] identificadores = {"Documentacion", "Documentacion", "Pagina Web", "Pagina Web", "Programa", "Programa"};
    private final double[] horas = {10,20,30,1,2,3};
    private final boolean[] tipo_resultado = {true,false,true,false,true,true};
    LocalDate fecha_creacion = LocalDate.now();

    private List<Persona> listaPersonas = new ArrayList<>();
    private List<Tarea> listaTareas = new ArrayList<>();



    @Test
    void addParticipante(){
        for (int c = 0; c < nombres.length; c++) {
            listaPersonas.add(new Persona(nombres[c], correos[c], null));
        }
        for (Persona persona : listaPersonas)
            assertEquals(p.addParticipante(persona), true);

        for (Persona persona : listaPersonas)
            assertEquals(p.addParticipante(persona), false);
    }

   @Test
   void addTarea() {
       for(int i = 0; i < 6 ; i++){
           Resultado resultado = new Resultado(identificadores[i], horas[i], tipo_resultado[i]);
           Tarea tarea = new Tarea(titulos[i], descrip[i], prioridad[i], fecha_creacion,resultado);
           assertEquals(p.addTarea(tarea), true);
       }

       for (Tarea tarea : listaTareas)
           assertEquals(p.addTarea(tarea), false);
   }

    @Test
    void encuentraTarea() {
        for(int i = 0; i < 6 ; i++){
            Resultado resultado = new Resultado(identificadores[i], horas[i], tipo_resultado[i]);
            Tarea tarea = new Tarea(titulos[i], descrip[i], prioridad[i], fecha_creacion,resultado);
            p.addTarea(tarea);
        }

        for (String titulo : titulos)
            assertEquals(p.encuentraTarea(titulo), true);

        for (String titulo : etiquetas)
            assertEquals(p.encuentraTarea(titulo), false);
    }

    @Test
    void devuelveTarea() {
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
            assertEquals(p.devuelveTarea(titulos[t]), listaTareas.get(t));

        for (int t = 0; t < titulos.length; t++)
            assertNotEquals(p.devuelveTarea(titulos[t]), tareasNo.get(t));
    }

    @Test
    void encuentraPersona() {
        for(int i = 0; i < 6 ; i++){
            Persona persona = new Persona(nombres[i], correos[i], null);
            p.addParticipante(persona);
        }

        for (String nombre : nombres)
            assertEquals(p.encuentraPersona(nombre), true);

        for (String nombre : etiquetas)
            assertEquals(p.encuentraPersona(nombre), false);

    }

    @Test
    void devuelvePersona() {
        for(int i = 0; i < 6 ; i++){
            Persona persona = new Persona(nombres[i], correos[i], null);
            p.addParticipante(persona);
            //(@Nullable Object expected
        }
        for (int c = 0; c < nombres.length; c++){
            assertEquals(p.devuelvePersona(nombres[c]), p.getParticipantes().get(c));
        }

        List<Persona> personasNo = new ArrayList<>();
        for (int c = 0; c < nombres.length; c++) {
            personasNo.add(new Persona(nombres2[c], correos[c], null));
        }

        for (int t = 0; t < nombres2.length; t++)
            assertNotEquals(p.devuelvePersona(nombres2[t]), personasNo.get(t));
    }

    @Test
    void addPersonaTarea() {
        Resultado resultado = new Resultado(identificadores[0], horas[0], tipo_resultado[0]);
        Tarea tarea = new Tarea(titulos[0], descrip[0], prioridad[0], fecha_creacion,resultado);
        for(int i=0;i<6;i++)
            listaPersonas.add(new Persona(nombres[i], correos[i], null));

        for (Persona persona : listaPersonas)
            assertEquals(p.addPersonaTarea(persona,tarea),true);

        for (Persona persona : listaPersonas)
            assertEquals(p.addPersonaTarea(persona,tarea), false);
    }

    @Test
    void eliminarPersonaTarea() {
        Resultado resultado = new Resultado(identificadores[0], horas[0], tipo_resultado[0]);
        Tarea tarea = new Tarea(titulos[0], descrip[0], prioridad[0], fecha_creacion,resultado);
        for(int i=0;i<6;i++) {
            p.addPersonaTarea(new Persona(nombres[i], correos[i], null), tarea);
        }

        for (String nomPersona : nombres)
            assertEquals(p.eliminarPersonaTarea(nomPersona,tarea), true);

        for (String nomPersona : nombres)
            assertEquals(p.eliminarPersonaTarea(nomPersona,tarea), false);

    }

    @Test
    void addEtiquetas() {
        Resultado resultado = new Resultado(identificadores[0], horas[0], tipo_resultado[0]);
        Tarea tarea = new Tarea(titulos[0], descrip[0], prioridad[0], fecha_creacion,resultado);

        for (String etiqueta : etiquetas)
            assertEquals(p.addEtiquetas(etiqueta,tarea),true);

        for (String etiqueta : etiquetas)
            assertEquals(p.addEtiquetas(etiqueta,tarea), false);

    }


    @Test
    void eliminarEtiqueta() {
        Resultado resultado = new Resultado(identificadores[0], horas[0], tipo_resultado[0]);
        Tarea tarea = new Tarea(titulos[0], descrip[0], prioridad[0], fecha_creacion,resultado);

        for (String etiqueta : etiquetas)
            p.addEtiquetas(etiqueta,tarea);

        for (String etiqueta : etiquetas)
            assertEquals(p.eliminarEtiqueta(etiqueta,tarea),true);

        for (String etiqueta : etiquetas)
            assertEquals(p.eliminarEtiqueta(etiqueta,tarea), false);
    }



    @Test
    void addResponsable() {
        for(int i=0;i<6;i++) {
            Resultado resultado = new Resultado(identificadores[i], horas[i], tipo_resultado[i]);
            Tarea tarea = new Tarea(titulos[i], descrip[i], prioridad[i], fecha_creacion,resultado);
            Persona persona = new Persona(nombres[i], correos[i], null);
            p1.addParticipante(persona);
            p1.addTarea(tarea);

        }
        String nomPersona = nombres[0];
        String nomTarea = titulos[0];
        String nombrePersonaFalso = "Vicente";
        String nombreTareaFalso = "Cocinar";
        //ia estoi arto

        assertEquals(p1.addResponsable(nomPersona,nomTarea,p1), true);
        assertEquals(p1.addResponsable(nomPersona,nomTarea,p1), false);
        assertEquals(p1.addResponsable(nombrePersonaFalso,nomTarea,p1), false);
        assertEquals(p1.addResponsable(nomPersona,nombreTareaFalso,p1), false);


    }
}