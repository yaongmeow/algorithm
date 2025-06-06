import sys

n, m = map(int, sys.stdin.readline().split())
pnum = dict()
pname = dict()

for i in range(1, n + 1):
    s = sys.stdin.readline().strip()
    pnum[i] = s
    pname[s] = i

for _ in range(m):
    s = sys.stdin.readline().strip()
    if s.isdigit():
        print(pnum[int(s)])
    else:
        print(pname[s])
