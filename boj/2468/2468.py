from collections import deque

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

def bfs(n, water, arr, vis, pos):
    q = deque([pos])
    while len(q) != 0:
        now = q.popleft()
        for i in range(4):
            x, y = now[0] + dx[i], now[1] + dy[i]
            if x < 0 or x >= n or y < 0 or y >= n:
                continue
            if vis[x][y] == True or arr[x][y] <= water:
                continue
            vis[x][y] = True
            q.append((x, y))

import sys

n = int(sys.stdin.readline())
arr = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

min = arr[0][0]
max = arr[0][0]
for row in arr:
    for area in row:
        if area > max:
            max = area
        if area < min:
            min = area

answer = 1
for water in range(min, max + 1):
    cnt = 0
    vis = [[False] * n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            if arr[i][j] > water and vis[i][j] == False:
                bfs(n, water, arr, vis, (i, j))
                cnt += 1
    if answer < cnt:
        answer = cnt

print(answer)
