def binary_search(arr, x):
    l = 0
    r = len(arr) - 1
    while l <= r:
        m = l + (r - l) // 2
        if arr[m] == x:
            return m
        if arr[m] < x:
            l = m + 1
        else:
            r = m - 1
    return -1

def binary_search_ceil(arr, x):
    l = 0
    r = len(arr) - 1
    while l <= r:
        m = l + (r - l) // 2
        if arr[m] == x:
            return m
        if arr[m] < x:
            l = m + 1
        else:
            r = m - 1
    return l if l <= len(arr) - 1 else -1

def binary_search_floor(arr, x):
    l = 0
    r = len(arr) - 1
    while l <= r:
        m = l + (r - l) // 2
        if arr[m] == x:
            return m
        if arr[m] < x:
            l = m + 1
        else:
            r = m - 1
    return r if r >= 0 else -1

arr = [1, 3, 5, 7]
print("floor 6:", binary_search_floor(arr, 6) == 2)
print("floor 0:", binary_search_floor(arr, 0) == -1)
print("floor 4:", binary_search_floor(arr, 4) == 1)
print("floor 2:", binary_search_floor(arr, 2) == 0)

print("ceil 0:", binary_search_ceil(arr, 0) == 0)
print("ceil 6:", binary_search_ceil(arr, 6) == 3)
print("ceil 2:", binary_search_ceil(arr, 2) == 1)
print("ceil 8:", binary_search_ceil(arr, 8) == -1)

print("Binary 1:", binary_search(arr, 1) == 0)
print("Binary 3:", binary_search(arr, 3) == 1)
print("Binary 5:", binary_search(arr, 5) == 2)
print("Binary 7:", binary_search(arr, 7) == 3)
print("Binary 2:", binary_search(arr, 2) == -1)