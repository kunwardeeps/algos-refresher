def topologicalSort(inDegree, graph):
    res = []
    while inDegree:
        noLoop = False
        for key in inDegree.keys():
            if inDegree[key] == 0:
                res.append(key)
                children = graph[key]
                for child in children:
                    inDegree[child] -= 1
                del inDegree[key]
                noLoop = True
                break
        if not noLoop:
            return []
    return res

#  1 -> 2 -> 4
#  1 -> 3 -> 5

graph = {
    1: [2, 3],
    2: [4],
    3: [5],
    4: [],
    5: []
}

inDegree = {
    1: 0,
    2: 1,
    3: 1,
    4: 1,
    5: 1
}

print(topologicalSort(inDegree, graph))