a = list(map(int, input().split()))
asum = 0
for i in range(len(a)):
    asum += a[i] ** 2
print(asum % 10)