package Resultado;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ResultadoPaginaWeb extends Resultado {
    private boolean estatica_dinamica; //True = estatica || False = dinamica
    private String lenguaje;
    private String backend; //Es la parte o rama del desarrollo web encargada de que toda la lógica de una página funcione.
    private final List<String> lenguajesValido = new ArrayList<>(List.of("JAVASCRIP", "PYTHON","HTML", "PHP", "RUBY"));

    public ResultadoPaginaWeb(String identificador, double horas_invertidas, boolean tipo_resultado) {
        super(identificador,horas_invertidas,tipo_resultado);
    }

    public boolean isEstatica_dinamica(){
        return estatica_dinamica;
    }


    public String getestatica_dinamica() {
        if(estatica_dinamica)
            return "Estática";
        else
            return "Dinámica";
    }

    public void setEstatica_dinamica(boolean estatica_dinamica) {
        this.estatica_dinamica = estatica_dinamica;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }

    public String getBackend() {
        return backend;
    }

    public void setBackend(String backend) {
        this.backend = backend;
    }

    public String toString() {
        return "Identificador = " + getIdentificador() +"{ Horas invertidas = " + getHoras_invertidas() + ", Tipo de resultado = " + getTipo_resultado() +
                ", Tipo de WEB ='" + getestatica_dinamica() + '\'' +
                ", Lenguaje=" + lenguaje +
                ", Backend=" + backend +
                '}';
    }

    public void resultado(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Elige {1 - Estatica | 2 - Dinamica}: ");
        estatica_dinamica = devolverResultado(scanner.nextInt());
        scanner.skip("\n");
        System.out.print("Escribe el backend(parte o rama del desarrollo web encargada de que toda la lógica de una página funcione): ");
        backend = scanner.nextLine();
        System.out.print("Tipos de lenguaje disponible:\n\t * JAVASCRIP\n\t * PYTHON\n\t * PHP\n\t * HTML \n\t * RUBY\n");
        System.out.print("Elige el lenguaje a utilizar: ");
        lenguaje = scanner.next().toUpperCase(Locale.ROOT);
        while (!lenguajesValido.contains(lenguaje)){
            System.out.print("El formato no es valido, introduce uno que lo sea: ");
            lenguaje = scanner.next().toUpperCase(Locale.ROOT);
        }
        System.out.println();


    }
}
