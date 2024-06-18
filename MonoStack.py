from collections import deque
def nle(A):
    stack = deque()
    nle = [-1] * len(A)

    for i in range(len(A)):
        while stack and A[stack[-1]] > A[i]:
            x = stack.pop()
            nle[x] = i
        stack.append(i)

    return nle


def ple(A):
    stack = deque()
    ple = [-1] * len(A)

    for i in range(len(A)):
        while stack and A[stack[-1]] > A[i]:
            stack.pop()
        ple[i] = stack[-1] if stack else -1
        stack.append(i)

    return ple


print(nle([1, 5, 6, 4, 0]) == [4, 3, 3, 4, -1])
print(ple([1, 5, 6, 4, 0]) == [-1, 0, 1, 0, -1])
