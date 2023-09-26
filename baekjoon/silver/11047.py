N, K = map(int, input().split())
data = []
result = 0

for i in range(N):
    data.append(int(input()))

data = sorted(data, reverse=True)

for i in range(len(data)):
    result += K//data[i]
    K=K%data[i]

print(result)