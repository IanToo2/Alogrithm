t = int(input())

cnt = 1

while cnt <= t:
    for i in range(cnt):
        print("*", end='')
    print("")

    cnt += 1

cnt -= 2

while cnt != 0:
    for i in range(cnt):
        print("*", end='')
    print("")
    cnt -= 1