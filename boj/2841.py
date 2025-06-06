import sys
from collections import deque
n, p = map(int, sys.stdin.readline().split())

strings = [deque() for _ in range(6)]
cnt = 0

for _ in range(n):
    i, prat = map(int, sys.stdin.readline().split())
    i -= 1

    if len(strings[i]) == 0 or strings[i][-1] < prat:
        strings[i].append(prat)
        cnt += 1
        continue

    if strings[i][-1] == prat:
        continue
    
    while len(strings[i]) > 0 and strings[i][-1] > prat:
        strings[i].pop()
        cnt += 1

    if len(strings[i]) > 0 and strings[i][-1] == prat:
        continue

    strings[i].append(prat)
    cnt += 1
    
print(cnt)