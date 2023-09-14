import math

H,W,세로,가로 = list(map(int,input().split(' ')))

행 = math.ceil(W/(가로+1))
열 = math.ceil(H/(세로+1))

result = 행*열

print(result)