import sys

n = int(sys.stdin.readline().rstrip())
arr = list(map(int, sys.stdin.readline().split()))
arr.sort()
prev = 1001
answer = list()
for num in arr:
    if num != prev:
        answer.append(str(num))
        prev = num

print(" ".join(answer))
