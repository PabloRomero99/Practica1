package vista;

public interface Vista {
    void datosCambiados();

    void setControlador(Controlador controlador);
    void setModelo(Modelo modelo);

    void crearGUI();

    String getNombre();
    String getTipo_Fact();

}
