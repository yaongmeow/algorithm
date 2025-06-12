import sys

n = int(sys.stdin.readline().strip())
arr = list(map(int, sys.stdin.readline().split()))

max = 0
for num in arr:
    if num > max:
        max = num

m = int(sys.stdin.readline().strip())
min = 0
max += 1
res = 0
answer = 0

while min - 1 < max:
    sum = 0
    mid = int((min + max)/2)
    for i in range(n):
        if arr[i] >= mid: sum += mid
        else: sum += arr[i]

    if sum > m:
        max = mid - 1
        continue

    if sum > answer:
        answer = sum
        res = mid

    min = mid + 1
print(res)