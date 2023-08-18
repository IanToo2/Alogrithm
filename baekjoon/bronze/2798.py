# 한국 최고의 블랙잭 고수 김! 정! 인!!
n,m = list(map(int, input().split()))

a = list(map(int,input().split()))

mmin = 300000
result = 0
for i in range(n):
    for j in range(i+1,n):
        for k in range(j+1,n):
            if a[i]+a[j]+a[k] <= m:
                # print("{}번째 , {}번째 , {}번째 = {} {} {} and sum = {}".format(i,j,k, a[i],a[j],a[k], a[i]+a[j]+a[k]))
                # print("현재 최적의 값 : {}".format(mmin))
                # print("이번 연산의 차 : {}".format(m - (a[i]+a[j]+a[k])))
                if mmin > m - (a[i]+a[j]+a[k]):
                    mmin = m - (a[i]+a[j]+a[k])
                    result = a[i]+a[j]+a[k]
print(result)