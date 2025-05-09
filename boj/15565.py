import sys

data = sys.stdin.read().split()

n = int(data[0])
k = int(data[1])

arr = [int(data[i]) for i in range(2, n+2)]

s = 0
e = 0

doll = arr[0]
min_size = n + 1

while s < n:
    size = e - s + 1
    lion = size * 2 - doll
    if lion >= k:
        if size < min_size:
            min_size = size
        doll -= arr[s]
        s+=1
    else:
        if e == n - 1:
            break
        e += 1
        doll += arr[e]

print(min_size if min_size != n+1 else -1)
