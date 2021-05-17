package modelo.Tarea.Resultado;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ResultadoDocumentacion extends Resultado{

    private int numpaginas;
    private String formato;
    private int espacio_disco;
    //WORD(DOC,DOCX), PDF, TXT(texto plano), XSIG(ficheros firmados), ZIP, XML(plantillas preseentación), TELECON(documentos contables))
    private final List<String> formatovalido = new ArrayList<>(List.of("WORD","PDF","TXT","XSIG","ZIP","XML","TELECON"));


    public ResultadoDocumentacion(String identificador, double horas_invertidas, boolean tipo_resultado) {
        super(identificador,horas_invertidas,tipo_resultado);

    }

    public int getNumpaginas() {
        return numpaginas;
    }

    public void setNumpaginas(int numpaginas) {
        this.numpaginas = numpaginas;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public int getEspacio_disco() {
        return espacio_disco;
    }

    public void setEspacio_disco(int espacio_disco) {
        this.espacio_disco = espacio_disco;
    }

    public List<String> getFormatovalido() {
        return formatovalido;
    }

    @Override
    public String toString() {
        return "Identificador= "+ getIdentificador() +"{Horas invertidas= "+ getHoras_invertidas() + ", Tipo= "+ getTipo_resultado() +
                ", Número de páginas=" + numpaginas +
                ", Formato='" + formato + '\'' +
                ", Espacio de disco=" + espacio_disco +
                '}';
    }

    public void resultado(){
        Scanner scanner = new Scanner(System.in);
        //WORD(DOC,DOCX), PDF, TXT(texto plano), XSIG(ficheros firmados), ZIP, XML(plantillas preseentación), TELECON(documentos contables))
        System.out.println("Tipos de formato disponible:\n\t * WORD\n\t * PDF\n\t * TXT\n\t * XSIG\n\t * ZIP\n\t * TELECON\n\t * XML ");
        System.out.print("Elige un formato: ");
        formato = scanner.next().toUpperCase(Locale.ROOT);
        while (!formatovalido.contains(formato)){
            System.out.print("El formato no es valido, introduce uno que lo sea:");
            formato = scanner.next().toUpperCase(Locale.ROOT);;
        }

        System.out.print("Espacio que ocupa en disco: ");
        espacio_disco = scanner.nextInt();

        System.out.print("Número de paginas: ");
        numpaginas = scanner.nextInt();
        System.out.println();
    }
}

package modelo.Tarea.Resultado;
import java.io.Serializable;

public class ResultadoDocumentacion implements Serializable {
    private String identificador;      //cadena única que identifica el resultado
    private double horas_invertidas;  //horas invertido en su producción
    private boolean tipo_resultado;  //true --> resultado interno | false --> destinado a ser comercializado

    public ResultadoDocumentacion(String identificador, double horas_invertidas, boolean tipo_resultado) {
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
