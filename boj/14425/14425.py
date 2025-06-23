import sys
from itertools import combinations

n = int(sys.stdin.readline().strip())
arr = list(map(int, sys.stdin.readline().split()))

combi = set(arr)
for i in range(2, n+1):
    combi.update([sum(c) for c in combinations(arr, i)])

max_val = max(combi)

for i in range(1, max_val):
    if i not in combi:
        print(i)
        quit()
print(max_val + 1)