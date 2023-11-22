cnt = int(input())

a = 1
while a <= cnt:
    for i in range(a):
        print("*", end='')
    for i in range(2*(cnt-a)):
        print(" ", end='')
    for i in range(a):
        print("*", end='')
    print("")
    a += 1
cnt = 1
a -= 2
while a != 0:
    for i in range(a):
        print("*", end='')
    for i in range(2*(cnt)):
        print(" ", end='')
    for i in range(a):
        print("*", end='')
    print("")
    cnt += 1
    a -= 1
