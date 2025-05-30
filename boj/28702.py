arr = [input() for _ in range(3)]
idx = -1
narr = [0] * 3
for i in range(3):
    if arr[i].isdigit():
        idx = i
        break

for i in range(3):
    if i == idx:
        narr[i] = int(arr[idx])
    else:
        narr[i] = int(arr[idx]) + (i - idx)
target = narr[2] + 1
if target % 3 == 0 and target % 5 == 0:
    print("FizzBuzz")
elif target % 3 == 0:
    print("Fizz")
elif target % 5 == 0:
    print("Buzz")
else:
    print(target)