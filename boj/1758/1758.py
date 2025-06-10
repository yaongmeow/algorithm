import sys

n = int(sys.stdin.readline().strip())
tip = [0] * n

for i in range(n):
    tip[i] = int(sys.stdin.readline().strip())

tip.sort(reverse=True)
answer = 0

for i in range(n):
    if tip[i] - i >= 0:
        answer += tip[i] - i

print(answer)
