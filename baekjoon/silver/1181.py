import sys

N = int(sys.stdin.readline())

data = []

for i in range(N):
    data.append(sys.stdin.readline().strip())

data = list(set(data))
data.sort(key=lambda x: (len(x), x))

print(*data, sep="\n")