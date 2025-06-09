import sys
from collections import deque

n = int(sys.stdin.readline().strip())

st = deque(list(map(int, sys.stdin.readline().split())))
out = deque()

answer = [0] * n
idx = n - 1

while len(st) != 0:
    top = st.pop()
    while len(out) != 0:
        outTop = out[-1]
        if outTop > top:
            out.append(top)
            answer[idx] = str(outTop)
            break
        else:
            out.pop()
    if len(out) == 0:
        out.append(top)
        answer[idx] = "-1"
    idx -= 1

print(" ".join(answer))
