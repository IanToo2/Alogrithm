# 별 생각없이풀다가 인덱스로 꺼내야하는거 잠시 생각 못한 문제
a = map(list, input())
a = list(a)
a = sorted(a,reverse=True)
b=[]
for i in range(len(a)):
    b.append(a[i][0])
print(*b, sep = '')
