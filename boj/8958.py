import sys

n = int(sys.stdin.readline())

for _ in range(n):
    s = sys.stdin.readline()
    sum = 0
    prev = 0
    for letter in s:
        if letter == 'O':
            prev += 1
            sum += prev
        else:
            prev = 0
    print(sum)