t = int(input())

data = list(map(int,input().split()))

data = sorted(list(set(data)))

print(*data, sep=' ')