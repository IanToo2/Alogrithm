t = int(input())
cnt = 0

while t != 0:
    for i in range(cnt):
        print(" ",end = "")
    for i in range(2*t - 1):
        print("*", end='')




    cnt += 1
    t -= 1
    print("")
