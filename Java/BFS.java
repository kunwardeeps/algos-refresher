import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BFS {


    private static void bfs(Map<Integer, List<Integer>> graph, int startNode) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<Integer>(); 
        visited.add(1);
        queue.add(1);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + ", ");

            List<Integer> neighbors = graph.get(node);
            if (neighbors == null || neighbors.isEmpty()) continue;

            for (int n : neighbors) {
                if (!visited.contains(n)) {
                    visited.add(n);
                    queue.add(n);
                }
            }
        }

    }

    /**          
     *           2 - 4
     *          /
     *     6 - 1
     *          \
     *           3 - 5
     */
    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, Arrays.asList(2, 3, 6));
        graph.put(6, null);
        graph.put(2, Arrays.asList(1, 4));
        graph.put(3, Arrays.asList(1, 5));
        graph.put(4, null);
        graph.put(5, null);

        bfs(graph, 1);
    }
}
