# 도화지 넓이가 함정인 문제

수 = int(input())
도화지 = [[0 for _ in range(101)] for _ in range(101)]

for _ in range(수):
    x, y = map(int, input().split())
    for i in range(x, x+10):
        for j in range(y, y+10):
            도화지[i][j] = 1

전체넓이 = 0

for row in 도화지:
    전체넓이 += row.count(1)
print(전체넓이)