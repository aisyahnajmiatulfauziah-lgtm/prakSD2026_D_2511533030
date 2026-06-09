package pekan9_2511533030;
import java.util.*;

public class GraphTraversal_2511533030 {

    private Map<String, List<String>> graph_3030 = new HashMap<>();

    // Menambahkan edge (graf tak berarah)
    public void addEdge(String node1, String node2) {
        graph_3030.putIfAbsent(node1, new ArrayList<>());
        graph_3030.putIfAbsent(node2, new ArrayList<>());
        graph_3030.get(node1).add(node2);
        graph_3030.get(node2).add(node1);
    }

    // Menampilkan graf awal
    public void printGraph() {
        System.out.println("Graf Awal (Adjacency List):");
        for (String node : graph_3030.keySet()) {
            System.out.print(node + " -> ");
            List<String> neighbors = graph_3030.get(node);
            System.out.println(String.join(", ", neighbors));
        }
        System.out.println();
    }

    // DFS rekursif
    public void dfs(String start) {
        Set<String> visited = new HashSet<>();
        System.out.println("Penelusuran DFS:");
        dfsHelper(start, visited);
        System.out.println();
    }

    private void dfsHelper(String current, Set<String> visited) {
        if (visited.contains(current)) return;

        visited.add(current);
        System.out.print(current + " ");

        for (String neighbor : graph_3030.getOrDefault(current, new ArrayList<>())) {
            dfsHelper(neighbor, visited);
        }
    }
 // BFS iteratif
    public void bfs(String start) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.add(start);
        visited.add(start);

        System.out.println("Penelusuran BFS:");

        while (!queue.isEmpty()) {
            String current = queue.poll();
            System.out.print(current + " ");

            for (String neighbor : graph_3030.getOrDefault(current, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        System.out.println();
    }
 // Main
    public static void main(String[] args) {
        GraphTraversal_2511533030 graph_3030 = new GraphTraversal_2511533030();

        // Contoh graf: A-B, A-C, B-D, B-E
        graph_3030.addEdge("A", "B");
        graph_3030.addEdge("A", "C");
        graph_3030.addEdge("B", "D");
        graph_3030.addEdge("B", "E");

        // Cetak graf awal
        System.out.println("Graf Awal adalah: ");
        graph_3030.printGraph();

        // Lakukan penelusuran
        graph_3030.dfs("A");
        graph_3030.bfs("A");
    }
}