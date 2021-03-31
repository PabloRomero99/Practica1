package Herramienta;

import Persona.Persona;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

 class LeerTest {
    private String[] nombres = {"perico", "juan", "andres", "pako", "manolo"};
    private String[] correos = {"perico@mail", "juan@mail", "andres@mail", "pako@mail", "manolo@mail"};

    @Test
    void leerpersona() {
        for (int n = 0, c = 0; n < nombres.length; n++, c++){
            Persona p = new Persona(nombres[n], correos[c], null);

        }
    }

    @Test
    void leertarea() {
    }

    @Test
    void leerEtiquetas() {
    }

    @Test
    void leerDecision() {
    }

    @Test
    void leerValorTipo() {
    }

    @Test
    void prioridadCorrecta() {
    }
}