import java.util.ArrayList;

public class EveryPath {

    public static void printAllSimplePaths(int[][] graph, int u, int w, int length, ArrayList<Integer> path) {

        path.add(u);

        if (length == 5 && u == w) {
            for (int vertex : path) {
                System.out.print(vertex + " ");
            }
            System.out.println();
            return;
        }

        for (int v = 0; v < graph.length; v++) {
            if (graph[u][v] > 0 && !path.contains(v)) {
                printAllSimplePaths(graph, v, w, length + 1, new ArrayList<>(path));
            }
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 1, 0, 1, 0},
                {0, 0, 1, 0, 1},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0}
        };

        int u = 0; // Starting vertex
        int w = 4; // Ending vertex

        System.out.println("Paths from " + u + " to " + w + " with a length of 5:");
        printAllSimplePaths(graph, u, w, 1, new ArrayList<>());
    }
}
