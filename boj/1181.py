import sys
from functools import cmp_to_key

def cmp(a, b):
    if len(a) > len(b):
        return 1
    elif len(a) == len(b):
        if a > b: return 1
        elif a < b: return -1
        return 0
    else:
        return -1

data = sys.stdin.read().split()

n = int(data[0])
arr = [data[i] for i in range(1, n+1)]
arr.sort(key = cmp_to_key(cmp))
for i in range(n):
    if i > 0:
        if arr[i-1] != arr[i]:
            print(arr[i])
    else:
        print(arr[i])
