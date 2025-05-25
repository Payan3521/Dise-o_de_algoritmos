package arboles.arbol_binario;

public class Nodo {
    int dato;
    Nodo izquierdo, derecho;

    public Nodo(int dato) {
        this.dato = dato;
        izquierdo = derecho = null;
    }
}