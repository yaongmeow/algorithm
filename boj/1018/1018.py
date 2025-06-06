import sys

n, m = map(int, sys.stdin.readline().split())
arr = list()
for _ in range(n):
    line = sys.stdin.readline()
    tmp = list()
    for letter in line:
        tmp.append(letter)
    arr.append(tmp)

starts = list()

for i in range(n-7):
    for j in range(m-7):
        starts.append([i, j])

result = -1

for pos in starts:
    x = pos[0]
    y = pos[1]

    # B로 시작 카운트
    now = 'B'
    bcnt = 0
    while x <= pos[0] + 7:
        y = pos[1]
        while y <= pos[1] + 7:
            if arr[x][y] != now: bcnt += 1
            if now == 'B': now = 'W'
            else: now = 'B'
            y+= 1
        if now == 'B': now = 'W'
        else: now = 'B'
        x += 1

    x = pos[0]

    # W로 시작 카운트
    now = 'W'
    wcnt = 0
    while x <= pos[0] + 7:
        y = pos[1]
        while y <= pos[1] + 7:
            if arr[x][y] != now: wcnt += 1
            if now == 'B': now = 'W'
            else: now = 'B'
            y+= 1
        if now == 'B': now = 'W'
        else: now = 'B'
        x += 1
    mincnt = min(bcnt, wcnt)
    if result == -1 or result > mincnt:
        result = mincnt

print(result)