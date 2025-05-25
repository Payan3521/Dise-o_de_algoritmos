Un arbol binario tiene los siguientes metodos:

Insertar: Añadir un nodo en la posición correcta.

Buscar: Encontrar si un valor está presente en el árbol.

Recorridos: Visitar todos los nodos en cierto orden:

Inorden (In-order): Izquierda → Raíz → Derecha

       A
      / \
     B    C
    / \  / \ 
    D  E F  G

    = D-B-E-A-F-C-G

Preorden (Pre-order): Raíz → Izquierda → Derecha

       A
      / \
     B    C
    / \  / \ 
    D  E F  G

    = A-B-D-E-C-F-G

Postorden (Post-order): Izquierda → Derecha → Raíz

       A
      / \
     B    C
    / \  / \ 
    D  E F  G

    = D-E-B-F-G-C-A

Nivel orden (Level-order): Visitar todos los nodos en el mismo nivel antes de pasar al siguiente nivel

       A
      / \
     B    C
    / \  / \ 
    D  E F  G

    = A-B-C-D-E-F-G

*Cuando se elimina un nodo hay 3 casos:*
- El nodo a eliminar es una hoja (no tiene hijos):
- El nodo a eliminar tiene un hijo a la izquierda o a la derecha.
- El nodo a eliminar tiene dos hijos.