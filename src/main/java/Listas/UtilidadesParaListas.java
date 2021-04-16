package Listas;

import Interfaces.tieneClave;
import Interfaces.tieneLista;

import java.util.ArrayList;
import java.util.List;

public class UtilidadesParaListas<E>  {

    public static <E extends tieneLista> List<E> elementosConListaVacia(List<E> list){
        List<E> vacios = new ArrayList();
        for (E aux : list){
            if (aux.getLista().isEmpty())
                vacios.add(aux);
        }
        return vacios;
    }

    public static <E extends tieneClave> boolean encuentraElementos(E elem, List<E> list){
        for (E aux: list) {
            if (aux.getClave().equals(elem.getClave()))
                return true;
        }
        return false;
    }


}

/*
 public static <T, E extends tieneClave> E devuelveElementos(T cad, List<E> list){
        if(encuentraElementos(cad,list)) {
            for (E aux : list) {
                if (aux.getClave().equals(cad))
                    return aux;
            }
        }
        return null;
    }
 */






