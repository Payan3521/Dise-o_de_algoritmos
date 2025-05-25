package arboles.arbol_binario;

import java.util.LinkedList;
import java.util.Queue;

public class ArbolBinario {
    Nodo raiz;

    // Insertar un nodo en el árbol
    public void insertar(int dato) {
        raiz = insertarRecursivo(raiz, dato);
    }

    private Nodo insertarRecursivo(Nodo actual, int dato) {
        if (actual == null) {
            return new Nodo(dato);
        }
        if (dato < actual.dato) {
            actual.izquierdo = insertarRecursivo(actual.izquierdo, dato);
        } else if (dato > actual.dato) {
            actual.derecho = insertarRecursivo(actual.derecho, dato);
        }
        return actual;
    }

    // Buscar un nodo en el árbol
    public boolean buscar(int dato) {
        return buscarRecursivo(raiz, dato);
    }

    private boolean buscarRecursivo(Nodo actual, int dato) {
        if (actual == null) {
            return false;
        }
        if (dato == actual.dato) {
            return true;
        }
        return dato < actual.dato
                ? buscarRecursivo(actual.izquierdo, dato)
                : buscarRecursivo(actual.derecho, dato);
    }

    // Recorridos
    public void inorden() {
        inordenRecursivo(raiz);
        System.out.println();
    }

    private void inordenRecursivo(Nodo actual) {
        if (actual != null) {
            inordenRecursivo(actual.izquierdo);
            System.out.print(actual.dato + " ");
            inordenRecursivo(actual.derecho);
        }
    }

    public void preorden() {
        preordenRecursivo(raiz);
        System.out.println();
    }

    private void preordenRecursivo(Nodo actual) {
        if (actual != null) {
            System.out.print(actual.dato + " ");
            preordenRecursivo(actual.izquierdo);
            preordenRecursivo(actual.derecho);
        }
    }

    public void postorden() {
        postordenRecursivo(raiz);
        System.out.println();
    }

    private void postordenRecursivo(Nodo actual) {
        if (actual != null) {
            postordenRecursivo(actual.izquierdo);
            postordenRecursivo(actual.derecho);
            System.out.print(actual.dato + " ");
        }
    }

    public void nivelOrden() {
        if (raiz == null) return;
        Queue<Nodo> cola = new LinkedList<>();
        cola.add(raiz);
        while (!cola.isEmpty()) {
            Nodo actual = cola.poll();
            System.out.print(actual.dato + " ");
            if (actual.izquierdo != null) cola.add(actual.izquierdo);
            if (actual.derecho != null) cola.add(actual.derecho);
        }
        System.out.println();
    }

    // Eliminar un nodo del árbol
    public void eliminar(int dato) {
        raiz = eliminarRecursivo(raiz, dato);
    }

    private Nodo eliminarRecursivo(Nodo actual, int dato) {
        if (actual == null) return null;

        if (dato < actual.dato) {
            actual.izquierdo = eliminarRecursivo(actual.izquierdo, dato);
        } else if (dato > actual.dato) {
            actual.derecho = eliminarRecursivo(actual.derecho, dato);
        } else {
            // Nodo encontrado: caso 1 y 2 (sin hijos o con un solo hijo)
            if (actual.izquierdo == null) return actual.derecho;
            if (actual.derecho == null) return actual.izquierdo;

            // Caso 3: dos hijos
            int valorMin = encontrarMinimo(actual.derecho);
            actual.dato = valorMin;
            actual.derecho = eliminarRecursivo(actual.derecho, valorMin);
        }
        return actual;
    }

    private int encontrarMinimo(Nodo actual) {
        int minimo = actual.dato;
        while (actual.izquierdo != null) {
            minimo = actual.izquierdo.dato;
            actual = actual.izquierdo;
        }
        return minimo;
    }
}