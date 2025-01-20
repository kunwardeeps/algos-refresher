import heapq
def dijkstra(graph, source):
    min_heap = []
    heapq.heappush(min_heap, (0, source))
    visited = {}  # track visited as well as final min dist
    
    while min_heap:
        dist, label = heapq.heappop(min_heap)  # get the unvisited node with min distance
        
        if label in visited:
            continue
        visited[label] = dist
        
        for neighbor, weight in graph[label].items():
            heapq.heappush(min_heap, (dist + weight, neighbor))
    
    return visited

# Test the algorithm https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/
graph = {
    0: {1: 4, 7: 8},
    1: {0: 4, 7: 11, 2: 8},
    7: {0: 8, 1: 11, 8: 7, 6: 1},
    2: {1: 8, 8: 2, 3: 7, 5: 4},
    8: {7: 7, 2: 2, 6: 6},
    6: {8: 6, 7: 1, 5: 2},
    3: {2: 7, 5: 14, 4: 9},
    5: {6: 2, 2: 4, 3: 14, 4: 10},
    4: {3: 9, 5: 10}
}

print(dijkstra(graph, 0))