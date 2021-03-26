package Resultado;

public class ResultadoPaginaWeb {
    private boolean estatica_dinamica; //True = estatica || False = dinamica
    private String lenguaje;
    private String backend;

    public ResultadoPaginaWeb(boolean estatica_dinamica, String lenguaje, String backend) {
        this.estatica_dinamica = estatica_dinamica;
        this.lenguaje = lenguaje;
        this.backend = backend;
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
}
