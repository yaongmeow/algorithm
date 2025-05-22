import sys

data = sys.stdin.read().split()

n = int(data[0])
m = int(data[1])

arr = sorted([int(data[i]) for i in range(2, n+2)])

s = 0
e = n-1
cnt = 0

while s < e:
    if arr[s] + arr[e] > m:
        e -= 1
    elif arr[s] + arr[e] == m:
        cnt += 1
        e -= 1
        s+= 1
    else:
        s+= 1

print(cnt)