import sys
from collections import deque

n = int(sys.stdin.readline())
arr = [int(input()) for _ in range(n)]

st = deque()
now = 1
answer = list()
for num in arr:
    if(len(st) > 0):
        top = st[-1]
        if top == num:
            st.pop()
            answer.append("-")
            continue
    while now != num and now <= n:
        st.append(now)
        now += 1
        answer.append("+")
    if now != num:
        print("NO")
        quit()
    answer.append("+")
    answer.append("-")
    now += 1
print("\n".join(answer))