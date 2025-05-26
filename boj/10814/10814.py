import sys

n = int(sys.stdin.readline())
d = dict()
s = set()
for _ in range(n):
    age, name = sys.stdin.readline().split()
    s.add(int(age))
    if int(age) in d:
        d[int(age)].append(name)
    else:
        d[int(age)] = [name]

l = sorted(list(s))

for i in l:
    people = d[i]
    for p in people:
        print(i, p)
