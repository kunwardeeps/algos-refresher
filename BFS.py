from collections import deque

def bfs(graph, startNode):
    visited = set()
    queue = deque()
    visited.add(startNode)
    queue.append(startNode)

    while queue:
        node = queue.popleft()
        print(node, end=", ")

        neighbors = graph.get(node)
        if not neighbors:
            continue

        for n in neighbors:
            if n not in visited:
                visited.add(n)
                queue.append(n)

             
#      2 - 4
#     /
# 6 - 1
#     \
#      3 - 5
     
graph = {
    1: [2, 3, 6],
    6: None,
    2: [1, 4],
    3: [1, 5],
    4: None,
    5: None
}

bfs(graph, 1)
