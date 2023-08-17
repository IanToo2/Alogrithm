# 정사각형의 3점으로 마지막 점 위치 찾기
x = []
y = []
for i in range(3):
    a,b = map(int, input().split())
    x.append(a)
    y.append(b)
for i in range(3):
    if x.count(x[i]) == 1:
        result_x = x[i]
    if y.count(y[i]) == 1:
        result_y = y[i]

print(result_x, result_y)