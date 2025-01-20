import heapq

def kClosest(points, K):
    max_heap = []
    for p in points:
        dist = p[0] * p[0] + p[1] * p[1]
        heapq.heappush(max_heap, (-dist, p))
        if len(max_heap) > K:
            heapq.heappop(max_heap)
    res = []
    while K > 0:
        res.append(heapq.heappop(max_heap)[1])
        K -= 1
    return res

print(kClosest([[1, 3], [-2, 2]], 1) == [[-2, 2]])
print(kClosest([[3, 3], [5, -5], [-2, 4]], 2) ==  [[-2, 4], [3, 3]])