from typing import List
from bisect import bisect_left

def findRightInterval(intervals: List[List[int]]) -> List[int]:
    # Create a dictionary to store the start points of intervals and their indices
    start_points = {}
    for i, interval in enumerate(intervals):
        start_points[interval[0]] = i
    
    # Sort the intervals based on their start points
    sorted_intervals = sorted(intervals, key=lambda x: x[0])
    
    # Initialize the result list with -1 for all intervals
    result = [-1] * len(intervals)
    
    # Iterate over the sorted intervals
    for i, interval in enumerate(intervals):
        # Find the index of the right interval using binary search
        index = bisect_left(sorted_intervals, [interval[1], 0])
        # If a right interval is found, update the result list with its index
        if index != len(intervals):
            result[i] = start_points[sorted_intervals[index][0]]
    
    return result

print(findRightInterval([[1,2],[2,3],[3,4]]) == [1, 2, -1])
print(findRightInterval([[3,4],[2,3],[1,2]]) == [-1, 0, 1]) 
