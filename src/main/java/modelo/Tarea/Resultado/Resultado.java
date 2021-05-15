package modelo.Tarea.Resultado;
import java.io.Serializable;

public class Resultado implements Serializable {
    private String identificador;      //cadena única que identifica el resultado
    private double horas_invertidas;  //horas invertido en su producción
    private boolean tipo_resultado;  //true --> resultado interno | false --> destinado a ser comercializado

    public Resultado(String identificador, double horas_invertidas, boolean tipo_resultado) {
        this.identificador = identificador;
        this.horas_invertidas = horas_invertidas;
        this.tipo_resultado = tipo_resultado;
    }

    public String getIdentificador() {
        return identificador;
    }

    public double getHoras_invertidas() {
        return horas_invertidas;
    }

    public boolean isTipo_resultado(){
        return tipo_resultado;
    }


    public String getTipo_resultado() {
        if(tipo_resultado)
            return "Resultado interno";
        else
            return "Destinado a ser comercializado";
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public void setHoras_invertidas(double horas_invertidas) {
        this.horas_invertidas = horas_invertidas;
    }

    public void setTipo_resultado(boolean tipo_resultado) {
        this.tipo_resultado = tipo_resultado;
    }

    public static boolean devolverResultado(int eleccion){
        return eleccion == 1;
    }



    public String toString() {
        return "Resultado{" +
                "identificador='" + identificador + '\'' +
                ", horas_invertidas=" + horas_invertidas +
                ", tipo_resultado=" + getTipo_resultado() +
                '}';
    }


}