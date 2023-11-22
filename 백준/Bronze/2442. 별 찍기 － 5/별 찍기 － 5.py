t = int(input())
cnt = 1
a = 1
while a <= t:
    for i in range(t - cnt):
        print(" ",end = "")

    for i in range(2*a - 1):
        print("*", end='')

    cnt += 1
    a += 1
    print("")
