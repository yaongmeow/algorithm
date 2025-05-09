from collections import deque

n = int(input())
arr = [input() for _ in range(n)]

for s in arr:
    st = deque()
    tmp = deque()
    for c in s:
        if c == '<':
            if len(st) != 0:
                tmp.append(st.pop())
        elif c == '>':
            if len(tmp) != 0:
                st.append(tmp.pop())
        elif c == '-':
            if len(st) != 0:
                st.pop()
        else:
            st.append(c)

    while len(tmp) != 0:
        st.append(tmp.pop())
    
    print("".join(st))
