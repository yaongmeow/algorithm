import sys
from functools import cmp_to_key


def cmp(a, b):
    if len(a) > len(b):
        return 1
    elif len(a) == len(b):
        asum = 0
        bsum = 0
        for i in range(len(a)):
            if a[i].isdigit():
                asum += int(a[i])
            if b[i].isdigit():
                bsum += int(b[i])
        if asum == bsum:
            if a > b: return 1
            elif a < b: return -1
            return 0
        elif asum > bsum: return 1
        else: return -1
    else:
        return -1

data = sys.stdin.read().split()

n = int(data[0])
arr = [data[i] for i in range(1, n+1)]
arr.sort(key = cmp_to_key(cmp))
print("\n".join(arr))