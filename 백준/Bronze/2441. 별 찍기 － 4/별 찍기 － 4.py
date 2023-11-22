t = int(input())
cnt = 0
while t != 0:
    for i in range(cnt):
        print(" ",end='')
    for i in range(t):
        print("*", end='')
    print("")
    t -= 1
    cnt += 1
