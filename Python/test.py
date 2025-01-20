import heapq

def solve(a):
    n = len(a)
    heap = []
    
    pref = 0
    ans = 0

    for i in range(n):
        if pref - a[i] > 0:
            # When subtracting the current value from 'pref' results in a positive value
            heapq.heappush(heap, -a[i])  # Push the negative value to simulate a max-heap
            pref -= a[i]
            ans += 1  # Increment counter for selected elements
        else:
            # Try swapping the current element with the largest in the heap (if it's larger)
            if heap and -heap[0] > a[i]:  # Check if the max element in the heap is larger
                largest = -heapq.heappop(heap)
                pref += 2 * largest  # To account for removing the largest and adding a new element
                pref -= a[i]
                heapq.heappush(heap, -a[i])  # Insert the smaller current element
            else:
                pref += a[i]  # Otherwise, just add the current value to pref

    return ans

# Example usage:
a = [5, 2, 4, 6, 1]
print(solve(a))  # This will depe