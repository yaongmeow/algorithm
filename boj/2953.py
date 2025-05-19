winner = 0
score = 0

for i in range(1, 6):
    tmp = sum(list(map(int, input().split())))
    if score < tmp:
        score = tmp
        winner = i

print(winner, score)