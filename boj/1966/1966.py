from collections import deque

def find_max(pcnt):
    idx = 9
    while idx >= 1:
        if pcnt[idx] != 0:
            return idx
        idx -= 1
    return idx

tc = int(input())

for _ in range(tc):
    n, pos = map(int, input().split())

    pcnt = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
    q = deque()

    arr = list(map(int, input().split()))
    for i in range(n):
        pcnt[arr[i]] += 1
        q.append(arr[i])

    maxv = find_max(pcnt)
    cnt = 0
    while len(q) >= 1:
        front = q.popleft()
        if front == maxv:
            pcnt[front] -= 1
            cnt += 1
            maxv = find_max(pcnt)
            if pos == 0:
                print(cnt)
                break
        else:
            q.append(front)

        if pos != 0:
            pos -= 1
        else:
            pos = len(q) - 1
