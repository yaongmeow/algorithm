def cnt(arr, length):
    res = 0
    for l in arr:
        res += int(l/length)
    return res

import sys

sys.stdin = open("input.txt")

data = sys.stdin.read().split()

k = int(data[0])
n = int(data[1])
arr = [int(data[i]) for i in range(2, k+2)]

s = 0
e = 2**31 + 1

result = 0
while s < e-1:
    mid = int((s + e)/2)
    if cnt(arr, mid) >= n:
        result = mid
        s = mid
    else:
        e = mid

print(result)