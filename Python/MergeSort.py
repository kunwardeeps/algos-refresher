def merge_sort(a, l, r):
    if l < r:
        pvtIdx = (l + r) // 2
        merge_sort(a, l, pvtIdx)
        merge_sort(a, pvtIdx + 1, r)
        merge(a, l, pvtIdx, r)

def merge(a, l, m, r):
    a1 = a[l:m+1]
    a2 = a[m+1:r+1]
    
    i = j = 0
    k = l
    while i < len(a1) and j < len(a2):
        if a1[i] <= a2[j]:
            a[k] = a1[i]
            i += 1
        else:
            a[k] = a2[j]
            j += 1
        k += 1
    
    while i < len(a1):
        a[k] = a1[i]
        i += 1
        k += 1
    
    while j < len(a2):
        a[k] = a2[j]
        j += 1
        k += 1

a = [2, 7, 1, 6]
merge_sort(a, 0, len(a) - 1)
print(f"Test case 1: {a} {a == [1, 2, 6, 7]}")

a = [4, 3, 2, 1]
merge_sort(a, 0, len(a) - 1)
print(f"Test case 2: {a} {a == [1, 2, 3, 4]}")

a = [1, 2, 3, 4]
merge_sort(a, 0, len(a) - 1)
print(f"Test case 3: {a} {a == [1, 2, 3, 4]}")