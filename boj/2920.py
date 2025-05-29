arr = list(map(int, input().split()))
asc = True
dsc = True
for i in range(1, 8):
    if arr[i-1] + 1 != arr[i]:
        asc = False
    if arr[i-1] - 1 != arr[i]:
        dsc = False
    if asc is False and dsc is False:
        break

if asc is True: print("ascending")
elif dsc is True: print("descending")
else: print("mixed")
