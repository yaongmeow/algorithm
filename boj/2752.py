arr = list(map(int, input().split()))
arr.sort()
result = [str(n) for n in arr]    
print(" ".join(result))