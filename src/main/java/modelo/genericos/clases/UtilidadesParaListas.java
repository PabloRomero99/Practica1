package modelo.genericos.clases;


import modelo.Proyecto;
import modelo.genericos.interfaces.tieneClave;
import modelo.genericos.interfaces.tieneLista;

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

    public static <T, E extends tieneClave> E devuelveElemento(T cad, List<E> list) throws Exception {
        for (E aux : list) {
            if (aux.getClave().equals(cad))
                return aux;
        }
        throw new Exception();
    }
}
