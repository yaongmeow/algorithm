import sys
from collections import deque

n = int(sys.stdin.readline().strip())

st = deque([(i, int(sys.stdin.readline())) for i in range(n)])
out = deque()

answer = [0] * n
idx = n - 1

while len(st) != 0:
    num, top = st.pop()
    while len(out) != 0:
        out_num, out_top = out[-1]
        if out_top >= top:
            out.append((num, top))
            answer[idx] = out_num - num - 1
            break
        else:
            out.pop()
    if len(out) == 0:
        out.append((num, top))
        answer[idx] = n - num - 1
    idx -= 1

print(sum(answer))
