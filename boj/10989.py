import sys

n = int(sys.stdin.readline().strip())
cnt = [0] * 10001
for _ in range(n):
    cnt[int(sys.stdin.readline().strip())] += 1

for i in range(1, 10001):
    for _ in range(cnt[i]):
        print(i)

# sys.stdin.read().split() 해서 배열에 저장하면 메모리 잡아먹음