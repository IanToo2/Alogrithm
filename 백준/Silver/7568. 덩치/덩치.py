t = int(input())
data = []
for i in range(t):
    W, H = map(int, input().split())
    data.append((W,H))

for i in data:
    rank = 1
    for j in data:
        if i[0] < j[0] and i[1] < j[1]:
            rank += 1
    print(rank, end = " ")