x, y = map(int, input().split())
z = int(y * 100 / x)

if z >= 99:
    print("-1")
    quit()
    
st = 0
en = 10**9+1
answer = -1
while st < en - 1:
    mid = int((st + en) / 2)
    new_z = int(((y + mid)*100) / (x + mid))
    if new_z > z:
        answer = mid
        en = mid
    else:
        st = mid
print(answer)