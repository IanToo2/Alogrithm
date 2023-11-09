from math import gcd

t = int(input())

for i in range(1,t+1):
    a = 1
    b = 1
    t = list(input())

    for j in t:
        if j == "L":
            b = a+b
        elif j == "R":
            a = a+b

    check = gcd(a,b)

    a = int(a/check)
    b = int(b/check)

    print("#{} {} {}".format(i,a,b))