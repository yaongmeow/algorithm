import sys

data = sys.stdin.read().split()

n = int(data[0])
m = int(data[1])
arr = [int(data[i]) for i in range(2, n+2)]

max_pay = 0
pay = 0


s = 0
e = m-1

for i in range(m):
    pay += arr[i]

while e < n:
    if pay > max_pay:
        max_pay = pay
    pay -= arr[s]
    s+=1
    e+=1
    if e == n:
        break
    pay += arr[e]


print(max_pay)