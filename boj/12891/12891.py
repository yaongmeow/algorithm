def cmp(target, tmp):
    for k, v in target.items():
        if tmp[k] < v:
            return False
    return True

s, p = map(int, input().split())
input_str = input()
arr = list(map(int, input().split()))

target = {'A':arr[0], 'C':arr[1], 'G':arr[2], 'T':arr[3]}
tmp = {'A':0, 'C':0, 'G':0, 'T':0}

for i in range(0, p):
    tmp[input_str[i]]+=1

start = 0
end = p - 1
cnt = 0

while end < s:
    if cmp(target, tmp): cnt+=1
    tmp[input_str[start]]-=1
    start += 1
    end += 1
    if end == s: break
    tmp[input_str[end]]+=1

print(cnt)
