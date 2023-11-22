n = int(input())

data = list(map(int, input().split()))

if len(data) == 1:
    print(data[0] * data[0])
else:
    data = sorted(data)
    print(data[0]*data[-1])