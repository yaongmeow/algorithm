arr = input().split("+")

if len(arr) != 2:
    print("No Money")
else:
    money = True
    for s in arr:
        if s.startswith('0') or s.isdigit() is False:
            money = False
            break
    if arr[0] != arr[1]:
        money = False
    print("CUTE" if money else "No Money")
