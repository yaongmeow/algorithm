import re

s = input()
res = s.count("=")
res += s.count("-")
res += s.count("lj")
res += s.count("nj")
s = re.sub(r"c=|c-|dz=|d-|lj|nj|s=|z=", "", s)
print(res + len(s))