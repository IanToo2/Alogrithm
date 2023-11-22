t = int(input())

for i in range(t):
    a,b= map(str, input().split())

    a = int(a)
    answer =''
    for i in range(len(b)):
        if i != a-1:
            answer += b[i]
    print(answer)