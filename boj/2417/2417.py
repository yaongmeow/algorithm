n = int(input())

st = -1
en = 2**63 

result = 0
while st < en - 1:
    mid = int((st + en) / 2)
    if mid**2 > n:
        result = mid
        en = mid
    elif mid**2 == n:
        result = mid
        break
    else:
        st = mid

print(result)
