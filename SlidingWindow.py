def minWindow(s: str, t: str) -> str:
    if len(t) > len(s):
        return ""
    map = [0] * 128
    for c in t:
        map[ord(c)] += 1
    start = 0
    end = 0
    minStart = 0
    minLen = float('inf')
    counter = len(t)
    while end < len(s):
        c1 = s[end]
        if map[ord(c1)] > 0:
            counter -= 1
        map[ord(c1)] -= 1
        end += 1
        while counter == 0:
            if minLen > end - start:
                minLen = end - start
                minStart = start
            c2 = s[start]
            map[ord(c2)] += 1
            if map[ord(c2)] > 0:
                counter += 1
            start += 1
    return s[minStart:minStart + minLen]

print(minWindow("ADOBECODEBANC", "ABC") == "BANC")
print(minWindow("a", "a") == "a")
print(minWindow("a", "aa") == "")