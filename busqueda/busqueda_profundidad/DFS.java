package busqueda.busqueda_profundidad;

import java.util.*;

public class DFS {

    public static void main(String[] args) {
        // Crear grafo
        Map<Integer, List<Integer>> graph = new HashMap<>();

        // Agregar aristas
        addEdge(graph, 0, 1);
        addEdge(graph, 0, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 1, 4);
        addEdge(graph, 2, 5);
        addEdge(graph, 2, 6);

        // Ejecutar DFS desde el nodo 0
        System.out.println("Recorrido DFS desde el nodo 0:");
        Set<Integer> visited = new HashSet<>();
        dfs(graph, 0, visited);
    }

    // Agrega una arista al grafo (no dirigido)
    public static void addEdge(Map<Integer, List<Integer>> graph, int u, int v) {
        graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
    }

    // DFS recursivo
    public static void dfs(Map<Integer, List<Integer>> graph, int node, Set<Integer> visited) {
        if (visited.contains(node)) return;

        visited.add(node);
        System.out.print(node + " ");

        for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                dfs(graph, neighbor, visited);
            }
        }
    }

    // DFS iterativo con pila
    public static void dfsIterative(Map<Integer, List<Integer>> graph, int start) {
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int node = stack.pop();

            if (!visited.contains(node)) {
                visited.add(node);
                System.out.print(node + " ");

                // Agregar vecinos en orden inverso para simular recursión
                List<Integer> neighbors = graph.getOrDefault(node, new ArrayList<>());
                Collections.reverse(neighbors);
                for (int neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
            }
        }
    }

}