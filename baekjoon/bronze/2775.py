T = int(input())

while True:
    if T == 0:
        break

    k = int(input())
    n = int(input())

    if k == 0:
        a = [_ for _ in range(1,15)]
        print(a[n-1])
    else:
        a = [_ for _ in range(1,15)]
        b = [ 1 for _ in range(14)]
        for j in range(k):
            for i in range(len(a)):
                if i == 0:
                    b[i] == a[i]
                    #print("{}층의 {}호의 인원 {}:".format(j+1,i+1,b[i]))
                else:
                    b[i] = b[i-1] + a[i]
                    #print("{}층의 {}호의 인원 {}:".format(j+1,i+1,b[i]))
            a = b
        print(b[n-1])    
    T -= 1