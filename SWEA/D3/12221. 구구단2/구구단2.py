t = int(input())
for i in range(1,t+1):

    a,b = map(int, input().split())

    if a>9 or b>9:
        print("#{} -1".format(i))
    else:
        print("#{} {}".format(i, a*b))