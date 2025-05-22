from collections import deque
import sys

n, m, r = map(int, sys.stdin.readline().strip().split())
arr = [[] for _ in range(n)]

for _ in range(m):
    a, b = map(int, sys.stdin.readline().strip().split())
    arr[a-1].append(b-1)
    arr[b-1].append(a-1)

for l in range(n):
    arr[l].sort()

vis = [False] * n
d = dict()
cnt = 1

q = deque()
q.append(r-1)
vis[r-1] = True

while len(q) > 0:
    pos = q.popleft()
    d[pos] = cnt
    cnt += 1
    for i in arr[pos]:
        if vis[i] == False:
            q.append(i)
            vis[i] = True

for i in range(n):
    if i in d:
        print(d[i])
    else:
        print(0)
