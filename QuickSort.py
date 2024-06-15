def quicksort(a):
    sort(a, 0, len(a) - 1)

def sort(a, l, r):
    if l < r:
        pvtIdx = partition(a, l, r)
        sort(a, l, pvtIdx - 1)
        sort(a, pvtIdx + 1, r)

def partition(a, l, r):
    pivot = a[r]
    i = l - 1
    for j in range(l, r):
        if a[j] < pivot:
            i += 1
            swap(a, i, j)
    swap(a, i + 1, r)
    return i + 1

def swap(a, i, j):
    a[i], a[j] = a[j], a[i]

a = [2, 7, 1, 6]
quicksort(a)
print("Test case 1: {2,7,1,6}", a == [1, 2, 6, 7])

a = [4, 3, 2, 1]
quicksort(a)
print("Test case 2: {4,3,2,1}", a == [1, 2, 3, 4])

a = [1, 2, 3, 4]
quicksort(a)
print("Test case 3: {1,2,3,4}", a == [1, 2, 3, 4])