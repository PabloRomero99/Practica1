package modelo.Tarea.Resultado;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ResultadoPrograma extends Resultado {
    private String lenguaje; //Lenguaje de programación
    private int numlineas;  //Cantidad del lineas de código
    private int nummodulos; //Cantidad de módulos
    private final List<String> lenguajesValido = new ArrayList<>(List.of("JAVA", "JAVASCRIP", "PYTHON", "C/C++", "C#", "HTML", "PHP", "R"));

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
        return "Identificador = " + getIdentificador() +"{ Horas invertidas = " + getHoras_invertidas() + ", Tipo de resultado = " + getTipo_resultado() +
                ", Tenguaje='" + lenguaje + '\'' +
                ", Número de líneas=" + numlineas +
                ", Número de modulos=" + nummodulos +
                '}';
    }


    public void resultado(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tipos de lenguaje disponible:\n\t * Java\n\t * JavaScript\n\t * Python\n\t * C/C++\n\t * C#\n\t * PHP\n\t * HTML \n\t * R");
        System.out.print("Elige uno de estos lenguajes: ");
        lenguaje = scanner.next().toUpperCase(Locale.ROOT);
        while (!lenguajesValido.contains(lenguaje)){
            System.out.println("El formato no es valido, introduce uno que lo sea.");
            lenguaje = scanner.next().toUpperCase(Locale.ROOT);
        }

        System.out.print("Número de líneas: ");
        numlineas = scanner.nextInt();

        System.out.print("Número de modulos: ");
        nummodulos = scanner.nextInt();
        System.out.println();
    }
}