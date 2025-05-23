from collections import deque
import sys

n, m, r = map(int, sys.stdin.readline().strip().split())
arr = [[] for _ in range(n + 1)]

for _ in range(m):
    a, b = map(int, sys.stdin.readline().strip().split())
    arr[a].append(b)
    arr[b].append(a)

vis = [-1] * (n + 1)

q = deque()
q.append(r)
vis[r] = 0

while len(q) > 0:
    pos = q.popleft()
    for i in arr[pos]:
        if vis[i] == -1:
            q.append(i)
            vis[i] = vis[pos] + 1

for i in range(1, n+1):
    print(vis[i])