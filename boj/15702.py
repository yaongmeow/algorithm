import sys

n, m = map(int, sys.stdin.readline().split())
score_map = dict()

idx = 1
for s in list(map(int, sys.stdin.readline().split())):
    score_map[idx] = s
    idx += 1

score = list()

for i in range(m):
    arr = sys.stdin.readline().split()
    total_score = 0
    for i in range(1, n+1):
        if arr[i] == 'O':
            total_score += score_map[i]
    score.append((int(arr[0]), total_score))

sorted_score = sorted(score, key=lambda x: (-x[1], x[0]))
print(sorted_score[0][0], sorted_score[0][1])
