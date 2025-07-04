import sys
from itertools import permutations

n = int(sys.stdin.readline())
k = int(sys.stdin.readline())
arr = [sys.stdin.readline().strip() for _ in range(n)]
result = set(int("".join(list(p))) for p in permutations(arr, k))
print(len(result))
