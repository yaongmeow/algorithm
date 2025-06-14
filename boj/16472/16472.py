import sys

n = int(sys.stdin.readline().rstrip())
s = sys.stdin.readline().rstrip()

st = 0
en = 0
cnt = 0
answer = 0

d = dict()
idx = 0

while idx < len(s):
    if s[idx] not in d or d[s[idx]] == 0:
        d[s[idx]] = 1
        cnt += 1
    else:
        d[s[idx]] += 1
    en = idx

    while cnt > n:
        d[s[st]] -= 1
        if d[s[st]] == 0:
            cnt -= 1
        st += 1
    if en - st + 1 > answer: answer = en - st + 1
    idx += 1

print(answer)