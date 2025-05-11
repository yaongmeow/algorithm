import sys

n = int(sys.stdin.readline())

arr = sorted([float(sys.stdin.readline()) for i in range(1, n+1)])

for i in range(7):
    print("{:.3f}".format(arr[i]))
