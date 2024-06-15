def dfs(graph, root, visited):
    neighbors = graph.get(root)
    if root in visited or neighbors is None:
        return
    print(root, end=", ")
    visited.add(root)

    for neighbor in neighbors:
        dfs(graph, neighbor, visited)

#   2 - 4
#  /
# 1 - 6
#  \
#   3 - 5
graph = {
    1: [2, 3, 6],
    6: [1],
    2: [1, 4],
    3: [1, 5],
    4: [2],
    5: [3]
}

visited = set()
dfs(graph, 1, visited)