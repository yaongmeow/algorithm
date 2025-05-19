import sys
import math

m, n = map(int, sys.stdin.read().split())

sum = 0
result = -1

for i in range(m, n+1):
    if math.sqrt(i) == int(math.sqrt(i)):
        if result == -1: result = i
        sum += i

if sum == 0:
    print(-1)
else:
    print(sum)
    print(result)