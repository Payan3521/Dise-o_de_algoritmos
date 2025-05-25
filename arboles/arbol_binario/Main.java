package arboles.arbol_binario;

public class Main {
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        
        // Insertando nodos
        arbol.insertar(50);

        arbol.insertar(30);
        arbol.insertar(70);
        arbol.insertar(4);
        arbol.insertar(20);
        arbol.insertar(60);
        arbol.insertar(80);

        System.out.println("Recorrido Inorden:");
        arbol.inorden();

        System.out.println("Recorrido Preorden:");
        arbol.preorden();

        System.out.println("Recorrido Postorden:");
        arbol.postorden();

        System.out.println("Recorrido por niveles:");
        arbol.nivelOrden();

        // Buscando un nodo
        System.out.println("¿El número 40 está en el árbol?: " + arbol.buscar(40));
        System.out.println("¿El número 90 está en el árbol?: " + arbol.buscar(90));

        // Eliminando un nodo
        arbol.eliminar(30);
        System.out.println("Recorrido Inorden después de eliminar 30:");
        arbol.inorden();

        System.out.println("Recorrido Preorden después de eliminar 30:");
        arbol.preorden();

        
    }
}