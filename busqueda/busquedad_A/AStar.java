package busqueda.busquedad_A;

import java.util.*;

class Node implements Comparable<Node> {
    public final String name;
    public double g = Double.MAX_VALUE; // costo desde inicio
    public final double h;              // heurística estimada
    public double f = Double.MAX_VALUE; // f = g + h
    public Node parent = null;
    public List<Edge> neighbors = new ArrayList<>();

    public Node(String name, double h) {
        this.name = name;
        this.h = h;
    }

    @Override
    public int compareTo(Node other) {
        return Double.compare(this.f, other.f);
    }
}

class Edge {
    public final Node target;
    public final double cost;

    public Edge(Node target, double cost) {
        this.target = target;
        this.cost = cost;
    }
}

public class AStar {

    public static List<Node> aStarSearch(Node start, Node goal) {
        PriorityQueue<Node> openSet = new PriorityQueue<>();
        Set<Node> closedSet = new HashSet<>();

        start.g = 0;
        start.f = start.h;
        openSet.add(start);

        while (!openSet.isEmpty()) {
            Node current = openSet.poll();

            if (current == goal) {
                return reconstructPath(current);
            }

            closedSet.add(current);

            for (Edge edge : current.neighbors) {
                Node neighbor = edge.target;
                if (closedSet.contains(neighbor))
                    continue;

                double tentative_g = current.g + edge.cost;

                if (tentative_g < neighbor.g) {
                    neighbor.parent = current;
                    neighbor.g = tentative_g;
                    neighbor.f = tentative_g + neighbor.h;

                    if (!openSet.contains(neighbor)) {
                        openSet.add(neighbor);
                    } else {
                        // Remover y volver a agregar para actualizar prioridad
                        openSet.remove(neighbor);
                        openSet.add(neighbor);
                    }
                }
            }
        }
        return null; // No hay camino
    }

    private static List<Node> reconstructPath(Node current) {
        List<Node> path = new ArrayList<>();
        while (current != null) {
            path.add(current);
            current = current.parent;
        }
        Collections.reverse(path);
        return path;
    }

    // Ejemplo de uso
    public static void main(String[] args) {
        Node a = new Node("A", 10);
        Node b = new Node("B", 8);
        Node c = new Node("C", 5);
        Node d = new Node("D", 7);
        Node e = new Node("E", 3);
        Node f = new Node("F", 6);
        Node g = new Node("G", 0); // Objetivo

        a.neighbors.add(new Edge(b, 1));
        a.neighbors.add(new Edge(c, 4));
        b.neighbors.add(new Edge(d, 2));
        b.neighbors.add(new Edge(e, 6));
        c.neighbors.add(new Edge(f, 3));
        d.neighbors.add(new Edge(g, 1));
        e.neighbors.add(new Edge(g, 2));
        f.neighbors.add(new Edge(g, 5));

        List<Node> path = aStarSearch(a, g);

        if (path != null) {
            System.out.print("Camino encontrado: ");
            for (Node node : path) {
                System.out.print(node.name + " ");
            }
        } else {
            System.out.println("No se encontró camino.");
        }
    }
}
