import sys
n = int(sys.stdin.readline().strip())
arr = [int(sys.stdin.readline().strip()) for _ in range(n)]
print("\n".join([str(num) for num in sorted(arr)[::-1]]))