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
        out_top = out[-1]
        if out_top > top:
            out.append(top)
            answer[idx] = str(out_top)
            break
        else:
            out.pop()
    if len(out) == 0:
        out.append(top)
        answer[idx] = "-1"
    idx -= 1

print(" ".join(answer))
