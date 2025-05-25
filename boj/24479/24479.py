from collections import deque
import sys

n, m, r = map(int, sys.stdin.readline().strip().split())
arr = [[] for _ in range(n + 1)]

for _ in range(m):
    a, b = map(int, sys.stdin.readline().strip().split())
    arr[a].append(b)
    arr[b].append(a)

vis = [False] * (n + 1)
cnt = [0] * (n + 1)
turn = 1

st = deque()
st.append(r)

while len(st) > 0:
    pos = st.pop()
    if vis[pos]: continue
    vis[pos] = True
    cnt[pos] = turn
    turn+=1
    arr[pos].sort(reverse=True)
    for i in arr[pos]:
        if vis[i] == False:
            st.append(i)

for i in range(1, n+1):
    print(cnt[i])