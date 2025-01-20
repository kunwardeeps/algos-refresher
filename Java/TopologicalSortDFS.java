import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopologicalSortDFS {
    
    // Helper DFS function to perform topological sort
    private static boolean dfs(Map<Integer, List<Integer>> graph, int[] visited, List<Integer> result, int course) {
        // If the course is being visited (in recursion stack), a cycle is detected
        if (visited[course] == 1) {
            return false;
        }
        
        // If the course has already been fully processed, no need to do it again
        if (visited[course] == 2) {
            return true;
        }
        
        // Mark the course as currently being visited
        visited[course] = 1;
        
        // Visit all the prerequisites (neighbors)
        for (int prereq : graph.get(course)) {
            if (!dfs(graph, visited, result, prereq)) {
                return false;
            }
        }
        
        // Mark the course as fully processed and add to the result list
        visited[course] = 2;
        result.add(course);
        
        return true;
    }

    public static List<Integer> topologicalSort(int numCourses, Map<Integer, List<Integer>> graph) {
        // Result list to store the topological sort order
        List<Integer> result = new ArrayList<>();
        
        // visited array: 0 = not visited, 1 = visiting (in recursion stack), 2 = fully processed
        int[] visited = new int[numCourses];
        
        // Perform DFS for each course to ensure all courses are covered
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {  // If not yet visited
                if (!dfs(graph, visited, result, i)) {
                    return new ArrayList<>(); // If cycle is detected, return empty list
                }
            }
        }
        
        // The result list contains the courses in reverse topological order
        Collections.reverse(result);
        return result;
    }

    /**
     * 0 -> 1 -> 3
     * 0 -> 2 -> 4
     */
    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1, 2));
        graph.put(1, Arrays.asList(3));
        graph.put(2, Arrays.asList(4));
        graph.put(3, new ArrayList<>());
        graph.put(4, new ArrayList<>());

        System.out.println(topologicalSort(5, graph));
    }

}
