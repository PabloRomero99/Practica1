package Facturación;

import java.io.Serializable;

public interface Facturacion extends Serializable {
    String nombre();
    double conseguirCoste(double coste);
}
