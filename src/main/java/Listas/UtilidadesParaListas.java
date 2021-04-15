package Listas;

import Interfaces.tieneClave;
import Interfaces.tieneLista;
import Tarea.Tarea;

import java.util.ArrayList;
import java.util.List;

public class UtilidadesParaListas<E>  {
/*
    @Override
    public List getLista() {
        return null;
    }

    @Override
    public Object getClave() {
        return null;
    }
*/
    public static <E extends tieneLista> List<E> elementosConListaVacia(List<E> list){
        List<E> vacios = new ArrayList();
        for (E elem : list){
            if (elem.getLista().isEmpty())
                vacios.add(elem);
        }
        return vacios;
    }

    public static <E extends tieneClave> boolean elementos(E elem,List<E> list){
        for (E e: list){
            if(e.getClave().equals(elem.getClave()))
                return false;
        }
        return true;
    }


}