M = int(input())
N = int(input())
sum =0
datalist = []
for a in range(1,101):
    if M <= a*a <= N : 
        sum += a*a
        datalist.append(a*a)
if sum == 0:
    print("-1")
else:
    print(sum)
    print(min(datalist))