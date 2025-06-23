import sys

n, k = map(int, sys.stdin.readline().split())
arr = list(map(int, sys.stdin.readline().split()))

st = 0
en = 0

cnt = 1 if arr[st] % 2 == 1 else 0
answer = 0 if arr[st] % 2 == 1 else 1
length = 0 if arr[st] % 2 == 1 else 1

while en < n:
    while cnt > k:
        if arr[st] % 2 == 1:
            cnt -= 1
            st += 1
            continue
        length -= 1
        st += 1

    en += 1
    if en >= n:
        break

    nxt = arr[en]

    if nxt % 2 == 0:
        length += 1
        if answer < length:
            answer = length
        continue
    
    cnt += 1

print(answer)
