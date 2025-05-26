a, b = map(int, input().split())
min_val = min(a, b)
cgy = 1
for i in range(1, min_val + 1):
    if a % i == 0 and b % i == 0: cgy = i
cgb = cgy * (a / cgy) * (b / cgy)
print(cgy, int(cgb))