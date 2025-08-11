import sys

def is_good(arr, i):
    target = arr[i]
    st = 0
    en = i - 1

    while st < en:
        sum = arr[st] + arr[en]
        if sum == target: return True
        elif sum > target: en -= 1
        else: st += 1

    return False


def bin_search(arr, target):
    st = 0
    en = len(arr) - 1
    while st <= en:
        mid = (st + en)//2
        if arr[mid] == target:
            return mid
        elif arr[mid] < target:
            st = mid + 1
        else:
            en = mid - 1
    return -1


n = int(sys.stdin.readline().strip())
arr = list(map(int, sys.stdin.readline().split()))
arr.sort()

zero = 0
pos = list()
neg = list()
for i in range(n):
    if arr[i] < 0:
        neg.append(arr[i])
    elif arr[i] == 0:
        zero += 1
    else:
        pos.append(arr[i])


answer = 0

# 0 처리
if zero >= 3:
    answer += zero
else:
    for num in pos:
        if bin_search(neg, -num) != -1:
            answer += zero
            break

# 음수 처리
for i in range(len(neg)):
    target = neg[i]
    st = i + 1
    en = len(neg) - 1

    good = False
    while st < en:
        sum = arr[st] + arr[en]
        if sum == target:
            good = True
            break
        elif sum > target: en -= 1
        else: st += 1
    if good:
        answer += 1
        continue
    

print(answer)