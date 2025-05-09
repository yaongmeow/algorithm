from collections import deque

n = int(input())
q = deque(map(int, input().split()))
st = deque()

exp = 1
while len(q) > 0:
    if len(st) > 0 and st[-1] == exp:
        st.pop()
        exp += 1
        continue
    front = q.popleft()
    if front == exp:
        exp += 1
    else:
        st.append(front)

if exp == n+1:
    print("Nice")
else:
    nice = True
    while len(st) > 0:
        if st[-1] != exp:
            nice = False
            break
        else:
            st.pop()
            exp += 1
    print("Nice" if nice else "Sad")
