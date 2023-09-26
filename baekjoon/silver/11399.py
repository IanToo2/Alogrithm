N = int(input())

data = []
result = 0
data.extend(map(int, input().split()))

data = sorted(data)

for i in range(len(data)):
    result = result + data[i]*(len(data)-i)

print(result)