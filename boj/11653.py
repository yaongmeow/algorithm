import math

n = int(input())

prime = [1] * (int(math.sqrt(n)) + 1)
prime[0] = 0
prime[1] = 0
for i in range(2, int(math.sqrt(n)) + 1):
    if prime[i] == 1:
        idx = i * 2
        while idx < len(prime):
            prime[idx] = 0
            idx += i

num = 2
result = list()
while n != 1 and num < len(prime):
    if prime[num] == 1:
        while n % num == 0:
            n /= num
            result.append(num)
    num += 1
n = int(n)
if n != 1:
    result.append(n)
for r in result:
    print(r)
