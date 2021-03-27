package Resultado;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ResultadoPrograma extends Resultado {
    private String lenguaje; //Lenguaje de programación
    private int numlineas;  //Cantidad del lineas de código
    private int nummodulos; //Cantidad de módulos

    public ResultadoPrograma(String identificador, double horas_invertidas, boolean tipo_resultado) {
        super(identificador,horas_invertidas,tipo_resultado);
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }

    public int getNumlineas() {
        return numlineas;
    }

    public void setNumlineas(int numlineas) {
        this.numlineas = numlineas;
    }

    public int getNummodulos() {
        return nummodulos;
    }

    public void setNummodulos(int nummodulos) {
        this.nummodulos = nummodulos;
    }

    @Override
    public String toString() {
        return "ResultadoPrograma{" +
                "lenguaje='" + lenguaje + '\'' +
                ", numlineas=" + numlineas +
                ", nummodulos=" + nummodulos +
                '}';
    }
}
