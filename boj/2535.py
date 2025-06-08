import sys

n = int(sys.stdin.readline().strip())

arr = list()
d = dict()
for _ in range(n):
    country, student, score = map(int, sys.stdin.readline().split())
    arr.append(score)
    d[score] = (country, student)

arr.sort(reverse=True)
cnt = 0
cnt_dict = dict()
idx = 0
while  cnt < 3:
    country, student = d[arr[idx]]
    if country in cnt_dict:
        if cnt_dict[country] == 2:
            idx += 1
            continue
        cnt_dict[country] += 1
    else:
        cnt_dict[country] = 1
    cnt += 1
    print(country, student)
    idx += 1
