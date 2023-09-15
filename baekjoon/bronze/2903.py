n = int(input())

point = 2

while True:
    if n == 0:
        print(point*point)
        break
    point += point-1
    n -=1