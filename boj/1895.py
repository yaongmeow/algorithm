import sys

r, c = map(int, sys.stdin.readline().split())
arr = [list(map(int, sys.stdin.readline().split())) for _ in range(r)]
t = int(sys.stdin.readline().strip())

answer = 0

for i in range(r-2):
    for j in range(c-2):
        tmp = list()
        tmp.extend(arr[i][j:j+3])
        tmp.extend(arr[i+1][j:j+3])
        tmp.extend(arr[i+2][j:j+3])
        tmp.sort()
        if tmp[4] >= t: answer+= 1
print(answer)