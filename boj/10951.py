import sys

data = sys.stdin.read.split()

idx = 0
while idx != len(data):
    a = int(data[idx])
    b = int(data[idx + 1])
    idx += 2
    print(a + b)