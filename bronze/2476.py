T = int(input())
money = []
for i in range(T):
    a = list(map(int, input().split()))
    if (a[0] == a[1] and a[1] == a[2]):
        money.append(10000+a[0]*1000)
    elif (a[0] != a[1] and a[1]!= a[2] and a[2]!=a[0]):
        money.append(max(a)*100)
    else:
        if(a[0] == a[1] or a[0] == a[2]):
            money.append(1000+a[0]*100)
        else:
            money.append(1000+a[1]*100)
print(max(money))

