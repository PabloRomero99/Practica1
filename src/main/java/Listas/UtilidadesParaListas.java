package Listas;

import Interfaces.tieneClave;
import Interfaces.tieneLista;
import Persona.Persona;
import Proyectos.Proyecto;
import Tarea.Tarea;

import java.util.ArrayList;
import java.util.List;

public class UtilidadesParaListas<E>  {

    public static <E extends tieneLista> List<E> elementosConListaVacia(List<E> list){
        List<E> vacios = new ArrayList();
        for (E elem : list){
            if (elem.getLista().isEmpty())
                vacios.add(elem);
        }
        return vacios;
    }

    /*
    public static <E extends tieneClave> boolean encuentraElementos(E elem, List<E> list){
        for (E e: list){
            if(e.getClave().equals(elem.getClave()))
                return false;
        }
        return true;
    }
     */

    public static <E extends tieneClave> boolean encuentraElementos(E elem, Persona persona){
        for (E man: p) {

        }
        return true;
    }
}



