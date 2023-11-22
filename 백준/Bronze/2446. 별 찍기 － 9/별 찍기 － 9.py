t = int(input())
cnt = 0
while cnt < t:
    for i in range(cnt):
        print(" ", end='')
    for i in range(2*(t-cnt)-1):
        print("*", end='')
    print("")
    cnt += 1

cnt -= 2
while cnt > -1:
    for i in range(cnt):
        print(" ", end ='')
    for i in range(2*(t-cnt)-1):
        print("*", end='')
    print("")
    cnt -= 1