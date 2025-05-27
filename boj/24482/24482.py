from collections import deque
import sys

n, m, r = map(int, sys.stdin.readline().strip().split())
arr = [[] for _ in range(n + 1)]

for _ in range(m):
    a, b = map(int, sys.stdin.readline().strip().split())
    arr[a].append(b)
    arr[b].append(a)

vis = [False] * (n + 1)
cnt = [-1] * (n + 1)
depth = 0

st = deque()
st.append(r)
cnt[r] = 0

while len(st) > 0:
    pos = st.pop()
    if vis[pos]: continue
    vis[pos] = True
    arr[pos].sort()
    for i in arr[pos]:
        if vis[i] == False:
            st.append(i)
            cnt[i] = cnt[pos] + 1

for i in range(1, n+1):
    print(cnt[i])