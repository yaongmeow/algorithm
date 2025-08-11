import sys
n = int(sys.stdin.readline())
arr = [tuple(sys.stdin.readline().split()) for _ in range(n)]
new_arr = list()
for t in arr:
    new_arr.append((int(t[1]), int(t[2]), int(t[3]), t[0]))

new_arr.sort(key=lambda x: (-x[0], x[1], -x[2], x[3]))

for t in new_arr:
    print(t[3])