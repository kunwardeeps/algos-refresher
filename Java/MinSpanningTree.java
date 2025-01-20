import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MinSpanningTree {
    public static Map<Integer, Integer> mst(Map<Integer, Map<Integer, Integer>> graph, int source) {

        PriorityQueue<Node> minHeap = new PriorityQueue<>((p1,p2) -> p1.dist - p2.dist);
        minHeap.offer(new Node(source, 0));
        Map<Integer, Integer> visited = new HashMap<>(); // track visited as well as final min dist
        
        while (!minHeap.isEmpty()) {
            Node currentPair = minHeap.poll(); //get the unvisited node with min distance
            
            if (visited.containsKey(currentPair.label)) continue;
            visited.put(currentPair.label, currentPair.dist);
            
            for (int neighbor : graph.get(currentPair.label).keySet()) {
                minHeap.offer(new Node(neighbor, graph.get(currentPair.label).get(neighbor)));
            }
        }
        return visited;
    }

    /** https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/
     */
    public static void main(String[] args) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        graph.computeIfAbsent(0, e -> new HashMap<>()).put(1, 4);
        graph.computeIfAbsent(0, e -> new HashMap<>()).put(7, 8);
        graph.computeIfAbsent(1, e -> new HashMap<>()).put(0, 4);
        graph.computeIfAbsent(1, e -> new HashMap<>()).put(7, 11);
        graph.computeIfAbsent(1, e -> new HashMap<>()).put(2, 8);
        graph.computeIfAbsent(7, e -> new HashMap<>()).put(0, 8);
        graph.computeIfAbsent(7, e -> new HashMap<>()).put(1, 11);
        graph.computeIfAbsent(7, e -> new HashMap<>()).put(8, 7);
        graph.computeIfAbsent(7, e -> new HashMap<>()).put(6, 1);
        graph.computeIfAbsent(2, e -> new HashMap<>()).put(1, 8);
        graph.computeIfAbsent(2, e -> new HashMap<>()).put(8, 2);
        graph.computeIfAbsent(2, e -> new HashMap<>()).put(3, 7);
        graph.computeIfAbsent(2, e -> new HashMap<>()).put(5, 4);
        graph.computeIfAbsent(8, e -> new HashMap<>()).put(7, 7);
        graph.computeIfAbsent(8, e -> new HashMap<>()).put(2, 2);
        graph.computeIfAbsent(8, e -> new HashMap<>()).put(6, 6);
        graph.computeIfAbsent(6, e -> new HashMap<>()).put(8, 6);
        graph.computeIfAbsent(6, e -> new HashMap<>()).put(7, 1);
        graph.computeIfAbsent(6, e -> new HashMap<>()).put(5, 2);
        graph.computeIfAbsent(3, e -> new HashMap<>()).put(2, 7);
        graph.computeIfAbsent(3, e -> new HashMap<>()).put(5, 14);
        graph.computeIfAbsent(3, e -> new HashMap<>()).put(4, 9);
        graph.computeIfAbsent(5, e -> new HashMap<>()).put(6, 2);
        graph.computeIfAbsent(5, e -> new HashMap<>()).put(2, 4);
        graph.computeIfAbsent(5, e -> new HashMap<>()).put(3, 14);
        graph.computeIfAbsent(5, e -> new HashMap<>()).put(4, 10);
        graph.computeIfAbsent(4, e -> new HashMap<>()).put(3, 9);
        graph.computeIfAbsent(4, e -> new HashMap<>()).put(5, 10);
        System.out.println(mst(graph, 0));
    }
}

class Node {
    int label;
    int dist;
    public Node(int k, int i) {
        this.label = k;
        this.dist = i;
    }
}
