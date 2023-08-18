n = int(input())

a = 2
asum = 1
if n==1:
    print("1")
else:
    while True:
        asum += 6 * (a-1)
        if n <= asum:
            print(a)
            break
        else:
            a+=1