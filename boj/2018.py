n = int(input())

s = 1
e = 1
tmp_sum = 1
cnt = 0

while s <= n:
    if tmp_sum < n:
        e += 1
        tmp_sum += e
    elif tmp_sum == n:
        cnt += 1
        tmp_sum -= s
        s += 1
    else:
        tmp_sum -= s
        s += 1
        
print(cnt)