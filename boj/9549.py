import sys

def strsum(str):
    res = 0
    for c in str:
        res += ord(c)
    return res

data = sys.stdin.read().split()

t = int(data[0])

cypher = [data[2*i - 1] for i in range(1, t + 1)]
original = [data[2*i] for i in range(1, t + 1)]

for i in range(t):
    target_sum = strsum(original[i])
    size = len(original[i])
    s = 0
    e = size - 1
    tmp = strsum(cypher[i][:size])
    res = False
    while e < len(cypher[i]):
        if tmp == target_sum:
            if sorted(cypher[i][s:e+1]) == sorted(original[i]):
                res = True
                break
        tmp -= ord(cypher[i][s])
        s += 1
        if e == len(cypher[i]) - 1: break
        e += 1
        tmp += ord(cypher[i][e])
    print("YES" if res else "NO")