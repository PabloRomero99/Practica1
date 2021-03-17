package Resultado;

public class ResultadoPrograma {
    private String lenguaje; //Lenguaje de programación
    private int numlineas;  //Cantidad del lineas de código
    private int nummodulos; //Cantidad de módulos

    public ResultadoPrograma(){
        this.lenguaje = "";
        this.numlineas = 0;
        this.nummodulos = 0;
    }

    public ResultadoPrograma(String lenguaje, int numlineas, int nummodulos){
        this.lenguaje = lenguaje;
        this.numlineas = numlineas;
        this.nummodulos = nummodulos;
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
