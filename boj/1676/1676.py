def count(n):
    ten = 0
    while n % 10 == 0:
        n /= 10
        ten += 1
    two = ten
    five = ten
    while n % 2 == 0:
        n /= 2
        two += 1

    while n % 5 == 0:
        n /= 5
        five += 1
    
    return [two, five]


n = int(input())

if n < 5:
    print(0)
    quit()

cnt = [0, 0]

for i in range(1, n+1):
    two, five = count(i)
    cnt[0] += two
    cnt[1] += five

print(min(cnt))