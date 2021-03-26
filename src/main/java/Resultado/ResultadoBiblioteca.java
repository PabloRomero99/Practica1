package Resultado;

public class ResultadoBiblioteca {
    private String nombreBiblioteca; //Lenguaje de programación
    private int numLibros;  //Cantidad del lineas de código
    private int numEstanterias; //Cantidad de módulos

    public ResultadoBiblioteca(String nombreBiblioteca, int numLibros, int numEstanterias) {
        this.nombreBiblioteca = nombreBiblioteca;
        this.numLibros = numLibros;
        this.numEstanterias = numEstanterias;
    }

    public String getNombreBiblioteca() {
        return nombreBiblioteca;
    }

    public void setNombreBiblioteca(String nombreBiblioteca) {
        this.nombreBiblioteca = nombreBiblioteca;
    }

    public int getNumLibros() {
        return numLibros;
    }

    public void setNumLibros(int numLibros) {
        this.numLibros = numLibros;
    }

    public int getNumEstanterias() {
        return numEstanterias;
    }

    public void setNumEstanterias(int numEstanterias) {
        this.numEstanterias = numEstanterias;
    }
}
