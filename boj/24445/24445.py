from collections import deque
import sys

n, m, r = map(int, sys.stdin.readline().strip().split())
arr = [[] for _ in range(n + 1)]

for _ in range(m):
    a, b = map(int, sys.stdin.readline().strip().split())
    arr[a].append(b)
    arr[b].append(a)

vis = [0] * (n + 1)
cnt = 1

q = deque()
q.append(r)
vis[r] = cnt
cnt += 1

while len(q) > 0:
    pos = q.popleft()
    arr[pos].sort(reverse=True)
    for i in arr[pos]:
        if vis[i] == False:
            q.append(i)
            vis[i] = cnt
            cnt += 1

for i in range(1, n+1):
    print(vis[i])