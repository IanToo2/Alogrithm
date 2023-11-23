t = int(input())
for _ in range(t):
    data = list(map(list,input().split()))

    for i in data:
        for j in i[::-1]:
            print(j, end = '')
        print(' ',end = '')

