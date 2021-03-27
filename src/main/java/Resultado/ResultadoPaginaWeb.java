package Resultado;

import java.util.Scanner;

public class ResultadoPaginaWeb extends Resultado {
    private boolean estatica_dinamica; //True = estatica || False = dinamica
    private String lenguaje;
    private String backend; //Es la parte o rama del desarrollo web encargada de que toda la lógica de una página funcione.

    public ResultadoPaginaWeb(String identificador, double horas_invertidas, boolean tipo_resultado) {
        super(identificador,horas_invertidas,tipo_resultado);
    }

    public boolean isEstatica_dinamica() {
        return estatica_dinamica;
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

    public void resultado(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Elige {1 - Estatica | 2 - Dinamica}: ");
        estatica_dinamica = devolverResultado(scanner.nextInt());

        System.out.print("Elige el lenguaje a utilizar: ");
        lenguaje = scanner.next();

        System.out.print("Escribe el backend(parte o rama del desarrollo web encargada de que toda la lógica de una página funcione): ");
        backend = scanner.nextLine();
    }
}
