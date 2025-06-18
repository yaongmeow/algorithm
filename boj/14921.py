import sys

n = int(sys.stdin.readline().rstrip())
plus = list()
minus = list()
for num in list(map(int, sys.stdin.readline().split())):
    if num > 0: plus.append(num)
    else: minus.append(num)

plus.sort()
minus.sort()

if len(plus) == 0:
    print(minus[-2] + minus[-1])
elif len(minus) == 0:
    print(plus[0] + plus[1])
else:
    find = False
    a = -1
    b = -1
    bt = 100000000
    for p in plus:
        t = -p
        st = 0
        en = len(minus) - 1
        while en - st > 1:
            mid = (st + en) // 2
            if minus[mid] == t:
                a = minus[mid]
                b = p
                find = True
                break
            if minus[mid] < t:
                st = mid
            else:
                en = mid

        if find: break
        if abs(p + minus[st]) > abs(p + minus[en]):
            tp = minus[en]
        else:
            tp = minus[st]

        if abs(p + tp) < bt:
            a = tp
            b = p
            bt = abs(p + tp)
        if bt == 0:
            break

    if bt != 0:
        if len(minus) >= 2 and abs(minus[-2] + minus[-1]) < bt:
            print(minus[-2] + minus[-1])
        elif len(plus) >= 2 and abs(plus[0]+plus[1]) < bt:
            print(plus[0] + plus[1])
        else: print(a + b)
    else: print(a + b)
