import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DFS {

    private static void dfs(Map<Integer, List<Integer>> graph, int root, Set<Integer> visited) {

        List<Integer> neighbors = graph.get(root);
        if (visited.contains(root) || neighbors == null) {
            return;
        }
        System.out.print(root + ", ");
        visited.add(root);

        for (int neighbor : neighbors) {
            dfs(graph, neighbor, visited);
        }

    }

    /**          
     *           2 - 4
     *          /
     *         1 - 6
     *          \
     *           3 - 5
     */
    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, Arrays.asList(2, 3, 6));
        graph.put(6, Arrays.asList(1));
        graph.put(2, Arrays.asList(1, 4));
        graph.put(3, Arrays.asList(1, 5));
        graph.put(4, Arrays.asList(2));
        graph.put(5, Arrays.asList(3));

        Set<Integer> visited = new HashSet<>();
        dfs(graph, 1, visited);
    }
    
}
