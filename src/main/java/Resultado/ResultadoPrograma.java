package Resultado;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ResultadoPrograma extends Resultado {
    private String lenguaje; //Lenguaje de programación
    private int numlineas;  //Cantidad del lineas de código
    private int nummodulos; //Cantidad de módulos
    private List<String> lenguajesValido = new ArrayList<>(List.of("Java", "JavaScrip", "Python", "C/C++", "C#", "HTML", "PHP", "R"));

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

    public void resultado(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tipos de lenguaje disponible:\n\t * Java\n\t * JavaScript\n\t * Python\n\t * C/C++\n\t * C#\n\t * PHP\n\t * HTML \n\t * R");
        lenguaje = scanner.next();
        while (!lenguajesValido.contains(lenguaje)){
            System.out.println("El formato no es valido, introduce uno que lo sea.");
            lenguaje = scanner.next();
        }

        System.out.print("Número de líneas: ");
        numlineas = scanner.nextInt();

        System.out.print("Número de modulos: ");
        nummodulos = scanner.nextInt();
    }
}
