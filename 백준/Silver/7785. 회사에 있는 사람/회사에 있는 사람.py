import sys

input = sys.stdin.readline

t = int(input())

data = {}

for i in range(t):
    log = list(map(str, input().split()))

    if log[0] in data:
        del data[log[0]]
    else:
        data[log[0]] = True

sorted_data = sorted(data.keys(), reverse=True)

print(*sorted_data, sep='\n')
