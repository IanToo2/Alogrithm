import sys

n = int(sys.stdin.readline())

data = {}

for i in range(n):
    x, y = map(int, sys.stdin.readline().split())
    data[i] = [x, y]

data = dict(sorted(data.items(), key = lambda x : (x[1],x[0]) ))

for key, value in data.items():
    print(*value)