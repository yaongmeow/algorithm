import sys
import bisect

t = int(sys.stdin.readline())
for _ in range(t):
    n, m = map(int, sys.stdin.readline().split())
    a = sorted(list(map(int, sys.stdin.readline().split())))
    b = sorted(list(map(int, sys.stdin.readline().split())))
    res = 0
    for num in a:
        res += bisect.bisect_left(b, num)
    print(res)
        