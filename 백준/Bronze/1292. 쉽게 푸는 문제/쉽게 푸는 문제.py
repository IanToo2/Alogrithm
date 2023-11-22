a,b = map(int,input().split())
data = []
cnt = 1
while len(data) < b:
    for _ in range(cnt):
        data.append(cnt)
    cnt += 1

sum = 0

for i in data[a-1:b]:

    sum += i

print(sum)

