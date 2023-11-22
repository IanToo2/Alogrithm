t = int(input())

for _ in range(t):
    n = int(input())
    data = list(map(int, input().split()))

    data = sorted(data)

    print(2*(data[-1]-data[0]))