def check(arr, p, m):
    now = p
    cnt = 1
    for n in arr:
        if n > now:
            now = p - n
            cnt += 1
        else:
            now -= n
    if cnt <= m: return True
    else: return False


n, m = map(int, input().split())
arr = [int(input()) for _ in range(n)]

st = max(arr) - 1
en = 100000 * 10000 + 1
answer = en
while st < en - 1:
    mid = int((st + en)/2)
    if check(arr, mid, m):
        en = mid
        answer = mid
    else:
        st = mid
print(answer)

