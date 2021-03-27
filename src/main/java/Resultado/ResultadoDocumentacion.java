package Resultado;

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
            System.out.println("El formato no es valido, introduce uno que lo sea.");
            formato = scanner.next();
        }

        System.out.print("Espacio que ocupa en disco: ");
        espacio_disco = scanner.nextInt();

        System.out.print("Número de paginas: ");
        numpaginas = scanner.nextInt();
    }
}
