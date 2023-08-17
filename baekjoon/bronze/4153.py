while True:
    a = []
    a = list(map(int, input().split()))

    if a[0] == 0: break
    
    maxa = max(a)
    a.remove(maxa)

    if maxa**2 == a[0]**2 + a[1]**2:
        print("right")
    else:
        print("wrong")