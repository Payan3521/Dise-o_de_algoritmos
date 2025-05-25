package busqueda.busqueda_anchura;

import java.util.*;

public class BFS {

    public static void main(String[] args) {
        // Crear un grafo como lista de adyacencia
        Map<Integer, List<Integer>> graph = new HashMap<>();

        // Agregar aristas (grafo no dirigido)
        addEdge(graph, 0, 1);
        addEdge(graph, 0, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 1, 4);
        addEdge(graph, 2, 5);
        addEdge(graph, 2, 6);

        // Ejecutar BFS desde el nodo 0
        System.out.println("Recorrido BFS desde el nodo 0:");
        bfs(graph, 0);
    }

    // Función para agregar una arista al grafo
    public static void addEdge(Map<Integer, List<Integer>> graph, int u, int v) {
        graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u); // Si es no dirigido
    }

    // Implementación de BFS
    public static void bfs(Map<Integer, List<Integer>> graph, int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }
}

