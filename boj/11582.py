import sys

n = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().split()))
k = int(sys.stdin.readline())

people = n/2
size = 2

while people >= k:
    result = list()
    idx = 0
    while idx + size - 1 < n:
        tmp = sorted(arr[idx:idx+size])
        result += tmp
        idx += size
    arr = result
    people /= 2
    size *= 2

print(" ".join([str(num) for num in arr]))
